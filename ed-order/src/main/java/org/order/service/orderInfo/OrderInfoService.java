package org.order.service.orderInfo;

import pojo.course.OrderInfo;
import pojo.user.User;

import java.util.List;

/**
 * 订单信息表(OrderInfo)
 */
public interface OrderInfoService {

    //通过ID查询单条数据
    OrderInfo findById(Long id);

    //通过实体作为筛选条件查询
    List<OrderInfo> findAll(OrderInfo orderInfo);

    //新增数据
    int insertOrderInfo(OrderInfo orderInfo);

    // 修改数据
    int updateOrderInfo(OrderInfo orderInfo);

    // 通过主键删除数据
    int deleteById(Long id);

    //刷新订单状态
    boolean flushSuccessOrderStatus();

    //单击购买按钮生成订单（用户信息， 购买课程 ， 秒杀价格）
    int buyInfoByOrderInfo(User userInfo, Long courseNum , double price);

    //订单存储到缓存中(存储到redis中)(传入用户编号，和秒杀商品Id)
    OrderInfo insertRedisOrderInfo(Long userId , Long miaoShaCourseId);

    //生成订单号
    String orderNo();
}