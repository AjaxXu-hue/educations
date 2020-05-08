package org.demo.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@MapperScan("mapper.system")
//@EnableCaching
public class SystemRun {

    public static void main(String[] args) {
        SpringApplication.run(SystemRun.class , args);
    }
}
