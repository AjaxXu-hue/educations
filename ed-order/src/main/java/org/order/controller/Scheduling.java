package org.order.controller;

import org.order.service.orderInfo.OrderInfoService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@EnableScheduling
public class Scheduling {

    @Resource
    OrderInfoService orderInfoService;//订单信息

    /***
     * 10分钟执行一次 刷新订单的状态 ,如果两小时内订单没有付款则更改为取消状态，
     * 0/30 * * * * ?
     */
    @Scheduled(cron = "* 0/10 * * * ?")
    public void flushCancelOrderStatus() {
        try {
            boolean flag = orderInfoService.flushSuccessOrderStatus();
            String massage =  flag ? "刷取订单成功" : "刷单失败";
            System.out.println(new Date() + "---------------" + massage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
