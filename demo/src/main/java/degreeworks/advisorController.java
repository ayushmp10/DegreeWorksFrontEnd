package degreeworks;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Advisor;
import model.Guardian;
import model.Student;
import model.User;
import model.UserList;


public class advisorController {
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
        App.setRoot("advisor_home");
    }

}
