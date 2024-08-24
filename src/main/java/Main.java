import controller.ActionListenerIcon;
import controller.MenuListenerImpl;
import controller.MouseListenerIcon;
import interfaces.IPanel;
import interfaces.PanelCiv;
import view.civ.Francs;
import view.MenuBar;
import view.civ.Mongols;
import service.ServiceColor;
import service.ServiceFont;
import service.ServiceIcon;
import view.tactics.Castle;
import view.tactics.Scout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main() {
        startGUI();
    }

    private void startGUI(){
        //load colors
        ServiceColor colorBackground = ServiceColor.BACKGROUND;
        ServiceColor colorMenuBar = ServiceColor.MENUBAR;
        ServiceColor colorSubMenu = ServiceColor.SUBMENU;
        ServiceColor colorTitle = ServiceColor.TITLE;

        //load menuBar
        ServiceFont fonts = new ServiceFont("font/Centaur MT.ttf", "font/papyrus.ttf");
        MenuBar menuBar = new MenuBar(colorMenuBar, colorTitle, colorSubMenu, fonts);

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
        //IPanel home = new Home(colorBackground);
        //home.startGUI();
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

        iconMongols.addMouseListener(new MouseListenerIcon(iconMongols,colorTitle));
        iconFrancs.addMouseListener(new MouseListenerIcon(iconFrancs, colorTitle));

        //PANELS CIVILIZATIONS
        PanelCiv mongolPanel = new Mongols(new JFrame("Mongoles"));
        PanelCiv francPanel = new Francs(new JFrame("Francos"));
        iconMongols.addActionListener(new ActionListenerIcon(mongolPanel));
        iconFrancs.addActionListener(new ActionListenerIcon(francPanel));

        panelCiv.add(iconMongols);
        panelCiv.add(iconFrancs);

        //PANELS TACTICS
        IPanel scoutPanel = new Scout();
        IPanel castlePanel = new Castle();

        //add panels at main panel
        mainPanel.add(panelCiv);

        //add panels at card panel
        cardPanel.add(scoutPanel.startGUI(),"Scouts");
        cardPanel.add(castlePanel.startGUI(),"Castle");
        cardPanel.add(mainPanel, "Civilizations");

        window.setJMenuBar(menuBar.get_menu_bar());

        CardLayout managerPanels = (CardLayout) cardPanel.getLayout();
        MenuListener getCivilizations = new MenuListenerImpl(managerPanels,
                cardPanel, "Civilizations");

        ActionListener cardSwitchListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cardPanel.getLayout();
                JMenuItem source = (JMenuItem) e.getSource();

                if (source == menuBar.getScout()) {
                    cl.show(cardPanel, "Scouts");
                } else if (source == menuBar.getCastle()) {
                    cl.show(cardPanel, "Castle");
                }
            }
        };

        menuBar.getCiv().addMenuListener(getCivilizations);
        menuBar.getScout().addActionListener(cardSwitchListener);
        menuBar.getCastle().addActionListener(cardSwitchListener);

        //add main panel at window panel
        window.add(cardPanel);
        //window.add(mainPanel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}