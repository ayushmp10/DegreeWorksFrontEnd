package model;

import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User{
    private ArrayList<String> students;
    private String building;
    private String roomNumber;
    public Advisor(UUID id, String username, String password, String firstName, String lastName,
                    ArrayList<String> students, String phoneNumber, String building, String roomNumber) {
        super(id, username, password, firstName, lastName, phoneNumber);
        this.students = students;
        this.building = building;
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return this.building;
    }
    public String getRoomNumber() {
        return this.roomNumber;
    }
    public UUID getUUID() {
        return super.getID();
    }
    
    public ArrayList<String> getStudents() {
        return students;
    }
    public void highlightStudentCourses(Student student) {
    }
    public ArrayList<Course> getStudentCurrentCourses(Student student) {
        return new ArrayList<>();
    }
    public void addCourse(Course course) {
    }
    public void removeCourse(Course course) {
    }
    public void addStudent(Student student) {
        students.add(student.getID().toString());
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }

    public String getLocation() {
        return "Advisor's Office: " + this.building + " " + this.roomNumber;
    }
}

