package Controller;

//import OOAD_Mini_project_smart_city.main;
import Model.UserModel;
import View.LoginView;
import View.AdminView;
import java.util.List;
import java.util.ArrayList;

// LoginController.java
public class LoginController {
    private UserModel userModel;
    private LoginView loginView;
    private boolean isLoggedIn;
    public boolean isadminloggedin;
    private AdminView adminView;
    private AdminController adminController;
    private List<LoginObserver> observers;

    public LoginController(UserModel userModel, LoginView loginView) {
        this.userModel = userModel;
        this.loginView = loginView;
        this.isLoggedIn = false;
        this.isadminloggedin = false;
        this.adminView = adminView;
        this.adminController = adminController;
        observers = new ArrayList<>();
    }

    public void addObserver(LoginObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (LoginObserver observer : observers) {
            observer.updateLoginState(isLoggedIn, isadminloggedin);
        }
    }

    public void loginUser() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        // Check if username and password match some stored values (for simplicity,
        // hardcoded here)
        if (username.equals("admin") && password.equals("admin123")) {
            isLoggedIn = true;
            isadminloggedin = true;
            loginView.displayLoginSuccessMessage();
            System.out.println("Admin logged in");
            notifyObservers();
            // main.showadminview();

        } else if (username.equals("a") && password.equals("123")) {
            isLoggedIn = true;
            isadminloggedin = false;
            loginView.displayLoginSuccessMessage();
            notifyObservers();
        } else {
            isLoggedIn = false;
            loginView.displayLoginErrorMessage();
            notifyObservers();
        }
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
