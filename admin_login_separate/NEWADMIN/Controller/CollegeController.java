package Controller;

import Model.CollegeModel;
import View.CollegeView;

import javax.swing.JOptionPane;

public class CollegeController {
    private CollegeModel collegeModel;
    private CollegeView collegeView;

    public CollegeController(CollegeModel collegeModel, CollegeView collegeView) {
        this.collegeModel = collegeModel;
        this.collegeView = collegeView;
        initializeListeners();
    }

    private void initializeListeners() {
        collegeView.addOkButtonListener(e -> saveCollege());
    }

    private void saveCollege() {
        // Retrieve college details from the view
        String[] collegeDetails = collegeView.getCollegeDetails();
        String fieldOfInterest = collegeDetails[0];
        String collegeName = collegeDetails[1];
        String collegeLocation = collegeDetails[2];

        // Set college details in the model
        collegeModel.setFieldOfInterest(fieldOfInterest);
        collegeModel.setCollegeName(collegeName);
        collegeModel.setCollegeLocation(collegeLocation);

        // Here you can perform any additional operations like saving to a database

        // Display the "Input Done!" popup
        JOptionPane.showMessageDialog(collegeView, "Input Done!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Close the view
        collegeView.dispose();
    }
}
