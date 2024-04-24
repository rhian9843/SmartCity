package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RoundedCornerButton extends JButton {
    public RoundedCornerButton(String text) {
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

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;

    public LoginView() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with custom background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("bg.jpg").getImage(); // Change "bg.jpg" to your image file
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(new BorderLayout());

        // Create a panel for the login components with GridBagLayout
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setOpaque(false); // Make the panel transparent

        // Create GridBagConstraints for layout customization
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding

        // Create labels for username and password
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        // Set font and font size for labels
        Font labelFont = new Font("Times New Roman", Font.PLAIN, 20); // Change the font family and size as desired
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        usernameLabel.setForeground(Color.WHITE); // Change color as desired
        passwordLabel.setForeground(Color.WHITE);

        // Create components
        usernameField = new JTextField(30);
        passwordField = new JPasswordField(30);
        loginButton = new RoundedCornerButton("Login"); // Use custom button class
        signupButton = new RoundedCornerButton("SignUp"); // Use custom button class

        Dimension fieldSize = new Dimension(100, 40); // Adjust the size as needed
        usernameField.setPreferredSize(fieldSize);
        passwordField.setPreferredSize(fieldSize);

        Dimension buttonSize = new Dimension(150, 50); // Adjust the size as needed
        loginButton.setPreferredSize(buttonSize);
        signupButton.setPreferredSize(buttonSize);
        // Add components to the loginPanel using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginButton, gbc);

        gbc.gridy = 3;
        loginPanel.add(signupButton, gbc);

        // Add loginPanel to the center of the panel
        panel.add(loginPanel, BorderLayout.CENTER);

        // Set size and make the frame visible
        setSize(800, 600); // Set a reasonable size
        setLocationRelativeTo(null); // Center the frame on the screen
        setContentPane(panel);
        
    }

    // Getters for username and password
    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    // Method to add ActionListener to login button
    public void addLoginButtonListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    // Method to display login success message
    public void displayLoginSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Login successful!");
    }

    // Method to display login error message
    public void displayLoginErrorMessage() {
        JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to add ActionListener to signup button
    public void addSignupButtonListener(ActionListener listener) {
        signupButton.addActionListener(listener);
    }

    // Method to display sign-up message
    public void displaySignUpMessage() {
        JOptionPane.showMessageDialog(this, "Please enter correct login credentials.");
    }

    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }
}