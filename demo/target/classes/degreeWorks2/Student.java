package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
/* 
enum Grade {
    FRESHMAN,
    SOPHOMORE,
    JUNIOR,
    SENIOR
}
*/

// enum Major {
//     CS,
//     CIS
// }

public class Student extends User{
    // don't need this since they are part of the User
    // private String username;
    // private String password;
    // don't know if we should include minor yet
    // public Minor minor;
    // public Grade grade; removed for now
    // private ArrayList<String> passedCourses = new ArrayList<String>(); // the UUIDs will be stored as strings
    private String year;
    private Long completedCredits;
    private Long totalCredits;
    private UUID advisor;
    private UUID guardian;
    private String applicationArea;
    private String USCid;
    private String adviseeNotes;
    private Degree degree;
    private Semester currSemester;
    private ArrayList<Semester> allSemesters;
    private HashMap<Course, String> completedCourses; // includes all complete courses with grades
    private ArrayList<Semester> eightSemesterPlan = new ArrayList<Semester>();
    private Long gpa;
    
    
    // need to add advisor and guardian
    public Student(UUID id, String username, String password, String firstName,
                String lastName, String year, Degree degree,
                Long completedCredits, Long totalCredits, Long gpa, String phoneNumber, UUID advisor, UUID guardian, String USCid,
                String applicationArea, String adviseeNotes, HashMap<Course, String> completedCourses, Semester currSemester,
                ArrayList<Semester> allSemesters) {
        super(id, username, password, firstName, lastName, phoneNumber); // Call User constructor
        setCompletedCourses(completedCourses);
        this.year = year;
        setDegree(degree);
        this.gpa = gpa;
        this.completedCredits = completedCredits;
        this.totalCredits = totalCredits;
        setAdvisor(advisor);
        setGuardian(guardian);
        setApplicationArea(applicationArea);
        this.USCid = USCid;
        setAdvisorNotes(adviseeNotes);
        setCurrSemester(currSemester);
        setAllSemester(allSemesters);
    }

    // another constructor - used for signing up
    public Student(String firstName, String lastName, String phoneNumber, String VIPid, String userName, String password) {
        super(UUID.randomUUID(), userName, password, firstName, lastName, phoneNumber);
        this.year = "Freshman";
        this.degree = new Degree();
        this.gpa = (long) 0.0;
        this.completedCredits = (long) 0;
        this.totalCredits = (long) 0;
        this.advisor = null;
        this.guardian = null;
        this.applicationArea = "none";
        this.USCid = "unassigned";
        this.adviseeNotes = "No Notes";
        this.currSemester = null;
        this.allSemesters = null;
    }

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

    public Long getGPA() {
        return this.gpa;
    }
    public Long getCompletedCredits() {
        return this.completedCredits;
    }
    public Long getTotalCredits() {
        return this.totalCredits;
    }
    public Degree getDegree() {
        return this.degree;
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
    public HashMap<Course, String> getCompletedCourses() {
        return this.completedCourses;
    }
    public String getAdvisorNotes() {
        return this.adviseeNotes;
    }
    public String getUSCID() {
        return this.USCid;
    }
    public Semester getCurrSemester() {
        return this.currSemester;
    }
    public ArrayList<Semester> getAllSemesters() {
        return this.allSemesters;
    }

    public void setAdvisor(UUID advisor) {
        if (advisor != null)
            this.advisor = advisor;
    }
    public void setApplicationArea(String appArea) {
        this.applicationArea = appArea;
    }
    public void setAdvisorNotes(String advisorNotes) {
        this.adviseeNotes = advisorNotes;
    }
    public void setGuardian(UUID guardian) {
        if (guardian != null)
            this.guardian = guardian;
    }
    public void setCurrSemester(Semester semester) {
        if (semester != null)
            this.currSemester = semester;
    }
    public void setAllSemester(ArrayList<Semester> newAllSemesters) {
        if (newAllSemesters != null)
            allSemesters = newAllSemesters;
    }
    public void setCompletedCourses(HashMap<Course, String> completedCourses) {
        if (completedCourses != null)
            this.completedCourses = completedCourses;
    }
    public void setDegree(Degree degree) {
        if (degree != null)
            this.degree = degree;
    }


    public void addCourse(Course course, String grade) {
        if (this.completedCourses == null) {
            this.completedCourses = new HashMap<Course, String>();
        }
        this.completedCourses.put(course, grade);
        generateEightSemesterPlan();
    }

    public void addSemester(Semester semester) {
        this.allSemesters.add(semester);
    }

    public void completeSemester() {
        this.allSemesters.add(this.currSemester);
        this.currSemester = null;
        generateEightSemesterPlan();
    }
    

    // private double calculateGPA() {
    //     return 4.0;
    // }
    // public void updateTotalCredits(int credits) {
    //     // implementation
    // }
    public String toString() {
        return "Student: " + super.getFirstName() + " " + super.getLastName() + " " + this.year +
                " " + "USC ID: " + this.USCid;
                
    }
    public void generateEightSemesterPlan() {
        this.eightSemesterPlan.clear();
        // account for all the completed courses
        for (Semester completedSemester : this.allSemesters) {
            this.eightSemesterPlan.add(completedSemester);
        }

        HashMap<UUID, Integer> toTakeCourses = new HashMap<UUID, Integer>();
        ArrayList<Course> courseQueue = new ArrayList<Course>();
        
        // load all the courses that need to be taken
        HashMap<Course, Integer> majorCourses = this.degree.getMajorCourses();
        for (Course course : majorCourses.keySet()) {
            if (this.completedCourses.keySet().stream().anyMatch(c -> !c.equals(course))) {
                toTakeCourses.put(course.getUUID(), majorCourses.get(course));
                courseQueue.add(course);
            }
        }

        ArrayList<Elective> electives = this.degree.getElectives();
        for (Elective elective : electives) {
            for (Course course : elective.getCourseOptions().keySet()) {
                if (this.completedCourses.keySet().stream().anyMatch(c -> !c.equals(course))) {
                    toTakeCourses.put(course.getUUID(), elective.getCourseOptions().get(course));
                    courseQueue.add(course);
                }
            }
        }
        
        // determine what course is next
        ArrayList<Course> semesterCourses = new ArrayList<Course>();
        String currSeason;
        int currYear;
        if (this.allSemesters.size() != 0) {
            Semester prevSemester = this.allSemesters.get(this.allSemesters.size() - 1);
            currSeason = prevSemester.getSeason().toString();
            currYear = prevSemester.getYear();
        } else {
            // first year student case
            currSeason = "Fall";
            currYear = 2024;
        }

        int creditLimit = 18;
        for (int sem = 1; sem <= 8; sem++) {
            for (int i = courseQueue.size() - 1; i >= 0; i--) {
                // empty out the queue every semester from the bottom
                Course course = courseQueue.get(i);
                int prefSemester = toTakeCourses.get(course.getUUID());
                if (prefSemester != sem) {
                    continue;
                }

                int courseCredit = course.getCredits();
                if (courseCredit  <= creditLimit) {
                    // taking this course update the credits remaining
                    creditLimit -= courseCredit;
                    semesterCourses.add(course);
                    courseQueue.remove(course);
                } else {
                    Semester tempSem = new Semester(currSeason, currYear, 18 - creditLimit, new ArrayList<>(semesterCourses));
                    this.eightSemesterPlan.add(tempSem);
                    if (currSeason.equalsIgnoreCase("fall")) {
                        currSeason = "Spring";
                        currYear += 1;
                    }

                    semesterCourses.clear();
                    creditLimit = 18;
                    i++;
                }
            }
        }
    }
    // public String getEightSemesterPlanToString() {
    //     String eightSemesterPlan = "";
    //     for (Semester semester : this.eightSemesterPlan) {
    //         eightSemesterPlan += "\n" + semester.toString();
    //     }
    //     return eightSemesterPlan;
    // }
    public ArrayList<Semester> getEightSemesterPlan() {
        if (this.eightSemesterPlan == null) {
            generateEightSemesterPlan();
        }
        return eightSemesterPlan;
    }
}

