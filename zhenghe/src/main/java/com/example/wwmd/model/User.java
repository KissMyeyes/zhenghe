package com.example.wwmd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;


/**
 * @author wagnwei
 */
@Data
@Table(name = "`user`")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 734833154199607416L;
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
}