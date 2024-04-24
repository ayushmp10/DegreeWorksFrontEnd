module degreeworks {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires javafx.graphics;
    requires javafx.base;

    opens degreeworks to javafx.fxml;
    exports degreeworks;

    opens model to javafx.fxml;
    exports model; 
}