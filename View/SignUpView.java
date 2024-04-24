package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RoundCornerButton extends JButton {
    public RoundCornerButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(Color.LIGHT_GRAY);
        } else if (getModel().isRollover()) {
            g.setColor(Color.GRAY);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g);
    }
}
public class SignUpView extends JFrame {
    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField phoneNumberField;
    private JButton signupButton;
    //private JButton cancelButton;

    public SignUpView() {
        setTitle("Sign Up");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel with custom background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("bg.jpg").getImage(); // Change "bg.jpg" to your image file
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(new GridBagLayout());

        // Create GridBagConstraints for layout customization
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding
        gbc.anchor = GridBagConstraints.CENTER; // Center horizontally and vertically

        // Create labels for text
        JLabel emailLabel = new JLabel("Email:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");

        // Set labels foreground color to white
        emailLabel.setForeground(Color.WHITE);
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        phoneNumberLabel.setForeground(Color.WHITE);

        // Set font size for labels
        Font labelFont = new Font("Arial", Font.PLAIN, 18); // Adjust the font family and size as desired
        emailLabel.setFont(labelFont);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);
        phoneNumberLabel.setFont(labelFont);

        // Create text fields and buttons
        emailField = new JTextField(20);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        phoneNumberField = new JTextField(20);
        signupButton = new RoundedCornerButton("Sign Up");
        //cancelButton = new RoundedCornerButton("Cancel");

        // Set preferred size for text fields
        Dimension fieldSize = new Dimension(200, 30); // Adjust the width and height as desired
        emailField.setPreferredSize(fieldSize);
        usernameField.setPreferredSize(fieldSize);
        passwordField.setPreferredSize(fieldSize);
        phoneNumberField.setPreferredSize(fieldSize);

        Dimension buttonSize = new Dimension(150, 50); // Adjust the size as needed
        //cancelButton.setPreferredSize(buttonSize);
        signupButton.setPreferredSize(buttonSize);

        // Add components to the panel using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Reset gridwidth to default
        panel.add(emailLabel, gbc);

        gbc.gridy = 1;
        panel.add(usernameLabel, gbc);

        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        gbc.gridy = 3;
        panel.add(phoneNumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Give text fields more space horizontally
        panel.add(emailField, gbc);

        gbc.gridy = 1;
        panel.add(usernameField, gbc);

        gbc.gridy = 2;
        panel.add(passwordField, gbc);

        gbc.gridy = 3;
        panel.add(phoneNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Span two columns
        panel.add(signupButton, gbc);

        gbc.gridy = 5;
        //panel.add(cancelButton, gbc);

        // Set size and make the frame visible
        setSize(800, 600); // Set a reasonable size
        setLocationRelativeTo(null); // Center the frame on the screen
        setContentPane(panel);
    }

    // Getters for email, username, password, and phone number
    public String getEmailId() {
        return emailField.getText();
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    // Method to add ActionListener to signup button
    public void addSignupButtonListener(ActionListener listener) {
        signupButton.addActionListener(listener);
    }

    // Method to add ActionListener to cancel button
    /*public void addCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }*/

    // Method to display signup success message
    public void displaySignUpSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Signup successful! Please check your email for verification.");
    }

    // Method to display signup error message
    public void displaySignUpErrorMessage() {
        JOptionPane.showMessageDialog(this, "Signup failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }

}