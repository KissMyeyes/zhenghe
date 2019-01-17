package com.example.wwmd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "`user`")
public class User extends BaseEntity implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "`user_name`")
    private String userName;

    /**
     * 账号
     */
    @Column(name = "`real_name`")
    private String realName;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 部门id
     */
    @Column(name = "`dept_id`")
    private Long deptId;

    /**
     * 邮箱
     */
    @Column(name = "`email`")
    private String email;

    /**
     * 联系电话
     */
    @Column(name = "`mobile`")
    private String mobile;

    /**
     * 状态 0锁定 1有效
     */
    @Column(name = "`locked`")
    private String locked;

    /**
     * 创建时间
     */
    @Column(name = "`crate_time`")
    private Date crateTime;

    /**
     * 修改时间
     */
    @Column(name = "`modify_time`")
    private Date modifyTime;

    /**
     * 最近访问时间
     */
    @Column(name = "`last_login_time`")
    private Date lastLoginTime;

    /**
     * 性别 0男 1女
     */
    @Column(name = "`ssex`")
    private String ssex;

    /**
     * 主题
     */
    @Column(name = "`theme`")
    private String theme;

    /**
     * 头像
     */
    @Column(name = "`avatar`")
    private String avatar;

    /**
     * 描述
     */
    @Column(name = "`description`")
    private String description;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取账号
     *
     * @return real_name - 账号
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置账号
     *
     * @param realName 账号
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系电话
     *
     * @return mobile - 联系电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置联系电话
     *
     * @param mobile 联系电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取状态 0锁定 1有效
     *
     * @return locked - 状态 0锁定 1有效
     */
    public String getLocked() {
        return locked;
    }

    /**
     * 设置状态 0锁定 1有效
     *
     * @param locked 状态 0锁定 1有效
     */
    public void setLocked(String locked) {
        this.locked = locked;
    }

    /**
     * 获取创建时间
     *
     * @return crate_time - 创建时间
     */
    public Date getCrateTime() {
        return crateTime;
    }

    /**
     * 设置创建时间
     *
     * @param crateTime 创建时间
     */
    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取最近访问时间
     *
     * @return last_login_time - 最近访问时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最近访问时间
     *
     * @param lastLoginTime 最近访问时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取性别 0男 1女
     *
     * @return ssex - 性别 0男 1女
     */
    public String getSsex() {
        return ssex;
    }

    /**
     * 设置性别 0男 1女
     *
     * @param ssex 性别 0男 1女
     */
    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    /**
     * 获取主题
     *
     * @return theme - 主题
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 设置主题
     *
     * @param theme 主题
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}