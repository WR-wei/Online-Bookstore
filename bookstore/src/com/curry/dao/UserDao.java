package com.curry.dao;

import com.curry.pojo.User;

import java.util.List;

/**
 * @author RUIWU
 * @create 2020-11-23 9:50
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return
     */
     public User queryByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
     public User queryByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 返回-1表示保存失败，返回其他是sql影响的行数
     */
     public int saveUser(User user);

    /**
     * 删除用户信息
     *
     * @param id
     * @return 返回-1表示失败
     */
     public int deleteUser(Integer id);

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    public List queryAllUsers();
}
