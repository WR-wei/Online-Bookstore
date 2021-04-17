package com.curry.service.impl;

import com.curry.dao.CourseDao;
import com.curry.dao.impl.CourseDaoImpl;
import com.curry.pojo.Course;
import com.curry.pojo.Page;
import com.curry.service.CourseService;

import java.util.List;

/**
 * @author RUIWU
 * @create 2020-11-25 17:57
 */
public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();
    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public void deleteCourseById(Integer courseId) {
        courseDao.deleteCourseById(courseId);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public Course queryCourseById(Integer courseId) {
        return courseDao.queryCourseById(courseId);
    }

    @Override
    public List<Course> queryCourses() {
        return courseDao.queryCourses();
    }

    @Override
    public Page<Course> page(int pageNo, int pageSize) {
        Page<Course> page = new Page();

        // 求总记录数
        Integer pageTotalCount = courseDao.queryForPageTotalCount();

        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);

        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }

        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;

        // 求当前页数据
        List<Course> items = courseDao.queryForPageItems(begin,pageSize);


        // 设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Course> pageByCredit(int pageNo, int pageSize, double max, double min) {
        Page<Course> page = new Page();

        // 求总记录数
        Integer pageTotalCount = courseDao.queryForPageTotalCountByCredit(max,min);

        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);

        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }

        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;

        // 求当前页数据
        List<Course> items = courseDao.queryForPageItemsByCredit(begin,pageSize,max,min);

        // 设置当前页数据
        page.setItems(items);

        return page;
    }
}
