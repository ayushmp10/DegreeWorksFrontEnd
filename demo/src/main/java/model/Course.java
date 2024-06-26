package model;
import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private UUID id;
    private String subject;
    private String number; // section number
    private String name;
    private String description;
    private int creditHours;
    private ArrayList<Season> semestersOffered;
    private ArrayList<Prerequisites> prerequisites;
    // // they are listed as UUIDs
    // private ArrayList<String> corequisites;
    // // don't know if we need this yet
    // private ArrayList<String> courseCoreCategories;

    // public Course(UUID id, String subject, String number, String name,
    //         String description, String creditHours,
    //         ArrayList<Season> semestersOffered, ArrayList<Prerequisites> prerequisites,
    //         ArrayList<String> corequisites, ArrayList<String> courseCoreCategories) {
    //     // creating all the variables with the this.
    //     this.id = id;
    //     this.subject = subject;
    //     this.number = number;
    //     this.name = name;
    //     this.description = description;
    //     this.creditHours = creditHours;
    //     this.semestersOffered = semestersOffered;
    //     this.prerequisites = prerequisites;
    //     this.corequisites = corequisites;
    //     this.courseCoreCategories = courseCoreCategories;
    // }

    public Course(UUID id, String subject, String number, String name,
            String description, int creditHours,
            ArrayList<Season> semestersOffered, ArrayList<Prerequisites> prerequisites) {
        // creating all the variables with the this.
        setUUID(id);
        setSubject(subject);
        setName(name);
        setNumber(number);
        setDescription(description);
        setCredits(creditHours);
        setSemestersOffered(semestersOffered);
        setPrerequisites(prerequisites);
    }
    // Accessors and Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        if (number.isBlank()) {
            this.number = "101";
        }
        this.number = number;
        
    }

    public void setPrerequisites(ArrayList<Prerequisites> prereqs) {
        this.prerequisites = prereqs;
    }

    public void setCredits(int credits) {
        creditHours = credits;

        // String strCredits[] = credits.split(".");
        // if (strCredits.length > 0) {
        //     if (Integer.valueOf(strCredits[0]) > 0) {
        //         this.creditHours = Integer.valueOf(strCredits[0]);
        //     }
        // } else {
        //     if (Integer.valueOf(credits) > 0) {
        //         this.creditHours = Integer.valueOf(credits);
        //     }
        // }
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSemestersOffered(ArrayList<Season> semesters) {
        if (semesters != null) {
            this.semestersOffered = semesters;
        }
    }

    public void setUUID(UUID id) {
        if (id != null) {
            this.id = id;
        }
    }

    public int getCredits() {
        // getting how many credits the course is
        return this.creditHours;
    }

    public String getFullName() {
        // getting name of course
        return this.subject + " " + this.number + ": " + this.name;
    }

    public UUID getUUID() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<Season> getSemestersOffered() {
        return this.semestersOffered;
    }

    public ArrayList<Prerequisites> getPrerequisites() {
        return this.prerequisites;
    }

    public String getSubject() {
        return this.subject;
    }

    public String toString() {
        return getFullName() + " (" + getCredits() + ")";
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

    public void printPrerequisites() {
        for (Prerequisites prereq : this.prerequisites) {
            if (prereq.getCourseOptions().size() > 0)
                System.out.println(prereq.getCourseOptions());
        }
    }

    public String toStringShort() {
        return this.subject + " " + this.number;
    }

}
