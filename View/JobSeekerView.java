package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class JobSeekerView extends JFrame {
    public JList<String> jobsList;
    private JButton searchButton;
    private JTextArea jobOpportunitiesTextArea;
    private JButton applyButton; // New Apply button
    public JTextField locationTextField;
    public JTextField fieldOfInterestTextField;


    public JobSeekerView() {
        setTitle("Job Opportunities");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                /*Image backgroundImage = new ImageIcon("bg.jpg").getImage(); // Change "bg.jpg" to your image file
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);*/
            }
        };

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        contentPane.add(panel, BorderLayout.CENTER);

        // Panel for input fields
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLocation = new JLabel("Location:");
        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLocation.setBounds(29, 23, 75, 23);
        contentPane.add(lblLocation);

        locationTextField = new JTextField();
        locationTextField.setBounds(110, 23, 200, 23);
        contentPane.add(locationTextField);

        JLabel lblFieldOfInterest = new JLabel("Field of Interest:");
        lblFieldOfInterest.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblFieldOfInterest.setBounds(320, 23, 120, 23);
        contentPane.add(lblFieldOfInterest);

        fieldOfInterestTextField = new JTextField();
        fieldOfInterestTextField.setBounds(450, 23, 200, 23);
        contentPane.add(fieldOfInterestTextField);

        searchButton = new JButton("Search");
        searchButton.setBounds(29, 60, 100, 23);
        contentPane.add(searchButton);

        // Scroll pane for job opportunities text area
        JScrollPane jobOpportunitiesScrollPane = new JScrollPane();
        jobOpportunitiesScrollPane.setBounds(29, 100, 540, 250);
        contentPane.add(jobOpportunitiesScrollPane);

        // Job opportunities text area
        jobOpportunitiesTextArea = new JTextArea();
        jobOpportunitiesScrollPane.setViewportView(jobOpportunitiesTextArea);

        // Apply button
        applyButton = new JButton("Apply");
        applyButton.setBounds(29, 60, 100, 23);
        contentPane.add(applyButton);
    }

    public String getLocationText() {
        return locationTextField.getText();
    }

    public String getFieldOfInterestText() {
        return fieldOfInterestTextField.getText();
    }

    public void setSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public void setJobOpportunities(List<String> jobOpportunities) {
        StringBuilder sb = new StringBuilder();
        for (String opportunity : jobOpportunities) {
            sb.append(opportunity).append("\n\n");
        }
        jobOpportunitiesTextArea.setText(sb.toString());
    }

    public void addApplyButtonListener(ActionListener listener) {
        applyButton.addActionListener(listener);
    }
}
