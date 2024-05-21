package com.ys.business.student.application;

import com.ys.commons.web.apiversion.register.EnableApiVersion;
import com.ys.commons.web.devicetype.register.EnableDeviceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableApiVersion
@EnableDeviceType
//启用nacos服务

//@MapperScan("com.ys.data.mapper")
public class StuApplication {
    public static void main(String[] args) {
        SpringApplication.run(StuApplication.class,args);
    }
}
