import javax.swing.*;
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
        //load image 1
        ImageIcon icon = new ImageIcon("img/CivIcon-Mongoles.png");
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
        mainPanel.setBackground(new Color(232,220,196));

        JPanel panelButtons = new JPanel();
        //organizo los contenedores en fila
        panelButtons.setLayout(new FlowLayout());
        panelButtons.setOpaque(false); // fondo del panel transparente
        //panelButtons.setPreferredSize(new Dimension(200, 200));
        //add button 1
        JButton myButton = new JButton("Message");
        myButton.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        myButton.setBackground(new Color(8, 4, 36));
        myButton.setForeground(new Color(252, 212, 4));
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World");
            }
        });
        //add button 2
        JButton myButton2 = new JButton("Finish");
        myButton2.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        myButton2.setBackground(new Color(8, 4, 36));
        myButton2.setForeground(new Color(252, 212, 4));

        //add buttons at frame
        panelButtons.add(myButton);
        panelButtons.add(myButton2);

        JPanel panelHome = new JPanel();
        panelHome.setOpaque(false); //fondo del panel transparente
        JLabel image = new JLabel("Mongoles",newImageScaled, JLabel.CENTER);
        panelHome.add(image);

        //add main panel at frame
        mainPanel.add(panelButtons);
        mainPanel.add(panelHome);

        //add window panel
        window.add(mainPanel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}