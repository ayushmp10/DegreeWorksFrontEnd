package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.CourseList;
import model.*;

public class student_majorMapController implements Initializable {
    @FXML private GridPane semester1;
    @FXML private GridPane semester2;
    @FXML private GridPane semester3;
    @FXML private GridPane semester4;
    @FXML private GridPane semester5;
    @FXML private GridPane semester6;
    @FXML private GridPane semester7;
    @FXML private GridPane semester8;

    @FXML private Label courseNameLabelS1;
    @FXML private Label courseCreditsLabelS1;
    @FXML private Label prerequisiteCoursesLabelS1;

    @FXML private Label courseNameLabelS2;
    @FXML private Label courseCreditsLabelS2;
    @FXML private Label prerequisiteCoursesLabelS2;

    @FXML private Label courseNameLabelS3;
    @FXML private Label courseCreditsLabelS3;
    @FXML private Label prerequisiteCoursesLabelS3;

    @FXML private Label courseNameLabelS4;
    @FXML private Label courseCreditsLabelS4;
    @FXML private Label prerequisiteCoursesLabelS4;

    @FXML private Label courseNameLabelS5;
    @FXML private Label courseCreditsLabelS5;
    @FXML private Label prerequisiteCoursesLabelS5;

    @FXML private Label courseNameLabelS6;
    @FXML private Label courseCreditsLabelS6;
    @FXML private Label prerequisiteCoursesLabelS6;

    @FXML private Label courseNameLabelS7;
    @FXML private Label courseCreditsLabelS7;
    @FXML private Label prerequisiteCoursesLabelS7;

    @FXML private Label courseNameLabelS8;
    @FXML private Label courseCreditsLabelS8;
    @FXML private Label prerequisiteCoursesLabelS8;

    private CourseList courseList;
    private UserList userList;
    private Student currStudent;
    private Degree degree;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        courseList = CourseList.getInstance();
        currStudent = (Student) userList.getCurrUser();
        degree = currStudent.getDegree();
        createMajorMap(degree);
        Font font = Font.font("Arial Black", 14);
        courseNameLabelS1.setFont(font);
        courseCreditsLabelS1.setFont(font);
        prerequisiteCoursesLabelS1.setFont(font);

        courseNameLabelS2.setFont(font);
        courseCreditsLabelS2.setFont(font);
        prerequisiteCoursesLabelS2.setFont(font);

        courseNameLabelS3.setFont(font);
        courseCreditsLabelS3.setFont(font);
        prerequisiteCoursesLabelS3.setFont(font);

        courseNameLabelS4.setFont(font);
        courseCreditsLabelS4.setFont(font);
        prerequisiteCoursesLabelS4.setFont(font);

        courseNameLabelS5.setFont(font);
        courseCreditsLabelS5.setFont(font);
        prerequisiteCoursesLabelS5.setFont(font);

        courseNameLabelS6.setFont(font);
        courseCreditsLabelS6.setFont(font);
        prerequisiteCoursesLabelS6.setFont(font);

        courseNameLabelS7.setFont(font);
        courseCreditsLabelS7.setFont(font);
        prerequisiteCoursesLabelS7.setFont(font);

        courseNameLabelS8.setFont(font);
        courseCreditsLabelS8.setFont(font);
        prerequisiteCoursesLabelS8.setFont(font);

    }

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
        /*
        semester1.getRowConstraints().add(new RowConstraints(semester1Rows));
        semester2.getRowConstraints().add(new RowConstraints(semester2Rows));
        semester3.getRowConstraints().add(new RowConstraints(semester3Rows));
        semester4.getRowConstraints().add(new RowConstraints(semester4Rows));
        semester5.getRowConstraints().add(new RowConstraints(semester5Rows));
        semester6.getRowConstraints().add(new RowConstraints(semester6Rows));
        semester7.getRowConstraints().add(new RowConstraints(semester7Rows));
        semester8.getRowConstraints().add(new RowConstraints(semester8Rows));
        */

        //clear out grid panes
        ArrayList<GridPane> allSemesters = new ArrayList<>();
        allSemesters.add(semester1);
        allSemesters.add(semester2);
        allSemesters.add(semester3);
        allSemesters.add(semester4);
        allSemesters.add(semester5);
        allSemesters.add(semester6);
        allSemesters.add(semester7);
        allSemesters.add(semester8);



        //clear default rows and add fake box
        int labelHeight = 50;
        for(GridPane semester : allSemesters){
            semester.getRowConstraints().clear();
            semester.getRowConstraints().add(new RowConstraints(labelHeight));
        }


        for (Map.Entry<Course, Integer> courseElement : majorCourses.entrySet()) {
            // get all course information for major map
            Label course = new Label(courseElement.getKey().getFullName());
            ArrayList<Prerequisites> coursePrereqs = courseElement.getKey().getPrerequisites();
            // consolidate all the prereqs into one string
            String coursePrereqsString = "";
            for (Prerequisites prereq : coursePrereqs) {
                System.out.println(prereq.toString());
                coursePrereqsString += prereq.toString() +"\n";
            }
            Label coursePrereqsLabel = new Label(coursePrereqsString);
            Label courseCredits = new Label(String.valueOf(courseElement.getKey().getCredits()));


            //style text and labels
            Font font = Font.font("Arial Black", 14);
            course.setFont(font);
            courseCredits.setFont(font);
            coursePrereqsLabel.setFont(font);
            course.setAlignment(Pos.CENTER);
            courseCredits.setAlignment(Pos.CENTER);
            coursePrereqsLabel.setAlignment(Pos.CENTER);
            // there are 8 panes to add to
            // determine which pane based on the preferred semester .getValue()

            //row height
            int rowHeight = 100;
            if (courseElement.getValue() == 1) {
                semester1.getRowConstraints().add(new RowConstraints());
                semester1.add(course, 0, semester1Rows);
                semester1.add(courseCredits, 1, semester1Rows);
                semester1.add(coursePrereqsLabel, 2, semester1Rows);
                semester1Rows--;
                semester1.getColumnConstraints().forEach(column -> {
                    column.setHalignment(javafx.geometry.HPos.CENTER);
                });
            }
            else if (courseElement.getValue() == 2) {
                semester2.getRowConstraints().add(new RowConstraints());
                semester2.add(course, 0, semester2Rows);
                semester2.add(courseCredits, 1, semester2Rows);
                semester2.add(coursePrereqsLabel, 2, semester2Rows);
                semester2Rows--;
                semester2.getColumnConstraints().forEach(column -> {
                    column.setHalignment(javafx.geometry.HPos.CENTER);
                });
            }
            else if (courseElement.getValue() == 3) {
                semester3.getRowConstraints().add(new RowConstraints());
                semester3.add(course, 0, semester3Rows);
                semester3.add(courseCredits, 1, semester3Rows);
                semester3.add(coursePrereqsLabel, 2, semester3Rows);
                semester3Rows--;
                semester3.getColumnConstraints().forEach(column -> {
                    column.setHalignment(javafx.geometry.HPos.CENTER);
                });
            }
            else if (courseElement.getValue() == 4) {
                semester4.getRowConstraints().add(new RowConstraints());
                semester4.add(course, 0, semester4Rows);
                semester4.add(courseCredits, 1, semester4Rows);
                semester4.add(coursePrereqsLabel, 2, semester4Rows);
                semester4Rows--;
                semester4.getColumnConstraints().forEach(column -> {
                    column.setHalignment(javafx.geometry.HPos.CENTER);
                });
            }
            else if (courseElement.getValue() == 5) {
                semester5.getRowConstraints().add(new RowConstraints());
                semester5.add(course, 0, semester5Rows);
                semester5.add(courseCredits, 1, semester5Rows);
                semester5.add(coursePrereqsLabel, 2, semester5Rows);
                semester5Rows--;
                semester5.getColumnConstraints().forEach(column -> {
                    column.setHalignment(javafx.geometry.HPos.CENTER);
                });
            }
            else if (courseElement.getValue() == 6) {
                semester6.getRowConstraints().add(new RowConstraints());
                semester6.add(course, 0, semester6Rows);
                semester6.add(courseCredits, 1, semester6Rows);
                semester6.add(coursePrereqsLabel, 2, semester6Rows);
                semester6Rows--;
                semester6.getColumnConstraints().forEach(column -> {
                    column.setHalignment(javafx.geometry.HPos.CENTER);
                });
            }
            else if (courseElement.getValue() == 7) {
                semester7.getRowConstraints().add(new RowConstraints());
                semester7.add(course, 0, semester7Rows);
                semester7.add(courseCredits, 1, semester7Rows);
                semester7.add(coursePrereqsLabel, 2, semester7Rows);
                semester7Rows--;
                semester7.getColumnConstraints().forEach(column -> {
                    column.setHalignment(javafx.geometry.HPos.CENTER);
                });
            }
            else if (courseElement.getValue() == 8) {
                semester8.getRowConstraints().add(new RowConstraints());
                semester8.add(course, 0, semester8Rows);
                semester8.add(courseCredits, 1, semester8Rows);
                semester8.add(coursePrereqsLabel, 2, semester8Rows);
                semester8Rows--;
                semester8.getColumnConstraints().forEach(column -> {
                    column.setHalignment(javafx.geometry.HPos.CENTER);
                });
            }
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
