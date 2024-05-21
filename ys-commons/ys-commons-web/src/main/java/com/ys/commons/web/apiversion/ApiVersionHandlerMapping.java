package com.ys.commons.web.apiversion;

import org.springframework.core.annotation.AnnotationUtils;
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
        // 获取类上的版本注解
        ApiVersion apiVersion = AnnotationUtils.getAnnotation(handlerType, ApiVersion.class);

        return new ApiVersionRequestCondition(apiVersion != null ? apiVersion.value() : 1.0);
    }


    /**
     * Spring容器初始化时触发
     * 工程中所有Controller中的所有方法都会进入该方法
     * @param method the handler method for which to create the condition
     * @return
     */
    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        ApiVersion apiVersion = AnnotationUtils.getAnnotation(method, ApiVersion.class);

        // 如果方法的版本注解为空， 尝试获取类上面的注解
        if (apiVersion == null){
            // 获取该方法类上面的注解
            apiVersion = AnnotationUtils.getAnnotation(method.getDeclaringClass(), ApiVersion.class);
        }

        return new ApiVersionRequestCondition(apiVersion != null ? apiVersion.value() : 1.0);
    }
}
