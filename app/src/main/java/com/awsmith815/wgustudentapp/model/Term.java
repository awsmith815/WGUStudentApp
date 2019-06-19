package com.awsmith815.wgustudentapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName="Term")
public class Term {
    @PrimaryKey(autoGenerate = true)
    private int termId;
    private String termName;
    private Date termStartDate;
    private Date termEndDate;


    //Make sure to ignore constructors that do not accept all values to insert
    public Term(int termId, String termName, Date termStartDate, Date termEndDate) {
        this.termId = termId;
        this.termName = termName;
        this.termStartDate = termStartDate;
        this.termEndDate = termEndDate;
    }


    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public Date getTermStartDate() {
        return termStartDate;
    }

    public void setTermStartDate(Date termStartDate) {
        this.termStartDate = termStartDate;
    }

    public Date getTermEndDate() {
        return termEndDate;
    }

    public void setTermEndDate(Date termEndDate) {
        this.termEndDate = termEndDate;
    }

    @Override
    public String toString() {
        return "Term{" +
                ", termName='" + termName + '\'' +
                ", termStartDate=" + termStartDate +
                ", termEndDate=" + termEndDate +
                '}';
    }
}