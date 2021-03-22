package com.laoma.admin.dao;

import com.laoma.admin.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);

    @Query("select u from User u where u.username like ?1")

    List<User> findByQuery(String query);
}
