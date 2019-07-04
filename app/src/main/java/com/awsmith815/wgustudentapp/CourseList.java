package com.awsmith815.wgustudentapp;

import android.os.Bundle;

import com.awsmith815.wgustudentapp.model.Course;
import com.awsmith815.wgustudentapp.ui.CourseListAdapter;
import com.awsmith815.wgustudentapp.ui.TermListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CourseList extends AppCompatActivity {
    /*this is the adapter*/
    private CourseListAdapter cAdapter;
    private List<Course> courseData = new ArrayList<>();
    private RecyclerView mCourseRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCourseRecyclerView = findViewById(R.id.recyclerViewCourseList);
        assert mCourseRecyclerView != null;
        initCourseList(mCourseRecyclerView);

        FloatingActionButton fabAdd = findViewById(R.id.fabAddCourse);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initCourseList(RecyclerView mCourseRecyclerView) {
        mCourseRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mCourseRecyclerView.setLayoutManager(layoutManager);

        cAdapter = new CourseListAdapter(courseData, this);
        mCourseRecyclerView.setAdapter(cAdapter);
    }

}
