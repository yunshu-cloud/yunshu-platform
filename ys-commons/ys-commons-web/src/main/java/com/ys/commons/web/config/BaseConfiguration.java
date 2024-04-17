package com.ys.commons.web.config;

import com.ys.commons.web.exception.GlobalException;
import com.ys.commons.web.utils.ApplicationUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: Web模块的自动装配的核心配置文件
 */
@Configuration
public class BaseConfiguration {

    /**
     * 装配全局异常处理器
     * @return
     */
    @Bean
    public GlobalException getGlobalException(){
        return new GlobalException();
    }

    @Bean
    public ApplicationUtils getApplicationUtils(){
        return new ApplicationUtils();
    }

}
