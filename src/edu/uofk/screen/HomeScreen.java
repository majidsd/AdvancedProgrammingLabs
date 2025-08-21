package edu.uofk.screen;

import javax.swing.*;
import java.awt.*;

public class HomeScreen {
    private final JFrame screenFrame;
    private final JLabel logedUserLabel;

    public HomeScreen(String currentUser) {
        screenFrame = new JFrame("Home Screen");
        screenFrame.setSize( 720, 720);
        screenFrame.setLocationRelativeTo(null); // This to put the login screen into the middle of the computer screen
        screenFrame.setLayout(null);
        screenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenFrame.getContentPane().setBackground(Color.gray);
        screenFrame.setResizable(false); // don't allow a user to maximize the screen

        logedUserLabel = new JLabel("Welcome " + currentUser);
        logedUserLabel.setBounds(20, 20, 100, 25);
        logedUserLabel.setForeground(Color.white);
        screenFrame.add(logedUserLabel); // attach current user label to the screen

        screenFrame.setVisible(true);
    }
}
