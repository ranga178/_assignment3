package com.AG.assignment2.module.View;

import com.AG.assignment2.module.ProgramRefInterface;

import javax.swing.*;
import java.awt.*;

public class ProgramDisplayView extends JPanel implements ProgramRefInterface {

    private JTextArea programDetail;

    public ProgramDisplayView() {
        this.createGui();
    }

    public void createGui() {
        this.setLayout(new BorderLayout());
        this.programDetail = new JTextArea(10, 40);
        this.programDetail.setEditable(false);
        JScrollPane scrollDisplay = new JScrollPane(this.programDetail);
        this.add(scrollDisplay, "Center");
    }




    @Override
    public void refresh(String newTitle,String newProgramCode,String newCo_op) {
        this.programDetail.setText("\n\tProgram Details\n\t\tTitle: " + newTitle + "\n\t\tProgram Code: " + newProgramCode + "\n" + "\t\tco op: " + newCo_op);

    }
}
