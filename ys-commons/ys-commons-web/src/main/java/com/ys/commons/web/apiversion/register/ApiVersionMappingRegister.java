package com.ys.commons.web.apiversion.register;

import com.ys.commons.web.apiversion.ApiVersionHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class ApiVersionMappingRegister implements WebMvcRegistrations {

    /**
     * 替换掉springmvc默认的RequestMappingHandlerMapping
     * @return
     */
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new ApiVersionHandlerMapping();
    }
}
