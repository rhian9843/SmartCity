package View;

import javax.swing.*;
import java.awt.event.*;

public class UserView {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;

    public UserView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("User Login/Signup");
        frame.setBounds(100, 100, 300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30, 30, 80, 25);
        frame.getContentPane().add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(120, 30, 150, 25);
        frame.getContentPane().add(usernameField);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, 70, 80, 25);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 150, 25);
        frame.getContentPane().add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(30, 120, 100, 25);
        frame.getContentPane().add(loginButton);

        signupButton = new JButton("Signup");
        signupButton.setBounds(170, 120, 100, 25);
        frame.getContentPane().add(signupButton);

        frame.setVisible(true);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void addSignupListener(ActionListener listener) {
        signupButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    // Method to open the new page after login
    public void openUserHomePage(ActionListener transportListener, ActionListener studentListener, ActionListener jobSeekerListener) {
        // Close the current login/signup window
        frame.dispose();

        // Create new frame for user home page
        JFrame homeFrame = new JFrame("User Home Page");
        homeFrame.setBounds(100, 100, 300, 200);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.getContentPane().setLayout(null);

        JButton transportButton = new JButton("Transport");
        transportButton.setBounds(30, 30, 100, 25);
        homeFrame.getContentPane().add(transportButton);

        JButton studentButton = new JButton("Student");
        studentButton.setBounds(30, 70, 100, 25);
        homeFrame.getContentPane().add(studentButton);

        JButton jobSeekerButton = new JButton("Job Seeker");
        jobSeekerButton.setBounds(30, 110, 100, 25);
        homeFrame.getContentPane().add(jobSeekerButton);

        transportButton.addActionListener(transportListener);
        studentButton.addActionListener(studentListener);
        jobSeekerButton.addActionListener(jobSeekerListener);

        homeFrame.setVisible(true);
    }
}
