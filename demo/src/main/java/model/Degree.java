package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Degree {
    private UUID uuid;
    private String degree;
    private String subject;
    private int totalCreditsRequired;
    private HashMap<Course, Integer> majorCourses;
    private ArrayList<Elective> electives;
    
    // default constructor (undeclared major)
    public Degree() {
        this.uuid = UUID.randomUUID();
        this.degree = "Undeclared";
        this.subject = "Undeclared";
        this.totalCreditsRequired = 0;
        this.majorCourses = new HashMap<Course, Integer>();
        this.electives = new ArrayList<Elective>();
    }

    public Degree(UUID id, String degree, String subject, int totalCreditsRequired,
                    HashMap<Course, Integer> majorCourses, ArrayList<Elective> electives) {
        this.uuid = id;
        setSubject(subject);
        setDegree(degree);
        setTotalCreditsRequired(totalCreditsRequired);
        setMajorCourses(majorCourses);
        setElectives(electives);
    }

    public Degree(String degree, String subject, int totalCreditsRequired,
                    HashMap<Course, Integer> majorCourses, ArrayList<Elective> electives) {
        this.uuid = UUID.randomUUID();
        setSubject(subject);
        setDegree(degree);
        setTotalCreditsRequired(totalCreditsRequired);
        setMajorCourses(majorCourses);
        setElectives(electives);
    }    


    // Accessors and Mutators
    public UUID getUUID() {
        return this.uuid;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getDegree() {
        return this.degree;
    }

    public int getTotalCreditsRequired() {
        return this.totalCreditsRequired;
    }

    public ArrayList<Elective> getElectives() {
        return this.electives;
    }

    public HashMap<Course, Integer> getMajorCourses() {
        return this.majorCourses;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTotalCreditsRequired(int credits) {
        this.totalCreditsRequired = credits;
    }

    public void setMajorCourses(HashMap<Course, Integer> courses) {
        if (courses != null) {
            this.majorCourses = courses;
            return;
        }
        this.majorCourses = new HashMap<Course, Integer>();
    }

    public void setElectives(ArrayList<Elective> electives) {
        if (electives != null) {
            this.electives = electives;
        }
        else {
            electives = new ArrayList<Elective>();
        }
    }

    public boolean addMajorCourse(Course course, int prefSemester) {
        if (course != null && prefSemester > 0 && prefSemester < 9) {
            majorCourses.put(course, prefSemester);
            return true;
        }
        return false;
    }

    public boolean removeMajorCourse(Course course) {
        if (course != null) {
            majorCourses.remove(course);
            return true;
        }
        return false;
    }

    public boolean equals(Degree degree) {
        return this == degree;
    }

}

