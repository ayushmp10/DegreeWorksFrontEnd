package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import model.*;

public class student_completedCoursesController implements Initializable{
    private Student currStudent;
    private UserList userList;
    @FXML private GridPane completedCoursePane;
    @FXML private Label x;
    @FXML private Label y;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // call get completed courses for a student object
        // there should be a current user that is a student by now
        userList = UserList.getInstance();
        currStudent = (Student) userList.getCurrUser();
        HashMap<Course, String> completedCourses = currStudent.getCompletedCourses();
        displayCompletedCourses(completedCourses);
        Font font = Font.font("Arial Black", 14);
        x.setFont(font);
        y.setFont(font);
    }

    private void displayCompletedCourses(HashMap<Course, String> completedCourses) {
        int rowHeight = 50;
        // set formatting for gridpane
        completedCoursePane.getRowConstraints().clear();
        completedCoursePane.getRowConstraints().add(new RowConstraints(50));
        // run throguh hashmap
        int row = 1;
        for (Map.Entry<Course, String> gradedCourse : completedCourses.entrySet()) {
            completedCoursePane.getRowConstraints().add(new RowConstraints(50));
            Font font = Font.font("Arial Black",14);
            Label courseName = new Label(gradedCourse.getKey().getFullName());
            Label courseGrade = new Label(gradedCourse.getValue());
            courseName.setFont(font);
            courseName.setAlignment(Pos.CENTER);
            courseGrade.setFont(font);
            courseGrade.setAlignment(Pos.CENTER);
            

            completedCoursePane.add(courseName, 0, row);
            completedCoursePane.add(courseGrade, 1, row);
            GridPane.setHalignment(courseGrade, HPos.CENTER);
            GridPane.setValignment(courseGrade, VPos.CENTER);
            GridPane.setHalignment(courseName, HPos.CENTER);
            GridPane.setValignment(courseName, VPos.CENTER);
            row++;
        }
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
