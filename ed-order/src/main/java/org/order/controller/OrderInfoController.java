package org.order.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.order.service.course.CourseService;
import org.order.service.lecturer.LecturerService;
import org.order.service.orderInfo.OrderInfoService;
import org.order.utils.RedisAPI;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dto;
import pojo.course.Course;
import pojo.course.OrderInfo;
import pojo.user.Lecturer;
import pojo.user.User;
import pojo.user.UserExt;
import utils.DtoUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Api(value = "OrderInfoController" , tags = "订单接口")
public class OrderInfoController {

    @Resource
    OrderInfoService orderInfoService;//订单信息

    @Resource
    CourseService courseService;//课程信息

    @Resource
    LecturerService lecturerService;//讲师信息

    @Resource
    RedisAPI redisAPI;

    //单击购买按钮新增订单信息(传入课程ID)
    @ApiOperation(value = "生成订单信息", notes = "生成订单信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query" , name = "courseNum" , value = "课程编号"),
                        @ApiImplicitParam(paramType="header",required=true,name="token",value="用户认证Token")})
    @GetMapping("/addOrder/insertInfo")
    public Dto userInfo(@RequestParam(value = "courseNum" , required = true) String courseNum ,
                        HttpServletRequest request){

        // 获取当前登录的用户信息
        String tokenString = request.getHeader("token");
        String userJson = String.valueOf(redisAPI.get(tokenString));
        User userInfo = JSON.parseObject(userJson,User.class);
        if(null == userInfo){
            return DtoUtil.returnFail("请先登录用户" , "00000");
        }
        System.out.println(userInfo);

        //生成订单
        int count = orderInfoService.buyInfoByOrderInfo(userInfo , Long.parseLong(courseNum) , 0 , null);
        if(count < 0){
            return DtoUtil.returnSuccess("新增失败!!");
        }

        return DtoUtil.returnSuccess("新增成功!!");
    }


}
