package com.geekerstar.exception;

/**
 * @author geekerstar
 * date: 2019/12/22 09:04
 * description: 公共异常定义，公用的异常定义在这里
 */
public class CommonException {

    public static final BusinessException UNKNOWN_EXCEPTION = new BusinessException("100", "未知异常");
    public static final BusinessException FORMAT_ERROR = new BusinessException("101", "参数格式错误");
    public static final BusinessException TIME_OUT = new BusinessException("102", "超时");
    public static final BusinessException ADD_ERROR = new BusinessException("103", "添加失败");
    public static final BusinessException UPDATE_ERROR = new BusinessException("104", "更新失败");
    public static final BusinessException DELETE_ERROR = new BusinessException("105", "删除失败");
    public static final BusinessException GET_ERROR = new BusinessException("106", "查找失败");
    public static final BusinessException ARGUMENT_TYPE_MISMATCH = new BusinessException("107", "参数类型不匹配");
    public static final BusinessException REQ_METHOD_NOT_SUPPORT = new BusinessException("110", "请求方式不支持");


}
