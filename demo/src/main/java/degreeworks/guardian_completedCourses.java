package degreeworks;

import java.io.IOException;

import javafx.fxml.FXML;

public class guardian_completedCourses {
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
