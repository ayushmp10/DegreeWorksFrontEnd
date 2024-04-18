package model;

// import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.ArrayList;

public class Prerequisites {
    private int choices;
    private String minimumGrade;
    private ArrayList<Course> courseOptions;

    // default constructor
    public Prerequisites() {
        setChoices(0);
        setMinGrade("F");
        setCourseOptions(null);
    }

    public Prerequisites(int choices, String minGrade, ArrayList<Course> courseOptions) {
        setChoices(choices);
        setMinGrade(minGrade);
        setCourseOptions(courseOptions);
    }

    public void setChoices(int choices) {
        this.choices = choices;
    }

    public void setMinGrade(String minimumGrade) {
        this.minimumGrade = minimumGrade;
    }

    public void setCourseOptions(ArrayList<Course> courseOptions) {
        if (courseOptions != null) {
            this.courseOptions = new ArrayList<Course>();
            return;
        }
        this.courseOptions = courseOptions;
    }

    public int getChoices() {
        return this.choices;
    }

    public String getMinGrade() {
        return this.minimumGrade;
    }

    public ArrayList<Course> getCourseOptions() {
        return this.courseOptions;
    }
}

