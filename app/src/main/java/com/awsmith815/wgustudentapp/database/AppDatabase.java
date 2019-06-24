package com.awsmith815.wgustudentapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.awsmith815.wgustudentapp.model.Course;
import com.awsmith815.wgustudentapp.model.Term;


@Database(entities = {Term.class, Course.class}, version=1) //add more classes (models) as needed in order to hit all models
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "AppDatabase.db";
    private static volatile AppDatabase instance;
    private static final Object LOCK = new Object();

    public abstract TermDAO termDAO();
    public abstract CourseDAO courseDAO();
    //Add more as needed

    public static AppDatabase getInstance(Context context) {
        if(instance == null){
            synchronized (LOCK) {
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }


}
