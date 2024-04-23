package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Advisor;
import model.UserList;

public class advisor_homeController implements Initializable {
    @FXML private GridPane advisorInfo;
    @FXML private Label numberStudents;
    @FXML private Label advisorName;
    @FXML private Label buildingName;
    @FXML private Label roomNumber;
    @FXML private ImageView profileImage;

    private UserList userList;
    private Advisor currAdvisor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        currAdvisor = (Advisor) userList.getCurrUser();
        numberStudents.setText(String.valueOf(currAdvisor.getStudents().size()));
        advisorName.setText(currAdvisor.getFirstName() + " " + currAdvisor.getLastName());
        buildingName.setText(currAdvisor.getBuilding());
        roomNumber.setText(currAdvisor.getRoomNumber());
    }

    @FXML
    private void viewAdvisees() throws IOException {
        App.setRoot("advisor_advisees");
    }

    @FXML
    private void viewAllStudents() throws IOException {
        App.setRoot("advisor_all_students");
    }

    @FXML
    private void goHome() throws IOException {
        App.setRoot("advisor_home");
    }

    @FXML
    private void showComments() throws IOException {
        App.setRoot("advisor_comments");
    }

    @FXML
    private void onLogOutClicked() throws IOException{
        App.setRoot("home");
    }
}
