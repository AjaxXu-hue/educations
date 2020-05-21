package org.order.service.course;

import mapper.course.CourseMiaoshaMapper;
import org.order.service.lecturer.LecturerService;
import org.order.service.orderInfo.OrderInfoService;
import org.order.utils.RedisAPI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.course.Course;
import pojo.course.CourseMiaosha;
import pojo.course.OrderInfo;
import pojo.user.Lecturer;
import pojo.user.User;
import utils.DtoUtil;

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
    RedisAPI redisAPI;

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
    public boolean updateCourseStock(String id, String stoType) {
        int num = courseMiaoshaMapper.updateCourseStock(id , stoType);
        return num > 0;
    }

    //修改库存 生成订单
    @Override
    @Transactional//事务
    public int miaosha(User userInfo, String msId) {
        //减少库存
        boolean success = updateCourseStock(msId , null);
        if(success){
            //查询秒杀信息获取
            CourseMiaosha info = findById(Long.parseLong(msId));
            //生成订单
            return orderInfoService.buyInfoByOrderInfo(userInfo , info.getCourseId() , info.getMiaoshaPrice() , msId);
        }
            setGoodsOver(Long.parseLong(msId));
            return 0;
    }


    //返回秒杀结果
    @Override
    public long getMiaoshaResult(long userId, long miaoshaId) {
        //是否生成订单
        OrderInfo result = orderInfoService.insertRedisOrderInfo(userId , miaoshaId);
        if(result != null){
            //秒杀成功
            return result.getOrderNo();
        } else {
            boolean isOver = getGoodsOver(miaoshaId);
            if(isOver){
                return -1;
            } else {
                return 0;
            }
        }
    }

    //判断改秒杀课程ID是否已经购买完
    private void setGoodsOver(long miaoshaId) {
        redisAPI.set(String.valueOf(miaoshaId) , "true" , 0);
    }

    private boolean getGoodsOver(long miaoshaId) {
        return redisAPI.hasKey(String.valueOf(miaoshaId));
    }


}