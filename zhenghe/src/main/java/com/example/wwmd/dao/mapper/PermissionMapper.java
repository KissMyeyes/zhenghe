package com.example.wwmd.dao.mapper;

import com.example.wwmd.model.Permission;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {
    List<Permission> findUserPermissions(Long userId);
}