package com.curry.dao.impl;

import com.curry.dao.UserDao;
import com.curry.pojo.User;

import java.util.List;

/**
 * @author RUIWU
 * @create 2020-11-23 10:59
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryByUsername(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public int deleteUser(Integer id) {
        String sql = "delete from t_user where id = ?";
        return update(sql,id);
    }

    @Override
    public List queryAllUsers() {
        String sql = "select * from t_user";
        return queryForList(User.class,sql);
    }
}
