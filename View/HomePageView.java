package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// This class represents the view for the home page
public class HomePageView extends JFrame {
    private JButton studentButton;
    private JButton jobButton;
    private JButton transportButton;
    private JLabel welcomeLabel;

    public HomePageView() {
        setTitle("Smart City Project");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel to hold image and buttons
        JPanel panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw background image
                Image backgroundImage = new ImageIcon("bg.jpg").getImage(); // Change "bg.jpg" to your image file
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Create GridBagConstraints for layout customization
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Add welcome label
        Font labelFont = new Font("Times New Roman", Font.BOLD, 50);
        welcomeLabel = new JLabel("Welcome to Smart City!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align the text
        welcomeLabel.setForeground(Color.BLACK); // Set text color
        welcomeLabel.setFont(labelFont);
        panel.add(welcomeLabel, gbc);

        // Adjusting GridBagConstraints for button placement
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0); // Adding top margin

        // Initialize buttons
        studentButton = new JButton("Student");
        jobButton = new JButton("Job");
        transportButton = new JButton("Public Transport");

        // Add buttons to the panel
        panel.add(studentButton, gbc);
        gbc.gridy++;
        panel.add(jobButton, gbc);
        gbc.gridy++;
        panel.add(transportButton, gbc);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Add panel to frame
        add(panel);

        // Display the frame
        setVisible(true);
    }

    // Add action listeners for the buttons
    public void addStudentButtonListener(ActionListener listener) {
        studentButton.addActionListener(listener);
    }

    public void addJobButtonListener(ActionListener listener) {
        jobButton.addActionListener(listener);
    }

    public void addTransportButtonListener(ActionListener listener) {
        transportButton.addActionListener(listener);
    }

    // Method to set text for the welcome label
    public void setWelcomeLabelText(String text) {
        welcomeLabel.setText(text);
    }

    // Method to set font for the welcome label
    public void setWelcomeLabelFont(Font font) {
        welcomeLabel.setFont(font);
    }

    // Method to set foreground color for the welcome label
    public void setWelcomeLabelColor(Color color) {
        welcomeLabel.setForeground(color);
    }
}
