module com.castillocasco.registroinasisteciasgrupo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.sextoProg.registroinasistencias to javafx.fxml;
    exports com.sextoProg.registroinasistencias;
}