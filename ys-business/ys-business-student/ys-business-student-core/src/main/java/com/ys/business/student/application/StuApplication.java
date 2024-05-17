package com.ys.business.student.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
//@MapperScan("com.ys.data.mapper")
public class StuApplication {
    public static void main(String[] args) {
        SpringApplication.run(StuApplication.class,args);
    }
}
