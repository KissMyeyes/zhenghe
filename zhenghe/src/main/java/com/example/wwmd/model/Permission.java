package com.example.wwmd.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`sys_permission`")
public class Permission extends BaseEntity implements Serializable {

    /**
     * 权限类型：菜单
     */
    public static int PTYPE_MENU = 1;
    /**
     * 权限类型：按钮
     */
    public static int PTYPE_BUTTON = 2;

    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 资源类型：menu,button,
     */
    @Column(name = "`type`")
    private String type;

    /**
     * 访问url地址
     */
    @Column(name = "`url`")
    private String url;

    /**
     * 权限代码字符串
     */
    @Column(name = "`per_code`")
    private String perCode;

    /**
     * 父结点id
     */
    @Column(name = "`parent_id`")
    private Long parentId;

    /**
     * 父结点id列表串
     */
    @Column(name = "`parent_ids`")
    private String parentIds;

    /**
     * 排序号
     */
    @Column(name = "`sorted`")
    private String sorted;

    /**
     * 是否可用,1：可用，0不可用
     */
    @Column(name = "`available`")
    private String available;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取资源名称
     *
     * @return name - 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称
     *
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取资源类型：menu,button,
     *
     * @return type - 资源类型：menu,button,
     */
    public String getType() {
        return type;
    }

    /**
     * 设置资源类型：menu,button,
     *
     * @param type 资源类型：menu,button,
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取访问url地址
     *
     * @return url - 访问url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置访问url地址
     *
     * @param url 访问url地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取权限代码字符串
     *
     * @return per_code - 权限代码字符串
     */
    public String getPerCode() {
        return perCode;
    }

    /**
     * 设置权限代码字符串
     *
     * @param perCode 权限代码字符串
     */
    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }

    /**
     * 获取父结点id
     *
     * @return parent_id - 父结点id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父结点id
     *
     * @param parentId 父结点id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取父结点id列表串
     *
     * @return parent_ids - 父结点id列表串
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置父结点id列表串
     *
     * @param parentIds 父结点id列表串
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 获取排序号
     *
     * @return sorted - 排序号
     */
    public String getSorted() {
        return sorted;
    }

    /**
     * 设置排序号
     *
     * @param sorted 排序号
     */
    public void setSorted(String sorted) {
        this.sorted = sorted;
    }

    /**
     * 获取是否可用,1：可用，0不可用
     *
     * @return available - 是否可用,1：可用，0不可用
     */
    public String getAvailable() {
        return available;
    }

    /**
     * 设置是否可用,1：可用，0不可用
     *
     * @param available 是否可用,1：可用，0不可用
     */
    public void setAvailable(String available) {
        this.available = available;
    }
}