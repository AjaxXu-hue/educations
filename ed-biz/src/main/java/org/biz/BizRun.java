package org.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BizRun {

    public static void main(String[] args) {
        SpringApplication.run(BizRun.class , args);
    }
}
