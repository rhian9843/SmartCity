package Controller;

import Model.LibraryModel;
import View.LibraryView;
import javax.swing.JOptionPane; // Import the JOptionPane class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryController {
    private LibraryModel libraryModel;
    private LibraryView libraryView;

    public LibraryController(LibraryModel libraryModel, LibraryView libraryView) {
        this.libraryModel = libraryModel;
        this.libraryView = libraryView;
        initializeListeners();
    }

    private void initializeListeners() {
        libraryView.addOkButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveLibrary();
            }
        });

        libraryView.addCancelButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                libraryView.dispose();
            }
        });
    }

    private void saveLibrary() {
        // Retrieve library details from the view
        String[] libraryDetails = libraryView.getLibraryDetails();
        String fieldOfInterest = libraryDetails[0];
        String libraryName = libraryDetails[1];
        String libraryLocation = libraryDetails[2];

        // Set library details in the model
        libraryModel.setFieldOfInterest(fieldOfInterest);
        libraryModel.setLibraryName(libraryName);
        libraryModel.setLibraryLocation(libraryLocation);

        // Any additional operations like saving to database
        LibraryCommand saveCommand = new SaveLibraryCommand(libraryModel, fieldOfInterest, libraryName,
                libraryLocation);
        saveCommand.execute();

        // Show a pop-up message to indicate success
        JOptionPane.showMessageDialog(
                libraryView,
                "Library details added successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

        // Close the view
        libraryView.dispose();
    }
}
