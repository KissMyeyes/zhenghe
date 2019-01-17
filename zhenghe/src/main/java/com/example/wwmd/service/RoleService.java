package com.example.wwmd.service;

import com.example.wwmd.dao.mapper.RoleMapper;
import com.example.wwmd.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by CaiBaoHong at 2018/4/18 16:08<br>
 */
@Service
public class RoleService {
    @Autowired
    private RoleMapper sysRoleMapper;

    /**
     * 模拟根据用户id查询返回用户的所有角色，实际查询语句参考：
     * SELECT r.rval FROM role r, user_role ur
     * WHERE r.rid = ur.role_id AND ur.user_id = #{userId}
     *
     * @param userId
     * @return
     */
    public List<Role> getRolesByUserId(Long userId) {
        return sysRoleMapper.getRolesByUserId(userId);
//        Set<String> roles = new HashSet<>();
//        //三种编程语言代表三种角色：js程序员、java程序员、c++程序员
//        roles.add("js");
//        roles.add("java");
//        roles.add("cpp");
//        return roles;
    }


}
