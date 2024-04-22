
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;
    private User currUser;

    private UserList() {
        users = new ArrayList<User>();
        ArrayList<Course> courseList = new ArrayList<Course>();
        ArrayList<Season> semestersOffered = new ArrayList<Season>();
        ArrayList<Prerequisites> prerequisites = new ArrayList<Prerequisites>();
        ArrayList<Semester> allSemesters = new ArrayList<Semester>();
        Course course = new Course(UUID.fromString("730005f1-113d-446e-865c-31b46dfbc924"), "CSCE", "247", "Software Engineering",
                                    "Fundamentals of software design and development; software implementation strategies; object-oriented design techniques; functional design techniques; design patterns; design process; source control; testing.    FS: 12/6/2017.   CL: 2020.",
                                    3, semestersOffered, prerequisites);
        HashMap<Course, Integer> majorCourses = new HashMap<Course, Integer>();
        majorCourses.put(course, 3);
        HashMap<Course, String> completedCourses = new HashMap<Course, String>();
        Course completedCourse = new Course(UUID.fromString("2e2ebf3f-c4d3-4dae-956b-d8afa7fca627"), "CSCE", "146", "Algorithmic Design I",
                                            "Problem-solving, algorithmic design, and programming. Three lectures and two laboratory hours per week.   FS: 12/04/2013.   CL: 2020.",
                                            3, semestersOffered, prerequisites);
        completedCourses.put(completedCourse, "A");
        HashMap<Course, Integer> courseOptions = new HashMap<Course, Integer>();
        Elective elective = new Elective("AIU", 2, courseOptions);
        ArrayList<Elective> electives = new ArrayList<Elective>();
        electives.add(elective);
        Degree degree = new Degree("Bachelor of Science", "Computer Science", 123, majorCourses, electives);
        Semester currSemester = new Semester("Fall", 2024, 123, courseList);
        Student baseStudent = new Student(UUID.randomUUID(), "tsmith", "1234", "tam", "smith", "Freshman", degree, Long.valueOf("11"),
                                            Long.valueOf("123"), Long.valueOf("3.0"), "0000", UUID.fromString("351c0f45-1c42-4412-bd1c-ad19f50320b1"),
                                            UUID.fromString("46ec90a8-ea87-491d-ae9f-3f2e4da4a701"), "Q123", "robotics", "Behind on credits", completedCourses,
                                            currSemester, allSemesters);
        
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
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
