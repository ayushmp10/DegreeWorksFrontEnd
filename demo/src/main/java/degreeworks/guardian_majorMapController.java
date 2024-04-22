package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.*;

public class guardian_majorMapController implements Initializable {
    @FXML private GridPane semester1;
    @FXML private GridPane semester2;
    @FXML private GridPane semester3;
    @FXML private GridPane semester4;
    @FXML private GridPane semester5;
    @FXML private GridPane semester6;
    @FXML private GridPane semester7;
    @FXML private GridPane semester8;

    private UserList userList;
    private Guardian currGuardian;
    private Degree degree;
    private Student student;

    private void createMajorMap(Degree degree) {
        // following code is copied from student_majorMapController
        // get all courses regarding the degree
        HashMap<Course, Integer> majorCourses = degree.getMajorCourses();
        int semester1Rows = 0;
        int semester2Rows = 0;
        int semester3Rows = 0;
        int semester4Rows = 0;
        int semester5Rows = 0;
        int semester6Rows = 0;
        int semester7Rows = 0;
        int semester8Rows = 0;
        for (Map.Entry<Course, Integer> courseElement : majorCourses.entrySet()) {
            // one loop to determine the size of each semesters grid pane
            //  number of rows changes but the number of columns will always be three
            if (courseElement.getValue() == 1)
                semester1Rows++;
            else if (courseElement.getValue() == 2)
                semester2Rows++;
            else if (courseElement.getValue() == 3)
                semester3Rows++;
            else if (courseElement.getValue() == 4)
                semester4Rows++;
            else if (courseElement.getValue() == 5)
                semester5Rows++;
            else if (courseElement.getValue() == 6)
                semester6Rows++;
            else if (courseElement.getValue() == 7)
                semester7Rows++;
            else if (courseElement.getValue() == 8)
                semester8Rows++;
        }

        // set all row numbers
        semester1.getRowConstraints().add(new RowConstraints(semester1Rows));
        semester2.getRowConstraints().add(new RowConstraints(semester2Rows));
        semester3.getRowConstraints().add(new RowConstraints(semester3Rows));
        semester4.getRowConstraints().add(new RowConstraints(semester4Rows));
        semester5.getRowConstraints().add(new RowConstraints(semester5Rows));
        semester6.getRowConstraints().add(new RowConstraints(semester6Rows));
        semester7.getRowConstraints().add(new RowConstraints(semester7Rows));
        semester8.getRowConstraints().add(new RowConstraints(semester8Rows));

        // row tracking (previous row counters are now tracking how many rows have been used)
        semester1Rows = semester2Rows = semester3Rows = semester4Rows = semester5Rows = semester6Rows = semester7Rows = semester8Rows = 0;

        for (Map.Entry<Course, Integer> courseElement : majorCourses.entrySet()) {
            // get all course information for major map
            Label course = new Label(courseElement.getKey().getFullName());
            ArrayList<Prerequisites> coursePrereqs = courseElement.getKey().getPrerequisites();
            // consolidate all the prereqs into one string
            String coursePrereqsString = "";
            for (Prerequisites prereq : coursePrereqs) {
                coursePrereqsString += prereq.toString();
            }
            Label coursePrereqsLabel = new Label(coursePrereqsString);
            Label courseCredits = new Label(String.valueOf(courseElement.getKey().getCredits()));
            // there are 8 panes to add to
            // determine which pane based on the preferred semester .getValue()
            if (courseElement.getValue() == 1) {
                semester1.add(course, 0, semester1Rows);
                semester1.add(courseCredits, 1, semester1Rows);
                semester1.add(coursePrereqsLabel, 2, semester1Rows);
                semester1Rows++;
            }
            else if (courseElement.getValue() == 2) {
                semester2.add(course, 0, semester2Rows);
                semester2.add(courseCredits, 1, semester2Rows);
                semester2.add(coursePrereqsLabel, 2, semester2Rows);
                semester2Rows++;
            }
            else if (courseElement.getValue() == 3) {
                semester3.add(course, 0, semester3Rows);
                semester3.add(courseCredits, 1, semester3Rows);
                semester3.add(coursePrereqsLabel, 2, semester3Rows);
                semester3Rows++;
            }
            else if (courseElement.getValue() == 4) {
                semester4.add(course, 0, semester4Rows);
                semester4.add(courseCredits, 1, semester4Rows);
                semester4.add(coursePrereqsLabel, 2, semester4Rows);
                semester4Rows++;
            }
            else if (courseElement.getValue() == 5) {
                semester5.add(course, 0, semester5Rows);
                semester5.add(courseCredits, 1, semester5Rows);
                semester5.add(coursePrereqsLabel, 2, semester5Rows);
                semester5Rows++;
            }
            else if (courseElement.getValue() == 6) {
                semester6.add(course, 0, semester6Rows);
                semester6.add(courseCredits, 1, semester6Rows);
                semester6.add(coursePrereqsLabel, 2, semester6Rows);
                semester6Rows++;
            }
            else if (courseElement.getValue() == 7) {
                semester7.add(course, 0, semester7Rows);
                semester7.add(courseCredits, 1, semester7Rows);
                semester7.add(coursePrereqsLabel, 2, semester7Rows);
                semester7Rows++;
            }
            else if (courseElement.getValue() == 8) {
                semester8.add(course, 0, semester8Rows);
                semester8.add(courseCredits, 1, semester8Rows);
                semester8.add(coursePrereqsLabel, 2, semester8Rows);
                semester8Rows++;
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        currGuardian = (Guardian) userList.getCurrUser();
        student = currGuardian.getStudent();
        degree = student.getDegree();
        createMajorMap(degree);
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
