package com.system.controller;

import com.system.service.order.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Dto;
import pojo.course.OrderInfo;
import utils.DtoUtil;

import javax.annotation.Resource;
import java.util.List;

//订单信息管理
@RestController
@Api(value = "OrderInfoController" , tags = "订单信息管理接口")
public class OrderInfoController {

    @Resource
    OrderInfoService orderInfoService;

    //查询订单信息
    //查询全部广告信息
    @ApiOperation(value = "查询订单信息", notes = "1.查询全部订单信息</br>2.根据条件查询信息[讲师名称、课程名称、支付方式、订单状态]")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "leName", value = "讲师名称"),
            @ApiImplicitParam(paramType = "query", name = "coName", value = "课程名称"),
            @ApiImplicitParam(paramType = "query", name = "payType", value = "支付方式 14=微信  15=支付宝"),
            @ApiImplicitParam(paramType = "query", name = "orderStatus", value = "订单状态 16=待支付 17=成功支付 18=支付失败 19=已关闭")})
    @GetMapping("/order/orList/findAll")
    public Dto findAll(@RequestParam(value = "leName", required = false) String leName,
                       @RequestParam(value = "coName", required = false) String coName,
                       @RequestParam(value = "payType", required = false) String payType,
                       @RequestParam(value = "orderStatus", required = false) String orderStatus) {
        //添加数据
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setLecturerName(leName);
        orderInfo.setCourseName(coName);
        if(payType != null){
            orderInfo.setPayType(Integer.parseInt(payType));
        }
        if(orderStatus != null){
            orderInfo.setOrderStatus(Integer.parseInt(orderStatus));
        }
        //查询信息
        List<OrderInfo> findAllInfo = orderInfoService.findAll(orderInfo);
        if (findAllInfo.size() == 0) {
            return DtoUtil.returnSuccess("未查询到订单信息");
        }

        return DtoUtil.returnDataSuccess(findAllInfo);
    }
}
