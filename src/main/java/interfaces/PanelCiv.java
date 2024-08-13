package interfaces;

import javax.swing.*;

public abstract class PanelCiv {
    private JFrame newWindow;
    private Integer width;
    private Integer height;

    public PanelCiv(JFrame newWindow){
        this.newWindow = newWindow;
        this.height=200;
        this.width=300;
    }

    public JFrame getNewWindow() {
        return newWindow;
    }

    public void startWindow(){
        newWindow.setSize(width, height);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setVisible(true);
    }
    public abstract void startGUI();
}
