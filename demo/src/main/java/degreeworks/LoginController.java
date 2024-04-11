package degreeworks;
import java.io.IOException;
import javafx.fxml.FXML;
public class LoginController {
    @FXML
    private void switchToUserScene() throws IOException {
        App.setRoot("primary");
    }
}
