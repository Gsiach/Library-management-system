/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rooney
 */
public class Loan {
    private int bookID;
    private int libraryID;
    private String Bookname;
    private String StudentID;
    
    public Loan(int bookID, int libraryID){
        this.bookID = bookID;
        this.libraryID = libraryID;
    
    }
    public Loan(int bookID, int libraryID,String Bookname,String StudentID){
        this.bookID = bookID;
        this.libraryID = libraryID;
        this.Bookname = Bookname;
        this.StudentID = StudentID;
    }

    /**
     * @return the bookID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * @param bookID the bookID to set
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    /**
     * @return the libraryID
     */
    public int getLibraryID() {
        return libraryID;
    }

    /**
     * @param libraryID the libraryID to set
     */
    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    /**
     * @return the Bookname
     */
    public String getBookname() {
        return Bookname;
    }

    /**
     * @param Bookname the Bookname to set
     */
    public void setBookname(String Bookname) {
        this.Bookname = Bookname;
    }

    /**
     * @return the StudentID
     */
    public String getStudentID() {
        return StudentID;
    }

    /**
     * @param StudentID the StudentID to set
     */
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }
    
}
