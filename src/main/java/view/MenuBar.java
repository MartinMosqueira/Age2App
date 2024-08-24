package view;

import service.ServiceColor;
import service.ServiceFont;
import javax.swing.*;
import java.awt.*;

public class MenuBar {
    private JMenu civ;
    private JMenu tactics;
    private JMenuItem scout;
    private JMenuItem castle;

    private final ServiceColor colorMenuBar;
    private final ServiceColor colorTitle;
    private final ServiceColor colorSubMenu;
    private final ServiceFont fonts;

    public MenuBar(ServiceColor colorMenuBar, ServiceColor colorTitle, ServiceColor colorSubMenu, ServiceFont fonts) {
        this.colorMenuBar = colorMenuBar;
        this.colorTitle = colorTitle;
        this.colorSubMenu = colorSubMenu;
        this.fonts = fonts;
    }

    public JMenu getCiv() {
        return civ;
    }

    public JMenu getTactics() {
        return tactics;
    }

    public JMenuItem getScout() {
        return scout;
    }

    public JMenuItem getCastle() {
        return castle;
    }

    public JMenuBar get_menu_bar(){
        JMenuBar menuBar = new JMenuBar();
        this.civ = new JMenu("Civilizaciones");
        this.tactics = new JMenu("Tácticas");
        this.scout = new JMenuItem("rush scouts");
        this.castle = new JMenuItem("fast castle boom");

        menuBar.setBackground(colorMenuBar.getColor());
        civ.setForeground(colorTitle.getColor());
        tactics.setForeground(colorTitle.getColor());
        scout.setBackground(colorSubMenu.getColor());
        castle.setBackground(colorSubMenu.getColor());

        civ.setFont(fonts.getFontMenu().deriveFont(Font.BOLD,16));
        tactics.setFont(fonts.getFontMenu().deriveFont(Font.BOLD,16));
        scout.setFont(fonts.getFontSubMenu().deriveFont(Font.BOLD,12));
        castle.setFont(fonts.getFontSubMenu().deriveFont(Font.BOLD,12));

        tactics.add(scout);
        tactics.add(castle);
        menuBar.add(civ);
        menuBar.add(tactics);

        return menuBar;
    }
}
