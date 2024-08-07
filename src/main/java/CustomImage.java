import javax.swing.*;
import java.awt.*;

public class CustomImage {

    public ImageIcon load_icon(String icon){
        return new ImageIcon(icon);
    }

    public ImageIcon resize_icon_civ(ImageIcon icon, int width, int height){
        Image getIcon = icon.getImage();
        Image scaledImage = getIcon.getScaledInstance(width,height,Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(scaledImage);
    }
}
