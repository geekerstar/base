package com.geekerstar.common;

import com.geekerstar.exception.BusinessException;
import com.geekerstar.exception.SystemException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author geekerstar
 * date: 2019/12/22 09:25
 * description:
 */
@Getter
@ApiModel("响应实体")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 729196429762925859L;

    private static final Boolean SUCCESS = true;
    private static final Boolean FAILED = false;
    private static final String SUCCESS_CODE = "200";
    private static final String SUCCESS_MSG = "OK";

    @ApiModelProperty(value = "是否成功")
    private boolean success;
    @ApiModelProperty(value="返回码值", example="200")
    private String code;
    @ApiModelProperty(value="状态信息")
    private String message;
    @ApiModelProperty(value="返回数据")
    private T results;

    public static <T> Result<String> success(String results) {
        return newResult(SUCCESS,SUCCESS_CODE, SUCCESS_MSG, results);
    }

    public static <T> Result<T> success(T results) {
        return newResult(SUCCESS,SUCCESS_CODE, SUCCESS_MSG, results);
    }

    public static <T> Result<T> success(String message, T results) {
        return newResult(SUCCESS,SUCCESS_CODE, message, results);
    }

    public static <T> Result<T> failed() {
        return failed(SystemException.SYS_ERROR);
    }

    public static <T> Result<T> failed(String code, String message) {
        return newResult(FAILED,code, message, null);
    }

    public static <T> Result<T> failed(BusinessException e) {
        return newResult(FAILED,e.getCode(), e.getMessage(), null);
    }

    public static <T> Result<T> newResult(Boolean success,String code, String message, T results) {
        return new Result<T>(success, code, message, results);
    }

    private Result(Boolean success, String code, String message, T results) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.results = results;
    }

    @Override
    public String toString() {
        return "Result [success=" + success +", code=" + code + ", message=" + message + ", results=" + results + "]";
    }
}
