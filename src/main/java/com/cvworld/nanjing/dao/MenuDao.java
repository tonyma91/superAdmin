package com.cvworld.nanjing.dao;

import com.cvworld.nanjing.bean.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuDao extends JpaRepository<Menu,Long> {

    @Query("select m from Menu m where m.menuname like ?1")

    List<Menu> listMenu(String name);

}
