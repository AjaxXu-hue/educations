package org.order.config.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import org.order.service.course.CourseMiaoshaService;
import org.order.service.orderInfo.OrderInfoService;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pojo.course.CourseMiaosha;
import pojo.course.OrderInfo;
import pojo.user.User;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Service
public class MQReceiver {

    @Resource
    CourseMiaoshaService courseMiaoshaService;//秒杀库存信息

    @Resource
    OrderInfoService orderInfoService;//订单信息

    /**
     * Direct模式 交换机Exchange（消息先发送到交换机上再发送到queue）
     * @param message
     */
    @RabbitListener(queues=MQConfig.QUEUE)
    public void receive(String message){
        System.out.println("receive message:"+ message);
        //获取信息
        MiaoshaMessage mess = JSONObject.parseObject(message , MiaoshaMessage.class);
        User userInfo = mess.getUser();
        long miaoshaId = mess.getMiaoshaId();

        //查询秒杀库存信息
        CourseMiaosha courseInfo = courseMiaoshaService.findById(miaoshaId);
        //判断库存
        if(courseInfo.getStockCount() <= 0){
            return;//库存不足
        }

//        //判断是否已经秒杀到了(防止重复下单)传入用户编号，和秒杀商品Id
//        OrderInfo orderInfo = orderInfoService.insertRedisOrderInfo(userInfo.getUserNo() , miaoshaId);
//        if(orderInfo != null){
//            return;
//        }

        //修改库存 生成订单
        int orderInfoCount = courseMiaoshaService.miaosha(userInfo , String.valueOf(miaoshaId));
        if(orderInfoCount == 0){
            return;//出现错误
        }
    }

}
