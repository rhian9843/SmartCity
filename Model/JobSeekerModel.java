package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobSeekerModel {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SmartCityDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // **Security Recommendation:** Store passwords securely, not directly in code

    // Method to retrieve job opportunities based on location and field of work
    public List<String> searchJobs(String location, String fieldOfWork) {
        List<String> jobOpportunities = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT job_opportunity, employer, description, salary FROM Jobs WHERE location = ? AND field_of_interest = ?")) {

            preparedStatement.setString(1, location);
            preparedStatement.setString(2, fieldOfWork);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String job = resultSet.getString("job_opportunity") + " - " +
                            resultSet.getString("employer") + ": " +
                            resultSet.getString("description") + ", Salary: " +
                            resultSet.getString("salary");
                    jobOpportunities.add(job);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQLException appropriately
        }

        return jobOpportunities;
    }
}
