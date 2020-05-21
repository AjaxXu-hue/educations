package org.order.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String QUEUE = "queue";

    /**
     * Direct模式 交换机Exchange（消息先发送到交换机上再发送到queue）
     */
    @Bean
    public Queue queue(){
        return new Queue(QUEUE , true);
    }
//
//    @Bean
//    DirectExchange directExchange(){
//        return new DirectExchange(QUEUE , true , false);
//    }
//
//    @Bean
//    Binding binding(){
//        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
//    }

}
