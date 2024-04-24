package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpModel {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost/SmartCityDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // **Security Recommendation:** Store passwords securely, not directly in code

    // Method to register a new user
    public boolean registerUser(String username, String password, String email, String phoneNumber) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AccountDetails (username, password, email_id, phone_number) VALUES (?, ?, ?, ?)")) {

            // Set parameters
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phoneNumber);

            // Execute update
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if the insertion was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Handle SQLException appropriately, like logging the error
            e.printStackTrace(); // This is for debugging purposes only, remove in production
            return false;
        }
    }
}
