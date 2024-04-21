package degreeworks;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import model.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class student_planGeneratorController implements Initializable {
    private Student currStudent;
    private UserList userList;
    @FXML private Tab year1;
    @FXML private Tab year2;
    @FXML private Tab year3;
    @FXML private Tab year4;
    @FXML private GridPane year1Courses;
    @FXML private GridPane year2Courses;
    @FXML private GridPane year3Courses;
    @FXML private GridPane year4Courses;

    // get all courses from Degree
    // create 8 semester plan for a student object
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        currStudent = (Student) userList.getCurrUser();
        ArrayList<Semester> eightSemesterPlan = currStudent.getEightSemesterPlan();
        // go through each semester and add each course to a semester tab
        // title of the tabs
        eightSemesterPlan.get(0).getSeason();
        eightSemesterPlan.get(0).getYear();

        // the size of the grid pane in each tab is decided by the number of courses that need to be taken
        int year1Rows = eightSemesterPlan.get(0).getCourses().size() + eightSemesterPlan.get(1).getCourses().size();
        int year2Rows = eightSemesterPlan.get(2).getCourses().size() + eightSemesterPlan.get(3).getCourses().size();
        int year3Rows = eightSemesterPlan.get(4).getCourses().size() + eightSemesterPlan.get(5).getCourses().size();
        int year4Rows = eightSemesterPlan.get(6).getCourses().size() + eightSemesterPlan.get(7).getCourses().size();
        // set the size of the gridpane, account for the two rows that are used for semester titles
        year1Courses.getRowConstraints().add(new RowConstraints(year1Rows + 2));
        year2Courses.getRowConstraints().add(new RowConstraints(year2Rows + 2));
        year3Courses.getRowConstraints().add(new RowConstraints(year3Rows + 2));
        year4Courses.getRowConstraints().add(new RowConstraints(year4Rows + 2));
        // run through each semester
        // use a counter to determine which pane needs to be edited
        int rowCount = 0;// relative to the title
        int count = 0;// used to determine which pane to add to
        for (Semester semester : eightSemesterPlan) {
            // get title
            Label semesterTitle = new Label(semester.getSeason() + " " + semester.getYear());
            year1Courses.add(semesterTitle, 0, rowCount);
            rowCount++;
            ArrayList<Course> courses = semester.getCourses();
            for (Course course : courses) {
                Label courseName = new Label(course.getFullName());
                Label courseCredits = new Label(String.valueOf(course.getCredits()));
                if (count <= 1) {
                    year1Courses.add(courseName, 0, rowCount);
                    year1Courses.add(courseCredits, 1, rowCount);
                } else if (count <= 3) {
                    year2Courses.add(courseName, 0, rowCount);
                    year2Courses.add(courseCredits, 0, rowCount);
                } else if (count <= 5) {
                    year3Courses.add(courseName, 0, rowCount);
                    year3Courses.add(courseCredits, 0, rowCount);
                } else if (count <= 7) {
                    year4Courses.add(courseName, 0, rowCount);
                    year4Courses.add(courseCredits, 0, rowCount);
                }
                rowCount++;
            }
            count++;
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
