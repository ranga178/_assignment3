package com.AG.assignment2.module.View;

import com.AG.assignment2.module.GradeRefInterface;

import javax.swing.*;
import java.awt.*;

public class GradeDisplayView extends JPanel implements GradeRefInterface {

    private JTextArea gradeDetail;

    public GradeDisplayView() {
        this.createGui();
    }

    public void createGui() {
        this.setLayout(new BorderLayout());
        this.gradeDetail = new JTextArea(10,40);
        this.gradeDetail.setEditable(false);
        JScrollPane scrollDisplay = new JScrollPane(this.gradeDetail);
        this.add(scrollDisplay,"Center");
    }

    public void refresh(int newCrn, String newCourseName,int newGrade) {
        this.gradeDetail.setText("\n\tGrade Details\n\t\tCrn: " + newCrn + "\n\t\tCourse Name: " + newCourseName + "\n" + "\t\tGrade: " + newGrade);
    }
}
