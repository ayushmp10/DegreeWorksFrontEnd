package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.*;

public class student_commentsController implements Initializable {
    private Student currStudent;
    private UserList userList;
    @FXML
    private TextField comment;
    @FXML
    private Button submit;

    // use the same formatting used for advisor
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        currStudent = (Student) userList.getCurrUser();
        comment.clear();
    }

    @FXML
    private void submitComment() {
        // do null checks
        if(comment.getText()!=null){
            currStudent.setAdvisorNotes(comment.getText());
            submit.setText("Submitted");
            comment.clear();
        }
        if (currStudent.getAdvisorNotes() != null) {
            comment.setText(currStudent.getAdvisorNotes());
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
