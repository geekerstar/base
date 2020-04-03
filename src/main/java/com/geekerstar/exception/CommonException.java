package com.geekerstar.exception;

/**
 * @author geekerstar
 * date: 2019/12/22 09:04
 * description: 公共异常定义，公用的异常定义在这里
 */
public class CommonException {

    public static final ExceptionEntity UNKNOWN_EXCEPTION = new ExceptionEntity("100", "未知异常");
    public static final ExceptionEntity FORMAT_ERROR = new ExceptionEntity("101", "参数格式错误");
    public static final ExceptionEntity TIME_OUT = new ExceptionEntity("102", "超时");
    public static final ExceptionEntity ADD_ERROR = new ExceptionEntity("103", "添加失败");
    public static final ExceptionEntity UPDATE_ERROR = new ExceptionEntity("104", "更新失败");
    public static final ExceptionEntity DELETE_ERROR = new ExceptionEntity("105", "删除失败");
    public static final ExceptionEntity GET_ERROR = new ExceptionEntity("106", "查找失败");
    public static final ExceptionEntity ARGUMENT_TYPE_MISMATCH = new ExceptionEntity("107", "参数类型不匹配");
    public static final ExceptionEntity REQ_METHOD_NOT_SUPPORT = new ExceptionEntity("110", "请求方式不支持");


}
