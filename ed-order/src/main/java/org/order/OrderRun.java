package org.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"mapper.user" , "mapper.course"})
public class OrderRun {

    public static void main(String[] args) {
        SpringApplication.run(OrderRun.class , args);
    }
}
