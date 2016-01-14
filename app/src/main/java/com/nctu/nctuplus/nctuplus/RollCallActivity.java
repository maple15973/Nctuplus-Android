package com.nctu.nctuplus.nctuplus;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class RollCallActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<Course> courses;
    private RollAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_call);
        recyclerView = (RecyclerView) findViewById(R.id.roll_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        setListItem();
    }
    public void setListItem() {
        // setAdapter
        courses =new ArrayList<>();
        courses.add(new Course("通訊原理","吳卓諭","104上",1104,onlineRoll()));
        courses.add(new Course("紀錄片","黃春滿","104上",1105,onlineRoll()));
        courses.add(new Course("新聞英語","貝文珍","104上",1106,onlineRoll()));
        courses.add(new Course("新聞英語","貝文珍","104上",1106,offline()));
        courses.add(new Course("新聞英語","貝文珍","104上",1106,offline()));
        courses.add(new Course("新聞英語","貝文珍","104上",1106,offline()));
        courses.add(new Course("紀錄片","黃春滿","104上",1105,onlineNoRoll()));
        courses.add(new Course("紀錄片","黃春滿","104上",1105,onlineNoRoll()));

        recyclerView.setLayoutManager(layoutManager);
        adapter = new RollAdapter(this,courses);
        recyclerView.setAdapter(adapter);
    }
    public CourseType onlineRoll(){
        return new CourseType(R.drawable.corner_red,"上課中");
    }
    public CourseType offline(){
        return new CourseType(R.drawable.corner_blue,"未上課");
    }
    public CourseType onlineNoRoll(){
        return new CourseType(R.drawable.corner_blue,"上課中");
    }
}
