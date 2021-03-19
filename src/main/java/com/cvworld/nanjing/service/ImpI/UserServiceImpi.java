package com.cvworld.nanjing.service.ImpI;

import com.cvworld.nanjing.bean.User;
import com.cvworld.nanjing.dao.UserDao;
import com.cvworld.nanjing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpi implements UserService {

    @Autowired
    private UserDao userDao;



    @Override
    public List<User> findall() {
        return userDao.findAll();
    }

    @Override
    public User findUser(String name, String password) {
        return userDao.findByUsernameAndPassword(name,password);
    }

    @Override
    public void saveuser(User user) {
        userDao.save(user);
    }

    @Override
    public User findUser(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {

        userDao.deleteById(id);
    }
    //通过关键字查询用户
    @Override
    public List<User> listUser(String query) {
        return userDao.findByQuery(query);
    }
}
