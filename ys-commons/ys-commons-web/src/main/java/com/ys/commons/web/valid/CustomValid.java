package com.ys.commons.web.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomValidHandler.class)
public @interface CustomValid {
    String message() default "校验未通过";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 开发者自定义的校验处理器
     * @return
     */
    Class<? extends DevelopValidHandler> handler();

}
