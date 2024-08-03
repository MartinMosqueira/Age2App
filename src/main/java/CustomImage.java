import javax.swing.*;
import java.awt.*;

public class CustomImage {

    public ImageIcon load_image_civ(String icon){
        Image getImage = new ImageIcon(icon).getImage();
        Image scaledImage = getImage.getScaledInstance(50,50,Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(scaledImage);
    }
}
