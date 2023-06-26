package com.AG.assignment2.module.View;
import javax.swing.*;

import com.AG.assignment2.module.Controller.GradeController;
import com.AG.assignment2.module.Controller.StudentController;
import com.AG.assignment2.module.Model.Student;
import com.AG.assignment2.module.StudentRefInterface;

import java.awt.*;
import java.awt.event.ActionListener;

public class StudentView extends JPanel implements StudentRefInterface {

    private static final long serialVersionUID = 1L;
    private static final String SHOW_BUTTON = "Show";
    private static final String EXIT_BUTTON = "Exit";
    private static final String STUDENT_FIRST_NAME = "First Name ";
    private static final String STUDENT_LAST_NAME = "Last Name ";
    private static final String STUDENT_NUMBER = "Student Number";

    private static final int FNAME_COL_WIDTH = 30;
    private static final int LNAME_COL_WIDTH = 50;
    private static final int STUDENT_NUM_COL_WIDTH = 35;

    private StudentController studentController;

    private GradeController gradeController;

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel studentNumberLabel;

    private JTextField firstName;
    private JTextField lastName;
    private JTextField studentNumber;

    private JButton display;
    private JButton exit;

    private JButton next;

    public StudentView(Student model) {
        this.studentController = new StudentController(model,this);
        this.createGui();
    }

    public StudentView(Student model,StudentController newController) {
        this.studentController = newController;
        this.createGui();

    }

    public void createGui() {
        this.display = new JButton("Show");
        this.exit = new JButton("Exit");
        this.next = new JButton("Next");
        this.firstNameLabel = new JLabel("First Name ");
        this.lastNameLabel = new JLabel("Last Name ");
        this.studentNumberLabel = new JLabel("Student Number ");
        this.firstName = new JTextField(50);
        this.lastName = new JTextField(50);
        this.studentNumber = new JTextField(50);
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BoxLayout(editPanel,0));
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(0,1));
        labelPanel.add(this.firstNameLabel);
        labelPanel.add(this.lastNameLabel);
        labelPanel.add(this.studentNumberLabel);
        editPanel.add(labelPanel);
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(0,1));
        fieldPanel.add(this.firstName);
        fieldPanel.add(this.lastName);
        fieldPanel.add(this.studentNumber);
        editPanel.add(fieldPanel);
        JPanel controlPanel = new JPanel();
        controlPanel.add(this.display);
        controlPanel.add(this.exit);
        this.display.addActionListener(this.studentController);
        this.exit.addActionListener(new ExitHandler());
        this.next.addActionListener(this.gradeController);
        this.setLayout(new BorderLayout());
        this.add(editPanel,"Center");
        this.add(controlPanel,"South");
    }

    public Object getUpdateRef() {
        return this.display;
    }

    public String getFirstName() {
        return this.firstName.getText();
    }

    public String getLastName() {
        return this.lastName.getText();
    }

    public int getStudentNumber() {
        return Integer.parseInt(this.studentNumber.getText());
    }
    @Override
    public void refresh(String newFirstName, String newLastName, String newStudentNumber) {
        this.firstName.setText(newFirstName);
        this.lastName.setText(newLastName);
        this.studentNumber.setText(String.valueOf(newStudentNumber));

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

