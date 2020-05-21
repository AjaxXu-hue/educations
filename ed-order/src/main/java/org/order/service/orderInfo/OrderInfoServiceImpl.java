package org.order.service.orderInfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import mapper.course.OrderInfoMapper;
import org.order.config.rabbitmq.MiaoshaMessage;
import org.order.service.course.CourseMiaoshaService;
import org.order.service.course.CourseService;
import org.order.service.lecturer.LecturerService;
import org.order.utils.RedisAPI;
import org.springframework.stereotype.Service;
import pojo.course.Course;
import pojo.course.CourseMiaosha;
import pojo.course.OrderInfo;
import pojo.user.Lecturer;
import pojo.user.User;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService{

    @Resource
    OrderInfoMapper orderInfoMapper;

    @Resource
    CourseService courseService;//课程信息

    @Resource
    LecturerService lecturerService;//讲师信息

    @Resource
    CourseMiaoshaService courseMiaoshaService;//秒杀信息

    @Resource
    RedisAPI redisAPI;

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

    //刷新订单状态
    @Override
    public boolean flushSuccessOrderStatus() {
        //查询需要刷新订单
        List<OrderInfo> findInfo = orderInfoMapper.findAllOrderStatus();
        if(findInfo.size() != 0){
            //判断订单状态
            for (OrderInfo order: findInfo) {
                if(order.getOrderType() == 20){
                    //秒杀库存加1
                    redisAPI.insert(order.getMsId().toString());//redis库存
                    courseMiaoshaService.updateCourseStock(order.getMsId().toString() , "1");//数据库库存
                    //删除redis中订单信息
                    redisAPI.del("order:"+order.getUserNo()+"_"+order.getMsId());
                }
            }
            int count = orderInfoMapper.flushSuccessOrderStatus();
            if(count > 0){
                return true;
            }
        }
        return false;
    }

    //单击购买按钮生成订单（用户信息， 购买课程 ， 秒杀价格 ， 秒杀ID）
    @Override
    public int buyInfoByOrderInfo(User userInfo , Long courseNum ,double price , String msId) {
        //根据课程ID查询课程信息
        Course course = courseService.findById(courseNum);

        //根据讲师编号查询讲师名称(算出收入多少)
        Lecturer le = new Lecturer();
        le.setLecturerUserNo(course.getLecturerUserNo());
        List<Lecturer> lecturer = lecturerService.findAll(le);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setLecturerUserNo(course.getLecturerUserNo());
        orderInfo.setLecturerName(lecturer.get(0).getLecturerName());
        orderInfo.setUserNo(userInfo.getUserNo());
        orderInfo.setMobile(userInfo.getMobile());
        orderInfo.setOrderNo(Long.parseLong(orderNo()));
        orderInfo.setCourseId(course.getId());
        orderInfo.setCourseName(course.getCourseName());
        double priceLe;
        double priceLa;
        if(price != 0){
            orderInfo.setPricePayable(price);
            priceLe = price*lecturer.get(0).getLecturerProportion();
            priceLa = course.getCourseOriginal() - priceLe;
            orderInfo.setOrderType(20);
            orderInfo.setMsId(Integer.parseInt(msId));
        } else {
            orderInfo.setPricePayable(course.getCourseOriginal());
            //讲师收入
            priceLe = course.getCourseOriginal()*lecturer.get(0).getLecturerProportion();
            priceLa = course.getCourseOriginal() - priceLe;
            orderInfo.setOrderType(21);
            orderInfo.setMsId(0);
        }
        orderInfo.setPriceDiscount(Double.parseDouble("0"));
        orderInfo.setPricePaid(course.getCourseOriginal());

        orderInfo.setPlatformProfit(priceLa);
        orderInfo.setLecturerProfit(priceLe);
        orderInfo.setOrderStatus(16);
        orderInfo.setGmtCreate(new Date());
        orderInfo.setGmtModified(new Date());
        orderInfo.setPayNo("");

        if(price != 0) {
            //写入redis中（用户编号信息_课程Id）
            redisAPI.set("order:" + userInfo.getUserNo() + "_" + msId, JSON.toJSONString(orderInfo), 0);
        }
        return insertOrderInfo(orderInfo);
    }

    //读取缓存中的信息(存储到redis中)(传入用户编号，和秒杀商品Id)
    @Override
    public OrderInfo insertRedisOrderInfo(Long userNo, Long miaoShaCourseId) {
        String info = (String) redisAPI.get("order:"+userNo+"_"+miaoShaCourseId);
        return JSONObject.parseObject(info , OrderInfo.class);
    }

    //生成唯一订单ID
    public String orderNo(){
        //获取年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
        //获取时间戳
        String time=dateFormat.format(new Date());
        //生成6位随机数
        int ran = (int)((Math.random()*9+1)*100000);
        return 21+time+ran;
    }

}
