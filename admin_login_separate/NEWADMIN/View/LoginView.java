package View;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import Controller.LoginObserver;

public class LoginView extends JFrame implements LoginObserver {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;
    private List<LoginObserver> observers; // List to store observers

    public LoginView() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        signupButton = new JButton("SignUp");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);

        add(panel);

        observers = new ArrayList<>(); // Initialize observers list
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void addLoginButtonListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void addSignupButtonListener(ActionListener listener) {
        signupButton.addActionListener(listener);
    }

    public void addObserver(LoginObserver observer) {
        observers.add(observer); // Add observer to the list
    }

    @Override
    public void updateLoginState(boolean isLoggedIn, boolean isAdminLoggedIn) {
        for (LoginObserver observer : observers) {
            observer.updateLoginState(isLoggedIn, isAdminLoggedIn); // Notify observers
        }
    }

    public void displayLoginSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Login successful!");
    }

    public void displayLoginErrorMessage() {
        JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void displaySignUpMessage() {
        JOptionPane.showMessageDialog(this, "Please enter correct login credentials.");
    }
}
