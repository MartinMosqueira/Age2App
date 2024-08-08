import interfaces.ICiv;
import model.Francs;
import model.Mongols;
import service.ServiceColor;
import service.ServiceFont;
import service.ServiceIcon;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JMenuItem scout;
    private JMenuItem castle;

    private JMenu civ;

    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main() {
        startGUI();
    }

    private JMenuBar get_menu_bar(){
        JMenuBar menuBar;
        JMenu tactics;
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
        ServiceIcon serviceIcon = new ServiceIcon();
        ImageIcon mongolsIcon = serviceIcon.load_icon("img/civ/CivIcon-Mongoles.png");
        ImageIcon francsIcon = serviceIcon.load_icon("img/civ/CivIcon-Francos.png");

        ImageIcon mongolsResize = serviceIcon.resize_icon_civ(mongolsIcon,50,50);
        ImageIcon francsResize = serviceIcon.resize_icon_civ(francsIcon,50,50);

        //WINDOW
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame window = new JFrame("Age of Empires II");
        window.setIconImage(new ImageIcon("img/icon-age2.png").getImage());
        window.setSize(600,400);
        //position center
        window.setLocationRelativeTo(null);
        window.setMinimumSize(window.getSize());

        //CARD PANEL
        JPanel cardPanel = new JPanel(new CardLayout());

        //MAIN PANEL
        JPanel mainPanel = new JPanel();
        //organizo los contenedores en columnas
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.setBackground(colorBackground.getColor());

        //PANEL CIVILIZATION
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

        serviceIcon.mouse_over_icons_civ(iconMongols,colorTitle);
        serviceIcon.mouse_over_icons_civ(iconFrancs,colorTitle);

        //PANELS CIVILIZATIONS
        ICiv mongolPanel = new Mongols();
        ICiv francPanel = new Francs();
        serviceIcon.panel_icons_civ(iconMongols, mongolPanel);
        serviceIcon.panel_icons_civ(iconFrancs,francPanel);

        panelCiv.add(iconMongols);
        panelCiv.add(iconFrancs);

        //PANELS TACTICS
        JPanel scoutsPanel = new JPanel();
        scoutsPanel.add(new JLabel("panel scouts!"));
        JPanel castlePanel = new JPanel();
        castlePanel.add(new JLabel("castle panel!"));

        //add panels at main panel
        mainPanel.add(panelCiv);

        //add panels at card panel
        cardPanel.add(scoutsPanel,"Scouts");
        cardPanel.add(castlePanel,"Castle");
        cardPanel.add(mainPanel, "Civilizations");

        window.setJMenuBar(this.get_menu_bar());

        MenuListener menuListener = new MenuListener() {
            final CardLayout cl = (CardLayout) cardPanel.getLayout();
            @Override
            public void menuSelected(MenuEvent e) {
                cl.show(cardPanel, "Civilizations");
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        };

        ActionListener cardSwitchListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cardPanel.getLayout();
                JMenuItem source = (JMenuItem) e.getSource();

                if (source == scout) {
                    cl.show(cardPanel, "Scouts");
                } else if (source == castle) {
                    cl.show(cardPanel, "Castle");
                }
            }
        };

        civ.addMenuListener(menuListener);
        scout.addActionListener(cardSwitchListener);
        castle.addActionListener(cardSwitchListener);

        //add main panel at window panel
        window.add(cardPanel);
        //window.add(mainPanel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}