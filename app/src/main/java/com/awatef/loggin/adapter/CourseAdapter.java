package com.awatef.loggin.adapter;

import android.content.Context;
import android.content.DialogInterface;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.awatef.loggin.R;
import com.awatef.loggin.model.Course;


import java.util.ArrayList;



public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private ArrayList<Course> courses;

    private Context context;
    private OnCourseClickListener onCourseActionListener;


    public CourseAdapter(Context context, ArrayList<Course> courses ,OnCourseClickListener onCourseActionListener) {
        this.courses = courses;
        this.context = context;
          this.onCourseActionListener = onCourseActionListener ;
    }


    public void addCourse(Course course) {
        courses.add(course);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_course, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.course = courses.get(position);

        holder.courseNameTV.setText(holder.course.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       onCourseActionListener.onCourseClick(holder.course);
            }
        });



    }



    @Override
    public int getItemCount() {
        return courses.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView courseNameTV;
        Course course;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            courseNameTV = view.findViewById(R.id.courseNameTV);

        }
    }
    public interface OnCourseClickListener{
        void onCourseClick(Course course);


    }
}