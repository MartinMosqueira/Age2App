import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoaderFont {
    public Font load_font(String path) throws IOException, FontFormatException{
        File fontFile = new File(path);
        return Font.createFont(Font.TRUETYPE_FONT, fontFile);
    }
}
