package com.curry.service;

import com.curry.pojo.Course;
import com.curry.pojo.Page;

import java.util.List;

/**
 * @author RUIWU
 * @create 2020-11-25 16:34
 */
public interface CourseService {

    void addCourse(Course course);

    void deleteCourseById(Integer courseId);

    void updateCourse(Course course);

    Course queryCourseById(Integer courseId);

    List<Course> queryCourses();

    Page<Course> page(int pageNo, int pageSize);

    Page<Course> pageByCredit(int pageNo, int pageSize, double max, double min);
}









