package Model;

public class JobModel {
    private int jobId;
    private String location;
    private String fieldOfInterest;
    private String jobOpportunity;
    private String employer;
    private String description;
    private double salary;

    // Constructor
    public JobModel() {
        // Initialize the fields
    }

    // Getters and setters for each field
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFieldOfInterest() {
        return fieldOfInterest;
    }

    public void setFieldOfInterest(String fieldOfInterest) {
        this.fieldOfInterest = fieldOfInterest;
    }

    public String getJobOpportunity() {
        return jobOpportunity;
    }

    public void setJobOpportunity(String jobOpportunity) {
        this.jobOpportunity = jobOpportunity;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
