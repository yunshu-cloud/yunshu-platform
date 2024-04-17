package com.ys.commons.web.valid;

import com.ys.commons.web.utils.ApplicationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidHandler implements ConstraintValidator<CustomValid, Object> {

    private CustomValid customValid;

    @Override
    public void initialize(CustomValid constraintAnnotation) {
        this.customValid = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value != null){
            // 获取开发者自定义的处理器类型
            Class<? extends DevelopValidHandler> handlerClass = customValid.handler();
            // 通过开发者给的类型从容器中获取Bean对象
            DevelopValidHandler developValidHandler = ApplicationUtils.getBean(handlerClass);
            if (developValidHandler == null){
                return true;
            }
            return developValidHandler.isValid(customValid, value);
        }
        return true;
    }
}
