package View;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Point;

public class JobView extends JFrame {
    private JTextField locationField;
    private JTextField fieldOfInterestField;
    private JTextField jobOpportunityField;
    private JTextField employerField;
    private JTextArea descriptionArea;
    private JTextField salaryField;
    private JButton okButton;
    private JButton cancelButton;

    public JobView() {
        setTitle("Add Job");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        // Initialize input fields
        locationField = new JTextField(20);
        fieldOfInterestField = new JTextField(20);
        jobOpportunityField = new JTextField(20);
        employerField = new JTextField(20);
        descriptionArea = new JTextArea(5, 20);
        salaryField = new JTextField(10);
        // Initialize OK button
        okButton = new JButton("OK");
        // Initialize Cancel button
        cancelButton = new JButton("Cancel");

        // Add components to the panel
        panel.add(new JLabel("Location:"));
        panel.add(locationField);
        panel.add(new JLabel("Field of Interest:"));
        panel.add(fieldOfInterestField);
        panel.add(new JLabel("Job Opportunity:"));
        panel.add(jobOpportunityField);
        panel.add(new JLabel("Employer:"));
        panel.add(employerField);
        panel.add(new JLabel("Description:"));
        panel.add(new JScrollPane(descriptionArea));
        panel.add(new JLabel("Salary:"));
        panel.add(salaryField);
        panel.add(okButton);

        // Add panel to the frame
        add(panel);
    }

    public String getFieldOfInterest() {
        return fieldOfInterestField.getText();
    }

    public String getJobOpportunity() {
        return jobOpportunityField.getText();
    }

    public String getEmployer() {
        return employerField.getText();
    }

    public String getDescription() {
        return descriptionArea.getText();
    }

    public double getSalary() {
        String salaryText = salaryField.getText();
        try {
            return Double.parseDouble(salaryText);
        } catch (NumberFormatException e) {
            // Handle the case where the salary text cannot be parsed to double
            // For example, you can show an error message to the user
            return 0.0; // Default value if parsing fails
        }
    }

    public String getLocationAsString() {
        Point location = getLocation();
        return "(" + location.x + ", " + location.y + ")";
    }

    // Method to retrieve job details entered by the user
    public String[] getJobDetails() {
        String location = locationField.getText();
        String fieldOfInterest = fieldOfInterestField.getText();
        String jobOpportunity = jobOpportunityField.getText();
        String employer = employerField.getText();
        String description = descriptionArea.getText();
        String salary = salaryField.getText();
        // Return job details as an array
        return new String[] { location, fieldOfInterest, jobOpportunity, employer, description, salary };
    }

    // Method to add action listener for the OK button
    public void addOkButtonListener(ActionListener listener) {
        okButton.addActionListener(listener);
    }

    public void addCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }
}
