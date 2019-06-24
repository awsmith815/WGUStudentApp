package com.awsmith815.wgustudentapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.awsmith815.wgustudentapp.model.Course;

import java.util.List;

@Dao
public interface CourseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCourse(Course course);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCourses(List<Course> courseList);

    @Delete
    void deleteCourse(Course course);

    @Query("SELECT * FROM Course WHERE termId = :termId")
    Course getCourseByTermId(int termId);

    @Query("SELECT * FROM Course WHERE courseId = :id")
    Course getCourseById(int id);

    @Query("SELECT * FROM Course ORDER BY courseStartDate DESC")
    LiveData<List<Course>> getAllCourses();

    @Query("DELETE FROM Course")
    int deleteAllCourses();

    @Query("SELECT COUNT(*) FROM Course")
    int getCountCourses();
}
