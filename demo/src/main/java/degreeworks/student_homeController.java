package degreeworks;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import model.*;

public class student_homeController implements Initializable {
    private CourseList courseList;
    private UserList userList;
    private Student currStudent;
    @FXML private GridPane grid_studentInfo;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // if the program has reached this far the current student
        userList = UserList.getInstance();
        currStudent = (Student) userList.getCurrUser();
        courseList = CourseList.getInstance();
        
        ArrayList<Advisor> allAdvisors = userList.getAdvisors();

        Label studentTitle = new Label(currStudent.getFirstName() + " " + currStudent.getLastName());
        studentTitle.setFont(new Font(20));
        studentTitle.setMaxWidth(1000);
        GridPane.setHalignment(studentTitle, HPos.CENTER);

        Label studentID = new Label(currStudent.getUSCID());
        studentID.setFont(new Font(20));
        studentID.setMaxWidth(1000);
        GridPane.setHalignment(studentID, HPos.CENTER);

        Label studentClassification = new Label(currStudent.getYear());
        studentClassification.setFont(new Font(20));
        studentClassification.setMaxWidth(1000);
        GridPane.setHalignment(studentClassification, HPos.CENTER);

        Label studentMajor = new Label(currStudent.getDegree().getSubject());
        studentMajor.setFont(new Font(20));
        studentMajor.setMaxWidth(1000);
        GridPane.setHalignment(studentMajor, HPos.CENTER);

        Label studentApplicationArea = new Label(currStudent.getApplicationArea());
        studentApplicationArea.setFont(new Font(20));
        studentApplicationArea.setMaxWidth(1000);
        GridPane.setHalignment(studentApplicationArea, HPos.CENTER);

        Label studentAdvisor = new Label(currStudent.getAdvisor().toString());// need to make this an advisor object
        for (Advisor advisor : allAdvisors) {
            if (advisor.getID().equals(currStudent.getAdvisor())) {
                studentAdvisor = new Label(advisor.getFirstName() + advisor.getLastName());
            }
        }
        studentAdvisor.setFont(new Font(20));
        studentAdvisor.setMaxWidth(1000);
        GridPane.setHalignment(studentAdvisor, HPos.CENTER);

        Label studentGPA = new Label(currStudent.getGPA().toString());
        studentGPA.setFont(new Font(20));
        studentGPA.setMaxWidth(1000);
        GridPane.setHalignment(studentGPA, HPos.CENTER);

        Label studentPhoneNumber = new Label(currStudent.getPhoneNumber());
        studentPhoneNumber.setFont(new Font(20));
        studentPhoneNumber.setMaxWidth(1000);
        GridPane.setHalignment(studentPhoneNumber, HPos.CENTER);

        Label name = new Label("Student Name");
        name.setFont(new Font(20));
        name.setMaxWidth(1000);
        GridPane.setHalignment(name, HPos.CENTER);

        Label id = new Label("USC ID");
        id.setFont(new Font(20));
        id.setMaxWidth(1000);
        GridPane.setHalignment(id, HPos.CENTER);

        Label classification = new Label("Classification");
        classification.setFont(new Font(20));
        classification.setMaxWidth(1000);
        GridPane.setHalignment(classification, HPos.CENTER);

        Label major = new Label("Major");
        major.setFont(new Font(20));
        major.setMaxWidth(1000);
        GridPane.setHalignment(major, HPos.CENTER);

        Label applicationArea = new Label("Application Area");
        applicationArea.setFont(new Font(20));
        applicationArea.setMaxWidth(1000);
        GridPane.setHalignment(applicationArea, HPos.CENTER);

        Label advisor = new Label("Advisor");
        advisor.setFont(new Font(20));
        advisor.setMaxWidth(1000);
        // advisor.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        GridPane.setHalignment(advisor, HPos.CENTER);

        Label gpa = new Label("GPA");
        gpa.setFont(new Font(20));
        gpa.setMaxWidth(1000);
        GridPane.setHalignment(gpa, HPos.CENTER);

        Label phoneNumber = new Label("Phone Number");
        phoneNumber.setFont(new Font(20));
        phoneNumber.setMaxWidth(1000);
        GridPane.setHalignment(phoneNumber, HPos.CENTER);
        // grid_studentInfo.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        // add all the labels to the gridpane
        grid_studentInfo.add(name, 0,0);
        grid_studentInfo.add(id,0,1);
        grid_studentInfo.add(classification,0,2);
        grid_studentInfo.add(major,0,3);
        // next column
        grid_studentInfo.add(studentTitle, 1, 0);
        grid_studentInfo.add(studentID, 1, 1);
        grid_studentInfo.add(studentClassification, 1, 2);
        grid_studentInfo.add(studentMajor, 1, 3);
        // next column
        grid_studentInfo.add(applicationArea, 2, 0);
        grid_studentInfo.add(advisor, 2, 1);
        grid_studentInfo.add(gpa, 2, 2);
        grid_studentInfo.add(phoneNumber,2,3);
        // last column
        grid_studentInfo.add(studentApplicationArea,3,0);
        grid_studentInfo.add(studentAdvisor,3,1);
        grid_studentInfo.add(studentGPA,3,2);
        grid_studentInfo.add(studentPhoneNumber,3,3);
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
