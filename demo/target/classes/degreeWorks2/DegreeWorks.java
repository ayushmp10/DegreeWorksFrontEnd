package model;

import java.util.ArrayList;

public class DegreeWorks {
    private User currUser;
    private UserList userList;
    private CourseList courseList;
    private DegreeList degreeList;
    private static DegreeWorks degreeWorks;

    private DegreeWorks() {
        userList = UserList.getInstance();
        courseList = CourseList.getInstance();
        degreeList = DegreeList.getInstance();
    }

    public static DegreeWorks getInstance() {
        if (degreeWorks == null) {
            degreeWorks = new DegreeWorks();
        }
        return degreeWorks;
    }

    public boolean createAccount(String firstName, String lastName, String phoneNumber, String VIPid, String userName, String password, String profileType) {
        ArrayList<User> tempUserToSave = new ArrayList<User>();
        if (profileType.equalsIgnoreCase("student")) {
            // create a student and add it to the user list
            // substitute default values for other information
            Student tempStudent = new Student(firstName, lastName, phoneNumber, VIPid, userName, password);
            userList.addUser(tempStudent);
            userList.setCurrUser(tempStudent);
            tempUserToSave.add(tempStudent);
            return true;
        }
        else if (profileType.equalsIgnoreCase("advisor")) {
            // create an advisor and add it to the user list
            // substitute default values for other information
            Advisor tempAdvisor = new Advisor(firstName, lastName, phoneNumber, VIPid, userName, password);
            userList.addUser(tempAdvisor);
            userList.setCurrUser(tempAdvisor);
            tempUserToSave.add(tempAdvisor);
            return true;
        }
        else if (profileType.equalsIgnoreCase("guardian")) {
            // create a guardian and add it to the user list
            // substitute default values for other information
            return true;
        }
        DataWriter.saveUsers(tempUserToSave);
        return false;
    }

    public boolean login(String username, String password) {
        ArrayList<User> allUsers = userList.getUsers();
        // check all users for the username
        for (User user : allUsers) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                // user exists check if password matches
                if (!user.getPassword().equals(password)) {
                    System.out.println("incorrect password");
                    return false;
                }
                // user is logged in
                userList.setCurrUser(user);
                return true;
            }
        }
        System.out.println("User not found");
        return false;
    }

    public User getCurrentUser() {
        return currUser;
    }

    public void logout() {
        currUser = null;
    }
}
