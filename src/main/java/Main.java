import javax.swing.*;
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

    private void startGUI(){
        //load colors
        CustomColor colorBackground = CustomColor.BACKGROUND;

        //load image
        ImageIcon icon = new ImageIcon("img/civ/CivIcon-Mongoles.png");
        Image getImage = icon.getImage();
        Image scaledImage = getImage.getScaledInstance(50,50,Image.SCALE_AREA_AVERAGING);
        ImageIcon newImageScaled = new ImageIcon(scaledImage);

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
        JLabel image = new JLabel(newImageScaled, JLabel.LEFT);
        panelCiv.add(image);

        //add main panel at frame
        mainPanel.add(panelCiv);

        //add window panel
        window.add(mainPanel);
        window.setJMenuBar(this.get_menu_bar());
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}