package com.ys.commons.web.exception;

import com.ys.commons.web.r.Codes;
import com.ys.commons.web.r.R;
import com.ys.commons.web.r.RUtils;
import com.ys.commons.web.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintDefinitionException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.net.BindException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * description: RestController层的异常统一处理
 */
@Slf4j
@RestControllerAdvice //  增强器
public class GlobalException {


    /**
     * 参数校验异常的统一处理
     * @return
     */
    @ExceptionHandler(BindException.class)
    public R bindExceptionHandler(BindException exception){
        return RUtils.create(Codes.PARAMETER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public R constraintViolationExceptionHandler(ConstraintViolationException exception){
        Set<String> errors = exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
        return RUtils.create(Codes.PARAMETER_ERROR, errors);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
        Set<String> errors = exception.getBindingResult().getAllErrors()
                .stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.toSet());
        return RUtils.create(Codes.PARAMETER_ERROR, errors);
    }



    /**
     * 统一异常处理方法
     * @param t
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public R exceptionHandler(Throwable t){
        try{
            // 获取当前请求的url
            HttpServletRequest request = RequestUtils.getHttpServletRequest();
            // 获取请求的url
            if (request != null){
                String uri = request.getRequestURI().toString();
                log.error("[Global-Exception] - 捕获到全局异常信息, url:"+ uri,t);
            }
        } catch (Exception e){
            log.error("[Global-Exception] - 捕获到全局异常信息！", t);
        }

        return RUtils.create(Codes.FAIL);
    }
}
