package degreeworks;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import model.*;

/**
 * JavaFX App
 */
public class App extends Application {
    private UserList userList;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        userList = UserList.getInstance();
        scene = new Scene(loadFXML("home"), 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    @Override
    public void stop() {
        ArrayList<User> users = UserList.getInstance().getUsers();
        for(User user : users){
            System.out.println(user.getFirstName());
        }
        userList.saveUsers();
        
    }

    public static void main(String[] args) {
        launch();
    }

}
