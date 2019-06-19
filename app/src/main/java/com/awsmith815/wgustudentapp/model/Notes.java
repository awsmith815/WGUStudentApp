package com.awsmith815.wgustudentapp.model;

import java.util.Date;

public class Notes {

    private int noteId;
    private String note;
    private Date noteSubmitted;
    private int courseId;

    public Notes(int noteId, String note, Date noteSubmitted, int courseId) {
        this.noteId = noteId;
        this.note = note;
        this.noteSubmitted = noteSubmitted;
        this.courseId = courseId;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getNoteSubmitted() {
        return noteSubmitted;
    }

    public void setNoteSubmitted(Date noteSubmitted) {
        this.noteSubmitted = noteSubmitted;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "note='" + note + '\'' +
                ", noteSubmitted=" + noteSubmitted +
                '}';
    }
}
