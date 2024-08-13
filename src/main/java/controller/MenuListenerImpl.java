package controller;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class MenuListenerImpl implements MenuListener {
    private JPanel listPanels;
    private CardLayout managerPanel;
    private String matchPanel;

    public MenuListenerImpl(CardLayout managerPanel, JPanel listPanels, String matchPanel) {
        this.managerPanel = managerPanel;
        this.listPanels = listPanels;
        this.matchPanel = matchPanel;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        managerPanel.show(listPanels, matchPanel);
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
