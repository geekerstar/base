package com.geekerstar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geekerstar.entity.SysUser;
import com.geekerstar.mapper.SysUserMapper;
import com.geekerstar.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表 SysUserServiceImpl 服务实现类
 *
 * @author Geekerstar
 * @since 2020-01-31
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUser(String username) {
        return sysUserMapper.getUser(username);
    }
}
