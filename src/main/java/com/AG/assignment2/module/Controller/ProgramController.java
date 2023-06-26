package com.AG.assignment2.module.Controller;

import com.AG.assignment2.module.Model.Program;
import com.AG.assignment2.module.View.ProgramView;
import javafx.event.ActionEvent;

import java.awt.event.ActionListener;


// class that represents the program controller(AG)
public class ProgramController implements ActionListener {

    // declaring program model and view(AG)
    private Program programModel;

    private ProgramView programView;

    // constructor to initialize(AG)
    public ProgramController(Program programModel,ProgramView programView) {
        this.programModel = programModel;
        this.programView = programView;
    }



    private void updateModel() {
        String title = null;
        String programCode = null;
        title = this.programView.getTitle();
        programCode = this.programView.getProgramCode();
        String co_op = null;
        co_op = this.programView.getCo_op();

    }


    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        Object source = e.getSource();
        if (source == this.programView.getUpdateRef()) {
            this.updateModel();
        }
    }
}