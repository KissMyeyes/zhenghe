package com.example.wwmd.service;

import com.example.wwmd.dao.mapper.PermissionMapper;
import com.example.wwmd.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by CaiBaoHong at 2018/4/18 16:08<br>
 */
@Service
public class PermService {
    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 模拟根据用户id查询返回用户的所有权限，实际查询语句参考：
     * SELECT p.pval FROM perm p, role_perm rp, user_role ur
     * WHERE p.pid = rp.perm_id AND ur.role_id = rp.role_id
     * AND ur.user_id = #{userId}
     *
     * @param uid
     * @return
     */
    public Set<String> getPermsByUserId(Long uid) {
        Set<String> perms = new HashSet<>();
        //三种编程语言代表三种角色：js程序员、java程序员、c++程序员
        //js程序员的权限
        perms.add("html:edit");
        //c++程序员的权限
        perms.add("hardware:debug");
        //java程序员的权限
        perms.add("mvn:install");
        perms.add("mvn:clean");
        perms.add("mvn:test");
        return perms;
    }

    public List<Permission> findUserPermissions(Long userId) {
        return permissionMapper.findUserPermissions(userId);
    }
}
