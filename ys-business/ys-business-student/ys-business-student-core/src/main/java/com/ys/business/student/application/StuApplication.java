package com.ys.business.student.application;

import com.ys.commons.web.apiversion.register.EnableApiVersion;
import com.ys.commons.web.devicetype.register.EnableDeviceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApiVersion
@EnableDeviceType
//@MapperScan("com.ys.data.mapper")
public class StuApplication {
    public static void main(String[] args) {
        SpringApplication.run(StuApplication.class,args);
    }
}
