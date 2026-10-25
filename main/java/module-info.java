module library.universitylibrary {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    
    

    opens library.universitylibrary to javafx.fxml;
  
    exports library.universitylibrary;
    exports data;
    exports models;
   
}
