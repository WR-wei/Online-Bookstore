package com.curry.test;

import com.curry.dao.CourseDao;
import com.curry.dao.UserDao;
import com.curry.dao.impl.CourseDaoImpl;
import com.curry.dao.impl.UserDaoImpl;
import com.curry.pojo.Course;
import com.curry.pojo.Page;
import com.curry.pojo.User;
import com.curry.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author RUIWU
 * @create 2020-11-23 10:42
 */
public class ConnectionTest {

    //测试连接是否正常
    @Test
    public void test(){
        JdbcUtils util = new JdbcUtils();
        Connection conn = util.getConnection();
        System.out.println(conn);
        util.closeResource(conn);
    }

    //测试插入数据
    @Test
    public void test01(){
        UserDao userDao = new UserDaoImpl();
        User user = new User(null,"吴瑞","123456","123456@qq.com");
        userDao.saveUser(user);
    }

    //测试查询数据
    @Test
    public void test02(){
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryByUsername("wurui"));
        System.out.println(userDao.queryByUsernameAndPassword("wurui","123456"));
    }

    //测试插入课程
    @Test
    public void test03(){
        CourseDao courseDao = new CourseDaoImpl();
        Course course = new Course(null,"算法设计","hxq",
                new Double(5),new Integer(100),new Integer(120));

        System.out.println(courseDao.addCourse(course));
    }

    //测试删除课程
    @Test
    public void test04(){
        CourseDao courseDao = new CourseDaoImpl();

        System.out.println(courseDao.deleteCourseById(new Integer(4)));
    }
    //测试修改课程

    @Test
    public void test05(){
        CourseDao courseDao = new CourseDaoImpl();
        Course course = new Course(2,"算法设计","hexiaoqiang",
                new Double(5),new Integer(100),new Integer(120));

        System.out.println(courseDao.updateCourse(course));
    }

    //测试查询课程
    @Test
    public void test06(){
        CourseDao courseDao = new CourseDaoImpl();

        System.out.println(courseDao.queryCourseById(new Integer(2)));
    }

    //测试查询全部课程
    @Test
    public void test07(){
        CourseDao courseDao = new CourseDaoImpl();

        System.out.println(courseDao.queryCourses());
    }

    //测试分页功能
    @Test
    public void test08(){
        CourseDao courseDao = new CourseDaoImpl();
        System.out.println(courseDao.queryForPageItems(5, Page.PAGE_SIZE));
        System.out.println(courseDao.queryForPageTotalCount());
    }

    //测试分页功能
    @Test
    public void test09(){
        CourseDao courseDao = new CourseDaoImpl();
        System.out.println(courseDao.queryForPageItemsByCredit(5, Page.PAGE_SIZE,5.0,1.0));
//        System.out.println(courseDao.queryForPageTotalCountByCredit(50.0,10.0));
    }

}
