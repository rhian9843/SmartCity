import javax.swing.*;
import java.awt.event.*;

import Model.*;
import View.*;
import Controller.*;

public class main {
    public static void main(String[] args) {
        // Initialize the login view, model, and controller

        LoginView loginView = new LoginView();
        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(loginModel, loginView);

        // Initialize the sign-up view, model, and controller
        SignUpView signUpView = new SignUpView();
        SignUpModel signUpModel = new SignUpModel();
        SignUpController signUpController = new SignUpController(signUpModel, signUpView);

        // Show the login view
        loginView.setVisible(true);

        // Add action listener for the login button
        loginView.addLoginButtonListener(e -> {
            loginController.loginUser();
            if (loginController.isLoggedIn()) {
                loginView.dispose();
                showHomePage();
                loginView.setVisible(false); // Hide the login view

            }
        });

        // Add action listener for the sign-up button
        loginView.addSignupButtonListener(e -> signUpView.setVisible(true));

        // Add action listener for the sign-up button in the sign-up view
        signUpView.addSignupButtonListener(e -> {
            signUpController.registerUser();
            signUpView.dispose(); // Close sign-up view after signing up
        });
        loginView.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    // Method to show the home page
    private static void showHomePage() {
        // Initialize the home page view
        HomePageView homePageView = new HomePageView();

        // Initialize the student model, view, and controller
        StudentModel studentModel = new StudentModel();
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(studentModel, studentView);

        // Initialize the job seeker model, view, and controller
        JobSeekerModel jobModel = new JobSeekerModel();
        JobSeekerView jobView = new JobSeekerView();
        JobSeekerController jobController = new JobSeekerController(jobModel, jobView);

        // Initialize the transport booking model, view, and controller
        TransportBookingModel transportModel = new TransportBookingModel();
        TransportBookingView transportView = new TransportBookingView();
        TransportBookingController transportController = new TransportBookingController(transportModel, transportView);

        // Initialize the home page model
        HomePageModel homePageModel = new HomePageModel();

        // Initialize the home page controller with the home page model
        HomePageController homePageController = new HomePageController(homePageModel, homePageView);


        // Add action listeners for the buttons in the home page view
        homePageView.addStudentButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the student view when the student button is clicked
                studentView.setVisible(true);
            }
        });

        // Add action listener for the "Job" button to open the JobSeekerView
        homePageView.addJobButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the job view
                jobView.setVisible(true);

            }
        });

        // Add action listener for the "Transport" button to open the TransportBookingView
        homePageView.addTransportButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the transport booking view
                transportView.setVisible(true);

            }
        });

        // Add action listeners for other buttons in the home page view
        homePageView.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Show the home page view
        homePageView.setVisible(true);
    }
}