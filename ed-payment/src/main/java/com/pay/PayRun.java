package com.pay;


import com.pay.bankpay.SDKConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"mapper.course"})
public class PayRun implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PayRun.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        SDKConfig.getConfig().loadPropertiesFromSrc();
    }
}


//@SpringBootApplication
//@MapperScan({"mapper.course"})
//public class PayRun{
//
//    public static void main(String[] args) {
//        SpringApplication.run(PayRun.class,args);
//    }
//
//}
