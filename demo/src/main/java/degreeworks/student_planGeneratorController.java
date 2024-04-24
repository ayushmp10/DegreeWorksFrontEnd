package degreeworks;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import model.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

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
        buildPage();
        year1Courses.getRowConstraints().clear();
        year2Courses.getRowConstraints().clear();
        year3Courses.getRowConstraints().clear();
        year4Courses.getRowConstraints().clear();
        /*
        year1Courses.getRowConstraints().add(new RowConstraints(20));
        year2Courses.getRowConstraints().add(new RowConstraints(20));
        year3Courses.getRowConstraints().add(new RowConstraints(20));
        year4Courses.getRowConstraints().add(new RowConstraints(20));
        */
    }

    public void buildPage() {
        // create the eight semester plan
        currStudent.generateEightSemesterPlan();
        // get an interable version of the eight semester plan
        ArrayList<Semester> eightSemesterPlan = currStudent.getEightSemesterPlan();
        // need a way to track which row of the grid pane we are in
        int rowCount = 0;
        // need a way to track how many semesters have been processed (to determine which grid pane the information is displayed on)
        int semesterCount = 1;
        // run through each semester of it
        for (Semester semester : eightSemesterPlan) {
            if (semester.getCourses().size() > 0) {
                // reset rowCount if it needs to move to a different year
                if (semesterCount % 2 == 1) {
                    rowCount = 0;
                }
                rowCount++;
                // each semester has a title
                Label semesterSeason = new Label(semester.getSeason().toString());
                Label semesterYear = new Label(String.valueOf(semester.getYear()));
                System.out.println(semesterCount + " " + semester.getCourses().size());
                Color darkred = Color.rgb(115, 0, 10);
                semesterSeason.setBackground(new Background(new BackgroundFill(darkred, CornerRadii.EMPTY, Insets.EMPTY)));
                semesterYear.setBackground(new Background(new BackgroundFill(darkred, CornerRadii.EMPTY, Insets.EMPTY)));
                semesterSeason.setMinWidth(298);
                semesterYear.setMinWidth(298);
                semesterSeason.setAlignment(Pos.CENTER);
                semesterYear.setAlignment(Pos.CENTER);
                semesterSeason.setTextFill(Color.WHITE);
                semesterYear.setTextFill(Color.WHITE);
                semesterSeason.setFont(Font.font("Arial Black", 14));
                semesterYear.setFont(Font.font("Arial Black", 14));
                if (semesterCount == 1 || semesterCount == 2) {
                    year1Courses.getRowConstraints().add(new RowConstraints(20));
                    year1Courses.add(semesterSeason, 0, rowCount);
                    year1Courses.add(semesterYear, 1, rowCount);
                } else if (semesterCount == 3 || semesterCount == 4) {
                    year2Courses.getRowConstraints().add(new RowConstraints(20));
                    year2Courses.add(semesterSeason, 0, rowCount);
                    year2Courses.add(semesterYear, 1, rowCount);
                } else if (semesterCount == 5 || semesterCount == 6) {       
                    year3Courses.getRowConstraints().add(new RowConstraints(20));
                    year3Courses.add(semesterSeason, 0, rowCount);
                    year3Courses.add(semesterYear, 1, rowCount);
                } else if (semesterCount == 7 || semesterCount == 8) {
                    year4Courses.getRowConstraints().add(new RowConstraints(20));
                    year4Courses.add(semesterSeason, 0, rowCount);
                    year4Courses.add(semesterYear, 1, rowCount);
                }
                // GridPane.setHalignment(semesterYear, HPos.CENTER);
                // GridPane.setHalignment(semesterSeason, HPos.CENTER);
                // GridPane.setValignment(semesterSeason, VPos.CENTER);
                // GridPane.setValignment(semesterYear, VPos.CENTER);
                
                rowCount++;
                // run through each course in the semester
                for (Course course : semester.getCourses()) {
                    // get course information
                    Label courseName = new Label(course.getFullName());
                    Label courseCredits = new Label(String.valueOf(course.getCredits()));
                    // format the labels
                    courseName.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    courseCredits.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                    courseName.setMinWidth(298);
                    courseCredits.setMinWidth(298);
                    courseName.setMinHeight(15);
                    courseCredits.setMinHeight(15);
                    courseName.setAlignment(Pos.CENTER);
                    courseCredits.setAlignment(Pos.CENTER);
                    courseName.setFont(Font.font("Arial Black", 12));
                    courseCredits.setFont(Font.font("Arial Black", 12));
                    //courseName.setWrapText(Boolean.TRUE);
                    courseCredits.setStyle("-fx-border-color: black");
                    courseName.setStyle("-fx-border-color: black");
                    courseName.setMinHeight(25);
                    courseCredits.setMinHeight(25);

                    if (semesterCount == 1 || semesterCount == 2) {
                        year4Courses.getRowConstraints().add(new RowConstraints(20));
                        year4Courses.add(courseName, 0, rowCount);
                        year4Courses.add(courseCredits, 1, rowCount);
                    } else if (semesterCount == 3 || semesterCount == 4) {
                        year3Courses.getRowConstraints().add(new RowConstraints(20));
                        year3Courses.add(courseName, 0, rowCount);
                        year3Courses.add(courseCredits, 1, rowCount);
                    } else if (semesterCount == 5 || semesterCount == 6) {
                        year2Courses.getRowConstraints().add(new RowConstraints(20));
                        year2Courses.add(courseName, 0, rowCount);
                        year2Courses.add(courseCredits, 1, rowCount);
                    } else if (semesterCount == 7 || semesterCount == 8) {
                        year1Courses.getRowConstraints().add(new RowConstraints(20));
                        year1Courses.add(courseName, 0, rowCount);
                        year1Courses.add(courseCredits, 1, rowCount);
                    }
                    // update row count to move on
                    rowCount++;
                    rowCount++;
                    GridPane.setHalignment(courseName, HPos.CENTER);
                    GridPane.setHalignment(courseCredits, HPos.CENTER);
                    GridPane.setValignment(courseCredits, VPos.CENTER);
                    GridPane.setValignment(courseName, VPos.CENTER);
                }
            }
            semesterCount++;
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
