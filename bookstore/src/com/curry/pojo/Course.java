package com.curry.pojo;

/**
 * @author RUIWU
 * @create 2020-11-25 16:29
 */
public class Course {
    private Integer courseId;
    private String courseName;
    private String courseTeacher;
    private Double courseCredit;
    private Integer courseStuNum;
    private Integer courseCapacity;

    public Course() {
    }

    public Course(Integer courseId, String courseName, String courseTeacher, Double courseCredit, Integer courseStuNum, Integer courseCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        this.courseCredit = courseCredit;
        this.courseStuNum = courseStuNum;
        this.courseCapacity = courseCapacity;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                ", courseCredit=" + courseCredit +
                ", courseStuNum=" + courseStuNum +
                ", courseCapacity=" + courseCapacity +
                '}';
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public Double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Double courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Integer getCourseStuNum() {
        return courseStuNum;
    }

    public void setCourseStuNum(Integer courseStuNum) {
        this.courseStuNum = courseStuNum;
    }

    public Integer getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(Integer courseCapacity) {
        this.courseCapacity = courseCapacity;
    }
}
