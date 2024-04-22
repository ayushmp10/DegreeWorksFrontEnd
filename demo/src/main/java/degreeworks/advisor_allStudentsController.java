package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.Advisor;
import model.Student;
import model.UserList;

public class advisor_allStudentsController implements Initializable {
    // show all students in a scroll pane 
    // student information is displayed in a grid pane (1x3 - USCId, name, degree)
    @FXML private ScrollPane allStudentScrollPane;
    @FXML private GridPane allStudentInfo;
    @FXML private Label studentUSCID;
    @FXML private Label studentName;
    @FXML private Label studentDegree;

    private UserList userList;
    private Advisor currAdvisor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        currAdvisor = (Advisor) userList.getCurrUser(); // could technically get rid of
        ArrayList<Student> allStudents = userList.getStudents();
        allStudentInfo.getColumnConstraints().add(new ColumnConstraints(3));
        allStudentInfo.getRowConstraints().add(new RowConstraints(allStudents.size()));
        int rowCount = 0;
        for (Student student : allStudents) {
            studentUSCID = new Label(student.getUSCID());
            studentName = new Label(student.getFirstName() + " " + student.getLastName());
            studentDegree = new Label(student.getDegree().getSubject());
            allStudentInfo.add(studentUSCID, 0, rowCount);
            allStudentInfo.add(studentName, 1, rowCount);
            allStudentInfo.add(studentDegree, 2, rowCount);
            rowCount++;
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
        App.setRoot("home");
    }
}
