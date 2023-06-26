package com.AG.assignment2.module.Controller;

import com.AG.assignment2.module.Model.Student;
import com.AG.assignment2.module.View.GradeView;
import com.AG.assignment2.module.View.StudentView;


import java.awt.event.ActionListener;

//class which represents the student controller(AG)
public class StudentController implements ActionListener {


    // declaring variables model and view(AG)

    private Student model;
    private StudentView view;



    //constructor to initialize(AG)
    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        Object source = e.getSource();
        if(source == this.view.getUpdateRef()) {
            this.updateModel();
        }
    }


    private void updateModel() {
        String firstName = null;
        String lastName = null;
        firstName = this.view.getFirstName();
        lastName = this.view.getLastName();
        this.model.updateModel(firstName, lastName, this.view.getStudentNumber());
    }



}
