package com.example.wwmd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "`permission`")
public class Permission extends BaseEntity implements Serializable {
    /**
     * 菜单/按钮id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 上级菜单id
     */
    @Column(name = "`parent_id`")
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    @Column(name = "`permission_name`")
    private String permissionName;

    /**
     * 菜单url
     */
    @Column(name = "`url`")
    private String url;

    /**
     * 权限代码字符串
     */
    @Column(name = "`perms`")
    private String perms;

    /**
     * 图标
     */
    @Column(name = "`icon`")
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    @Column(name = "`type`")
    private String type;

    /**
     * 排序
     */
    @Column(name = "`order_num`")
    private Long orderNum;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "`modify_time`")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取菜单/按钮id
     *
     * @return id - 菜单/按钮id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置菜单/按钮id
     *
     * @param id 菜单/按钮id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取上级菜单id
     *
     * @return parent_id - 上级菜单id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级菜单id
     *
     * @param parentId 上级菜单id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取菜单/按钮名称
     *
     * @return permission_name - 菜单/按钮名称
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 设置菜单/按钮名称
     *
     * @param permissionName 菜单/按钮名称
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * 获取菜单url
     *
     * @return url - 菜单url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单url
     *
     * @param url 菜单url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取权限代码字符串
     *
     * @return perms - 权限代码字符串
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 设置权限代码字符串
     *
     * @param perms 权限代码字符串
     */
    public void setPerms(String perms) {
        this.perms = perms;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取类型 0菜单 1按钮
     *
     * @return type - 类型 0菜单 1按钮
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型 0菜单 1按钮
     *
     * @param type 类型 0菜单 1按钮
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取排序
     *
     * @return order_num - 排序
     */
    public Long getOrderNum() {
        return orderNum;
    }

    /**
     * 设置排序
     *
     * @param orderNum 排序
     */
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
}