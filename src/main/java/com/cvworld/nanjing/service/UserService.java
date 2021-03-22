package com.cvworld.nanjing.service;

import com.cvworld.nanjing.bean.User;

import java.util.List;

public interface UserService {

    List<User>  findall();

    User findUser(String name, String password);

    User saveuser(User user);

    User findUser(Long id);

    void deleteById(Long id);

    //查询函数
    List<User> listUser(String query);
}
