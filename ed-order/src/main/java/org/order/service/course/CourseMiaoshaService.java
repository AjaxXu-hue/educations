package org.order.service.course;

import org.apache.ibatis.annotations.Param;
import pojo.course.CourseMiaosha;
import pojo.course.OrderInfo;
import pojo.user.User;

import java.util.List;

public interface CourseMiaoshaService {

    /**
     * 通过ID查询单条数据
     */
    CourseMiaosha findById(Long id);

    /**
     * 通过实体作为筛选条件查询
     */
    List<CourseMiaosha> findAll(CourseMiaosha courseMiaosha);

    /**
     * 新增数据
     */
    int insertMiaoShaInfo(CourseMiaosha courseMiaosha);

    /**
     * 修改数据
     */
    int updateMiaoShaInfo(CourseMiaosha courseMiaosha);

    /**
     * 通过主键删除数据
     */
    int deleteById(Long id);

    //修改库存信息
    boolean updateCourseStock(String id , String stoType);

    //修改库存 新增订单
    int miaosha(User userInfo, String msId);

    //返回秒杀结果
    public long getMiaoshaResult(long userId , long miaoshaId);
}