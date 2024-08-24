package view.tactics;

import interfaces.IPanel;

import javax.swing.*;

public class Castle implements IPanel {
    private JPanel castlePanel;

    @Override
    public JPanel startGUI() {
        this.castlePanel = new JPanel();
        this.castlePanel.add(new JLabel("castle panel!"));

        return castlePanel;
    }
}
