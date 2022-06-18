package Pomodoro;

import javax.swing.*;

public class JWindow extends JFrame{
    JWindow() {
        this.setTitle("savage");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(420,420);
        this.setVisible(true);
        ImageIcon logo = new ImageIcon("images/5ihr_ccqi_210528.jpg");
        this.setIconImage(logo.getImage());
    }
}
