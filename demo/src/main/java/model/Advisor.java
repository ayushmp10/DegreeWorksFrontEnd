package model;
import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User{
    private ArrayList<Student> students;
    private UserList userList = UserList.getInstance();
    private ArrayList<Student> allStudents = userList.getStudents();
    private Student currStudent;
    private String building;
    private String roomNumber;
    public Advisor(UUID id, String username, String password, String firstName, String lastName,
                    ArrayList<Student> students, String phoneNumber, String building, String roomNumber) {
        super(id, username, password, firstName, lastName, phoneNumber);// already adds the user to the userlist
        this.students = students;
        this.building = building;
        this.roomNumber = roomNumber;
    }

    // overloaded constructor for sign up
    public Advisor(String firstName, String lastName, String phoneNumber, String VIPid, String userName, String password) {
        super(UUID.randomUUID(), userName, password, firstName, lastName, phoneNumber);
        this.students = new ArrayList<Student>();
        this.building = "Swearingen";
        this.roomNumber = "1A01";
    }

    public String getName() {
        return super.getFirstName() + " " + super.getLastName();
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

    public void populateStudents() {
        for (Student student : allStudents) {
            if (student.getAdvisor().equals(this.getID())) {
                students.add(student);
            }
        }
        if (allStudents.size() > 0) {
            currStudent = allStudents.get(0);
        } else {
            currStudent = null;
        }
    }

    public Student getCurrentStudent() {
        return this.currStudent;
    }
    public void setCurrentStudent(Student student) {
        if (allStudents.contains(student) && student.getAdvisor().equals(this.getID())) {
            currStudent = student;
        } else if (!allStudents.contains(student)) {
            System.out.println("This student does not exist in our system");
        } else if (!student.getAdvisor().equals(this.getID())) {
            System.out.println("this is not your student");
        }
    }
    
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void highlightStudentCourses(Student student) {
    }
    public ArrayList<Course> getStudentCurrentCourses(Student student) {
        return new ArrayList<>();
    }
    public void addStudent(Student student) {
        if (allStudents.contains(student))
            students.add(student);
    }
    public void removeStudent(Student student) {
        if (students.contains(student))
            students.remove(student);
    }
    public Student getStudent(Student studentF) {
        for (Student student : students) {
            if (studentF.getID().equals(student.getID())) {
                return student;
            }
        }
        return null;
    }
    public Student getStudent(UUID studentFUUID) {
        for (Student student : students) {
            if (student.getID().equals(studentFUUID)) {
                return student;
            }
        } 
        return null;
    }

    public String getLocation() {
        return "Advisor's Office: " + this.building + " " + this.roomNumber;
    }
}


