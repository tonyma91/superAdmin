package com.cvworld.nanjing.service.ImpI;

import com.cvworld.nanjing.bean.User;
import com.cvworld.nanjing.dao.UserDao;
import com.cvworld.nanjing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@CacheConfig(cacheNames = {"user","user"})
public class UserServiceImpi implements UserService {

    @Autowired
    private UserDao userDao;



    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<User> findall() {

        return userDao.findAll();
    }

//    @Cacheable({"name"})
    @Override
    public User findUser(String name, String password) {
//        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
//        ops.set("hello","world");
//        System.out.println( ops.get("hello"));
//        System.out.println("走findUser方法");
        return userDao.findByUsernameAndPassword(name,password);
    }

//    @CachePut({"name1"})
    @Override
    public User saveuser(User user) {
//        System.out.println("走saveuser方法");
        return userDao.save(user);

    }
//    @Cacheable({"name2"})
    @Override
    public User findUser(Long id) {
        return userDao.findById(id).orElse(null);
    }

//    @CacheEvict()
    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
    //通过关键字查询用户
//    @Cacheable()
    @Override
    public List<User> listUser(String query) {
        return userDao.findByQuery(query);
    }
}
