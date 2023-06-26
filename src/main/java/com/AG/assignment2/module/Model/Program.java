package com.AG.assignment2.module.Model;

import com.AG.assignment2.module.ProgramRefInterface;
import com.AG.assignment2.module.StudentRefInterface;

import java.util.ArrayList;
import java.util.Iterator;

// class that represents program model(AG)
public class Program {

    private String title;
    private String programCode;
    private String co_op;

    private ArrayList programViews;

    public Program() {
        this((ProgramRefInterface)null);

    }

    public Program(ProgramRefInterface view) {
        this.programViews = new ArrayList();
        this.title = "";
        this.programCode = "";
        this.co_op = "";
        if(view != null) {
            this.programViews.add(view);
        }

    }

    public void addContactView(ProgramRefInterface view) {
        if(!this.programViews.contains(view)) {
            this.programViews.add(view);
        }

    }

    public void removeContactView(StudentRefInterface view) {
        this.programViews.remove(view);
    }

    //getter and setter methods(AG)
    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String newProgramCode) {
        this.programCode = newProgramCode;
    }

    public String getCo_op() {
        return co_op;
    }

    public void setCo_op(String newCo_op) {
        this.co_op = newCo_op;
    }


    public void updateModel(String newTitle,String newProgramCode,String newCo_op) {
        if(!this.isEmptyString(newTitle)) {
            this.setTitle(newTitle);
        }

        if(!this.isEmptyString(newProgramCode)) {
            this.setProgramCode(newProgramCode);
        }

        if(!this.isEmptyString(newCo_op)) {
            this.setCo_op(newCo_op);
        }

        this.updateView();
    }

    private boolean isEmptyString(String input) {
        return input == null || input.equals("");
    }

    private void updateView() {
        Iterator notifyViews = this.programViews.iterator();

        while(notifyViews.hasNext()) {
            ((StudentRefInterface)notifyViews.next()).refresh(this.title,String.valueOf(this.programCode),String.valueOf(this.co_op));
        }
    }
}

