package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.*;

public class student_completedCoursesController implements Initializable{
    private Student currStudent;
    private UserList userList;
    @FXML private GridPane completedCoursePane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // call get completed courses for a student object
        // there should be a current user that is a student by now
        userList = UserList.getInstance();
        currStudent = (Student) userList.getCurrUser();
        HashMap<Course, String> completedCourses = currStudent.getCompletedCourses();
        // set formatting for gridpane
        completedCoursePane.getRowConstraints().add(new RowConstraints(completedCourses.size()));
        completedCoursePane.getColumnConstraints().add(new ColumnConstraints(2));
        // run throguh hashmap
        int row = 0;
        for (Map.Entry<Course, String> gradedCourse : completedCourses.entrySet()) {
            // add each course to a 2 column gridpane
            Label courseName = new Label(gradedCourse.getKey().getFullName());
            Label courseGrade = new Label(gradedCourse.getValue());
            completedCoursePane.add(courseName, 0, row);
            completedCoursePane.add(courseGrade, 1, row);
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
