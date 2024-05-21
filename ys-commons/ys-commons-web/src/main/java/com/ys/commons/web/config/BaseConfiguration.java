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

    /**
     * 装配Application工具类
     * @return
     */
    @Bean
    public ApplicationUtils getApplicationUtils(){
        return new ApplicationUtils();
    }

    /**
     * 注册web拦截器配置类
     * @return
     */
    @Bean
    public WebInterceptorConfig getWebInteceptorConfig(){
        return new WebInterceptorConfig();
    }

//    /**
//     * 注册自定义handlermapping 实现接口多版本的控制
//     * @return
//     */
//    @Bean
//    public WebMvcRegistrations getWebMvcRegister(){
//        return new ApiVersionMappingRegister();
//    }


}
