module degreeworks {
    requires javafx.controls;
    requires javafx.fxml;

    opens degreeworks to javafx.fxml;
    exports degreeworks;
}
