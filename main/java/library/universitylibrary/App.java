package library.universitylibrary;

import data.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        try{Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
     
      
        stage.show();
                }
        catch(Exception e){
    e.printStackTrace();
}

    }
    
    



    public static void main(String[] args) {
        launch();
     
        
    }

}