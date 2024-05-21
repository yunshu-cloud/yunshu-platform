package com.ys.commons.web.devicetype.register;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(DeviceTypeMappingRegister.class)
public @interface EnableDeviceType {
}
