package com.curry.dao;

import com.curry.pojo.Course;

import java.util.List;

/**
 * @author RUIWU
 * @create 2020-11-25 16:24
 */
public interface CourseDao {
    /**
     * 添加新开的课程
     * @param course 新课信息
     * @return 返回-1表示失败
     */
    int addCourse(Course course);

    /**
     * 通过id删除关闭的课程
     * @param courseId
     * @return 返回-1表示失败
     */
    int deleteCourseById(Integer courseId);

    /**
     * 修改课程的相关信息
     * @param course 课程信息
     * @return 返回-1表示失败
     */
    int updateCourse(Course course);

    /**
     * 通过id查询课程信息
     * @param id 课程id
     * @return 返回课程信息
     */
    Course queryCourseById(Integer id);

    /**
     * 查询所有课程
     * @return 返回全部课程信息，用List集合包装
     */
    List<Course> queryCourses();

    /**
     * 查询总的记录数
     * @return 返回总的记录数
     */
    int queryForPageTotalCount();

    /**
     * 查询当前页数据
     * @param begin
     * @param pageSize
     * @return 返回当前页数据
     */
    List<Course> queryForPageItems(int begin,int pageSize);

    /**
     * 通过总的记录数
     * @param min
     * @param max
     * @return
     */
    Integer queryForPageTotalCountByCredit(double max,double min);

    /**
     * 通过学分查询当前页数据
     * @param begin
     * @param pageSize
     * @param max
     * @param min
     * @return
     */
    List<Course> queryForPageItemsByCredit(int begin, int pageSize, double max, double min);
}
