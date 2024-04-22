package model;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList userList = new UserList();;
    private ArrayList<User> users;
    private User currUser;

    private UserList() {
        users = new ArrayList<User>();
        // add all saved users to users arraylist
        ArrayList<Student> tempStudents = DataLoader.loadStudents();
        ArrayList<Advisor> tempAdvisors = DataLoader.getAdvisors();
        ArrayList<Guardian> tempGuardians = DataLoader.getGuardians();

        if (tempStudents != null ) {
            for (Student student : tempStudents) {
                addUser(student);
            }
        }

        if (tempAdvisors != null ) {
            for (Advisor advisor : tempAdvisors) {
                addUser(advisor);
            }
        }
        
        if (tempGuardians != null ) {
            for (Guardian guardian : tempGuardians) {
                addUser(guardian);
            }
        }
    }

    public static UserList getInstance() {
        /*if (userList == null) {
            userList = new UserList();
        } */
        return userList;
    }

    public void addUser(User user) {
        if( user != null) {
            users.add(user);
        }
    }

    public User getUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().toLowerCase().equals(username.toLowerCase())
                    && user.getPassword().equals(password)) {
                currUser = user;
                return user;
            }
        }
        return null;
    }

    public void saveUsers(){
        if (userList.getUsers() != null && userList.getUsers().size() > 0) {
            DataWriter.saveUsers(userList.getUsers());
        }
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public Student getStudent(UUID id) {
        for (User user : users) {
            if (user.getID().equals(id) && user instanceof Student) {
                return (Student) user;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> returnStudents = new ArrayList<Student>();
        for (User user : users) {
            if (user instanceof Student) {
                returnStudents.add((Student) user);
            }
        }
        return returnStudents;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    //Don't need this method anymore because of login method in DegreeWorks.java
    /* 
        public boolean isValidUser(String username, String password) {
        // Loop through users and compare data
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    */

    public ArrayList<Advisor> getAdvisors() {
        ArrayList<Advisor> returnAdvisors = new ArrayList<Advisor>();
        for (User user : users) {
            if (user instanceof Advisor) {
                returnAdvisors.add((Advisor) user);
            }
        }
        return returnAdvisors;
    }

    public ArrayList<Guardian> getGuardians() {
        ArrayList<Guardian> returnGuardians = new ArrayList<Guardian>();
        for (User user : users) {
            if (user instanceof Guardian) {
                returnGuardians.add((Guardian) user);
            }
        }
        return returnGuardians;
    }

    public User getCurrUser() {
        return currUser;
    }

    public boolean setCurrUser(User user) {
        if (users.contains(user)) {
            currUser = user;
            return true;
        }
        System.out.println("This user does not exist");
        return false;
    }
}
