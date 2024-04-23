package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class test {
    public static void main(String[] args) {
        // UserList userList = UserList.getInstance();
        // DegreeList degreeList = DegreeList.getInstance();
        // Degree tempDegree = degreeList.getDegree(UUID.fromString("dfa84645-4278-44a3-8b3b-c6b4fc6257c5"));
        // HashMap<Course, String> tempHashMap = new HashMap<Course, String>();
        // ArrayList<Semester> tempSemesters = new ArrayList<Semester>();
        // ArrayList<Course> courses = new ArrayList<Course>();
        // Long tempLong1 = Long.valueOf(1);
        // Long tempLong2 = Long.valueOf(1);
        // Long tempLong3 = Long.valueOf(1);
        // Semester tempSemester = new Semester("Fall", 2024, 120, courses);
        // Student tempStudent = new Student(UUID.fromString("6e30c187-5592-4d8a-91e4-e874f34a41cd"), "ayushmp", "1231",
        //                         "Ayush", "Parambath", "Freshman", tempDegree, tempLong1, tempLong2, tempLong3, "0000",
        //                         UUID.fromString("152004c3-c655-439d-bbc0-eeaa58f57874"), UUID.fromString("6e30c187-5592-4d8a-91e4-e874f34a41cd"),
        //                         "Q313514", "robotics", "none", tempHashMap, tempSemester, tempSemesters);
        // userList.addUser(tempStudent);
        // ArrayList<Student> allStudents = userList.getStudents();
        // Advisor tempAdvisor = new Advisor(UUID.randomUUID(), "appp", "12312", "Wanda", "Mujica", allStudents,
        //                         "000000", "Swearingen", "1A01");
        // userList.addUser(tempAdvisor);
        // DataWriter.saveUsers(userList.getUsers());

        // //ArrayList<Advisor> allAdvisors = DataLoader.getAdvisors();
        
        //System.out.println(allAdvisors.size());
        UserList userList = UserList.getInstance();
        ArrayList<User> users = userList.getUsers();
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user.getFirstName());
        }
    }
}
