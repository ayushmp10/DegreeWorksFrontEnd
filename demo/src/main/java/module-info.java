module degreeworks {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens degreeworks to javafx.fxml;
    exports degreeworks;

    opens model to javafx.fxml;
    exports model; 
}