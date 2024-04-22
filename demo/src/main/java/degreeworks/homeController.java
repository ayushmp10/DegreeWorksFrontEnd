package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import model.*;

public class homeController implements Initializable {
    private UserList userList;
    
    @FXML
    private void clickLogin(ActionEvent event) throws IOException {
        App.setRoot("LoginPage");
    }

    
    @FXML
    private void signUp(ActionEvent event) throws IOException {
        App.setRoot("signup");
        //System.out.println("YAY!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // userList = UserList.getInstance();
        // // create temp student, advisor, and guardian so that there is something in the json files
        // Degree degree = new Degree();
        // HashMap<Course, String> completedCourses = new HashMap<Course,String>();
        // ArrayList<Course> courses = new ArrayList<Course>();
        // ArrayList<Semester> allSemesters = new ArrayList<Semester>();
        // UUID advisorUUID = UUID.randomUUID();
        // UUID guardianUUID = UUID.randomUUID();
        // Semester currSemester = new Semester("Spring", 2024, 120, courses);
        // Student tempStudent = new Student(UUID.randomUUID(), "tsmith", "1234123", "tawnie", "smith", "2024", degree, Long.valueOf(21),
        //                                     Long.valueOf(123), Long.valueOf(3), "0000", advisorUUID, guardianUUID, "Q123", "something",
        //                                     "Something", completedCourses, currSemester,allSemesters);
        // ArrayList<Student> tempStudents = new ArrayList<Student>();
        // Advisor tempAdvisor = new Advisor(advisorUUID, "tadams", "123412", "tam", "adams", tempStudents, "0000", "Swearingen", "1A01");
        // Guardian tempGuardian = new Guardian(guardianUUID, "jadams", "123412", "john", "adams", "0000", tempStudent, true);
        // userList.addUser(tempGuardian);
        // userList.addUser(tempStudent);
        // userList.addUser(tempAdvisor);
        // userList.saveUsers();
    }


}
