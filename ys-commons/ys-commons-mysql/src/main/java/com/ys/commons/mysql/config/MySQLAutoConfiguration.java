package com.ys.commons.mysql.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.ys.data.mapper")
@EnableTransactionManagement
public class MySQLAutoConfiguration {
}
