package service;
import javax.swing.*;
import java.awt.*;

public class ServiceIcon {

    public ImageIcon load_icon(String iconPath){
        return new ImageIcon(iconPath);
    }

    public ImageIcon resize_icon_civ(ImageIcon icon, int width, int height){
        Image getIcon = icon.getImage();
        Image scaledImage = getIcon.getScaledInstance(width,height,Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(scaledImage);
    }
}
