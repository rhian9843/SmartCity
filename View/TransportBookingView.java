package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

public class TransportBookingView extends JFrame {
    private JComboBox<String> transportOptionsComboBox;
    private JTextField pickupTextField;
    private JTextField dropoffTextField;
    private JButton bookButton;

    public TransportBookingView() {
        setTitle("Transport Booking");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel inputPanel = new JPanel();
        contentPane.add(inputPanel, BorderLayout.NORTH);
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));

        JLabel lblPickup = new JLabel("Pickup Location:");
        inputPanel.add(lblPickup);

        pickupTextField = new JTextField();
        inputPanel.add(pickupTextField);
        pickupTextField.setColumns(10);

        JLabel lblDropoff = new JLabel("Dropoff Location:");
        inputPanel.add(lblDropoff);

        dropoffTextField = new JTextField();
        inputPanel.add(dropoffTextField);
        dropoffTextField.setColumns(10);

        JLabel lblTransportOptions = new JLabel("Transport Options:");
        inputPanel.add(lblTransportOptions);

        transportOptionsComboBox = new JComboBox<>();
        transportOptionsComboBox.addItem("Auto");
        transportOptionsComboBox.addItem("Cab");
        inputPanel.add(transportOptionsComboBox);

        bookButton = new JButton("Book");
        contentPane.add(bookButton, BorderLayout.SOUTH);
    }

    // Getter method to retrieve the selected transport option
    public String getSelectedTransportOption() {
        return (String) transportOptionsComboBox.getSelectedItem();
    }

    // Getter methods to retrieve pickup and dropoff locations
    public String getPickupLocation() {
        return pickupTextField.getText();
    }

    public String getDropoffLocation() {
        return dropoffTextField.getText();
    }

    // Add other methods as needed

    // Dummy method to add book listener
    public void addBookListener(ActionListener listener) {
        bookButton.addActionListener(listener);
    }
}
