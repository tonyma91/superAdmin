package com.cvworld.nanjing.service;

import com.cvworld.nanjing.bean.Organ;
import com.cvworld.nanjing.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrganService {

    List<Organ> findAll();

    //分页展示功能
    Page<Organ> findAll(Pageable pageable);

    //新建功能
    Organ saveOrgan(Organ organ);

    //搜索功能
    Page<Organ> listOrgan(String query, Pageable pageable);

    //编辑功能(根据id查找对象)
    Organ findById(Long id);

    //删除功能
    void deleteById(Long id);


}
