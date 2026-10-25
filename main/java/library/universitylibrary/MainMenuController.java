/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package library.universitylibrary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import models.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;



/**
 * FXML Controller class
 *
 * @author rooney
 */
public class MainMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    private Student student;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    @FXML
    public Button Student;
    @FXML
    public Button Lend;
    @FXML
    public Button Book;
    
    public void toManageStu(ActionEvent event) {
        
        try {
        Parent root = FXMLLoader.load(getClass().getResource("stu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);  // Setting the scene before showing the stage
        stage.show();           // Now showing the window
    }
    catch (IOException e) {
        e.printStackTrace();
    }
         
    }
    public void toManageBooks(ActionEvent event) throws IOException{ 
        try {
        Parent root = FXMLLoader.load(getClass().getResource("bk.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);  // Setting the scene before showing the stage
        stage.show();           // Now showing the window
    }
        
    catch (IOException e) {
        e.printStackTrace();
    }
    }
    public void toLendBooks(ActionEvent event) throws IOException{ 
        try {
        Parent root = FXMLLoader.load(getClass().getResource("len.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);  // Setting the scene before showing the stage
        stage.show();           // Now showing the window
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
        





