package Controller;

import Model.AdminModel;
import View.AdminView;
import View.JobView;
import View.DriverView;

public class AdminController {
    private AdminModel adminModel;
    private AdminView adminView;
    private JobView jobView;
    private DriverController driverController;

    public AdminController(AdminModel adminModel, AdminView adminView) {
        this.adminModel = adminModel;
        this.adminView = adminView;
        this.driverController = driverController;
    }

    public AdminController(JobView jobView) {
        this.jobView = jobView;
    }

    public void addJob() {
        jobView.setVisible(true); // Show the JobView when "Add Job" is clicked
    }

    public void addCollege() {
        // Call method in AdminModel to add college
    }

    public void addLibrary() {
        // Call method in AdminModel to add library
    }

    public void addDriver() {
        DriverView driverView = new DriverView();
        driverView.setVisible(true);
    }

    // public void addJob() {
    // Call method in AdminModel to add job
    // }
}