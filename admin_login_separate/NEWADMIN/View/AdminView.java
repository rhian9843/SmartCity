// AdminView.java
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import Controller.AdminController;

public class AdminView extends JFrame {
    private JButton addJobButton;
    private JButton addLibraryButton;
    private JButton addCollegeButton;
    private JButton addDriversButton;

    public AdminView() {
        setTitle("Admin Panel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        addJobButton = new JButton("Add Job");
        addLibraryButton = new JButton("Add Library");
        addCollegeButton = new JButton("Add College");
        addDriversButton = new JButton("Add Driver");

        // Set layout
        setLayout(new GridLayout(3, 1));

        // Add components to the frame
        add(addJobButton);
        add(addLibraryButton);
        add(addCollegeButton);
        add(addDriversButton);

        // Display the frame
        setVisible(true);
    }

    // Add action listeners for the buttons
    public void addAddJobButtonListener(ActionListener listener) {
        addJobButton.addActionListener(listener);
    }

    public void addAddLibraryButtonListener(ActionListener listener) {
        addLibraryButton.addActionListener(listener);
    }

    public void addAddCollegeButtonListener(ActionListener listener) {
        addCollegeButton.addActionListener(listener);
    }

    public void addAddDriversButtonListener(ActionListener listener) {
        addDriversButton.addActionListener(listener);
    }

    // Display admin options (buttons) in the view
    public void displayAdminOptions(AdminController adminController) {
        // Add action listeners for the buttons
        addAddJobButtonListener(e -> adminController.addJob());
        addAddLibraryButtonListener(e -> adminController.addLibrary());
        addAddCollegeButtonListener(e -> adminController.addCollege());
        addAddDriversButtonListener(e -> adminController.addDriver());
    }
}
