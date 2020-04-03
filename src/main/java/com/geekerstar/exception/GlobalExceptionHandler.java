package com.geekerstar.exception;

import com.geekerstar.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

/**
 * @author geekerstar
 * @date 2020/4/3 11:33
 * @description 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
//    /**
//     * 自定义异常
//     */
//    @ExceptionHandler(value = CustomException.class)
//    public <T> Response<T> processException(CustomException e) {
//        log.error("位置:{} -> 错误信息:{}", e.getCause() ,e.getLocalizedMessage());
//        return Response.error(resultEnum.getCode().toString(),resultEnum.getMsg());
//    }

    /**
     * 拦截表单参数校验
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({BindException.class})
    public <T> Response<T> bindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String defaultMessage = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
        return Response.error("A10000", defaultMessage);
    }

    /**
     * 拦截JSON参数校验
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public <T> Response<T> bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String defaultMessage = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
        return Response.error("A20000", defaultMessage);
    }

    /**
     * 参数格式错误
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public <T> Response<T> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("错误信息{}", e.getLocalizedMessage());
        return Response.error(CommonException.ARGUMENT_TYPE_MISMATCH.getCode(), CommonException.ARGUMENT_TYPE_MISMATCH.getMessage());
    }

    /**
     * 参数格式错误
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public <T> Response<T> httpMessageNotReadable(HttpMessageNotReadableException e) {
        log.error("错误信息:{}", e.getLocalizedMessage());
        return Response.error(CommonException.FORMAT_ERROR.getCode(), CommonException.FORMAT_ERROR.getMessage());
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public <T> Response<T> httpReqMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        log.error("错误信息:{}", e.getLocalizedMessage());
        return Response.error(CommonException.REQ_METHOD_NOT_SUPPORT.getCode(), CommonException.REQ_METHOD_NOT_SUPPORT.getMessage());
    }

    /**
     * 通用异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public <T> Response<T> exception(Exception e) {
        e.printStackTrace();
        return Response.error(CommonException.UNKNOWN_EXCEPTION.getCode(), CommonException.UNKNOWN_EXCEPTION.getMessage());
    }
}
