package com.AG.assignment2.module.View;

import com.AG.assignment2.module.Controller.ProgramController;
import com.AG.assignment2.module.Model.Program;
import com.AG.assignment2.module.ProgramRefInterface;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

//class that represents the view(AG)
public class ProgramView extends JPanel implements ProgramRefInterface {

    private static final long serialVersionUID = 1L;
    private static final String SHOW_BUTTON = "Show";
    private static final String EXIT_BUTTON = "Exit";
    private static final String STUDENT_FIRST_NAME = "Title   ";
    private static final String STUDENT_LAST_NAME = "Program Code  ";
    private static final String STUDENT_COURSE = "Co op  ";

    private static final int Title_COL_WIDTH = 30;
    private static final int ProgramCode_COL_WIDTH = 50;
    private static final int CO_OP_COL_WIDTH = 35;

    private ProgramController controller;
    private JLabel titleLabel;
    private JLabel programCodeLabel;
    private JLabel co_opLabel;

    private JTextField title;
    private JTextField programCode;
    private JTextField co_op;
    private JButton display;
    private JButton exit;

    public ProgramView(Program model) {
        this.controller = new ProgramController(model, this);
        this.createGui();
    }

    public ProgramView(Program model, ProgramController newController) {
        this.controller = newController;
        this.createGui();
    }

    public void createGui() {
        this.display = new JButton("Show");
        this.exit = new JButton("Exit");
        this.titleLabel = new JLabel("title   ");
        this.programCodeLabel = new JLabel("Program code  ");
        this.co_opLabel = new JLabel("co op  ");
        this.title = new JTextField(30);
        this.programCode = new JTextField(50);
        this.co_op = new JTextField(35);
        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BoxLayout(editPanel, 0));
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(0, 1));
        labelPanel.add(this.titleLabel);
        labelPanel.add(this.programCodeLabel);
        labelPanel.add(this.co_opLabel);
        editPanel.add(labelPanel);
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(0, 1));
        fieldPanel.add(this.title);
        fieldPanel.add(this.programCode);
        fieldPanel.add(this.co_op);
        editPanel.add(fieldPanel);
        JPanel controlPanel = new JPanel();
        controlPanel.add(this.display);
        controlPanel.add(this.exit);
        this.display.addActionListener(this.controller);
        this.exit.addActionListener(new ExitHandler());
        this.setLayout(new BorderLayout());
        this.add(editPanel, "Center");
        this.add(controlPanel, "South");
    }

    public Object getUpdateRef() {
        return this.display;
    }

    public String getTitle() {
        return this.title.getText();
    }

    public String getProgramCode() {
        return this.programCode.getText();
    }

    public String getCo_op() {
        return this.co_op.getText();
    }



    public void refresh(String newTitle, String newProgramCode,String newCo_op) {
        this.title.setText(newTitle);
        this.programCode.setText(newProgramCode);
        this.co_op.setText(newCo_op);
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

