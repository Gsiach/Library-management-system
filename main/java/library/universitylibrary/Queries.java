/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.universitylibrary;
import data.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


/**
 *
 * @author rooney
 */
public class Queries {
    private DBConnection c = new DBConnection();
    
    //student Querries
    public void addStudent(models.Student Student){
    try{
        c.getDBConn();
        java.sql.PreparedStatement ps = c.getCon().prepareStatement("insert into student(studentID,fname,lname)values(?,?,?)");
        ps.setString(1,Student.getStudentID());
        ps.setString(2,Student.getFirstname());
        ps.setString(3,Student.getLastname());
        ps.execute();
        ps.close();
        c.closeConnection();
    }
    catch(Exception e){
        
    }
    }
    
    public ObservableList<models.Student> getStudentList(){
        ObservableList<models.Student> studentList = FXCollections.observableArrayList();
        
    try{
        String query ="select libraryID,fname,studentID,lname from student ;";
        
        c.getDBConn();
        Statement st = c.getCon().createStatement();
        ResultSet rs = st.executeQuery(query);
        models.Student s;
        while(rs.next()){
        s = new models.Student(rs.getInt("libraryID"),rs.getString("fname"),rs.getString("studentID"),rs.getString("lname"));
        studentList.add(s);
            
        }
        c.closeConnection();
        rs.close();
        st.close();
    }   
    catch (Exception ex) {
        ex.printStackTrace();     
    }
    return studentList;
    }
    public void updateStudent(models.Student Student){
        try{
            
            int q = Student.getLibraryID();
            System.out.println(q);
            c.getDBConn();
            java.sql.PreparedStatement pq = c.getCon().prepareStatement("update  student \n" +
            "set studentID = ?," +
            "fname = ?," +
            "lname = ?" +
            "where " +
            "libraryID = ? ;");
            pq.setString(1,Student.getStudentID());
            pq.setString(2,Student.getFirstname());
            pq.setString(3,Student.getLastname());
            pq.setInt(4,q);
            pq.execute();
            pq.close();
            c.closeConnection();
            System.out.println(q);
            
        }
        catch(SQLException e){
            System.out.println("SQL error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void deleteStudent(models.Student Student){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("delete from student\n" +
                "where libraryID = ?");
            ps.setInt(1,Student.getLibraryID());
            ps.execute();
            ps.close();
            c.closeConnection();
        }
        catch(Exception e) {
            System.out.println("SQL error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //bookQuerries
    public void addBook(models.Book book){
        try{
            c.getDBConn();
            java.sql.PreparedStatement pq = c.getCon().prepareStatement("insert into books (BName,Author) values(?,?)");
        
            pq.setString(1,book.getBookName());
            pq.setString(2,book.getAuthor());
            pq.execute();
            pq.close();
            c.closeConnection();
        }
        catch(Exception ex){ 
            System.out.println("SQL error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public ObservableList<models.Book> getBookList(){
        ObservableList<models.Book> BookList = FXCollections.observableArrayList();
        
        try{
            String query ="select Book_ID,BName,author from books ;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            models.Book b;
            while(rs.next()){
            b = new models.Book(rs.getInt("Book_ID"),rs.getString("BName"),rs.getString("Author"));
            BookList.add(b);    
            }
            c.closeConnection();
            rs.close();
            st.close();
        }   
        catch (Exception ex) { 
        System.out.println("SQL error: " + ex.getMessage());
        ex.printStackTrace();
           
        }
        return BookList;
    }
    public void updateBook(models.Book book){
        try{
            
            int q = book.getBookID();
            System.out.println(q);
            c.getDBConn();
            java.sql.PreparedStatement pq = c.getCon().prepareStatement("update  books\n" +
                "set BName = ?,\n" +
                "Author = ?\n" +
                "where \n" +
                "Book_ID = ? ;");
            pq.setString(1,book.getBookName());
            pq.setString(2,book.getAuthor());
            pq.setInt(3,q);
            pq.execute();
            pq.close();
            c.closeConnection();
           
            
        }
        catch(SQLException e){
            System.out.println("SQL error: " + e.getMessage());
            e.printStackTrace();
    }
    }
    public void deleteBook(models.Book Book){
        try{
            c.getDBConn();
            java.sql.PreparedStatement pq = c.getCon().prepareStatement("delete from books\n" +
                "where Book_ID = ?");
            pq.setInt(1,Book.getBookID());
            pq.execute();
            pq.close();
            c.closeConnection();
        }
        catch(Exception ex){ 
            System.out.println("SQL error: " + ex.getMessage());
            ex.printStackTrace();}
    }
    //lend querries
     public void lendBook(models.Loan loan){
        try{
            c.getDBConn();
            java.sql.PreparedStatement pq = c.getCon().prepareStatement("insert into loanedbooks (loanedbookID,Borrower_libraryID) values(?,?)");
        
            pq.setInt(1,loan.getLibraryID());
            pq.setInt(2,loan.getBookID());
            pq.execute();
            pq.close();
            c.closeConnection();
        }
        catch(Exception ex){ 
            System.out.println("SQL error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public ObservableList<models.Loan> getLoanList(){
        ObservableList<models.Loan> LoanList = FXCollections.observableArrayList();
        
        try{
            String query ="select BName,loanedbookID,studentID,libraryID from lend_view ;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            models.Loan b;
            while(rs.next()){
            b = new models.Loan(rs.getInt("loanedbookID"),rs.getInt("libraryID") ,rs.getString("BName") ,rs.getString("StudentID"));
            LoanList.add(b);    
            }
            c.closeConnection();
            rs.close();
            st.close();
        }   
        catch (Exception ex) { 
        System.out.println("SQL error: " + ex.getMessage());
        ex.printStackTrace();
           
        }
        return LoanList;
    }
    
    
    public void returnBook(models.Loan Loan){
        try{
            c.getDBConn();
            java.sql.PreparedStatement pq = c.getCon().prepareStatement("delete from loanedbooks\n" +
                "where loanedbookID = ?");
            pq.setInt(1,Loan.getBookID());
            pq.execute();
            pq.close();
            c.closeConnection();
        }
        catch(Exception ex){ 
            System.out.println("SQL error: " + ex.getMessage());
            ex.printStackTrace();}
    }
    
}
 
    

