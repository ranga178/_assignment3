package com.AG.assignment2.module.Model;
//class that represents student model(AG)

import com.AG.assignment2.module.StudentRefInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {

    //declaring variables(AG)
    private String firstName;
    private String lastName;
    private int studentNumber;

    private ArrayList studentViews;

    public Student() {
        this((StudentRefInterface)null);

    }

    public Student(StudentRefInterface view) {
        this.studentViews = new ArrayList();
        this.firstName = "";
        this.lastName = "";
        this.studentNumber = 0;
        if(view != null) {
            this.studentViews.add(view);
        }

    }

    public void addContactView(StudentRefInterface view) {
        if(!this.studentViews.contains(view)) {
            this.studentViews.add(view);
        }

    }

    public void removeContactView(StudentRefInterface view) {
        this.studentViews.remove(view);
    }

    //getter and setter methods(AG)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int newStudentNumber) {
        this.studentNumber = newStudentNumber;
    }


    public void updateModel(String newFirstName,String newLastName,int newStudentNumber) {
        if(!this.isEmptyString(newFirstName)) {
            this.setFirstName(newFirstName);
        }

        if(!this.isEmptyString(newLastName)) {
            this.setLastName(newLastName);
        }

         if(newStudentNumber != 0) {
            setStudentNumber(newStudentNumber);
        }

         this.updateView();
    }

    private boolean isEmptyString(String input) {
        return input == null || input.equals("");
    }

    private void updateView() {
        Iterator notifyViews = this.studentViews.iterator();

        while(notifyViews.hasNext()) {
            ((StudentRefInterface)notifyViews.next()).refresh(this.firstName,this.lastName, String.valueOf(this.studentNumber));
        }
    }

}
