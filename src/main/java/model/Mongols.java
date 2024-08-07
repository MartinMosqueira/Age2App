package model;

import interfaces.ICiv;

import javax.swing.*;

public class Mongols implements ICiv {
    @Override
    public void startGUI() {
        JFrame newFrame = new JFrame("New Panel Mongols");
        newFrame.setSize(300, 200);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel newPanel = new JPanel();
        newPanel.add(new JLabel("This is a new panel!"));
        newFrame.add(newPanel);
        newFrame.setVisible(true);
    }
}
