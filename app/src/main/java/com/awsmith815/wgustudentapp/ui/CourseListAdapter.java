package com.awsmith815.wgustudentapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awsmith815.wgustudentapp.R;
import com.awsmith815.wgustudentapp.model.Course;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {

    private final List<Course> mCourse;
    private final Context mContext;

    public CourseListAdapter(List<Course> mCourse, Context mContext) {
        this.mCourse = mCourse;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.course_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Course course = mCourse.get(position);
        holder.textCourse.setText(course.getCourseTitle());

    }

    @Override
    public int getItemCount() {
        return mCourse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textCourse;
        FloatingActionButton mFabCourseDetail;
        FloatingActionButton mFabEditCourse;
        FloatingActionButton mFabAssignment;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCourse = itemView.findViewById(R.id.textCourse);
            mFabCourseDetail = itemView.findViewById(R.id.fabCourseDetail);
            mFabEditCourse = itemView.findViewById(R.id.fabEditCourse);
            mFabAssignment = itemView.findViewById(R.id.fabAddAssignment);

        }
    }
}
