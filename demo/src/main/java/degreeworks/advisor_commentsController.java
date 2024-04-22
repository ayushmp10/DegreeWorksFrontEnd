package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import model.*;

public class advisor_commentsController implements Initializable {
    @FXML
    private TextField studentUSCID;
    @FXML
    private TextField advisorComment;
    @FXML
    private Button submit;

    private UserList userList;
    private Advisor currAdvisor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        currAdvisor = (Advisor) userList.getCurrUser();
    }

    @FXML
    private void submitComment() {
        String studentUSCIDinput = "";
        if (studentUSCID.getText() != null) {
            studentUSCIDinput = studentUSCID.getText();
        }
        ArrayList<Student> students = currAdvisor.getStudents();
        boolean canSubmit = false;
        for (Student student : students) {
            if (student.getUSCID().equalsIgnoreCase(studentUSCIDinput)) {
                canSubmit = true;
                currAdvisor.setCurrentStudent(student);
            }
            System.out.println("Student's id" + student.getUSCID());
        }
        if (canSubmit) {
            // move on with submitting the comment
            currAdvisor.getCurrentStudent().setAdvisorNotes(advisorComment.getText());
            System.out.println(currAdvisor.getCurrentStudent().getAdvisorNotes());

        } else {
            submit.setText("Error");
        }
    }

    @FXML
    private void viewAdvisees() throws IOException {
        App.setRoot("advisor_advisees");// create page for advisors to view their own students
    }

    @FXML
    private void viewAllStudents() throws IOException {
        App.setRoot("advisor_all_students");// create page for advisors to view students
    }

    @FXML
    private void goHome() throws IOException {
        App.setRoot("advisor_home");
    }

    @FXML
    private void showComments() throws IOException {
        App.setRoot("advisor_comments");// create page for advisors to view comments left by or for students
    }

    @FXML
    private void onLogOutClicked() throws IOException {
        App.setRoot("home");
    }
}
