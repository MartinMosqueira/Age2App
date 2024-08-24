package view.civ;

import interfaces.PanelCiv;
import javax.swing.*;

public class Mongols extends PanelCiv {
    public Mongols(JFrame newWindow) {
        super(newWindow);
    }

    @Override
    public void startGUI() {
        startWindow();
        JPanel newPanel = new JPanel();
        newPanel.add(new JLabel("This is a new panel Mongols!"));
        getNewWindow().add(newPanel);
    }
}
