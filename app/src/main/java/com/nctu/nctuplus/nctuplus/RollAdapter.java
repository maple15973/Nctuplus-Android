package com.nctu.nctuplus.nctuplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by cober on 2016/1/14.
 */
public class RollAdapter extends RecyclerView.Adapter<RollAdapter.ViewHolder> {

    private final String LOG_TAG = this.getClass().getSimpleName();
    // Store the context for later use
    protected Context context;
    // dataSet
    private ArrayList<Course> courses;

    public RollAdapter(Context context, ArrayList<Course> courses) {
        super();
        this.context = context;
        this.courses = courses;
    }

    @Override
    public RollAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_roll, parent, false);
        return new RollAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RollAdapter.ViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.tvName.setText(course.getName());
        holder.type.setText(course.getType().getText());
        holder.type.setBackgroundResource(course.getType().getColor());
        holder.tvIntro.setText(course.getTeacher());
        Picasso.with(context).load(course.getNormalImageUrl()).into(holder.img);
    }

    public int getItem(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView tvName, tvIntro;
        public ImageView img;
        public Button type;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.course_item_name);
            this.tvIntro = (TextView) itemView.findViewById(R.id.course_item_intro);
            this.img = (ImageView) itemView.findViewById(R.id.course_item_image);
            this.type = (Button) itemView.findViewById(R.id.course_item_type);
        }
    }
}
