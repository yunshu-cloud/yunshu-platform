package com.ys.commons.web.config;

import com.ys.commons.web.exception.GlobalException;
import com.ys.commons.web.utils.ApplicationUtils;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: Web模块的自动装配的核心配置文件
 */
@Configuration
@EnableDiscoveryClient
public class BaseConfiguration {


    /**
     * 相关基础工具配置类
     */
    @Configuration
    public static class BaseAutoConfiguration {
        /**
         * 装配Application工具类
         * @return
         */
        @Bean
        public ApplicationUtils getApplicationUtils(){
            return new ApplicationUtils();
        }
    }


    /**
     * web相关依赖
     */
    @Configuration
    public static class WebMvcConfiguration{
        /**
         * 装配全局异常处理器
         * @return
         */
        @Bean
        public GlobalException getGlobalException(){
            return new GlobalException();
        }



        /**
         * 注册web拦截器配置类
         * @return
         */
        @Bean
        public WebInterceptorConfig getWebInteceptorConfig(){
            return new WebInterceptorConfig();
        }
    }


    /**
     * nacos注册相关配置
     */
    @Configuration
    public static class NacosConfiguration{

    }


}
