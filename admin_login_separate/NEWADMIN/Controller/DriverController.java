package Controller;

import Model.DriverModel;
import View.DriverView;

import javax.swing.JOptionPane; // For pop-up messages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverController {
    private DriverModel driverModel;
    private DriverView driverView;

    public DriverController(DriverModel driverModel, DriverView driverView) {
        this.driverModel = driverModel;
        this.driverView = driverView;

        this.driverView.addAddButtonListener(new AddButtonListener());
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Retrieve data from the view
            String name = driverView.getName();
            String pickUpLocation = driverView.getPickUpLocation();
            String dropOffLocation = driverView.getDropOffLocation();
            String carNumberPlate = driverView.getCarNumberPlate();

            // Set data to the model
            driverModel.setName(name);
            driverModel.setPickUpLocation(pickUpLocation);
            driverModel.setDropOffLocation(dropOffLocation);
            driverModel.setCarNumberPlate(carNumberPlate);

            // Perform any necessary actions with the model data, such as saving to a
            // database

            // Display the "Input Done!" pop-up
            JOptionPane.showMessageDialog(
                    driverView,
                    "Input Done!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            // Optionally, close the DriverView
            driverView.dispose();
        }
    }
}
