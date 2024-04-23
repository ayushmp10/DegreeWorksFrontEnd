package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;

public class student_changeMajorController implements Initializable {
    private Student currStudent;
    private UserList userList;
    @FXML
    private TextField newMajor;
    @FXML
    private Label message;
    @FXML
    private Button submitButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        message = new Label("Please list the major you would like to switch to");
        newMajor.clear();
    }

    @FXML
    void sendMajorChangeRequest() {
        userList = UserList.getInstance();
        currStudent = (Student) userList.getCurrUser();
        currStudent.setAdvisorNotes("\n" + currStudent.getFirstName() + " " + currStudent.getLastName() +
                ": I would like to change my major to " + newMajor.getText());
        System.out.println(currStudent.getAdvisorNotes());
        newMajor.clear();
        submitButton.setText("Submitted");

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
