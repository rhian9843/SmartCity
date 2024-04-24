package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// This class represents the view for the home page
public class HomePageView extends JFrame {
    private JLabel descriptionLabel;
    private JButton studentButton;
    private JButton jobButton;
    private JButton transportButton;

    public HomePageView() {
        setTitle("Smart City Project");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        descriptionLabel = new JLabel("Welcome to the Smart City Project!");
        studentButton = new JButton("Student");
        jobButton = new JButton("Job");
        transportButton = new JButton("Public Transport");

        // Set layout
        setLayout(new GridLayout(4, 1));

        // Add components to the frame
        add(descriptionLabel);
        add(studentButton);
        add(jobButton);
        add(transportButton);

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
}
