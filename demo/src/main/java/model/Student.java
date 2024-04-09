import java.util.ArrayList;
import java.util.UUID;
/* 
enum Grade {
    FRESHMAN,
    SOPHOMORE,
    JUNIOR,
    SENIOR
}
*/

enum Major {
    CS,
    CIS
}

public class Student extends User{
    // don't need this since they are part of the User
    // private String username;
    // private String password;
    public String major;
    // don't know if we should include minor yet
    // public Minor minor;
    // public Grade grade; removed for now
    private ArrayList<String> passedCourses = new ArrayList<String>(); // the UUIDs will be stored as strings
    private String year;
    private Long completedCredits;
    private Long totalCredits;
    private UUID advisor;
    private UUID guardian;
    private String applicationArea;
    private String USCid;
    private String adviseeNotes;
    // need to add advisor and guardian
    public Student(UUID id, String username, String password, String firstName,
                String lastName, ArrayList<String> passedCourses, String year, String major,
                Long completedCredits, Long totalCredits, String phoneNumber, UUID advisor, UUID guardian, String USCid,
                String applicationArea, String adviseeNotes) {
        super(id, username, password, firstName, lastName, phoneNumber); // Call User constructor
        this.passedCourses = passedCourses;
        this.year = year;
        this.major = major;
        this.completedCredits = completedCredits;
        this.totalCredits = totalCredits;
        this.advisor = advisor;
        this.guardian = guardian;
        this.applicationArea = applicationArea;
        this.USCid = USCid;
        this.adviseeNotes = adviseeNotes;
    }

    /*public Grade getGrade() {
        return this.grade;
    }*/

    // TODO implementation
    private ArrayList<Course> getCurrentCourses() {
        return new ArrayList<>();
    }
    // FIX ME
    // public void addCompletedCourse(Course course, double grade) {
    //     passedCourses.add(course);
    //     // update HashMap with course and grade
    //     updateTotalCredits(course.getCredits());
    //     calculateGPA();
    // }

    public Long getCompletedCredits() {
        return this.completedCredits;
    }
    public Long getTotalCredits() {
        return this.totalCredits;
    }
    public String getMajor() {
        return this.major;
    }
    public UUID getAdvisor() {
        return this.advisor;
    }
    public UUID getGuardian() {
        return this.guardian;
    }
    public String getYear() {
        return this.year;
    }
    public String getApplicationArea() {
        return this.applicationArea;
    }
    public ArrayList<String> getCompletedCourses() {
        return this.passedCourses;
    }
    public String getAdvisorNotes() {
        return this.adviseeNotes;
    }
    public void setAdvisor(UUID advisor) {
        this.advisor = advisor;
    }

    public void setApplicationArea(String appArea) {
        this.applicationArea = appArea;
    }
    public void setAdvisorNotes(String advisorNotes) {
        this.adviseeNotes = advisorNotes;
    }
    public void addCourse(String courseUUID) {
        passedCourses.add(courseUUID);
    }

    private void removeCourse(Course course) {
    }

    public String getUSCID() {
        return this.USCid;
    }

    private double calculateGPA() {
        return 4.0;
    }
    public void updateTotalCredits(int credits) {
        // implementation
    }
    public String toString() {
        return "Student: " + super.getFirstName() + " " + super.getLastName() + " " + this.year +
                " " + "USC ID: " + this.USCid;
                
    }
    public ArrayList<String> generate8SemesterPlan() {
        ArrayList<String> plan = new ArrayList<String>();
        // TODO Implementation
        return plan;
    }
}
