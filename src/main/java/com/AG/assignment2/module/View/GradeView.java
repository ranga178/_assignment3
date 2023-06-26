package com.AG.assignment2.module.View;

import com.AG.assignment2.module.Controller.GradeController;
import com.AG.assignment2.module.GradeRefInterface;
import com.AG.assignment2.module.Model.Grade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//class which represents the grade view(AG)
public class GradeView extends JPanel implements GradeRefInterface {

    private static final long serialVersionUID = 1L;
    private static final String SHOW_BUTTON = "Show";
    private static final String EXIT_BUTTON = "Exit";
    private static final String GRADE_CRN = "Crn  ";
    private static final String GRADE_COURSE_NAME = "Course Name   ";
    private static final String GRADE_GRADE = "Grade  ";

    private static final int CRN_COL_WIDTH = 30;
    private static final int CNAME_COL_WIDTH = 50;
    private static final int GRADE_COL_WIDTH = 35;

    private GradeController controller;
    private JLabel crnLabel;
    private JLabel courseNameLabel;
    private JLabel gradeLabel;
    private JTextField crn;
    private JTextField courseName ;
    private JTextField grade;
    private JButton display;
    private JButton exit;

    private JButton next;


    public GradeView(Grade model) {
        this.controller = new GradeController(model, this);
        this.createGui();
    }

    public GradeView(Grade model, GradeController newController) {
        this.controller = newController;
        this.createGui();
    }

    public void createGui() {
        this.display = new JButton("Show");
        this.exit = new JButton("Exit");
        this.next = new JButton("Next");
        this.crnLabel = new JLabel("Crn  ");
        this.courseNameLabel = new JLabel("Course Name ");
        this.gradeLabel = new JLabel("Grade  ");
        this.crn = new JTextField(30);
        this.courseName = new JTextField(50);
        this.grade = new JTextField(35);
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BoxLayout(editPanel, 0));
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(0, 1));
        labelPanel.add(this.crnLabel);
        labelPanel.add(this.courseNameLabel);
        labelPanel.add(this.gradeLabel);
        editPanel.add(labelPanel);
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(0, 1));
        fieldPanel.add(this.crn);
        fieldPanel.add(this.courseName);
        fieldPanel.add(this.grade);
        editPanel.add(fieldPanel);
        JPanel controlPanel = new JPanel();
        controlPanel.add(this.display);
        controlPanel.add(this.exit);
        controlPanel.add(this.next);
        this.display.addActionListener(this.controller);
        this.exit.addActionListener(new ExitHandler());

        this.setLayout(new BorderLayout());
        this.add(editPanel, "Center");
        this.add(controlPanel, "South");

    }

    public Object getUpdateRef() {
        return this.display;
    }

    public String getCrn() {
        return this.crn.getText();
    }

    public String getCourseName() {
        return this.courseName.getText();
    }

    public String getGrade() {
        return this.grade.getText();
    }

    public void refresh(int newCrn,String newCourseName,int newGrade) {
        this.crn.setText(String.valueOf(newCrn));
        this.courseName.setText(newCourseName);
        this.grade.setText(String.valueOf(newGrade));
    }

    private class ExitHandler implements ActionListener {
        private ExitHandler() {
        }

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            System.exit(0);

        }
    }







    }

