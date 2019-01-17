package com.example.wwmd.model;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "`role_permission`")
public class RolePermission extends BaseEntity implements Serializable {
    /**
     * 角色id
     */
    @Column(name = "`role_id`")
    private Long roleId;

    /**
     * 菜单/按钮id
     */
    @Column(name = "`permission_id`")
    private Long permissionId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单/按钮id
     *
     * @return permission_id - 菜单/按钮id
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 设置菜单/按钮id
     *
     * @param permissionId 菜单/按钮id
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}