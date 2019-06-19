package com.awsmith815.wgustudentapp.model;

import java.util.Date;

public class Assessment {

    private int assessmentId;
    private int courseId;
    private String assessmentType; //Objective or Performance
    private String assessmentTitle;
    private Date assessmentDueDate; //set alert for approaching due date
    private Date assessmentEstCompDate; //set alert to keep you on track to finishing
    //potentially add a status flag to allow the user to say when the assessment is done


    public Assessment(int assessmentId, int courseId, String assessmentType, String assessmentTitle, Date assessmentDueDate, Date assessmentEstCompDate) {
        this.assessmentId = assessmentId;
        this.courseId = courseId;
        this.assessmentType = assessmentType;
        this.assessmentTitle = assessmentTitle;
        this.assessmentDueDate = assessmentDueDate;
        this.assessmentEstCompDate = assessmentEstCompDate;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
    }

    public void setAssessmentTitle(String assessmentTitle) {
        this.assessmentTitle = assessmentTitle;
    }

    public Date getAssessmentDueDate() {
        return assessmentDueDate;
    }

    public void setAssessmentDueDate(Date assessmentDueDate) {
        this.assessmentDueDate = assessmentDueDate;
    }

    public Date getAssessmentEstCompDate() {
        return assessmentEstCompDate;
    }

    public void setAssessmentEstCompDate(Date assessmentEstCompDate) {
        this.assessmentEstCompDate = assessmentEstCompDate;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "assessmentType='" + assessmentType + '\'' +
                ", assessmentTitle='" + assessmentTitle + '\'' +
                ", assessmentDueDate=" + assessmentDueDate +
                ", assessmentEstCompDate=" + assessmentEstCompDate +
                '}';
    }
}
