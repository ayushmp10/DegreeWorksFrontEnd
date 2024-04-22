package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import model.*;

public class homeController implements Initializable {
    private UserList userList;
    
    @FXML
    private void clickLogin(ActionEvent event) throws IOException {
        App.setRoot("LoginPage");
    }

    
    @FXML
    private void signUp(ActionEvent event) throws IOException {
        App.setRoot("signup");
        //System.out.println("YAY!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        // create temp student, advisor, and guardian so that there is something in the json files
    }


}
