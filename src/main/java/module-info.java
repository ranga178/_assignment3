module com.example.student_information_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.AG.assignment2.module to javafx.fxml;
    exports com.AG.assignment2.module;
    exports com.AG.assignment2.module.Controller;
    opens com.AG.assignment2.module.Controller to javafx.fxml;
    exports com.AG.assignment2.module.View;
    opens com.AG.assignment2.module.View to javafx.fxml;
    exports com.AG.assignment2.module.Model;
    opens com.AG.assignment2.module.Model to javafx.fxml;
}