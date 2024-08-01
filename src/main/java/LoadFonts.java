import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoadFonts {
    private Font fontMenu;
    private Font fontSubMenu;

    public void load_custom_font(){
        try {
            File fontFileMenu = new File("font/Centaur MT.ttf");
            File fontFileSubMenu = new File("font/papyrus.ttf");
            this.fontMenu = Font.createFont(Font.TRUETYPE_FONT, fontFileMenu);
            this.fontSubMenu = Font.createFont(Font.TRUETYPE_FONT, fontFileSubMenu);

            //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //ge.registerFont(font);
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public Font getFontMenu() {
        return fontMenu;
    }

    public Font getFontSubMenu() {
        return fontSubMenu;
    }

}
