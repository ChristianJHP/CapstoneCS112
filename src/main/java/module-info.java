module com.cpjc_cs112_miracosta.edu.capstonecs112 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cpjc_cs112_miracosta.edu.capstonecs112 to javafx.fxml;
    exports com.cpjc_cs112_miracosta.edu.capstonecs112.View;
}