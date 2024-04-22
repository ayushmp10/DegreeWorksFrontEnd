package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Advisor;
import model.Guardian;
import model.Student;
import model.User;
import model.UserList;
import model.Utility;

public class signupController implements Initializable{
    @FXML
    private TextField txt_firstName;

    @FXML
    private TextField txt_lastName;

    @FXML
    private TextField txt_userName;

    @FXML
    private TextField txt_phoneNumber;

    @FXML
    private TextField txt_VIPId;

    @FXML
    private TextField txt_profileType;

    @FXML 
    private TextField txt_password;

    @FXML
    private TextField txt_confirmPassword;

    @FXML
    private Label lbl_error;

    @FXML 
    private void submitClicked() throws IOException {
        String firstName = txt_firstName.getText();
        String lastName = txt_lastName.getText();
        String userName = txt_userName.getText();
        String phoneNumber = txt_phoneNumber.getText();
        String VIPId = txt_VIPId.getText();
        String profileType = txt_profileType.getText();
        String password = txt_password.getText();
        String confirmPassword = txt_confirmPassword.getText();

        // checking for invalid inputs
        if(firstName.isBlank() || lastName.isBlank() || userName.isBlank() ||
                phoneNumber.isBlank() || VIPId.isBlank() ||
                profileType.isBlank() || password.isBlank() || confirmPassword.isBlank()){
            Utility.showAlert("WARNING", "Empty Fields", "Pleae fill all the fields");
        }

        if(!profileType.equalsIgnoreCase("advisor") && !profileType.equalsIgnoreCase("student") && !profileType.equalsIgnoreCase("guardian")){
            Utility.showAlert("ERROR", "Invalid Profile Type", "Please input \" student \", \"advisor\", or \"guardian\"");
        }

        // Confirming password with confirm password
        if(!password.equals(confirmPassword)) {
            Utility.showAlert("WARNING", "Password Mismatch", "Your passwords do not match");
        }

        // create user, add them to userlist, set currUser, and write them to the json
        User user = null;
        try {
            if (profileType.equalsIgnoreCase("student")) {
                user = new Student(firstName, lastName, phoneNumber, VIPId, userName, password);
            } 
            else if (profileType.equalsIgnoreCase("advisor")) {
                user = new Advisor(firstName, lastName, phoneNumber, VIPId, userName, password);
            }
            else if (profileType.equalsIgnoreCase("guardian")) {
                user = new Guardian(UUID.randomUUID(), userName, password, firstName, lastName, phoneNumber, null, true);
            }

            // adding the new user to userlist
            user.userList.addUser(user);

            // writing to json
            user.userList.saveUsers();

            Utility.showAlert("Info", "User Creation", "User " + userName + " Successfully created");

            // This step is to populate the current user in repsective home controllers
            User currUser = user.userList.getUser(userName, password);

            txt_firstName.setText("");
            txt_lastName.setText("");
            txt_userName.setText("");
            txt_phoneNumber.setText("");
            txt_VIPId.setText("");
            txt_profileType.setText("");
            txt_password.setText("");
            txt_confirmPassword.setText("");

        } catch (Exception e) {
            Utility.showAlert("ERROR", "User Creation error", "Unable to create user " + userName);
        }

        // call a facade to do all of these
        if(profileType.equals("student")) {
            App.setRoot("student_home");
        }else if(profileType.equals("adivsor")){
            App.setRoot("advisor_home");
        }else if(profileType.equals("guardian")){
            App.setRoot("guardian_home");
        }
    }
    
    @FXML
    void backButtonClicked(ActionEvent event) {
         try {
            App.setRoot("home");
        }catch (IOException ioe) {
            Utility.showAlert("ERROR", "Exception loading home page", ioe.getLocalizedMessage());
        }
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}

