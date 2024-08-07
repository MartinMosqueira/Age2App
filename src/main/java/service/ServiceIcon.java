package service;
import interfaces.ICiv;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ServiceIcon {

    public ImageIcon load_icon(String iconPath){
        return new ImageIcon(iconPath);
    }

    public ImageIcon resize_icon_civ(ImageIcon icon, int width, int height){
        Image getIcon = icon.getImage();
        Image scaledImage = getIcon.getScaledInstance(width,height,Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(scaledImage);
    }

    public void mouse_over_icons_civ(JButton iconCiv, ServiceColor overColor){
        iconCiv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                iconCiv.setBackground(overColor.getColor());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                iconCiv.setBackground(ServiceColor.MENUBAR.getColor());
            }
        });
    }

    public void frame_icons_civ(JButton iconCiv, ICiv frameCiv){
        iconCiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCiv.startGUI();
            }
        });

    }
}
