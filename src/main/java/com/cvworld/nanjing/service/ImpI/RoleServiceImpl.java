package com.cvworld.nanjing.service.ImpI;

import com.cvworld.nanjing.bean.Role;
import com.cvworld.nanjing.dao.RoleDao;
import com.cvworld.nanjing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findRole(Long id) {
        return roleDao.findById(id).orElse(null);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.save(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleDao.delete(role);
    }

    @Override
    public Role getRoleByName(String rolename) {
        return roleDao.findByRolename(rolename);
    }


}
