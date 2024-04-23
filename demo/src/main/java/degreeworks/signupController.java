package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;

public class signupController implements Initializable {

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

    private UserList userList;
    private User currUser;

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
        if(isFieldEmpty(firstName) || isFieldEmpty(lastName) || isFieldEmpty(userName) ||
                isFieldEmpty(phoneNumber) || isFieldEmpty(VIPId) ||
                isFieldEmpty(profileType) || isFieldEmpty(password) || isFieldEmpty(confirmPassword)){
            Utility.showAlert("WARNING", "Empty Fields", "Please fill all the fields");
            return;
        }

        // Validate profile type
        if(!isValidProfileType(profileType)){
            Utility.showAlert("ERROR", "Invalid Profile Type", "Please input 'student', 'advisor', or 'guardian'");
            return;
        }

        // Confirm password
        if(!password.equals(confirmPassword)) {
            Utility.showAlert("WARNING", "Password Mismatch", "Your passwords do not match");
            return;
        }

        // create user and handle exceptions
        try {
            currUser = createUser(firstName, lastName, phoneNumber, VIPId, userName, password, profileType);
            if (currUser instanceof Student) {
                Student tempStudent = (Student) currUser;
                HashMap<Course, String> completedCourses = new HashMap<Course, String>();
                tempStudent.setCompletedCourses(completedCourses);
                userList.addUser(tempStudent);
            }
            else {
                userList.addUser(currUser);
            }
            userList.setCurrUser(currUser);
            //userList.saveUsers();
            Utility.showAlert("Info", "User Creation", "User " + userName + " successfully created");
            clearFields();
            navigateToHomePage(profileType);
        } catch (Exception e) {
            Utility.showAlert("ERROR", "User Creation error", "Unable to create user " + userName);
            e.printStackTrace();
        }
    }

    // Method to check if a field is empty
    private boolean isFieldEmpty(String field){
        return field.isBlank();
    }

    // Method to validate profile type
    private boolean isValidProfileType(String profileType){
        return profileType.equalsIgnoreCase("advisor") || profileType.equalsIgnoreCase("student") || profileType.equalsIgnoreCase("guardian");
    }

    // Method to create user based on profile type
private User createUser(String firstName, String lastName, String phoneNumber, String VIPId, String userName, String password, String profileType){
    if (profileType.equalsIgnoreCase("student")) {
        return new Student(firstName, lastName, phoneNumber, VIPId, userName, password);
    } else if (profileType.equalsIgnoreCase("advisor")) {
        return new Advisor(firstName, lastName, phoneNumber, VIPId, userName, password);
    } else if (profileType.equalsIgnoreCase("guardian")) {
        return new Guardian(UUID.randomUUID(), userName, password, firstName, lastName, phoneNumber, null, true);
    }
    return null; // Or handle the case if profile type is invalid
}


    // Method to clear input fields
    private void clearFields(){
        txt_firstName.clear();
        txt_lastName.clear();
        txt_userName.clear();
        txt_phoneNumber.clear();
        txt_VIPId.clear();
        txt_profileType.clear();
        txt_password.clear();
        txt_confirmPassword.clear();
    }

    // Method to navigate to home page based on profile type
    private void navigateToHomePage(String profileType) throws IOException {
        if(profileType.equalsIgnoreCase("student")) {
            App.setRoot("student_home");
        } else if(profileType.equalsIgnoreCase("advisor")){
            App.setRoot("advisor_home");
        } else if(profileType.equalsIgnoreCase("guardian")){
            App.setRoot("guardian_home");
        }
    }
    
    @FXML
    void backButtonClicked(ActionEvent event) {
         try {
            App.setRoot("home");
        } catch (IOException ioe) {
            Utility.showAlert("ERROR", "Exception loading home page", ioe.getLocalizedMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
    }
}
