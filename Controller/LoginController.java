package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Model.LoginModel;
import View.LoginView;

public class LoginController {
    private Connection connection;
    private LoginModel loginModel;
    private LoginView loginView;

    private boolean isLoggedIn;

    public LoginController(LoginModel loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
        this.isLoggedIn = false;

        // Initialize the database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/SmartCityDB", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loginUser() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        // Check if username and password match some stored values
        isLoggedIn = loginModel.validateLogin(username, password);

        if (isLoggedIn) {
            loginView.displayLoginSuccessMessage();
        }
        else {
            loginView.displayLoginErrorMessage();
        }
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
