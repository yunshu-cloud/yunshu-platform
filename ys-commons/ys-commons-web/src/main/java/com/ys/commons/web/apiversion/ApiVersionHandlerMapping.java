package com.ys.commons.web.apiversion;

import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 增强RequestMappingHandlerMapping
 */
public class ApiVersionHandlerMapping extends RequestMappingHandlerMapping {

    /**
     * Spring容器初始化触发
     * 工程中所有的Controller都会进入该方法
     *
     * @param handlerType the handler type for which to create the condition -- Controller的class类型
     * @return
     */
    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        return super.getCustomTypeCondition(handlerType);
    }


    /**
     * Spring容器初始化时触发
     * 工程中所有Controller中的所有方法都会进入该方法
     * @param method the handler method for which to create the condition
     * @return
     */
    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        return super.getCustomMethodCondition(method);
    }
}
