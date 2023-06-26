package com.AG.assignment2.module;
import com.AG.assignment2.module.Model.Grade;
import com.AG.assignment2.module.Model.Program;
import com.AG.assignment2.module.Model.Student;
import com.AG.assignment2.module.View.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//main class(AG)
public class MVCMain   {

/** Aaron Girard
 * 200458198
 * June 25th 2023

*/


    public MVCMain() {

    }




    public static void main(String[] args) {

        Student student = new Student();
        StudentView view = new StudentView(student);
        student.addContactView(view);
        createGui(view,"Enter Student Details:");
        StudentDisplayView displayView = new StudentDisplayView();
        student.addContactView(displayView);
        createGui(displayView,"Student Details");

        Grade grade = new Grade();
        GradeView gradeView = new GradeView(grade);
        grade.addContactView(gradeView);
        createGui(gradeView, "Enter Grade Details");
        GradeDisplayView gradeDisplayView = new GradeDisplayView();
        grade.addContactView(gradeDisplayView);
        createGui(gradeDisplayView,"Grade Details");

        Program program = new Program();
        ProgramView programView = new ProgramView(program);
        program.addContactView(programView);
        createGui(view, "Enter Program Details");
        ProgramDisplayView programDisplayView = new ProgramDisplayView();
        program.addContactView(programDisplayView);
        createGui(displayView, "Program Details");



    }

    private static void createGui(JPanel contents,String windowName) {
        JFrame frame = new JFrame(windowName);
        frame.getContentPane().add(contents);
        frame.addWindowListener(new WindowCloseManager());
        frame.pack();
        frame.setVisible(true);

    }



    private static class WindowCloseManager extends WindowAdapter {
        private WindowCloseManager() {

        }

        public void windowClosing(WindowEvent event) {
            System.exit(0);

        }
    }
}
