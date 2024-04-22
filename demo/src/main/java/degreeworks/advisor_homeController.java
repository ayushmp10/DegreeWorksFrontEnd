package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    @FXML private ImageView advisorImage;

    private UserList userList;
    private Advisor currAdvisor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // create a view for the advisor to see in home
        // everything is store in a gridpane
        userList = UserList.getInstance();
        currAdvisor = (Advisor) userList.getCurrUser();
        numberStudents.setText(String.valueOf(currAdvisor.getStudents().size()));
        advisorName.setText(currAdvisor.getFirstName() + " " + currAdvisor.getLastName());
        buildingName.setText(currAdvisor.getBuilding());
        roomNumber.setText(currAdvisor.getRoomNumber());
        /* 
        if (currAdvisor.getFirstName().equals("Wanda") && currAdvisor.getLastName().equals("Mujica"))
            advisorImage.setImage(new Image("./demo/src/main/resources/images/wandaMujica.jpg"));
        else
            advisorImage.setImage(new Image(""));
        */
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
