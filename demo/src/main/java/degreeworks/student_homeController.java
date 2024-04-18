package degreeworks;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.*;

public class student_homeController implements Initializable {
    private CourseList courseList;
    private UserList userList;
    private Student currStudent;
    @FXML private GridPane grid_studentInfo;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        courseList = CourseList.getInstance();
        userList = UserList.getInstance();
        Degree tempDegree = new Degree();
        HashMap<Course, String> tempHashMap = new HashMap<Course, String>();
        ArrayList<Semester> tempSemesters = new ArrayList<Semester>();
        ArrayList<Course> courses = new ArrayList<Course>();
        Long tempLong1 = Long.valueOf(1);
        Long tempLong2 = Long.valueOf(1);
        Long tempLong3 = Long.valueOf(1);
        Semester tempSemester = new Semester("Fall", 2024, 120, courses);
        Student tempStudent = new Student(UUID.fromString("6e30c187-5592-4d8a-91e4-e874f34a41cd"), "ayushmp", "1231",
                                "Ayush", "Parambath", "Freshman", tempDegree, tempLong1, tempLong2, tempLong3, "0000",
                                UUID.fromString("6e30c187-5592-4d8a-91e4-e874f34a41cd"), UUID.fromString("6e30c187-5592-4d8a-91e4-e874f34a41cd"),
                                "Q313514", "robotics", "none", tempHashMap, tempSemester, tempSemesters);
        userList.addUser(tempStudent);
        ArrayList<Student> allStudents = userList.getStudents();
        currStudent = allStudents.get(0);
        VBox vbox = new VBox();
        Label studentTitle = new Label(currStudent.getFirstName() + currStudent.getLastName());
        studentTitle.setFont(new Font(20));
        vbox.getChildren().add(studentTitle);
        grid_studentInfo.add(vbox, 0, 0);
    }
    @FXML
    void availableCoursesClicked(MouseEvent event) throws IOException{
        App.setRoot("student_availableCourses");

    }

    @FXML
    void changeMajorClicked(MouseEvent event) throws IOException{
        App.setRoot("student_changeMajor");

    }

    @FXML
    void commentsClicked(MouseEvent event) throws IOException{
        App.setRoot("student_comments");

    }

    @FXML
    void completedCoursesClicked(MouseEvent event) throws IOException{
        App.setRoot("student_completedCourses");

    }

    @FXML
    void homeClicked(MouseEvent event) throws IOException{
        App.setRoot("student_home");

    }

    @FXML
    void majorMapClicked(MouseEvent event) throws IOException{
        App.setRoot("student_majorMap");

    }

    @FXML
    void onLogOutClicked(MouseEvent event) throws IOException{
        App.setRoot("home");

    }

    @FXML
    void planGeneratorClicked(MouseEvent event) throws IOException{
        App.setRoot("student_planGenreator");

    }
}
