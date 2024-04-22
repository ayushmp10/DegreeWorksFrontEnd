package model;

import java.util.HashMap;
import java.util.Map;

public class Elective {
    private String type;
    private int reqCredits;
    private HashMap<Course, Integer> courseOptions;

    public Elective(String type, int reqCredit, HashMap<Course, Integer> courseOptions) {
        this.type = type;
        this.reqCredits = reqCredit;
        this.courseOptions = courseOptions;
    }

    // Accessors and Mutators
    public void setCourseOptions(HashMap<Course, Integer> courses) {
        this.courseOptions = courses;
    }
    public void setType(String type) {
        this.type = type;
    } 
    public void setCreditRequired(int credits) {
        this.reqCredits = credits;
    }
    public HashMap<Course, Integer> getCourseOptions() {
        return this.courseOptions;
    }
    public String getType() {
        return this.type;
    }
    public int getReqCredits() {
        return this.reqCredits;
    }
}

