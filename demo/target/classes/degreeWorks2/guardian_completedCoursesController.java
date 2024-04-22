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

public class guardian_completedCoursesController implements Initializable {
    private UserList userList;
    private Student currStudent;
    private Guardian currGuardian;
    @FXML private GridPane completedCoursePane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // copied from student_completedCoursesController
        // call get completed courses for a student object
        // there should be a current user that is a student by now
        userList = UserList.getInstance();
        currGuardian = (Guardian) userList.getCurrUser();
        currStudent = currGuardian.getStudent();
        HashMap<Course, String> completedCourses = currStudent.getCompletedCourses();
        displayCompletedCourses(completedCourses);
    }

    private void displayCompletedCourses(HashMap<Course, String> completedCourses) {
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
    void onGuardianCompletedCoursesClicked() throws IOException{
        App.setRoot("guardian_completedCourses");
    }

    @FXML
    void onGuardianHomeClicked() throws IOException{
        App.setRoot("guardian_home");
    }

    @FXML
    void onGuardianMajorMapClicked() throws IOException{
        App.setRoot("guardian_majorMap");
    }

    @FXML
    void onLogOutClicked() throws IOException{
        App.setRoot("home");
    }
}
