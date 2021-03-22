package com.laoma.admin.service;

import com.laoma.admin.bean.Menu;

import java.util.List;

public interface MenuService {
    Menu save(Menu menu);

    List<Menu> listMenu();

    void delete(Long id);

    Menu findById(Long id);

    List<Menu> searchByName(String name);
}
