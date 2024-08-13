package controller;

import interfaces.IPanel;
import interfaces.PanelCiv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerIcon implements ActionListener {
    private PanelCiv civilization;

    public ActionListenerIcon(PanelCiv civilization) {
        this.civilization = civilization;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        civilization.startGUI();
    }
}
