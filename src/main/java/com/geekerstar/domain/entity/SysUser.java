package com.geekerstar.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表SysUser
 *
 * @author Geekerstar
 * @since 2020-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysUser对象", description = "用户表")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "登录账号")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "md5密码盐")
    private String salt;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "生日")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "性别(0-默认未知,1-男,2-女)")
    private Boolean sex;

    @ApiModelProperty(value = "电子邮件")
    private String email;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "机构编码")
    private String orgCode;

    @ApiModelProperty(value = "性别(1-正常,2-冻结)")
    private Boolean status;

    @ApiModelProperty(value = "删除状态(0-正常,1-已删除)")
    private Boolean delFlag;

    @ApiModelProperty(value = "同步工作流引擎(1-同步,0-不同步)")
    private Boolean activitiSync;

    @ApiModelProperty(value = "工号，唯一键")
    private String workNo;

    @ApiModelProperty(value = "职务，关联职务表")
    private String post;

    @ApiModelProperty(value = "座机号")
    private String telephone;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
