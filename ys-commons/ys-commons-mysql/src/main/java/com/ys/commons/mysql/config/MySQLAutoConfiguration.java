package com.ys.commons.mysql.config;


import com.ys.commons.mysql.plugin.SQLPlugin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.ys.data.mapper")
@EnableTransactionManagement
public class MySQLAutoConfiguration {
    // 注册MyBatis插件
    @Bean
    public SQLPlugin getSQLPlugin(){
        return new SQLPlugin();
    }
}
