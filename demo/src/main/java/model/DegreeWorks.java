package model;

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

    // overload createAccount for students, guardians, and advisors
    // each one should add to the userlist
    public boolean createAccount(String firstName, String lastName, String phoneNumber, String VIPid, String userName, String password, String profileType) {
        if (profileType.equalsIgnoreCase("student")) {
            // create a student and add it to the user list
            // substitute default values for other information
            Student tempStudent = new Student(firstName, lastName, phoneNumber, VIPid, userName, password);
            userList.addUser(tempStudent);
            userList.setCurrUser(tempStudent);
        }
        else if (profileType.equalsIgnoreCase("advisor")) {
            // create an advisor and add it to the user list
        }
        else if (profileType.equalsIgnoreCase("guardian")) {
            // create a guardian and add it to the user list
        }
        return true;
    }
}
