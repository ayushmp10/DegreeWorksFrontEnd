package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import model.Course;
import model.CourseList;
import model.Student;
import model.UserList;

public class student_availableCoursesController implements Initializable {
    private CourseList courseList;
    private UserList userList;
    private Student currStudent;
    private ObservableList<Course> originalCourses = FXCollections.observableArrayList();
    @FXML private GridPane allCoursesPane;
    @FXML private ScrollPane allCoursesScrollPane;
    @FXML private TextField searchTextField;
    @FXML private GridPane majorCoursesPane;
    @FXML private ScrollPane majorCoursesScrollPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        // there should a current user at this point
        currStudent = (Student) userList.getCurrUser();
        courseList = CourseList.getInstance();
        // get all available courses
        ArrayList<Course> allCourses = courseList.getCourses();
        originalCourses.addAll(allCourses);
        
        // Clear existing column constraints and set new ones
        allCoursesPane.getColumnConstraints().clear();
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(90.0); // Occupy entire width
        allCoursesPane.getColumnConstraints().add(column);
        
        // display them in a scroll pane with a search box
        updateCourseDisplay(originalCourses);
    }

    @FXML
    void handleSearch(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            performSearch();
        }
    }

    @FXML
    void searchButtonClicked(ActionEvent event) {
        performSearch();
    }

    private void performSearch() {
        String searchText = searchTextField.getText().toLowerCase();
        ObservableList<Course> filteredCourses = FXCollections.observableArrayList();
        for (Course course : originalCourses) {
            if (course.getFullName().toLowerCase().contains(searchText)) {
                filteredCourses.add(course);
            }
        }
        updateCourseDisplay(filteredCourses);
    }

    private void updateCourseDisplay(ObservableList<Course> courses) {
        allCoursesPane.getChildren().clear();
        int rowCount = 0;
        for (Course course : courses) {
            Label courseName = new Label(course.getFullName());
            Label courseCredits = new Label(String.valueOf(course.getCredits()));
            allCoursesPane.add(courseName, 0, rowCount);
            allCoursesPane.add(courseCredits, 1, rowCount);
            rowCount++;
        }
    }

    @FXML
    void availableCoursesClicked() throws IOException {
        App.setRoot("student_availableCourses");
    }

    @FXML
    void changeMajorClicked() throws IOException {
        App.setRoot("student_changeMajor");
    }

    @FXML
    void commentsClicked() throws IOException {
        App.setRoot("student_comments");
    }

    @FXML
    void completedCoursesClicked() throws IOException {
        App.setRoot("student_completedCourses");
    }

    @FXML
    void homeClicked() throws IOException {
        App.setRoot("student_home");
    }

    @FXML
    void majorMapClicked() throws IOException {
        App.setRoot("student_majorMap");
    }

    @FXML
    void onLogOutClicked() throws IOException {
        App.setRoot("home");
    }

    @FXML
    void planGeneratorClicked() throws IOException {
        App.setRoot("student_planGenerator");
    }
}
