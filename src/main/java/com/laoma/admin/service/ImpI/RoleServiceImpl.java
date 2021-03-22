package com.laoma.admin.service.ImpI;

import com.laoma.admin.bean.Role;
import com.laoma.admin.dao.RoleDao;
import com.laoma.admin.service.RoleService;
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
