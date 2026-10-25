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
import javafx.collections.FXCollections;
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
public class StuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showStudents();
        fieldSearch.textProperty().addListener((ObservableList,oldValue,newValue)->{
        filterData(newValue);
    });
    }    
   
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Student student;
    
    
    public void toManageStu(ActionEvent event) {
        
        try {
        Parent root = FXMLLoader.load(getClass().getResource("s.fxml"));
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
   
    public Button btnStu;
    @FXML
    public void tomainMenu(ActionEvent event) throws IOException{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);  // Setting the scene before showing the stage
            stage.show();           // Now showing the window
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
        
}
    @FXML
    public TextField fieldFirstName;
    @FXML
    public TextField fieldstudentID;
    @FXML 
    public TextField fieldLastName;
    @FXML 
    public TextField fieldSearch;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnDelete;
    @FXML
    public TableView<Student> tableView;
    @FXML
    public TableColumn<Student, Integer> colLibraryID;      
    @FXML
    public TableColumn<Student, String> colStudentID;
    @FXML
    public TableColumn<Student, String> colFirstname;
    @FXML
    public TableColumn<Student, String> colLastname;
    
    
    @FXML
    private void addStudent(){
    models.Student student = new Student(fieldFirstName.getText(),fieldstudentID.getText(),fieldLastName.getText()); 
    
    Queries query = new Queries();
    query.addStudent(student);
    showStudents();
    }
    private void showStudents(){
        Queries query = new Queries();
        ObservableList<Student> list = query.getStudentList();
        colLibraryID.setCellValueFactory(new PropertyValueFactory<Student, Integer>("libraryID"));
        colFirstname.setCellValueFactory(new PropertyValueFactory<Student, String>("firstname"));
        colStudentID.setCellValueFactory(new PropertyValueFactory<Student, String>("studentID"));
        colLastname.setCellValueFactory(new PropertyValueFactory<Student, String>("lastname"));
        tableView.setItems(list);
    }
     @FXML
    public void mouseClicked(MouseEvent e){
        try{
            Student student = tableView.getSelectionModel().getSelectedItem();
            student = new Student(student.getFirstname(),student.getStudentID(),student.getLastname());
            this.student = student;
            fieldFirstName.setText(student.getFirstname());
            fieldstudentID.setText(student.getStudentID());
            fieldLastName.setText(student.getLastname());
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
            
        }
        catch(Exception ex){
         ex.printStackTrace();
        }
   
    }
    @FXML
    public void updateStudent(){
        Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
    if (selectedStudent != null) {
            int firstName = selectedStudent.getLibraryID();
            System.out.println(firstName);
            this.student.setLibraryID(firstName);
    }
    
    
        models.Student student = new models.Student(this.student.getLibraryID(),fieldFirstName.getText(),fieldstudentID.getText(),fieldLastName.getText()); 
        Queries query = new Queries();
        query.updateStudent(student);
        showStudents();
    
       
        
    }
    @FXML
    public void deleteStudent(){
        Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            int firstName = selectedStudent.getLibraryID();
            System.out.println(firstName);
            this.student.setLibraryID(firstName);
        }
        
        models.Student student = new models.Student(this.student.getLibraryID(),this.student.getFirstname(),this.student.getStudentID(),this.student.getLastname()); 
        Queries query = new Queries();
        query.deleteStudent(student);
        showStudents();
        
        
    }
    private void filterData(String searchName){
    ObservableList<Student> filterData = FXCollections.observableArrayList();
    Queries query = new Queries();
    ObservableList<Student> list = query.getStudentList();
    for(Student student : list){
         String libraryID = String.valueOf(student.getLibraryID());
        if(student.getFirstname().toLowerCase().contains(searchName.toLowerCase())
            ||student.getLastname().toLowerCase().contains(searchName.toLowerCase())
            ||libraryID.contains(searchName.toLowerCase())
            ||student.getStudentID().toLowerCase().contains(searchName.toLowerCase())    
                ){
            filterData.add(student);    
        }
    }
    tableView.setItems(filterData);
    
    
    
    }
    
    
}


