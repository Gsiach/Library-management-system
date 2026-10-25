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
import models.Loan;
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
import models.Book;
import models.Loan;



/**
 * FXML Controller class
 *
 * @author rooney
 */
public class LenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBooks();
        fieldSearch.textProperty().addListener((ObservableList,oldValue,newValue)->{
        filterData(newValue);
    });
        
      
    }    
   
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Loan loan;
    
    
  
   
    public Button btnStu;
    @FXML
    public void tomainMenu(ActionEvent event) throws IOException{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);  // Setting the scene before showing the stage
            stage.show();           // Now showing the window
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
        
}
    @FXML
    public TextField fieldlibraryID;
    @FXML
    public TextField fieldSearch;
    @FXML 
    public TextField fieldBookID;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnDelete;
    @FXML
    public TableView<Loan> tableView;
    @FXML
    public TableColumn<Loan, String> colBName;      
    @FXML
    public TableColumn<Loan, Integer> colloanedbookID;
    @FXML
    public TableColumn<Loan, String> colstudentID;
    @FXML
    public TableColumn<Loan, Integer> collibraryID;
    
    
    @FXML
    private void lendBooks(){
    int BookID = Integer.valueOf(fieldBookID.getText());
    int libraryID = Integer.valueOf(fieldlibraryID.getText());
    models.Loan loan = new Loan(BookID,libraryID); 
    
    Queries query = new Queries();
    query.lendBook(loan);
    showBooks();
    }
    private void showBooks(){
        Queries query = new Queries();
        ObservableList<Loan> list = query.getLoanList();
        colBName.setCellValueFactory(new PropertyValueFactory<Loan, String>("Bookname"));
        colloanedbookID.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("bookID"));
        colstudentID.setCellValueFactory(new PropertyValueFactory<Loan, String>("StudentID"));
        collibraryID.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("libraryID"));
        tableView.setItems(list);
    }
     @FXML
    public void mouseClicked(MouseEvent e){
        try{
            Loan loan = tableView.getSelectionModel().getSelectedItem();
            loan = new Loan(loan.getBookID(),loan.getLibraryID(),loan.getBookname(),loan.getStudentID());
            this.loan = loan;
            String libraryID = String.valueOf(loan.getLibraryID());
            fieldlibraryID.setText(libraryID);
            String bookID = String.valueOf(loan.getBookID());
            fieldBookID.setText(bookID);
            
            
        }
        catch(Exception ex){
         ex.printStackTrace();
        }
   
    }
    
    @FXML
    public void returnBook(){
        Loan selectedLoan = tableView.getSelectionModel().getSelectedItem();
        Queries query = new Queries();
        query.returnBook(selectedLoan);
        showBooks();
        
        
    }
     private void filterData(String searchName){
    ObservableList<Loan> filterData = FXCollections.observableArrayList();
    Queries query = new Queries();
    ObservableList<Loan> list = query.getLoanList();
    for(Loan loan : list){
        String BookID = String.valueOf(loan.getBookID());
        String libraryID = String.valueOf(loan.getLibraryID());
        if(loan.getBookname().toLowerCase().contains(searchName.toLowerCase())
            ||loan.getStudentID().toLowerCase().contains(searchName.toLowerCase())
            ||BookID.toLowerCase().contains(searchName.toLowerCase())
            ||libraryID.toLowerCase().contains(searchName.toLowerCase())){
            filterData.add(loan);    
        }
    }
    tableView.setItems(filterData);
    
    
    
    }
}




