package com.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import utils.MD5;

@SpringBootApplication
@MapperScan({"mapper.user"})
@ComponentScan(basePackages = {"com.login.*"})
public class LoginRun {

    public static void main(String[] args) {
        SpringApplication.run(LoginRun.class , args);
    }
}
