package com.ys.commons.web.valid;

/**
 * 执行校验逻辑的接口
 */
public interface DevelopValidHandler<T> {
    boolean isValid(CustomValid customValid, T value);
}
