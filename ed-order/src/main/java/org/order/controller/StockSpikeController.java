package org.order.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.order.service.course.CourseMiaoshaService;
import org.order.service.orderInfo.OrderInfoService;
import org.order.utils.RedisAPI;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dto;
import pojo.course.CourseMiaosha;
import pojo.course.OrderInfo;
import pojo.user.User;
import utils.DtoUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//库存秒杀
@RestController
@Api(value = "StockSpikeController" , tags = "库存秒杀")
public class StockSpikeController {

    @Resource
    CourseMiaoshaService courseMiaoshaService;//秒杀库存信息

    @Resource
    OrderInfoService orderInfoService;//订单信息

    @Resource
    RedisAPI redisAPI;

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
        //查询秒杀库存信息
        CourseMiaosha courseInfo = courseMiaoshaService.findById(Long.parseLong(msId));
        //判断库存
        if(courseInfo.getStockCount() <= 0){
            return DtoUtil.returnSuccess("库存不足");
        }

        //判断是否已经秒杀到了(防止重复下单)传入用户编号，和秒杀商品Id
        OrderInfo orderInfo = orderInfoService.insertRedisOrderInfo(userInfo.getUserNo() , Long.parseLong(msId));

        //修改库存 生成订单
        int orderInfoCount = courseMiaoshaService.miaosha(userInfo , msId);
        if(orderInfoCount == 0){
            return DtoUtil.returnSuccess("出现错误");
        }

        return DtoUtil.returnSuccess("订单生成成功");
    }

//    //创建秒杀库存列表
//    @GetMapping("/createSeckillStockCount")
//    public void secKillStockCount(){
//        //有 100 个库存
//        Integer count = 100;
//        //添加到Redis列表中
//        for (Integer i = 0 ; i < count ; i++){
//            redisTemplate.opsForList().leftPush("slist" , 1);
//        }
//        System.out.println(redisTemplate.opsForList().range("slist" , 0 , 1));
//    }
//
//
//    //实现抢购处理功能
//    @GetMapping("/seckill")
//    public void seckill(){
//        //判断计数器
//        if(redisTemplate.opsForList().leftPop("slist").equals(1)){
//            //抢购成功的用户ID 这里简单设置为一个
//            long user_id = 1903;
//            redisTemplate.opsForList().leftPush("ulist" , user_id);
//        }
//        System.out.println(redisTemplate.opsForList().range("slist" , 0 , -1));
//        System.out.println(redisTemplate.opsForList().range("ulist" , 0 , -1));
//    }

}
