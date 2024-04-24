package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentView extends JFrame {
    private JList<String> collegeList;
    private JList<String> libraryList;
    private JTextField locationTextField;
    private JTextField fieldOfInterestTextField;
    private JButton searchButton;

    public StudentView() {
        setTitle("StudentMenu");
        setBounds(100, 100, 648, 414);
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("bg.jpg").getImage(); // Change "bg.jpg" to your image file
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
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

        JScrollPane collegeScrollPane = new JScrollPane();
        collegeScrollPane.setBounds(29, 100, 300, 150);
        contentPane.add(collegeScrollPane);

        collegeList = new JList<>();
        collegeScrollPane.setViewportView(collegeList);

        JScrollPane libraryScrollPane = new JScrollPane();
        libraryScrollPane.setBounds(335, 100, 300, 150);
        contentPane.add(libraryScrollPane);

        libraryList = new JList<>();
        libraryScrollPane.setViewportView(libraryList);

        // Other GUI components...

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("unnamed.jpg"));
        lblNewLabel_2.setBounds(0, 0, 634, 377);
        contentPane.add(lblNewLabel_2);
    }

    public String getLocationText() {
        return locationTextField.getText();
    }

    public String getFieldOfInterestText() {
        return fieldOfInterestTextField.getText();
    }

    public void setColleges(List<String> colleges) {
        collegeList.setListData(colleges.toArray(new String[0]));
    }

    public void setLibraries(List<String> libraries) {
        libraryList.setListData(libraries.toArray(new String[0]));
    }

    public void setSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }
}
