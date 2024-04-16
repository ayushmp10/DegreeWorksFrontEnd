package degreeworks;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class guardian_completedCourses {
    @FXML
    void onGuardianCompletedCoursesClicked(MouseEvent event) {
        App.setRoot("guardian_completedCourses");
    }

    @FXML
    void onGuardianHomeClicked(MouseEvent event) {
        App.setRoot("guardian_home");
    }

    @FXML
    void onGuardianMajorMapClicked(MouseEvent event) {
        App.setRoot("guardian_majorMap");
    }
}
