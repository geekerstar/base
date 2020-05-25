package com.geekerstar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geekerstar.domain.entity.SysUser;
import org.springframework.stereotype.Service;

/**
 * 用户表 ISysUserService 服务类
 *
 * @author Geekerstar
 * @since 2020-01-31
 */
@Service
public interface ISysUserService extends IService<SysUser> {

    SysUser getUser(String username);
}
