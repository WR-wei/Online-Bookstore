package com.curry.dao.impl;

import com.curry.dao.CourseDao;
import com.curry.pojo.Course;

import java.util.List;

/**
 * @author RUIWU
 * @create 2020-11-25 16:59
 */
public class CourseDaoImpl extends BaseDao implements CourseDao {

    @Override
    public int addCourse(Course course) {
        String sql = "insert into t_course(courseName,courseCredit,courseTeacher,courseStuNum,courseCapacity) values(?,?,?,?,?)";
        return update(sql,course.getCourseName(),course.getCourseCredit(),course.getCourseTeacher(),
                course.getCourseStuNum(),course.getCourseCapacity());
    }

    @Override
    public int deleteCourseById(Integer courseId) {
        String sql = "delete from t_course where courseId = ?";
        return update(sql,courseId);
    }

    @Override
    public int updateCourse(Course course) {
        String sql = "update t_course set courseName=?,courseCredit=?,courseTeacher=?,courseStuNum=?,courseCapacity=? where courseId=? ";
        return update(sql,course.getCourseName(),course.getCourseCredit(),course.getCourseTeacher(),
                course.getCourseStuNum(),course.getCourseCapacity(),course.getCourseId());
    }

    @Override
    public Course queryCourseById(Integer courseId) {
        String sql = "select courseId,courseName,courseCredit,courseTeacher,courseStuNum,courseCapacity from t_course where courseId = ?";
        return queryForOne(Course.class,sql,courseId);
    }

    @Override
    public List<Course> queryCourses() {
        String sql = "select courseId,courseName,courseCredit,courseTeacher,courseStuNum,courseCapacity from t_course";
        return queryForList(Course.class,sql);
    }

    @Override
    public int queryForPageTotalCount() {
        String sql = "select count(*) from t_course";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Course> queryForPageItems(int begin, int pageSize) {

        String sql = "select courseId,courseName,courseCredit,courseTeacher,courseStuNum,courseCapacity from t_course limit ?,?";
        return queryForList(Course.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByCredit(double max, double min) {
        String sql = "select count(*) from t_course where courseCredit between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Course> queryForPageItemsByCredit(int begin, int pageSize, double max, double min) {
        String sql = "select courseId,courseName,courseCredit,courseTeacher,courseStuNum,courseCapacity " +
                "from t_course where courseCredit between ? and ? order by courseCredit limit ?,?";
        return queryForList(Course.class,sql,min,max,begin,pageSize);
    }
}
