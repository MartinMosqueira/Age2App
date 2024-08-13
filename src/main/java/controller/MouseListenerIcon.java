package controller;

import service.ServiceColor;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerIcon implements MouseListener {
    private JButton iconCiv;
    private ServiceColor serviceColor;

    public MouseListenerIcon(JButton iconCiv, ServiceColor serviceColor) {
        this.iconCiv = iconCiv;
        this.serviceColor = serviceColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        iconCiv.setBackground(serviceColor.getColor());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        iconCiv.setBackground(ServiceColor.MENUBAR.getColor());
    }
}
