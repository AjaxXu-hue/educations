package pojo.org.leRun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"mapper.user" , "mapper.course"})
public class LeRun {

    public static void main(String[] args) {
        SpringApplication.run(LeRun.class , args);
    }
}
