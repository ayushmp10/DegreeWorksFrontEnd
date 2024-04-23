package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.Advisor;
import model.CourseList;
import model.DataLoader;
import model.Student;
import model.UserList;

public class student_homeController implements Initializable {
    private CourseList courseList;
    private UserList userList;
    private Student currStudent;
    @FXML private GridPane grid_studentInfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        // if the program has reached this far the current student
        currStudent = (Student) userList.getCurrUser();
        courseList = CourseList.getInstance();

        ArrayList<Advisor> allAdvisors = DataLoader.getAdvisors();

        Label studentTitle = new Label(currStudent.getFirstName() + " " + currStudent.getLastName());
        studentTitle.setFont(Font.font("Arial Black", 14));
        studentTitle.setMaxWidth(1000);
        studentTitle.setMaxHeight(grid_studentInfo.getMaxHeight());
        studentTitle.setMinHeight(grid_studentInfo.getMaxHeight());
        GridPane.setHalignment(studentTitle, HPos.CENTER);
        studentTitle.setAlignment(Pos.CENTER);

        Label studentID = new Label(currStudent.getUSCID());
        studentID.setFont(Font.font("Arial Black", 14));
        studentID.setMaxWidth(1000);
        studentID.setMaxHeight(grid_studentInfo.getMaxHeight());
        GridPane.setHalignment(studentID, HPos.CENTER);
        studentID.setAlignment(Pos.CENTER);

        Label studentClassification = new Label(currStudent.getYear());
        studentClassification.setFont(Font.font("Arial Black", 14));
        studentClassification.setMaxWidth(1000);
        studentClassification.setMaxHeight(grid_studentInfo.getMaxHeight());
        GridPane.setHalignment(studentClassification, HPos.CENTER);
        studentClassification.setAlignment(Pos.CENTER);

        Label studentMajor = new Label(currStudent.getDegree().getSubject());
        studentMajor.setFont(Font.font("Arial Black", 14));
        studentMajor.setMaxWidth(1000);
        studentMajor.setMaxHeight(grid_studentInfo.getMaxHeight());
        GridPane.setHalignment(studentMajor, HPos.CENTER);
        studentMajor.setAlignment(Pos.CENTER);

        Label studentApplicationArea = new Label(currStudent.getApplicationArea());
        studentApplicationArea.setFont(Font.font("Arial Black", 14));
        studentApplicationArea.setMaxWidth(1000);
        studentApplicationArea.setMaxHeight(grid_studentInfo.getMaxHeight());
        GridPane.setHalignment(studentApplicationArea, HPos.CENTER);
        studentApplicationArea.setAlignment(Pos.CENTER);

        String studentAdvisorName = "none";
        for (Advisor advisor : allAdvisors) {
            if (advisor.getUUID().equals(currStudent.getAdvisor())) {
                studentAdvisorName = advisor.getFirstName() + " " + advisor.getLastName();
            }

        }
        Label studentAdvisor = new Label(studentAdvisorName);
        studentAdvisor.setFont(Font.font("Arial Black", 14));
        studentAdvisor.setMaxWidth(1000);
        studentAdvisor.setMaxHeight(grid_studentInfo.getMaxHeight());
        GridPane.setHalignment(studentAdvisor, HPos.CENTER);
        studentAdvisor.setAlignment(Pos.CENTER);

        Label studentGPA = new Label(Double.toString(currStudent.getGPA()));
        studentGPA.setFont(Font.font("Arial Black", 14));
        studentGPA.setMaxWidth(1000);
        studentGPA.setMaxHeight(grid_studentInfo.getMaxHeight());
        GridPane.setHalignment(studentGPA, HPos.CENTER);
        studentGPA.setAlignment(Pos.CENTER);

        Label studentPhoneNumber = new Label(currStudent.getPhoneNumber());
        studentPhoneNumber.setFont(Font.font("Arial Black", 14));
        studentPhoneNumber.setMaxWidth(1000);
        studentPhoneNumber.setMaxHeight(grid_studentInfo.getMaxHeight());
        GridPane.setHalignment(studentPhoneNumber, HPos.CENTER);
        studentPhoneNumber.setAlignment(Pos.CENTER);

        grid_studentInfo.add(studentTitle, 1, 0);
        grid_studentInfo.add(studentID, 1, 1);
        grid_studentInfo.add(studentClassification, 1, 2);
        grid_studentInfo.add(studentMajor, 1, 3);
        grid_studentInfo.add(studentApplicationArea, 3, 0);
        grid_studentInfo.add(studentAdvisor, 3, 1);
        grid_studentInfo.add(studentGPA, 3, 2);
        grid_studentInfo.add(studentPhoneNumber, 3, 3);
    }

    private Advisor findAdvisorByID(ArrayList<Advisor> allAdvisors, UUID advisorID) {
        for (Advisor advisor : allAdvisors) {
            if (advisor.getID().equals(advisorID)) {
                return advisor;
            }
        }
        return null; // If no advisor with the given ID is found
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
