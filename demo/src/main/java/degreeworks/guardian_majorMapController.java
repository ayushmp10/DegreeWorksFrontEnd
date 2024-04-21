package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.*;

public class guardian_majorMapController implements Initializable {
    private UserList userList;
    private Guardian currGuardian;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        currGuardian = (Guardian) userList.getCurrUser();
    }

    @FXML
    void onGuardianCompletedCoursesClicked() throws IOException{
        App.setRoot("guardian_completedCourses");
    }

    @FXML
    void onGuardianHomeClicked() throws IOException{
        App.setRoot("guardian_home");
    }

    @FXML
    void onGuardianMajorMapClicked() throws IOException{
        App.setRoot("guardian_majorMap");
    }

    @FXML
    void onLogOutClicked() throws IOException{
        App.setRoot("home");
    }
}
