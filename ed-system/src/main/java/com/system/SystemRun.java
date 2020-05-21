package com.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"mapper.system","mapper.user","mapper.course"})
@ComponentScan(basePackages = {"com.system.*"})
public class SystemRun {

    public static void main(String[] args) {
        SpringApplication.run(SystemRun.class , args);
    }
}
