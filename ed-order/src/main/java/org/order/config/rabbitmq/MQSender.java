package org.order.config.rabbitmq;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Service
public class MQSender {

    @Resource
    AmqpTemplate amqpTemplate;

    //Direct模式
    public void sendMiaoShaMessage(MiaoshaMessage mm) {
        System.out.println("send message:"+ JSONObject.toJSONString(mm));
        String mess = (String) JSONObject.toJSONString(mm);
        amqpTemplate.convertAndSend(MQConfig.QUEUE , mess);
    }
}
