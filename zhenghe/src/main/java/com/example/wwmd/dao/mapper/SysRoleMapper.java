package com.example.wwmd.dao.mapper;

import com.example.wwmd.model.Role;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRoleMapper extends Mapper<Role> {

    @Select("SELECT r.* FROM role r, user_role ur WHERE r.rid = ur.role_id AND ur.user_id = #{userId}")
    List<Role> getRolesByUserId(Long userId);
}