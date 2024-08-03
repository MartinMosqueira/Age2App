import java.awt.*;

public enum CustomColor {
    BACKGROUND(new Color(232,220,196)),
    MENUBAR(new Color(140,12,12)),
    TITLE(new Color(227,148,94,255)),
    SUBMENU(new Color(192,148,124))
    ;

    private Color color;

    CustomColor(Color color) {
        this.color=color;
    }

    public Color getColor() {
        return color;
    }
}
