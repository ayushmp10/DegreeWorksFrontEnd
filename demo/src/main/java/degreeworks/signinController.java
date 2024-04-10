package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class signinController implements Initializable{
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
    private void submitClicked(MouseEvent event) throws IOException {
        String firstName = txt_firstName.getText();
        String lastName = txt_lastName.getText();
        String userName = txt_userName.getText();
        String phoneNumber = txt_phoneNumber.getText();
        String VIPId = txt_VIPId.getText();
        String profileType = txt_profileType.getText();
        String password = txt_password.getText();
        String confirmPassword = txt_confirmPassword.getText();

        if(firstName.equals("") || lastName.equals("") || userName.equals("") ||
        phoneNumber.equals("") || VIPId.equals("") ||
        profileType.equals("") || password.equals("") || confirmPassword.equals("")){
            lbl_error.setText("You cannot leave boxes blank");
        }
        
        if(password.equals(confirmPassword)){

        }else {
            lbl_error.setText("Your passwords do not match");
        }

        //gotten from portia ask how it works
        /* 
        Library library = Library.getInstance();

        if (!library.createAccount(username, firstName, lastName, age, phoneNumber)) {
            lbl_error.setText("Sorry, this user couldn't be created.");
            return;
        }

        library.login(username);
        User user = library.getCurrentUser();
        App.setRoot("user_home");
        */
    }
    

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("home");
    }

     @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
}
