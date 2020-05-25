package com.geekerstar.controller;


import com.geekerstar.annotation.Weblog;
import com.geekerstar.common.Response;
import com.geekerstar.domain.entity.SysUser;
import com.geekerstar.exception.ExceptionEntity;
import com.geekerstar.service.ISysUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表 SysUserController 前端控制器
 *
 * @author Geekerstar
 * @since 2020-01-31
 */
@Slf4j
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;

    @PostMapping("/getUser")
    @Weblog(description = "获取用户信息")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", required = true, defaultValue = "")
    })
    public Response<SysUser> getUser(@RequestParam String username) {
        SysUser result;
        try {
            result = iSysUserService.getUser(username);
        } catch (Exception e) {
            return Response.error((ExceptionEntity) e);
        }
        return Response.success(result);
    }

}
