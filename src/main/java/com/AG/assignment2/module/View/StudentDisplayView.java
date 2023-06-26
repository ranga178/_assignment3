package com.AG.assignment2.module.View;

import com.AG.assignment2.module.StudentRefInterface;

import javax.swing.*;
import java.awt.*;

public class StudentDisplayView extends JPanel implements StudentRefInterface {

    private JTextArea studentDetail;

    public StudentDisplayView() {
        this.createGui();
    }

    public void createGui() {
        this.setLayout(new BorderLayout());
        this.studentDetail = new JTextArea(10,40);
        this.studentDetail.setEditable(false);
        JScrollPane scrollDisplay = new JScrollPane(this.studentDetail);
        this.add(scrollDisplay,"Center");
    }

    public void refresh(String newFirstName, String newLastName, String newStudentNumber) {
        this.studentDetail.setText("\n\tStudent Details\n\t\tFirst Name: " +newFirstName + "\n\t\tLast Name: " + newLastName +"\n" + "\t\tStudent Number: " + newStudentNumber);

    }
}
