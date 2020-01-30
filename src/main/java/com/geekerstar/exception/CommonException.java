package com.geekerstar.exception;

/**
 * @author geekerstar
 * date: 2019/12/22 09:04
 * description: 公共异常定义，公用的异常定义在这里
 */
public class CommonException {

    public static final BusinessException TEST_EXCEPTION = new BusinessException("C00001", "这个是示例，抛出具体信息写在这里");

    public static final BusinessException PARAMS_IS_MISSING = new BusinessException("C60005", "缺少参数!");

    public static final BusinessException PARAMS_IS_NULL = new BusinessException("C00001", "[%s]不能为空!");
    public static final BusinessException INFO_IS_NULL = new BusinessException("C60004", "信息不存在!");

    public static final BusinessException ABSENCE_DEPARTMENT = new BusinessException("C60006","部门表不存在该部门");

    public static final BusinessException LOGIN_FAIL = new BusinessException("C60006","用户名或密码错误！");
    public static final BusinessException LOGIN_NOT_EMPTY = new BusinessException("C60006","用户名或密码不能为空！");

    public static final BusinessException AJBH_JQBH_ERROR = new BusinessException("C60006","案件编号或警情编号有误！");



}
