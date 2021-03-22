package com.laoma.admin.service.ImpI;

import com.laoma.admin.bean.Menu;
import com.laoma.admin.dao.MenuDao;
import com.laoma.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public Menu save(Menu menu) {
        return menuDao.save(menu);
    }

    @Override
    public List<Menu> listMenu() {
        return menuDao.findAll();
    }

    @Override
    public void delete(Long id) {
        menuDao.delete(Objects.requireNonNull(menuDao.findById(id).orElse(null)));
    }

    @Override
    public Menu findById(Long id) {
        return menuDao.findById(id).orElse(null);
    }

    @Override
    public List<Menu> searchByName(String name) {
        return menuDao.listMenu("%" + name + "%");
    }

}
