package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DriverView extends JFrame {
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel pickUpLocationLabel;
    private JTextField pickUpLocationTextField;
    private JLabel dropOffLocationLabel;
    private JTextField dropOffLocationTextField;
    private JLabel carNumberPlateLabel;
    private JTextField carNumberPlateTextField;
    private JButton addButton;

    public DriverView() {
        setTitle("Add Driver");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();
        pickUpLocationLabel = new JLabel("Pick-up Location:");
        pickUpLocationTextField = new JTextField();
        dropOffLocationLabel = new JLabel("Drop-off Location:");
        dropOffLocationTextField = new JTextField();
        carNumberPlateLabel = new JLabel("Car Number Plate:");
        carNumberPlateTextField = new JTextField();
        addButton = new JButton("Add");

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(pickUpLocationLabel);
        panel.add(pickUpLocationTextField);
        panel.add(dropOffLocationLabel);
        panel.add(dropOffLocationTextField);
        panel.add(carNumberPlateLabel);
        panel.add(carNumberPlateTextField);
        panel.add(addButton);

        add(panel);
    }

    public String getName() {
        return nameTextField.getText();
    }

    public String getPickUpLocation() {
        return pickUpLocationTextField.getText();
    }

    public String getDropOffLocation() {
        return dropOffLocationTextField.getText();
    }

    public String getCarNumberPlate() {
        return carNumberPlateTextField.getText();
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
