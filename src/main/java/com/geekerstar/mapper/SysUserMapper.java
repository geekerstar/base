package com.geekerstar.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.geekerstar.domain.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
 * 用户表 SysUserMapper Mapper 接口
 *
 * @author Geekerstar
 * @since 2020-01-31
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser getUser(String username);
}
