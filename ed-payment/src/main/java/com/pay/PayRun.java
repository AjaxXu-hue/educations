package com.pay;

import com.alibaba.druid.wall.WallFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"mapper.course"})
public class PayRun{

    public static void main(String[] args) {
        SpringApplication.run(PayRun.class , args);
    }

}
