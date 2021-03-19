package com.cvworld.nanjing.dao;

import com.cvworld.nanjing.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository <Role,Long>{

    Role findByRolename(String rolename);
}
