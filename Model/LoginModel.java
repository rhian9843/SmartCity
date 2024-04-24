package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SmartCityDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // **Security Recommendation:** Store passwords securely, not directly in code

    // Method to validate login credentials
    public boolean validateLogin(String username, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AccountDetails WHERE username = ? AND password = ?")) {

            // Set parameters
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if any rows returned
                return resultSet.next();
            }

        } catch (SQLException e) {
            // Handle SQLException appropriately, like logging the error
            e.printStackTrace(); // This is for debugging purposes only, remove in production
            return false;
        }
    }
}
