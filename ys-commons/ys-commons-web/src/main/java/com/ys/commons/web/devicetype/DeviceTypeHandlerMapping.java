package com.ys.commons.web.devicetype;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class DeviceTypeHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        DeviceType deviceType = AnnotationUtils.getAnnotation(handlerType, DeviceType.class);
        // 设置 设备类型
        return new DeviceTypeRequestCondition(deviceType != null ? deviceType.value() : "android");
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        DeviceType deviceType = AnnotationUtils.getAnnotation(method, DeviceType.class);

        if (deviceType == null){
            deviceType = AnnotationUtils.getAnnotation(method.getDeclaringClass(), DeviceType.class);
        }
        return new DeviceTypeRequestCondition(deviceType != null ? deviceType.value() : "android");
    }
}
