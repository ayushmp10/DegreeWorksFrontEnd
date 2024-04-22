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
import javafx.scene.layout.VBox;
import model.Advisor;
import model.DataLoader;
import model.Student;
import model.User;
import model.UserList;

public class advisor_adviseesController implements Initializable {
    @FXML private ScrollPane allStudentScrollPane;
    @FXML private GridPane allStudentInfo;

    private UserList userList;
    private Advisor currAdvisor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = UserList.getInstance();
        currAdvisor = (Advisor) userList.getCurrUser();
        
        // Load users from the DataLoader
        ArrayList<User> allUsers = DataLoader.loadUser();
        
        // Filter out the students from allUsers
        ArrayList<Student> allStudents = new ArrayList<>();
        for (User user : allUsers) {
            if (user instanceof Student) {
                allStudents.add((Student) user);
            }
        }

        int count = 0;
        int row = 0;
        int col = 0;
        for (Student student : allStudents) {
            if (count == 4)
                break;
            VBox studentBox = createStudentBox(student);
            allStudentInfo.add(studentBox, col, row);
            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
            count++;
        }
    }

    private VBox createStudentBox(Student student) {
        VBox studentInfo = new VBox();
        studentInfo.setSpacing(10);

        Label studentName = new Label(student.getFirstName() + " " + student.getLastName());
        studentName.setStyle("-fx-font-weight: bold");
        studentInfo.getChildren().add(studentName);

        Label studentUSCID = new Label("USC ID: " + student.getUSCID());
        studentInfo.getChildren().add(studentUSCID);

        Label studentDegree = new Label("Degree: " + student.getDegree().getSubject());
        studentInfo.getChildren().add(studentDegree);

        // Add more student information as needed
        
        return studentInfo;
    }

    @FXML
    private void viewAdvisees() throws IOException {
        App.setRoot("advisor_advisees"); // create page for advisors to view their own students
    }

    @FXML
    private void viewAllStudents() throws IOException {
        App.setRoot("advisor_all_students"); // create page for advisors to view students
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
