package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Guardian extends User{
    private Student student;
    private boolean authorized;
    
    public Guardian(UUID id, String username, String password, String firstName,
                    String lastName, String phoneNumber, Student student,
                    boolean authorized) {
        super(id,username,password,firstName,lastName,phoneNumber);
        this.student = student;
        this.authorized = authorized;
    }
    public HashMap<Course, String> getStudentCurrentCourses() {
        System.out.println("Getting current courses for student: " + student.getFirstName() + " " + student.getLastName());
        return this.student.getCompletedCourses();
    }

    public Student getStudent() {
        System.out.println("Getting associated student");
        return student;
    }

    public void setAuthorization(boolean isAuthorized) {
        this.authorized = isAuthorized;
    }

    public boolean getAuthorization() {
        return this.authorized;
    }

    public void setStudent(Student student) {
        if (student != null && student.getGuardian().equals(super.getID()))
            this.student = student;
    }
}
