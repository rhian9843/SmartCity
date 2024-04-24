package Controller;

import Model.JobModel;
import View.JobView;
import javax.swing.JOptionPane;

public class JobController {
    private JobModel jobModel;
    private JobView jobView;

    public JobController(JobModel jobModel, JobView jobView) {
        this.jobModel = jobModel;
        this.jobView = jobView;
        initializeListeners();
    }

    private void initializeListeners() {
        jobView.addOkButtonListener(e -> saveJob());
        jobView.addCancelButtonListener(e -> jobView.dispose());
    }

    private void saveJob() {
        // Retrieve job details from the view
        String location = jobView.getLocationAsString(); // Get the location as a String
        String fieldOfInterest = jobView.getFieldOfInterest();
        String jobOpportunity = jobView.getJobOpportunity();
        String employer = jobView.getEmployer();
        String description = jobView.getDescription();
        double salary = jobView.getSalary();

        // Set job details in the model
        jobModel.setLocation(location);
        jobModel.setFieldOfInterest(fieldOfInterest);
        jobModel.setJobOpportunity(jobOpportunity);
        jobModel.setEmployer(employer);
        jobModel.setDescription(description);
        jobModel.setSalary(salary);

        // Here you can perform any additional operations like saving to database

        // Show a pop-up message to indicate success
        JOptionPane.showMessageDialog(jobView, "Job details added successfully!", "Success",
                JOptionPane.INFORMATION_MESSAGE);

        // Close the view
        jobView.dispose();
    }

    public void addJob() {
        jobView.setVisible(true); // Show the JobView when "Add Job" is clicked
    }
}
