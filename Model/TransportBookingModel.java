package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransportBookingModel {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost/SmartCityDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // **Security Recommendation:** Store passwords securely, not directly in code

    // Method to fetch available transport options from the database based on pickup and dropoff locations
    public String bookRandomTransportOption(String pickupLocation, String dropoffLocation) {
        String transportOption = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, car_number_plate FROM Transport WHERE pick_up_location = ? AND drop_off_location = ?")) {

            preparedStatement.setString(1, pickupLocation);
            preparedStatement.setString(2, dropoffLocation);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<String> options = new ArrayList<>();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String carNumberPlate = resultSet.getString("car_number_plate");
                    options.add(name + " (" + carNumberPlate + ")");
                }
                if (!options.isEmpty()) {
                    Random random = new Random();
                    transportOption = options.get(random.nextInt(options.size()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQLException appropriately
        }

        return transportOption;
    }
}
