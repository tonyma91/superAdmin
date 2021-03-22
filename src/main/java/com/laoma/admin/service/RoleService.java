package com.laoma.admin.service;

import com.laoma.admin.bean.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findRole(Long id);

    void saveRole(Role role);

    void deleteRole(Role role);

    Role getRoleByName(String rolename);

}
