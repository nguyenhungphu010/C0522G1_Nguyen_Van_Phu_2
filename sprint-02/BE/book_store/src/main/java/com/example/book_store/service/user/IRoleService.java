package com.example.book_store.service.user;

import com.example.book_store.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAllRole();

    List<Role> getAllRoles();

    List<Role> getRoleByUsername(String email);
}
