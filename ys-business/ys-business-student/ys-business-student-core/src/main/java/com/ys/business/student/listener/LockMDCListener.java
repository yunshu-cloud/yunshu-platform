package com.ys.business.student.listener;

import org.slf4j.MDC;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * 监听Springboot的环境参数准备好的事件
 */
public class LockMDCListener implements GenericApplicationListener {

    private static final String APPLICATION_CONFIG_PROPERTIES = "configurationProperties";

    private static final String APP_NAME = "spring.application.name";
    /**
     * 表示 监听的事件类型
     * @param resolvableType
     * @return  true--是监听的事件
     */
    @Override
    public boolean supportsEventType(ResolvableType resolvableType) {
        boolean res = ApplicationEnvironmentPreparedEvent.class == resolvableType.getRawClass();
        return res;
    }

    /**
     * supportsEventType is true,then below method will be executed
     * @param applicationEvent -- current listening event object
     */
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        ApplicationEnvironmentPreparedEvent environmentPreparedEvent = (ApplicationEnvironmentPreparedEvent) applicationEvent;

        ConfigurableEnvironment environment = environmentPreparedEvent.getEnvironment();

        MutablePropertySources propertySources = environment.getPropertySources();

        PropertySource<?> propertySource = propertySources.get(APPLICATION_CONFIG_PROPERTIES);
        String appName = (String) propertySource.getProperty(APP_NAME);
        System.out.println("微服务名称"+appName);


        MDC.put("logName",appName);
    }
}
