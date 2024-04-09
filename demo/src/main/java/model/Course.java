import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private UUID id;
    private String subject;
    private String number; // section number
    private String name;
    private String description;
    private String creditHours;
    private ArrayList<String> semestersOffered;
    private ArrayList<String> prerequisites;
    // they are listed as UUIDs
    private ArrayList<String> corequisites;
    // don't know if we need this yet
    private ArrayList<String> courseCoreCategories;

    public Course(UUID id, String subject, String number, String name,
            String description, String creditHours,
            ArrayList<String> semestersOffered, ArrayList<String> prerequisites,
            ArrayList<String> corequisites, ArrayList<String> courseCoreCategories) {
        // creating all the variables with the this.
        this.id = id;
        this.subject = subject;
        this.number = number;
        this.name = name;
        this.description = description;
        this.creditHours = creditHours;
        this.semestersOffered = semestersOffered;
        this.prerequisites = prerequisites;
        this.corequisites = corequisites;
        this.courseCoreCategories = courseCoreCategories;
    }

    public String getCredits() {
        // getting how many credits the course is
        return this.creditHours;
    }

    public String getName() {
        // getting name of course
        return this.subject + " " + this.number + ": " + this.name;
    }

    public UUID getUUID() {
        return this.id;
    }

    public String toString() {
        return getName() + " (" + getCredits() + ")";
    }
    // public ArrayList<String> getAttributes() {
    // //getting class attributes like course description
    // ArrayList<String> attributeDescription = new ArrayList<String>();
    // for (int i = 0; i < attributes.size(); ++i) {
    // attributeDescription.add(attributes.get(i));
    // }
    // return attributeDescription;
    // }

    public boolean canTakeCourse() {
        // checking if the student can take the course
        // if he has prerequisites or not
        return false;
    }

    public void setAvailability() {
        // setting if the course is available or not that semester
    }

    public void addAttribute(String attribute) {
        // adding attribites to the class if neccessary
    }

}