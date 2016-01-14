package com.nctu.nctuplus.nctuplus;

/**
 * Created by cober on 2016/1/14.
 */
public class CourseType {
    private int color;
    private String text;

    public CourseType(int color, String text) {
        this.color = color;
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public String getText() {
        return text;
    }
}
