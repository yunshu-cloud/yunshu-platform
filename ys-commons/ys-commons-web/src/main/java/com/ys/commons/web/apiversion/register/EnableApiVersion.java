package com.ys.commons.web.apiversion.register;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 多版本接口的启用注解
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ApiVersionMappingRegister.class)
public @interface EnableApiVersion {
}
