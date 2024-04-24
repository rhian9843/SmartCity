import javax.swing.*;
import java.awt.event.*;
// import View.HomePageView;
// import View.StudentView;
// import View.JobSeekerView;
// import View.TransportBookingView; // Import TransportBookingView
// import Controller.HomePageController;
// import Controller.StudentController;
// import Controller.JobSeekerController;
// import Controller.TransportBookingController; // Import TransportBookingController
// import Model.HomePageModel;
// import Model.StudentModel;
// import Model.JobSeekerModel;
// import Model.TransportBookingModel; // Import TransportBookingModel
// import View.LoginView; // Import the LoginView
// import Controller.LoginController; // Import the LoginController
// import Model.UserModel; // Import the UserModel
// import View.SignUpView; // Import the SignupView
// import Controller.SignUpController; // Import the SignupController
// import Model.SignUpModel; // Import the SignupModel

import Model.*;
import View.*;
import Controller.*;

public class main {
    public static void main(String[] args) {
        // Initialize the login view, model, and controller
        // UserModel userModel = new UserModel();
        // LoginView loginView = new LoginView();
        // LoginModel loginModel = new LoginModel();
        // LoginController loginController = new LoginController(userModel, loginView);

        // Register the login view as an observer in the login controller
        AdminModel adminModel = new AdminModel();
        AdminView adminView = new AdminView();
        AdminController adminController = new AdminController(adminModel, adminView);

        ServiceLocator.registerService("AdminModel", adminModel);
        ServiceLocator.registerService("AdminView", adminView);
        ServiceLocator.registerService("AdminController", adminController);

        UserModel userModel = new UserModel();

        LoginView loginView = new LoginView();
        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(userModel, loginView);
        loginController.addObserver(loginView);

        // Initialize the sign-up view, model, and controller
        // SignUpView signUpView = new SignUpView();
        // SignUpModel signUpModel = new SignUpModel();
        // SignUpController signUpController = new SignUpController(userModel,
        // signUpView);

        DriverModel driverModel = new DriverModel();
        DriverView driverView = new DriverView();
        DriverController driverController = new DriverController(driverModel, driverView);

        // Show the login view
        loginView.setVisible(true);
        // driverView.setVisible(true);

        // Add action listener for the login button
        loginView.addLoginButtonListener(e -> {
            loginController.loginUser();
            if (loginController.isLoggedIn()) {
                loginView.dispose();
                if (loginController.isadminloggedin) {
                    showAdminView();
                } else {
                    showHomePage();

                }

            }
        });

        // Add action listener for the sign-up button
        // loginView.addSignupButtonListener(e -> signUpView.setVisible(true));

        // Add action listener for the sign-up button in the sign-up view
        // signUpView.addSignupButtonListener(e -> {
        // signUpController.signUpUser();
        // signUpView.dispose(); // Close sign-up view after signing up
        // });
    }

    private static void showAdminView() {
        // Initialize the admin model, view, and controller
        AdminModel adminModel = (AdminModel) ServiceLocator.getService("AdminModel"); // service locator
        AdminView adminView = (AdminView) ServiceLocator.getService("AdminView"); // service locator
        AdminController adminController = (AdminController) ServiceLocator.getService("AdminController"); // service
                                                                                                          // locator
        LibraryModel libraryModel = new LibraryModel();
        LibraryView libraryView = new LibraryView();
        LibraryController libraryController = new LibraryController(libraryModel, libraryView);
        JobView jobView = new JobView();
        JobModel jobModel = new JobModel();
        JobController jobController = new JobController(jobModel, jobView);
        CollegeModel collegeModel = new CollegeModel();
        CollegeView collegeView = new CollegeView();
        CollegeController collegeController = new CollegeController(collegeModel, collegeView);
        DriverModel driverModel = new DriverModel();
        DriverView driverView = new DriverView();
        DriverController driverController = new DriverController(driverModel, driverView);

        // Add action listeners for the buttons in the admin view
        adminView.addAddCollegeButtonListener(e -> adminController.addCollege());
        adminView.addAddLibraryButtonListener(e -> adminController.addLibrary());
        adminView.addAddJobButtonListener(e -> adminController.addJob());

        // adminView.addAddCollegeButtonListener(e -> adminController.addCollege());
        // adminView.addAddLibraryButtonListener(e -> adminController.addLibrary());
        // adminView.addAddJobButtonListener(e -> jobController.addJob()); // Add action
        // listener for adding job
        // adminView.addAddCollegeButtonListener(e -> adminController.addCollege());
        adminView.addAddLibraryButtonListener(e -> libraryView.setVisible(true)); // Show LibraryView when Add
                                                                                  // Librarybutton is clicked
        // adminView.addAddJobButtonListener(e -> adminController.addJob());

        adminView.addAddCollegeButtonListener(e -> collegeView.setVisible(true)); // Show CollegeView when Add College//
                                                                                  // button is clicked
        // adminView.addAddLibraryButtonListener(e -> adminController.addLibrary());
        adminView.addAddJobButtonListener(e -> jobController.addJob());
        adminView.addAddDriversButtonListener(e -> adminController.addDriver());

        // Display the admin view
        adminView.setVisible(true);

    }

    // Method to show the home page
    private static void showHomePage() {
        // Initialize the home page view
        HomePageView homePageView = new HomePageView();

        // Initialize the student model, view, and controller
        // StudentModel studentModel = new StudentModel();
        // StudentView studentView = new StudentView();
        // StudentController studentController = new StudentController(studentModel,
        // studentView);

        // Initialize the job seeker model, view, and controller
        // JobSeekerModel jobModel = new JobSeekerModel();
        // JobSeekerView jobView = new JobSeekerView();
        // JobSeekerController jobController = new JobSeekerController(jobModel,
        // jobView);

        // Initialize the transport booking model, view, and controller
        // TransportBookingModel transportModel = new TransportBookingModel();
        // TransportBookingView transportView = new TransportBookingView();
        // TransportBookingController transportController = new
        // TransportBookingController(transportModel, transportView);

        // Initialize the home page model
        // HomePageModel homePageModel = new HomePageModel();

        // Initialize the home page controller with the home page model
        // HomePageController homePageController = new HomePageController(homePageModel,
        // homePageView);

        // Add action listeners for the buttons in the home page view
        // homePageView.addStudentButtonListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // // Show the student view when the student button is clicked
        // studentView.setVisible(true);
        // }
        // });

        // Add action listener for the "Job" button to open the JobSeekerView
        // homePageView.addJobButtonListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // // Display the job view
        // jobView.setVisible(true);

        // Simulate displaying job opportunities for a location and field of work
        // String location = "City";
        // String fieldOfWork = "IT";
        // jobController.displayJobOpportunities(location, fieldOfWork);
        // }
        // });

        // Add action listener for the "Transport" button to open the
        // TransportBookingView
        // homePageView.addTransportButtonListener(new ActionListener() {
        // @Override
        //// public void actionPerformed(ActionEvent e) {
        // Display the transport booking view
        // transportView.setVisible(true);

        // Simulate displaying transport options
        // transportController.displayTransportOptions();
        // }
        // });

        // Add action listeners for other buttons in the home page view

        // Show the home page view
        homePageView.setVisible(true);
    }
}
