package com.cvworld.nanjing.service;

import com.cvworld.nanjing.bean.Role;
import com.cvworld.nanjing.bean.User;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findRole(Long id);

    void saveRole(Role role);

    void deleteRole(Role role);

    Role getRoleByName(String rolename);

}
