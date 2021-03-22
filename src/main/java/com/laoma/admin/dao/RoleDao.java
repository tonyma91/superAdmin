package com.laoma.admin.dao;

import com.laoma.admin.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository <Role,Long>{

    Role findByRolename(String rolename);
}
