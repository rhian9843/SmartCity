// StudentModel.java

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SmartCityDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // **Security Recommendation:** Store passwords securely, not directly in code

    // Method to search colleges based on location and field of interest
    public List<String> searchColleges(String location, String fieldOfInterest) {
        List<String> colleges = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT college_name FROM Student WHERE location = ? AND field_of_interest = ?")) {

            preparedStatement.setString(1, location);
            preparedStatement.setString(2, fieldOfInterest);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    colleges.add(resultSet.getString("college_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQLException appropriately
        }

        return colleges;
    }

    // Method to search libraries based on location and field of interest
    public List<String> searchLibraries(String location, String fieldOfInterest) {
        List<String> libraries = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT libraries_name FROM Student WHERE location = ? AND field_of_interest = ?")) {

            preparedStatement.setString(1, location);
            preparedStatement.setString(2, fieldOfInterest);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    libraries.add(resultSet.getString("libraries_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQLException appropriately
        }

        return libraries;
    }
}
