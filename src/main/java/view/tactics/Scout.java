package view.tactics;

import interfaces.IPanel;

import javax.swing.*;

public class Scout implements IPanel {
    private JPanel scoutPanel;

    @Override
    public JPanel startGUI() {
        this.scoutPanel = new JPanel();
        this.scoutPanel.add(new JLabel("panel scouts!"));

        return scoutPanel;
    }
}
