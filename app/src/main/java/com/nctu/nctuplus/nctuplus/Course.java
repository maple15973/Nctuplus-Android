package com.nctu.nctuplus.nctuplus;

import java.util.Random;

/**
 * Created by cober on 2016/1/14.
 */
public class Course {
    private String name;
    private String teacher;
    private String semester;
    private String thumbnail;
    private CourseType type;
    private int classId;

    public Course() {

    }

    public Course(String name, String teacher, String semester, int classId, CourseType type) {
        this.name = name;
        this.teacher = teacher;
        this.semester = semester;
        this.classId = classId;
        this.type = type;
    }

    public CourseType getType() {
        return type;
    }

    public void CourseType(CourseType type) {
        this.type = type;
    }

    public String getNormalImageUrl() {
        Random rand = new Random();
        thumbnail = "http://lorempixel.com/200/200/?p=" + rand.nextInt(100) + 1;
        return thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
