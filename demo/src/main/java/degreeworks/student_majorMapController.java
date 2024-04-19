package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import model.CourseList;
import model.*;

public class student_majorMapController implements Initializable {
    @FXML private GridPane grid_majorMap;
    private CourseList courseList;
    private UserList userList;
    private Student currStudent;
    private DegreeList degree;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        courseList = CourseList.getInstance();
        currStudent = (Student) userList.getCurrUser();
        degree = DegreeList.getInstance();
        ArrayList<Degree> degrees = degree.getAllDegrees();
        // get all courses regarding the degree
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
