package org.biz.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mapper.user.DictinfoUserMapper;
import org.biz.service.DictinfoUserService;
import org.biz.service.course.CourseCollectionService;
import org.biz.service.course.CourseService;
import org.biz.service.orderInfo.OrderInfoService;
import org.biz.service.userInfo.UserExtService;
import org.biz.utils.RedisAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dto;
import pojo.course.Course;
import pojo.course.CourseCollection;
import pojo.course.OrderInfo;
import pojo.user.Dictinfo;
import pojo.user.User;
import pojo.user.UserExt;
import utils.DtoUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Api(value = "UserController" , tags = "主业务(用户操作)接口")
public class UserController {

    @Resource
    UserExtService userExtService;//用户扩展信息

    @Resource
    OrderInfoService orderInfoService;//订单表

    @Resource
    CourseService courseService;//课程信息

    @Resource
    DictinfoUserService dictinfoUserService;//字典信息表

    @Resource
    CourseCollectionService courseCollectionService;//收藏表

    @Resource
    RedisAPI redisAPI;//redis工具类

    @ApiOperation(value = "根据用户编号查询信息", notes = "根据用户编号查询信息")
    @ApiImplicitParam(paramType = "query" , name = "userNum" , value = "用户编号")
    @GetMapping("/userInfo/findUserInfo")
    public Dto userInfo(@RequestParam(value = "userNum" , required = true) String userNum){
        //查询用户基本信息
        UserExt userInfo = userExtService.findById(Long.parseLong(userNum));

        //查询性别
        Dictinfo dicInfo = dictinfoUserService.findIdByInfo(userInfo.getSex());

        //性别信息
        userInfo.setSexInfo(dicInfo.getInfo());

        if(userInfo == null){
            return DtoUtil.returnSuccess("未查询到信息!!");
        }

        return DtoUtil.returnDataSuccess(userInfo);
    }


    @ApiOperation(value = "根据用户编号查询订单信息", notes = "根据用户编号查询订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" , name = "userNum" , value = "用户编号" , required = true),
            @ApiImplicitParam(paramType = "query" , name = "orderStatic" , value = "订单状态[16=待支付  17=成功支付  18=支付失败 19=已关闭]" , required = true),
    })
    @GetMapping("/userInfo/orderInfo")
    public Dto orderInfo(@RequestParam(value = "userNum") String userNum ,
                         @RequestParam(value = "orderStatic") String orderStatic){
        //添加数据
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserNo(Long.parseLong(userNum));
        orderInfo.setOrderStatus(Integer.parseInt(orderStatic));

        //根据用户ID和订单状态查询信息
        List<OrderInfo> findUserInfoOder = orderInfoService.findAll(orderInfo);

        if(findUserInfoOder.size() == 0){
            return DtoUtil.returnSuccess("未查询到用户订单信息!!");
        }

        return DtoUtil.returnDataSuccess(findUserInfoOder);
    }

    @ApiOperation(value = "学习记录", notes = "学习记录")
    @ApiImplicitParam(paramType = "query" , name = "userNum" , value = "用户编号" , required = true)
    @GetMapping("/userInfo/orderCourseInfo")
    public Dto orderCourseInfo(@RequestParam(value = "userNum") String userNum){
        //添加数据
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserNo(Long.parseLong(userNum));
        orderInfo.setOrderStatus(17);

        //根据用户ID和订单状态查询信息
        List<OrderInfo> findUserInfoOder = orderInfoService.findAll(orderInfo);

        //课程信息
        List<Course> coursesInfo = new ArrayList<>();

        if(findUserInfoOder.size() == 0){
            return DtoUtil.returnSuccess("未查询到用户订单信息!!");
        } else {
            for (OrderInfo order : findUserInfoOder){
                //根据课程编号查询课程信息
                Course course = courseService.findById(order.getCourseId());
                coursesInfo.add(course);
            }
        }

        return DtoUtil.returnDataSuccess(coursesInfo);
    }


    //课程收藏
    @ApiOperation(value = "课程收藏", notes = "课程收藏")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query" , name = "courseNum" , value = "课程编号"),
            @ApiImplicitParam(paramType = "query" , name = "courseName" , value = "课程名称"),
            @ApiImplicitParam(paramType="header",required=true,name="token",value="用户认证Token")})
    @GetMapping("/userInfo/insertInfo")
    public Dto userInfo(@RequestParam(value = "courseNum" , required = true) String courseNum ,
                        @RequestParam(value = "courseName" , required = true) String courseName ,
                        HttpServletRequest request) {

        // 获取当前登录的用户信息
        String tokenString = request.getHeader("token");
        String userJson = String.valueOf(redisAPI.get(tokenString));
        User userInfo = JSON.parseObject(userJson, User.class);
        if (null == userInfo) {
            return DtoUtil.returnFail("请先登录用户", "00000");
        }

        //新增收藏信息
        CourseCollection courseCollection = new CourseCollection();
        courseCollection.setCourseid(Long.parseLong(courseNum));
        courseCollection.setCoursename(courseName);
        courseCollection.setUserid(userInfo.getId());
        courseCollection.setCreatetime(new Date());
        courseCollection.setUpdatetime(new Date());
        int count = courseCollectionService.insert(courseCollection);

        if(count < 0){
            return DtoUtil.returnSuccess("课程收藏失败");
        }

        return DtoUtil.returnSuccess("课程收藏成功!!");
    }


}
