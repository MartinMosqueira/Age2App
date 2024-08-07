import java.awt.*;
import java.io.IOException;

public class CustomFont {
    private Font fontMenu;
    private Font fontSubMenu;
    private LoaderFont loaderFont = new LoaderFont();

    public CustomFont(String fontMenuPath, String fontSubMenuPath) {
        try{
            this.fontMenu = loaderFont.load_font(fontMenuPath);
            this.fontSubMenu = loaderFont.load_font(fontSubMenuPath);
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
