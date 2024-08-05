import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        LoadFonts fonts;

        //load colors
        CustomColor colorMenuBar = CustomColor.MENUBAR;
        CustomColor colorTitle = CustomColor.TITLE;
        CustomColor colorSubMenu = CustomColor.SUBMENU;


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
        fonts = new LoadFonts();
        fonts.load_custom_font();
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

    public void mouse_over_icons_civ(JButton iconCiv, CustomColor overColor){
        iconCiv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                iconCiv.setBackground(overColor.getColor());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                iconCiv.setBackground(CustomColor.MENUBAR.getColor());
            }
        });
    }

    private void startGUI(){
        //load colors
        CustomColor colorBackground = CustomColor.BACKGROUND;
        CustomColor colorMenuBar = CustomColor.MENUBAR;
        CustomColor colorTitle = CustomColor.TITLE;

        //load image
        CustomImage images = new CustomImage();
        ImageIcon mongols = images.load_image_civ("img/civ/CivIcon-Mongoles.png");
        ImageIcon francs = images.load_image_civ("img/civ/CivIcon-Francos.png");

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

        JButton iconMongols = new JButton(mongols);
        JButton iconFrancs = new JButton(francs);
        iconMongols.setBackground(colorMenuBar.getColor());
        iconFrancs.setBackground(colorMenuBar.getColor());
        iconMongols.setFocusPainted(false);
        iconFrancs.setFocusPainted(false);

        Border raisedbevel = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        iconMongols.setBorder(raisedbevel);
        iconFrancs.setBorder(raisedbevel);

        mouse_over_icons_civ(iconMongols,colorTitle);
        mouse_over_icons_civ(iconFrancs,colorTitle);

        //TODO: refactor functions
        iconMongols.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("New Panel");
                newFrame.setSize(300, 200);
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel newPanel = new JPanel();
                newPanel.add(new JLabel("This is a new panel!"));
                newFrame.add(newPanel);
                newFrame.setVisible(true);
            }
        });

        iconFrancs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("New Panel");
                newFrame.setSize(300, 200);
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel newPanel = new JPanel();
                newPanel.add(new JLabel("This is a new panel!"));
                newFrame.add(newPanel);
                newFrame.setVisible(true);
            }
        });

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