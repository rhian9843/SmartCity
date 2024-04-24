package Controller;

import Model.TransportBookingModel;
import View.TransportBookingView;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// Interface for creating transport options
interface TransportOptionFactory {
    TransportOption createTransportOption();
}

// Concrete factory for creating taxi transport options
class TaxiFactory implements TransportOptionFactory {
    @Override
    public TransportOption createTransportOption() {
        // Logic for creating a taxi transport option
        return new TaxiTransportOption();
    }
}

// Concrete factory for creating bus transport options
class BusFactory implements TransportOptionFactory {
    @Override
    public TransportOption createTransportOption() {
        // Logic for creating a bus transport option
        return new BusTransportOption();
    }
}

// Abstract class representing a transport option
// public abstract class TransportOption {
//     abstract String getType();
// }

// Concrete class representing a taxi transport option
class TaxiTransportOption extends TransportOption {
    @Override
    String getType() {
        return "Taxi";
    }
}

// Concrete class representing a bus transport option
class BusTransportOption extends TransportOption {
    @Override
    String getType() {
        return "Bus";
    }
}

public class TransportBookingController {
    private TransportBookingModel model;
    private TransportBookingView view;

    public TransportBookingController(TransportBookingModel model, TransportBookingView view) {
        this.model = model;
        this.view = view;

        // Initialize the view and add the book button listener
        initView();
        view.addBookListener(new BookButtonListener());
    }

    private void initView() {
        // No additional view initialization required for now
    }

    private class BookButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Retrieve the pickup and dropoff locations from the view
            String pickupLocation = view.getPickupLocation();
            String dropoffLocation = view.getDropoffLocation();

            // Check if pickup and dropoff locations are provided
            if (pickupLocation.isEmpty() || dropoffLocation.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter both pickup and dropoff locations.");
                return;
            }

            // Create a transport option based on user preferences (using factory method)
            TransportOptionFactory factory;
            if (view.getSelectedTransportOption().equals("Taxi")) {
                factory = new TaxiFactory();
            } else {
                factory = new BusFactory();
            }
            TransportOption transportOption = factory.createTransportOption();

            // Book the transport option based on pickup and dropoff locations
            String bookedTransportOption = model.bookTransportOption(transportOption, pickupLocation, dropoffLocation);

            // Display the result
            if (bookedTransportOption != null) {
                JOptionPane.showMessageDialog(view, "Transport option booked: " + bookedTransportOption);
            } else {
                JOptionPane.showMessageDialog(view, "No transport options available for the given locations.");
            }
        }
    }
}
