package model;

import java.util.UUID;

public class User {

    protected String username;
    protected String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private UUID id; // memory address id
    public UserList userList;

    public User(UUID id, String username, String password,
            String firstname, String lastName, String phoneNumber) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.userList = UserList.getInstance();
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public ArrayList<Course> getAvailableCourses() {
    //     return availableCourses;
    // }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }

    public UUID getID() {
        return this.id;
    }

    public void setID(UUID id) {
        this.id = id;
    }
}

