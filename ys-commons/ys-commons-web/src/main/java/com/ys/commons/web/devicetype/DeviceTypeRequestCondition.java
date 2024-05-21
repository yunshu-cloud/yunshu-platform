package com.ys.commons.web.devicetype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceTypeRequestCondition implements RequestCondition<DeviceTypeRequestCondition> {

    private String deviceType = "android";

    private static final String DEVICE_TYPE_NAME = "device-type";

    @Override
    public DeviceTypeRequestCondition combine(DeviceTypeRequestCondition other) {
        return other;
    }

    @Override
    public DeviceTypeRequestCondition getMatchingCondition(HttpServletRequest request) {
        String defaultType = "android";
        String deviceType = request.getHeader(DEVICE_TYPE_NAME);
        if (StringUtils.isEmpty(deviceType)){
            deviceType = request.getParameter(DEVICE_TYPE_NAME);
        }
        if (!StringUtils.isEmpty(deviceType)){
            defaultType = deviceType;
            // this.getDeviceType 是在Controller层的注解标识的 defaultType是前端传递的
            if (this.getDeviceType().equals(defaultType)){
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(DeviceTypeRequestCondition other, HttpServletRequest request) {
        return 0;
    }
}
