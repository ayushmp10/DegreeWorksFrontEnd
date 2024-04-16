package degreeworks;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class emailRecoveryController {

    @FXML
    private TextField emailField;

    @FXML
    private Label statusLabel;

    @FXML
    private void recoverEmail() {
        String email = emailField.getText();
        statusLabel.setText("Recovery email sent to " + email);
    }
}
