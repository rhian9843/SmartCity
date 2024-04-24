package View;

import javax.swing.*;
import java.awt.event.*;

public class LibraryView extends JFrame {
    private JTextField fieldOfInterestField;
    private JTextField libraryNameField;
    private JTextField libraryLocationField;
    private JButton okButton;
    private JButton cancelButton;

    public LibraryView() {
        setTitle("Add Library");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        fieldOfInterestField = new JTextField(20);
        libraryNameField = new JTextField(20);
        libraryLocationField = new JTextField(20);
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        panel.add(new JLabel("Field of Interest:"));
        panel.add(fieldOfInterestField);
        panel.add(new JLabel("Library Name:"));
        panel.add(libraryNameField);
        panel.add(new JLabel("Library Location:"));
        panel.add(libraryLocationField);
        panel.add(okButton);
        panel.add(cancelButton);

        add(panel);
    }

    // Method to retrieve library details entered by the user
    public String[] getLibraryDetails() {
        String fieldOfInterest = fieldOfInterestField.getText();
        String libraryName = libraryNameField.getText();
        String libraryLocation = libraryLocationField.getText();
        // Return library details as an array
        return new String[] { fieldOfInterest, libraryName, libraryLocation };
    }

    // Method to add action listener for the OK button
    public void addOkButtonListener(ActionListener listener) {
        okButton.addActionListener(listener);
    }

    // Method to add action listener for the Cancel button
    public void addCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }
}
