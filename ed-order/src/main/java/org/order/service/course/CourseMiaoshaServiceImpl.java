package org.order.service.course;

import mapper.course.CourseMiaoshaMapper;
import org.order.service.lecturer.LecturerService;
import org.order.service.orderInfo.OrderInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.course.Course;
import pojo.course.CourseMiaosha;
import pojo.course.OrderInfo;
import pojo.user.Lecturer;
import pojo.user.User;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//秒杀库存表
@Service
public class CourseMiaoshaServiceImpl implements CourseMiaoshaService{

    @Resource
    CourseMiaoshaMapper courseMiaoshaMapper;

    @Resource
    OrderInfoService orderInfoService;//订单信息

    @Resource
    CourseService courseService;//课程信息

    @Resource
    LecturerService lecturerService;//讲师信息

    @Override
    public CourseMiaosha findById(Long id) {
        return courseMiaoshaMapper.findById(id);
    }

    @Override
    public List<CourseMiaosha> findAll(CourseMiaosha courseMiaosha) {
        return courseMiaoshaMapper.findAll(courseMiaosha);
    }

    @Override
    public int insertMiaoShaInfo(CourseMiaosha courseMiaosha) {
        return courseMiaoshaMapper.insertMiaoShaInfo(courseMiaosha);
    }

    @Override
    public int updateMiaoShaInfo(CourseMiaosha courseMiaosha) {
        return courseMiaoshaMapper.updateMiaoShaInfo(courseMiaosha);
    }

    @Override
    public int deleteById(Long id) {
        return courseMiaoshaMapper.deleteById(id);
    }

    //修改库存信息
    @Override
    public int updateCourseStock(String id, String stoType) {
        return courseMiaoshaMapper.updateCourseStock(id , stoType);
    }

    //修改库存 生成订单
    @Override
    @Transactional//事务
    public int miaosha(User userInfo, String msId) {
        //减少库存
        int count = updateCourseStock(msId , null);

        //查询秒杀信息获取
        CourseMiaosha info = findById(Long.parseLong(msId));

        //生成订单
        return orderInfoService.buyInfoByOrderInfo(userInfo , info.getCourseId() , info.getMiaoshaPrice());

    }

}