package degreeworks;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import model.Student;
import model.UserList;

public class advisor_allStudentsController implements Initializable {
    @FXML private ScrollPane allStudentScrollPane;
    @FXML private GridPane allStudentInfo;

    private UserList userList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        ArrayList<Student> allStudents = userList.getStudents();
        int rowCount = 0;
        for (Student student : allStudents) {
            Label studentUSCID = new Label(student.getUSCID());
            Label studentName = new Label(student.getFirstName() + " " + student.getLastName());
            Label studentDegree = new Label(student.getDegree().getSubject());

            allStudentInfo.addRow(rowCount, studentUSCID, studentName, studentDegree);
            rowCount++;
        }
    }

    @FXML
    private void viewAdvisees() throws IOException {
        App.setRoot("advisor_advisees"); // create page for advisors to view their own students
    }

    @FXML
    private void viewAllStudents() throws IOException {
        App.setRoot("advisor_all_students"); // create page for advisors to view all students
    }

    @FXML
    private void goHome() throws IOException {
        App.setRoot("advisor_home");
    }

    @FXML
    private void showComments() throws IOException {
        App.setRoot("advisor_comments"); // create page for advisors to view comments left by or for students
    }

    @FXML
    private void onLogOutClicked() throws IOException {
        App.setRoot("home");
    }
}
