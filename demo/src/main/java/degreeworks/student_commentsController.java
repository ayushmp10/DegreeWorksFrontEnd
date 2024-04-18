package degreeworks;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.*;

public class student_commentsController {
    @FXML
    void availableCoursesClicked(MouseEvent event) throws IOException{
        App.setRoot("student_availableCourses");

    }

    @FXML
    void changeMajorClicked(MouseEvent event) throws IOException{
        App.setRoot("student_changeMajor");

    }

    @FXML
    void commentsClicked(MouseEvent event) throws IOException{
        App.setRoot("student_comments");

    }

    @FXML
    void completedCoursesClicked(MouseEvent event) throws IOException{
        App.setRoot("student_completedCourses");

    }

    @FXML
    void homeClicked(MouseEvent event) throws IOException{
        App.setRoot("student_home");

    }

    @FXML
    void majorMapClicked(MouseEvent event) throws IOException{
        App.setRoot("student_majorMap");

    }

    @FXML
    void onLogOutClicked(MouseEvent event) throws IOException{
        App.setRoot("home");

    }

    @FXML
    void planGeneratorClicked(MouseEvent event) throws IOException{
        App.setRoot("student_planGenreator");

    }
}
