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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import model.*;

public class student_availableCoursesController implements Initializable {
    private CourseList courseList;
    private UserList userList;
    private Student currStudent;
    @FXML GridPane allCoursesPane;
    @FXML ScrollPane allCoursesScrollPane;
    @FXML GridPane majorCoursesPane;
    @FXML ScrollPane majorCoursesScrollPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // there should a current user at this point
        currStudent = (Student) userList.getCurrUser();
        courseList = CourseList.getInstance();
        // get all available courses
        ArrayList<Course> allCourses = DataLoader.getCourses();
        // set formatting for coursePane and scrollPane
        allCoursesPane.getColumnConstraints().add(new ColumnConstraints(2));
        allCoursesPane.getRowConstraints().add(new RowConstraints(allCourses.size()));
        allCoursesPane.setMaxWidth(allCoursesScrollPane.getMaxWidth());
        // display them in a scroll pane with a search box
        int rowCount = 0;
        for (Course course : allCourses) {
            Label courseName = new Label(course.getFullName());
            Label courseCredits = new Label(String.valueOf(course.getCredits()));
            allCoursesPane.add(courseName, 0, rowCount);
            allCoursesPane.add(courseCredits, 1, rowCount);
            rowCount++;
        }
        
        // get all major courses
        HashMap<Course, Integer> allMajorCourses = currStudent.getDegree().getMajorCourses();
        // set up formatting
        majorCoursesPane.getColumnConstraints().add(new ColumnConstraints(2));
        majorCoursesPane.getRowConstraints().add(new RowConstraints(allMajorCourses.size()));
        rowCount = 0;
        for (Course course : allMajorCourses.keySet()) {
            Label courseName = new Label(course.getFullName());
            Label courseCredits = new Label(String.valueOf(course.getCredits()));
            majorCoursesPane.add(courseName, 0, rowCount);
            majorCoursesPane.add(courseCredits, 1, rowCount);
            rowCount++;
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
