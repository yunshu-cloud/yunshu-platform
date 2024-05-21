package com.ys.business.student.application;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.ys.commons.web.apiversion.register.EnableApiVersion;
import com.ys.commons.web.devicetype.register.EnableDeviceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
