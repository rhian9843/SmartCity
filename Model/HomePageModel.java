package Model;

public class HomePageModel {
    // Attributes
    private String description;
    // You can add more attributes as needed

    // Constructor
    public HomePageModel() {
        // Initialize attributes if necessary
        description = "Welcome to the Smart City Project!";
    }

    // Methods
    public String getDescription() {
        return description;
    }

    public void notifyObservers(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyObservers'");
    }

    // You can add more methods as needed
}
