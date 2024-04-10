package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class homeController implements Initializable{

    @FXML
    private void clickLogin(ActionEvent event) throws IOException {
        App.setRoot("Log In");
    }

    @FXML 
    private void signupClick(ActionEvent event) throws IOException {
        App.setRoot("Sign Up");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
}