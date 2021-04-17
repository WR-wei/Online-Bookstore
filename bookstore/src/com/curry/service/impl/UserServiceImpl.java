package com.curry.service.impl;

import com.curry.dao.UserDao;
import com.curry.dao.impl.UserDaoImpl;
import com.curry.pojo.User;
import com.curry.service.UserService;

import java.util.List;

/**
 * @author RUIWU
 * @create 2020-11-23 11:36
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryByUsername(username) != null){
            return true;
        }
        return false;
    }

    @Override
    public List queryAllUsers() {
        return userDao.queryAllUsers();
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }
}
