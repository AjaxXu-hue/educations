package com.pay.service;

import mapper.course.OrderInfoMapper;
import org.springframework.stereotype.Service;
import pojo.course.OrderInfo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService{

    @Resource
    OrderInfoMapper orderInfoMapper;

    //通过ID查询信息
    @Override
    public OrderInfo findById(Long id) {
        return orderInfoMapper.findById(id);
    }

    //通过实体作为筛选条件查询
    @Override
    public List<OrderInfo> findAll(OrderInfo orderInfo) {
        return orderInfoMapper.findAll(orderInfo);
    }

    //新增订单信息
    @Override
    public int insertOrderInfo(OrderInfo orderInfo) {
        return orderInfoMapper.insertOrderInfo(orderInfo);
    }

    //修改订单信息
    @Override
    public int updateOrderInfo(OrderInfo orderInfo) {
        return orderInfoMapper.updateOrderInfo(orderInfo);
    }

    //删除订单信息
    @Override
    public int deleteById(Long id) {
        return orderInfoMapper.deleteById(id);
    }
}
