package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Advisor;
import model.Student;
import model.UserList;

public class advisor_commentsController implements Initializable {
    @FXML private TextField studentUSCID;
    @FXML private TextField advisorComment;
    @FXML private Button submit;

    private UserList userList;
    private Advisor currAdvisor;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        currAdvisor = (Advisor) userList.getCurrUser();
    }
    @FXML
    private void submitComment() {
        String studentUSCIDinput = studentUSCID.getText();
        // do null checks 
        ArrayList<Student> students = currAdvisor.getStudents();
        boolean canSubmit = false;
        for (Student student : students) {
            if (student.getUSCID().equals(studentUSCIDinput)) {
                // move on with submitting the comment
                canSubmit = true;
                currAdvisor.setCurrentStudent(student);
            }
        }
        if (canSubmit) {
            // move on with submitting the comment
            currAdvisor.getCurrentStudent().setAdvisorNotes(advisorComment.getText());
        } else {
            submit.setText("This is not your student you cannot leave a comment");
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
    private void onLogOutClicked() throws IOException{
        App.setRoot("home");
    }
}
