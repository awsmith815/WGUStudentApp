package com.awsmith815.wgustudentapp.model;

public class CourseMentor {

    private int courseMentorId;
    private String courseMentorName;
    private String courseMentorPhone;
    private String courseMentorEmail;
    private int courseId;

    public CourseMentor(int courseMentorId, String courseMentorName, String courseMentorPhone, String courseMentorEmail, int courseId) {
        this.courseMentorId = courseMentorId;
        this.courseMentorName = courseMentorName;
        this.courseMentorPhone = courseMentorPhone;
        this.courseMentorEmail = courseMentorEmail;
        this.courseId = courseId;
    }

    public int getCourseMentorId() {
        return courseMentorId;
    }

    public void setCourseMentorId(int courseMentorId) {
        this.courseMentorId = courseMentorId;
    }

    public String getCourseMentorName() {
        return courseMentorName;
    }

    public void setCourseMentorName(String courseMentorName) {
        this.courseMentorName = courseMentorName;
    }

    public String getCourseMentorPhone() {
        return courseMentorPhone;
    }

    public void setCourseMentorPhone(String courseMentorPhone) {
        this.courseMentorPhone = courseMentorPhone;
    }

    public String getCourseMentorEmail() {
        return courseMentorEmail;
    }

    public void setCourseMentorEmail(String courseMentorEmail) {
        this.courseMentorEmail = courseMentorEmail;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "CourseMentor{" +
                "courseMentorName='" + courseMentorName + '\'' +
                ", courseMentorPhone='" + courseMentorPhone + '\'' +
                ", courseMentorEmail='" + courseMentorEmail + '\'' +
                '}';
    }
}
