package com.awsmith815.wgustudentapp.model;

import java.util.Date;

public class Course {

    private int courseId;
    private String courseTitle;
    private Date courseStartDate;
    private Date courseEstEndDate;
    private String courseStatus; //in-progress, completed, dropped, plan to take
    private int termId;

    public Course(int courseId, String courseTitle, Date courseStartDate, Date courseEstEndDate, String courseStatus, int termId) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseStartDate = courseStartDate;
        this.courseEstEndDate = courseEstEndDate;
        this.courseStatus = courseStatus;
        this.termId = termId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Date getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(Date courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public Date getCourseEstEndDate() {
        return courseEstEndDate;
    }

    public void setCourseEstEndDate(Date courseEstEndDate) {
        this.courseEstEndDate = courseEstEndDate;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    @Override
    public String toString() {
        return "Course{" +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseStartDate=" + courseStartDate +
                ", courseEstEndDate=" + courseEstEndDate +
                ", courseStatus='" + courseStatus + '\'' +
                '}';
    }
}
