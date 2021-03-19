package com.cvworld.nanjing.dao;

import com.cvworld.nanjing.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.cvworld.nanjing.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);

    @Query("select u from User u where u.username like ?1")

    List<User> findByQuery(String query);
}
