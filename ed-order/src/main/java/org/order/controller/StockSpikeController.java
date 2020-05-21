package org.order.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.order.config.rabbitmq.MQSender;
import org.order.config.rabbitmq.MiaoshaMessage;
import org.order.service.course.CourseMiaoshaService;
import org.order.service.orderInfo.OrderInfoService;
import org.order.utils.RedisAPI;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dto;
import pojo.course.CourseMiaosha;
import pojo.course.OrderInfo;
import pojo.user.User;
import utils.DtoUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//库存秒杀
@RestController
@Api(value = "StockSpikeController" , tags = "库存秒杀")
public class StockSpikeController implements InitializingBean {

    @Resource
    CourseMiaoshaService courseMiaoshaService;//秒杀库存信息

    @Resource
    OrderInfoService orderInfoService;//订单信息

    @Resource
    RedisAPI redisAPI;

    @Resource
    MQSender mqSender;

    private Map<Long , Boolean> localOverMap = new HashMap<>();

    //系统初始化
    @Override
    public void afterPropertiesSet() throws Exception {
        List<CourseMiaosha> findList = courseMiaoshaService.findAll(null);
        if(findList == null){
            return;
        }
        for (CourseMiaosha courseInfo : findList) {
            //判断保存时间
            Long now = System.currentTimeMillis();
            int millis = (int) (courseInfo.getEndDate().getTime() - now) / 1000;
            redisAPI.set(String.valueOf(courseInfo.getId()), String.valueOf(courseInfo.getStockCount()), millis);
            localOverMap.put(courseInfo.getId() , false);
        }
    }

    //秒杀按钮
    @ApiOperation(value = "抢购秒杀课程", notes = "抢购秒杀课程")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query" , name = "msId" , value = "秒杀Id"),
            @ApiImplicitParam(paramType="header",required=true,name="token",value="用户认证Token")})
    @GetMapping("/do_miaoSha")
    public Dto userInfo(@RequestParam(value = "msId" , required = true) String msId ,
                        HttpServletRequest request) {

        // 获取当前登录的用户信息
        String tokenString = request.getHeader("token");
        String userJson = String.valueOf(redisAPI.get(tokenString));
        User userInfo = JSON.parseObject(userJson, User.class);
        if (null == userInfo) {
            return DtoUtil.returnFail("请先登录用户", "00000");
        }

        boolean over = localOverMap.get(Long.parseLong(msId));
        if(over){
            return DtoUtil.returnSuccess("库存不足");
        }

        //判断是否已经秒杀到了(防止重复下单)传入用户编号，和秒杀商品Id
        OrderInfo orderInfo = orderInfoService.insertRedisOrderInfo(userInfo.getUserNo() , Long.parseLong(msId));
        if(orderInfo != null){
            return DtoUtil.returnSuccess("已经购买成功");
        }

        //预减库存
        boolean isFalg = redisAPI.decr(msId);
        if(!isFalg){
            localOverMap.put(Long.parseLong(msId) , true);
            return DtoUtil.returnSuccess("库存不足");
        }

        //入队
        MiaoshaMessage mm = new MiaoshaMessage();
        mm.setUser(userInfo);
        mm.setMiaoshaId(Long.parseLong(msId));
        mqSender.sendMiaoShaMessage(mm);
        return DtoUtil.returnSuccess("0");
    }


    /**
     * 查询秒杀结果请求
     * orderId 成功
     * -1 失败
     * 0 排队中 ./rabbitmq-server -detached
     */
    @ApiOperation(value = "查询秒杀结果请求", notes = "查询秒杀结果请求</br>orderId 成功</br>-1 失败</br>0 排队中")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query" , name = "msId" , value = "秒杀Id"),
            @ApiImplicitParam(paramType="header",required=true,name="token",value="用户认证Token")})
    @GetMapping("/result")
    public Dto resuleOrderInfo(@RequestParam(value = "msId" , required = true) String msId ,
                    HttpServletRequest request) {

        // 获取当前登录的用户信息
        String tokenString = request.getHeader("token");
        String userJson = String.valueOf(redisAPI.get(tokenString));
        User userInfo = JSON.parseObject(userJson, User.class);
        if (null == userInfo) {
            return DtoUtil.returnFail("请先登录用户", "00000");
        }

        //是否生成订单
        long result = courseMiaoshaService.getMiaoshaResult(userInfo.getUserNo() , Long.parseLong(msId));
        return DtoUtil.returnDataSuccess(result);
    }

}
