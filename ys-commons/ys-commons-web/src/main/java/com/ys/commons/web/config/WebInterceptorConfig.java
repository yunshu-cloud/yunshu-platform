package com.ys.commons.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.List;

/**
 * 架构层 - 拦截器注册类
 */

public class WebInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    List<HandlerInterceptorAdapter> interceptorAdapters;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        if (interceptorAdapters != null){
            for (HandlerInterceptorAdapter interceptorAdapter : interceptorAdapters) {
                registry.addInterceptor(interceptorAdapter);
            }
        }
    }
}
