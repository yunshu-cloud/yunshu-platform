package com.ys.commons.web.devicetype.register;

import com.ys.commons.web.devicetype.DeviceTypeHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class DeviceTypeMappingRegister implements WebMvcRegistrations {
    /**
     * 替换掉springmvc默认的RequestMappingHandlerMapping
     * @return
     */
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new DeviceTypeHandlerMapping();
    }
}
