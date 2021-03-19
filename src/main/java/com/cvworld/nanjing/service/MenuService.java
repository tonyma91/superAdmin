package com.cvworld.nanjing.service;

import com.cvworld.nanjing.bean.Menu;

import java.util.List;

public interface MenuService {
    Menu save(Menu menu);

    List<Menu> listMenu();

    void delete(Long id);

    Menu findById(Long id);

    List<Menu> searchByName(String name);
}
