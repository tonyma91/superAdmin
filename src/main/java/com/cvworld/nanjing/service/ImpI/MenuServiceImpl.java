package com.cvworld.nanjing.service.ImpI;

import com.cvworld.nanjing.bean.Menu;
import com.cvworld.nanjing.dao.MenuDao;
import com.cvworld.nanjing.service.MenuService;
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
