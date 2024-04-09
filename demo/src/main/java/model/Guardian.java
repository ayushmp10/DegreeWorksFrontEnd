package model;

import java.util.ArrayList;
import java.util.UUID;

public class Guardian extends User{
    private UUID student;
    private boolean authorized;
    
    public Guardian(UUID id, String username, String password, String firstName, String lastName, String phoneNumber, UUID student, boolean authorized) {
        super(id,username,password,firstName,lastName,phoneNumber);
        this.student = student;
        this.authorized = authorized;
    }
    public ArrayList<String> getStudentCurrentCourses(Student student) {
        System.out.println("Getting current courses for student: " + student.getFirstName() + " " + student.getLastName());
        return student.getCompletedCourses();
    }

    public UUID getStudent() {
        System.out.println("Getting associated student");
        return student;
    }
}
