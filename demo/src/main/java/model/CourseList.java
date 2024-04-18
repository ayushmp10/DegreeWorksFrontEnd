package model;
//Aaron and Anish Test

import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private ArrayList<Course> courses;
    private static CourseList courseList;

    private CourseList() {
        this.courses = DataLoader.getCourses();
    }

    public static CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public Course getCourse(String keyword) {
        for (Course course : this.courses) {
            // Check if the name of the course contains the provided keyword
            if (course.getFullName().contains(keyword)) {
                return course; // Return the course if the keyword is found in its name
            }
        }
        return null; // Return null if no course matches the keyword
    }

    public Course getCourse(UUID id) {
        for (Course course : courses) {
            if (course.getUUID().equals(id)) {
                return course;
            }
        }
        return null;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    // public MajorMap getMajorMap() {
    //     return this.majorMap;
    // }

    // public MinorMap getMinorMap() {
    //     return this.minorMap;
    // }
}

