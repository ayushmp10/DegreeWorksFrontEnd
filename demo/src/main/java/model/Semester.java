package model;

import java.util.ArrayList;

public class Semester {
    private Season season;
    private int year;
    private int creditLimit;
    private ArrayList<Course> courses;

    public Semester(String season, int year, int creditLimit, ArrayList<Course> courseList) {
        setSeason(season);
        setYear(year);
        setCreditLimit(creditLimit);
        setCourses(courseList);
    } 

    // Accessors and Mutators
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public Season getSeason() {
        return this.season;
    }

    public int getYear() {
        return this.year;
    }

    public int getCreditLimit() {
        return this.creditLimit;
    }

    public void setCourses(ArrayList<Course> courses) {
        if (courses != null) {
            this.courses = courses;
        }
    }

    public void setSeason(String season) {
        if (season.equalsIgnoreCase("spring")) {
            this.season = Season.SPRING;
        } else if (season.equalsIgnoreCase("fall")) {
            this.season = Season.FALL;
        } else if (season.equalsIgnoreCase("summer")) {
            this.season = Season.SUMMER;
        }
    }

    public void setCreditLimit(int credits) {
        this.creditLimit = credits;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public String toString() {
        String toReturn = "";
        for (Course course : this.courses) {
            toReturn += course.toString() + "\n";
        }
        return toReturn;
    }
}

