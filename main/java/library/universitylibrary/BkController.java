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
import models.Book;
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
import models.Student;



/**
 * FXML Controller class
 *
 * @author rooney
 */
public class BkController implements Initializable {

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
    private Book book;
    
    
  
   
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
    public TextField fieldAuthorName;
    @FXML
    public TextField fieldSearch;
    @FXML 
    public TextField fieldBookName;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnUpdate;
    @FXML
    public Button btnDelete;
    @FXML
    public TableView<Book> tableView;
    @FXML
    public TableColumn<Book, Integer> colBookID;      
    @FXML
    public TableColumn<Book, String> colAuthorname;
    @FXML
    public TableColumn<Book, String> colBookname;
    
    
    @FXML
    private void addBooks(){
    models.Book book = new Book(fieldBookName.getText(),fieldAuthorName.getText()); 
    
    Queries query = new Queries();
    query.addBook(book);
    showBooks();
    }
    private void showBooks(){
        Queries query = new Queries();
        ObservableList<Book> list = query.getBookList();
        colBookID.setCellValueFactory(new PropertyValueFactory<Book, Integer>("BookID"));
        colAuthorname.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        colBookname.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));
        tableView.setItems(list);
    }
     @FXML
    public void mouseClicked(MouseEvent e){
        try{
            Book book = tableView.getSelectionModel().getSelectedItem();
            book = new Book(book.getBookID(),book.getBookName(),book.getAuthor());
            this.book = book;
            fieldAuthorName.setText(book.getAuthor());
            
            fieldBookName.setText(book.getBookName());
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
            
        }
        catch(Exception ex){
         ex.printStackTrace();
        }
   
    }
    @FXML
    public void updateBook(){
        Book selectedStudent = tableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            int Bookid = selectedStudent.getBookID();
            System.out.println(Bookid);
            this.book.setBookID(Bookid);
        }
        Book book = new models.Book(this.book.getBookID(),fieldBookName.getText(),fieldAuthorName.getText()); 
        Queries query = new Queries();
        query.updateBook(book);
        showBooks();
    
       
        
    }
    @FXML
    public void deleteBook(){
        Book selectedBook = tableView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            int Bookid = selectedBook.getBookID();
            System.out.println(Bookid);
            this.book.setBookID(Bookid);
    }
        
        models.Book book = new models.Book(this.book.getBookID(),fieldBookName.getText(),fieldAuthorName.getText()); 
        Queries query = new Queries();
        query.deleteBook(book);
        showBooks();
        
        
    }
     private void filterData(String searchName){
    ObservableList<Book> filterData = FXCollections.observableArrayList();
    Queries query = new Queries();
    ObservableList<Book> list = query.getBookList();
    for(Book book : list){
        String BookID = String.valueOf(book.getBookID());
        if(book.getBookName().toLowerCase().contains(searchName.toLowerCase())
            ||book.getAuthor().toLowerCase().contains(searchName.toLowerCase())
            ||book.getBookName().toLowerCase().contains(searchName.toLowerCase())
            ||BookID.toLowerCase().contains(searchName.toLowerCase())    ){
            filterData.add(book);    
        }
    }
    tableView.setItems(filterData);
    
    
    
    }
}



