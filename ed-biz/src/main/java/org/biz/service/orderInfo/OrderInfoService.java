package org.biz.service.orderInfo;

import pojo.course.OrderInfo;

import java.util.List;

/**
 * 订单信息表(OrderInfo)
 */
public interface OrderInfoService {

    /**
     * 通过ID查询单条数据
     */
    OrderInfo findById(Long id);

    /**
     * 通过实体作为筛选条件查询
     */
    List<OrderInfo> findAll(OrderInfo orderInfo);

    /**
     * 新增数据
     */
    int insertOrderInfo(OrderInfo orderInfo);

    /**
     * 修改数据
     */
    int updateOrderInfo(OrderInfo orderInfo);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);

}