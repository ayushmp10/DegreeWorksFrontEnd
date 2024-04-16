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

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private void initialize() {
    }

    @FXML
    private void handleLoginButtonAction() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        UserList userList = UserList.getInstance();
        if(username!=null && password!=null && userList.isValidUser(username, password)){
            System.out.println("We good");
            //Log the user in
            // this needs to be able to determine what type of user is logging in and move them to that page
            User currUser = userList.getUser(username, password);
            if (currUser instanceof Student) {
                // move to student page
                App.setRoot("student_home");
            }
            else if (currUser instanceof Advisor) {
                // move to advisor page
                App.setRoot("advisor_home");// this is an empty unopenable page currently
            }
            else if (currUser instanceof Guardian) {
                // move to guardian page
                App.setRoot("guardian_home");
            }
        }
        else{
            //Throw an error message: "Incorrect password or username"

        }
    }
}

