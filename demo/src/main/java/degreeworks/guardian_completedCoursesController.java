package degreeworks;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class guardian_completedCoursesController {
    @FXML
    void onGuardianCompletedCoursesClicked(MouseEvent event) throws IOException{
        App.setRoot("guardian_completedCourses");
    }

    @FXML
    void onGuardianHomeClicked(MouseEvent event) throws IOException{
        App.setRoot("guardian_home");
    }

    @FXML
    void onGuardianMajorMapClicked(MouseEvent event) throws IOException{
        App.setRoot("guardian_majorMap");
    }

    @FXML
    void onLogOutClicked(MouseEvent event) throws IOException{
        App.setRoot("home");
    }
}
