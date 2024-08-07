import interfaces.ICiv;
import model.Francs;
import model.Mongols;
import service.ServiceColor;
import service.ServiceFont;
import service.ServiceIcon;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main() {
        startGUI();
    }

    private JMenuBar get_menu_bar(){
        JMenuBar menuBar;
        JMenu civ;
        JMenu tactics;
        JMenuItem scout;
        JMenuItem castle;
        ServiceFont fonts;

        //load colors
        ServiceColor colorMenuBar = ServiceColor.MENUBAR;
        ServiceColor colorTitle = ServiceColor.TITLE;
        ServiceColor colorSubMenu = ServiceColor.SUBMENU;


        menuBar = new JMenuBar();
        civ = new JMenu("Civilizaciones");
        tactics = new JMenu("Tácticas");
        scout = new JMenuItem("rush scouts");
        castle = new JMenuItem("fast castle boom");

        menuBar.setBackground(colorMenuBar.getColor());
        civ.setForeground(colorTitle.getColor());
        tactics.setForeground(colorTitle.getColor());
        scout.setBackground(colorSubMenu.getColor());
        castle.setBackground(colorSubMenu.getColor());

        //load fonts
        String menuFont = "font/Centaur MT.ttf";
        String subMenuFont = "font/papyrus.ttf";
        fonts = new ServiceFont(menuFont, subMenuFont);
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

    private void startGUI(){
        //load colors
        ServiceColor colorBackground = ServiceColor.BACKGROUND;
        ServiceColor colorMenuBar = ServiceColor.MENUBAR;
        ServiceColor colorTitle = ServiceColor.TITLE;

        //load image
        ServiceIcon images = new ServiceIcon();
        ImageIcon mongolsIcon = images.load_icon("img/civ/CivIcon-Mongoles.png");
        ImageIcon francsIcon = images.load_icon("img/civ/CivIcon-Francos.png");

        ImageIcon mongolsResize = images.resize_icon_civ(mongolsIcon,50,50);
        ImageIcon francsResize = images.resize_icon_civ(francsIcon,50,50);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame window = new JFrame("Age of Empires II");
        window.setIconImage(new ImageIcon("img/icon-age2.png").getImage());
        window.setSize(600,400);
        //position center
        window.setLocationRelativeTo(null);
        window.setMinimumSize(window.getSize());

        JPanel mainPanel = new JPanel();
        //organizo los contenedores en columnas
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.setBackground(colorBackground.getColor());

        JPanel panelCiv = new JPanel();
        //organizo los contenedores en filas
        panelCiv.setLayout(new FlowLayout());
        panelCiv.setOpaque(false); //fondo del panel transparente

        JButton iconMongols = new JButton(mongolsResize);
        JButton iconFrancs = new JButton(francsResize);
        iconMongols.setBackground(colorMenuBar.getColor());
        iconFrancs.setBackground(colorMenuBar.getColor());
        iconMongols.setFocusPainted(false);
        iconFrancs.setFocusPainted(false);

        Border raisedbevel = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        iconMongols.setBorder(raisedbevel);
        iconFrancs.setBorder(raisedbevel);

        images.mouse_over_icons_civ(iconMongols,colorTitle);
        images.mouse_over_icons_civ(iconFrancs,colorTitle);

        ICiv mongolFrame = new Mongols();
        ICiv francFrame = new Francs();
        images.frame_icons_civ(iconMongols, mongolFrame);
        images.frame_icons_civ(iconFrancs,francFrame);

        panelCiv.add(iconMongols);
        panelCiv.add(iconFrancs);

        //add main panel at frame
        mainPanel.add(panelCiv);

        //add window panel
        window.add(mainPanel);
        window.setJMenuBar(this.get_menu_bar());
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}