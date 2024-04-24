package View;

import javax.swing.*;
import java.awt.event.*;

public class CollegeView extends JFrame {
    private JTextField fieldOfInterestField;
    private JTextField collegeNameField;
    private JTextField collegeLocationField;
    private JButton okButton;

    public CollegeView() {
        setTitle("Add College");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        // Initialize input fields
        fieldOfInterestField = new JTextField(20);
        collegeNameField = new JTextField(20);
        collegeLocationField = new JTextField(20);
        // Initialize OK button
        okButton = new JButton("OK");

        // Add components to the panel
        panel.add(new JLabel("Field of Interest:"));
        panel.add(fieldOfInterestField);
        panel.add(new JLabel("College Name:"));
        panel.add(collegeNameField);
        panel.add(new JLabel("College Location:"));
        panel.add(collegeLocationField);
        panel.add(okButton);

        // Add panel to the frame
        add(panel);
    }

    // Method to retrieve college details entered by the user
    public String[] getCollegeDetails() {
        String fieldOfInterest = fieldOfInterestField.getText();
        String collegeName = collegeNameField.getText();
        String collegeLocation = collegeLocationField.getText();
        // Return college details as an array
        return new String[] { fieldOfInterest, collegeName, collegeLocation };
    }

    // Method to add action listener for the OK button
    public void addOkButtonListener(ActionListener listener) {
        okButton.addActionListener(listener);
    }
}
