package view.civ;

import interfaces.PanelCiv;
import javax.swing.*;

public class Francs extends PanelCiv {
    public Francs(JFrame newWindow) {
        super(newWindow);
    }

    @Override
    public void startGUI() {
        startWindow();
        JPanel newPanel = new JPanel();
        newPanel.add(new JLabel("This is a new panel Francs!"));
        getNewWindow().add(newPanel);
    }
}
