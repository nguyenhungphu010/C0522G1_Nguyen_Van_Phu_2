package com.service.user;

import com.model.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAllRole();

    List<Role> getAllRoles();

    List<Role> getRoleByUsername(String email);
}
