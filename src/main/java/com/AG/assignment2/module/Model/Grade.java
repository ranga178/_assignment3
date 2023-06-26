package com.AG.assignment2.module.Model;

import com.AG.assignment2.module.GradeRefInterface;

import java.util.ArrayList;
import java.util.Iterator;

//class that represents grade model(AG)
public class Grade {

    //declaring variables(AG)
    private int crn;
    private String courseName;
    private int grade;

    private ArrayList gradeViews;

    //constructor(AG)
   public Grade() {
       this((GradeRefInterface)null);
   }

    public Grade(GradeRefInterface view) {
        this.gradeViews = new ArrayList();
        this.crn = 0;
        this.courseName = "";
        this.grade = 0;
        if (view != null) {
            this.gradeViews.add(view);
        }

    }


    public void addContactView(GradeRefInterface view) {
        if (!this.gradeViews.contains(view)) {
            this.gradeViews.add(view);
        }

    }

    public void removeContactView(GradeRefInterface view) {
        this.gradeViews.remove(view);
    }



    //getter and setter methods(AG)
    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void updateModel(int newCrn,String newCourseName,int newGrade) {
        if(newCrn != 0) {
            setCrn(newCrn);
        }
        if (!this.isEmptyString(newCourseName)) {
            this.setCourseName(newCourseName);
        }

        if(grade != 0) {
            setGrade(newGrade);
        }


        this.updateView();
    }

    private boolean isEmptyString(String input) {
        return input == null || input.equals("");
    }

    private void updateView() {
        Iterator notifyViews = this.gradeViews.iterator();

        while(notifyViews.hasNext()) {
            ((GradeRefInterface)notifyViews.next()).refresh(Integer.parseInt(String.valueOf(this.crn)), this.courseName, Integer.parseInt(String.valueOf(this.grade)));
        }

    }
}
