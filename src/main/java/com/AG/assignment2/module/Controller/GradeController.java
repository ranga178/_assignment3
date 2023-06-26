package com.AG.assignment2.module.Controller;

import com.AG.assignment2.module.Model.Grade;
import com.AG.assignment2.module.View.GradeView;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.event.ActionListener;

//class which represents the controller(AG)
public class GradeController implements ActionListener {

    //declaring variables model and view(AG)
    private Grade gradeModel;
    private GradeView gradeView;

    private JPanel panel;

    //constructor to initialize(AG)
    public GradeController(Grade gradeModel, GradeView gradeView) {
        this.gradeModel = gradeModel;
        this.gradeView = gradeView;
        panel = createPanel();
    }


  private void updateModel() {
        int crn = Integer.parseInt(null);
        String courseName = null;
        int grade = Integer.parseInt(null);
        crn = Integer.parseInt(this.gradeView.getCrn());
        courseName = this.gradeView.getCourseName();
        grade = Integer.parseInt(this.gradeView.getGrade());

  }

  private JPanel createPanel() {
        JPanel panel = new JPanel();
        return panel;
  }
    public JPanel getPanel() {
        return panel;
    }


    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        Object source = e.getSource();
        if(source == this.gradeView.getUpdateRef()) {
            this.updateModel();
        }

    }
}
