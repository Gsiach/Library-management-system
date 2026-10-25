/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author rooney
 */
public class Student {
    private int libraryID;
    private String firstname;
    private String lastname;
    private String studentID;
    
    
 public Student(Integer libraryID, String firstname,String studentID,String lastname){
this.libraryID = libraryID;
this.firstname = firstname;
this.studentID = studentID;
this.lastname = lastname;
}
public Student(String firstname,String studentID,String lastname){
this.firstname = firstname;
this.studentID = studentID;
this.lastname = lastname;
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
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    
}
