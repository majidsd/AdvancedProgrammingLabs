package edu.uofk.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen implements ActionListener {
    private final JFrame screenFrame;

    private final JLabel usernameLabel;
    private final JTextField usernameField;

    private final JLabel passwordLabel;
    private final JPasswordField passwordField;

    private final JButton loginButton;
    private final JButton restValuesButton;

    private final JLabel errorMessageLabel;

    public LoginScreen(){
        // 1# The main screen holder [500 x 500 size in the middle of the computer screen]
        screenFrame = new JFrame();
        screenFrame.setSize( 720, 720);
        screenFrame.setLocationRelativeTo(null); // This to put the login screen into the middle of the computer screen
        screenFrame.setLayout(null);
        screenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenFrame.getContentPane().setBackground(Color.gray);
        //screenFrame.setIconImage("icon"); -- here you can set icon
        screenFrame.setResizable(false); // don't allow a user to maximize the screen

        // 2# The username section
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(220, 220, 75, 25);
        usernameLabel.setForeground(Color.white);
        screenFrame.add(usernameLabel); // attach username label to the screen

        usernameField = new JTextField();
        usernameField.setBounds(300, 220, 200, 25);
        screenFrame.add(usernameField); // attach username edit to the screen

        // 3# The password section
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(220, 260, 75, 25);
        passwordLabel.setForeground(Color.white);
        screenFrame.add(passwordLabel); // attach password label to the screen

        passwordField = new JPasswordField();
        passwordField.setBounds(300, 260, 200, 25);
        screenFrame.add(passwordField); // attach password edit to the screen

        // 4# Login and Rest values section
        loginButton = new JButton("Login");
        loginButton.setBounds(260, 310, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        screenFrame.add(loginButton);

        restValuesButton = new JButton("Reset");
        restValuesButton.setBounds(380, 310, 100, 25);
        restValuesButton.setFocusable(false);
        restValuesButton.addActionListener(this);
        screenFrame.add(restValuesButton);

        // 5# Error message section
        errorMessageLabel = new JLabel("");
        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setBounds(280, 350, 200, 25);
        screenFrame.add(errorMessageLabel);

        // Make the main screen visible
        screenFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // e is holding the click event in this screen, so we have two buttons to click (rest and login), let check them
        if (e.getSource() == restValuesButton){ // we clear the JTextEdit if rest is clicked
            usernameField.setText(""); // "" is empty text
            passwordField.setText(""); // "" is empty as well
            errorMessageLabel.setText(""); // "" same
        }

        if (e.getSource() == loginButton) {
            // As an example we accept only 'admin' and 'password' as valid users
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (username.equals("admin") && password.equals("password")) {
                // kill the current screen
                screenFrame.dispose();

                // Open the home screen
                new HomeScreen(username);
            } else {
                errorMessageLabel.setForeground(Color.RED);
                errorMessageLabel.setText("Invalid username or password");
            }
        }
    }
}
