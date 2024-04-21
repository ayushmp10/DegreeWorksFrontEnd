package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import model.*;

public class advisor_adviseesController implements Initializable {
    @FXML private VBox studentInfo;
    @FXML private Label studentName;
    @FXML private ImageView studentImage;
    @FXML private Label studentUSCID;
    @FXML private Label studentDegree;
    @FXML private GridPane allStudentInfo;

    private UserList userList;
    private Advisor currAdvisor;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        currAdvisor = (Advisor) userList.getCurrUser();
        ArrayList<Student> allStudents = currAdvisor.getStudents();
        // assume advisor has at most four students
        int count = 1;
        int row = 0;
        int col = 0;
        for (Student student : allStudents) {
            if (count == 4) 
                break;
            studentName = new Label(student.getFirstName() + " " + student.getLastName());
            studentImage.setImage(new Image("demo/src/main/resources/images/student" + count + ".jpg"));
            studentUSCID = new Label(student.getUSCID());
            studentDegree = new Label(student.getDegree().getSubject());
            studentInfo = new VBox();
            studentInfo.getChildren().add(studentName);
            studentInfo.getChildren().add(studentImage);
            studentInfo.getChildren().add(studentUSCID);
            studentInfo.getChildren().add(studentDegree);
            allStudentInfo.add(studentInfo, col, row);
            if (col == 2) {
                row += 2;
                col = 0;
            }
            if (row == 0) {
                col += 2;
            }
        }
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
        App.setRoot("advisor_home");
    }
}
