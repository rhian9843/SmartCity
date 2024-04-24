package Model;

// UserModel.java
public class UserModel {
    // Dummy user data
    private static final String[][] DUMMY_USERS = {
            { "admin", "admin123" },
            { "user1", "password1" },
            { "user2", "password2" },
            // Add more dummy users as needed
    };

    // Check if the provided username and password match any of the dummy data
    public boolean authenticate(String username, String password) {
        for (String[] userData : DUMMY_USERS) {
            String storedUsername = userData[0];
            String storedPassword = userData[1];
            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                return true;
            }
        }
        return false;
    }
}
