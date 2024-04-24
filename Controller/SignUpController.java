package Controller;

import Model.SignUpModel;
import View.SignUpView;

public class SignUpController {
    private SignUpModel signUpModel;
    private SignUpView signUpView;

    public SignUpController(SignUpModel signUpModel, SignUpView signUpView) {
        this.signUpModel = signUpModel;
        this.signUpView = signUpView;
    }

    public void registerUser() {
        String username = signUpView.getUsername();
        String password = signUpView.getPassword();
        String email = signUpView.getEmailId();
        String phoneNumber = signUpView.getPhoneNumber();

        // Register the user using SignUpModel
        boolean registrationSuccessful = signUpModel.registerUser(username, password, email, phoneNumber);

        if (registrationSuccessful) {
            signUpView.displaySignUpSuccessMessage();
        } else {
            signUpView.displaySignUpErrorMessage();
        }
    }
}
