package mapper.course;

import org.apache.ibatis.annotations.Param;
import pojo.course.OrderInfo;

import java.util.List;

/**
 * 订单信息表(OrderInfo)表数据库访问层
 */
public interface OrderInfoMapper {

    //通过ID查询单条数据
    OrderInfo findById(Long id);

    //通过实体作为筛选条件查询
    List<OrderInfo> findAll(OrderInfo orderInfo);

    //新增数据
    int insertOrderInfo(OrderInfo orderInfo);

    //修改数据
    int updateOrderInfo(OrderInfo orderInfo);

    //通过主键删除数据
    int deleteById(Long id);

    //刷新订单状态
    Integer flushSuccessOrderStatus();

    //查询需要刷新订单
    List<OrderInfo> findAllOrderStatus();

}