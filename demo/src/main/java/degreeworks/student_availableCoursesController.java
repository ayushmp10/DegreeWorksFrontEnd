package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.*;

public class student_availableCoursesController implements Initializable {
    private CourseList courseList;
    private UserList userList;
    private Student currStudent;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // there should a current user at this point
        currStudent = (Student) userList.getCurrUser();
        courseList = CourseList.getInstance();
        // get all available courses
        ArrayList<Course> allCourses = DataLoader.getCourses();
        // display them in a scroll pane with a search box
        
    }
    
    @FXML
    void availableCoursesClicked() throws IOException{
        App.setRoot("student_availableCourses");

    }

    @FXML
    void changeMajorClicked() throws IOException{
        App.setRoot("student_changeMajor");

    }

    @FXML
    void commentsClicked() throws IOException{
        App.setRoot("student_comments");

    }

    @FXML
    void completedCoursesClicked() throws IOException{
        App.setRoot("student_completedCourses");

    }

    @FXML
    void homeClicked() throws IOException{
        App.setRoot("student_home");

    }

    @FXML
    void majorMapClicked() throws IOException{
        App.setRoot("student_majorMap");

    }

    @FXML
    void onLogOutClicked() throws IOException{
        App.setRoot("home");

    }

    @FXML
    void planGeneratorClicked() throws IOException{
        App.setRoot("student_planGenerator");

    }

}
