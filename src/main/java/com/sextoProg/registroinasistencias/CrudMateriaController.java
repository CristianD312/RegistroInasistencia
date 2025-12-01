package com.sextoProg.registroinasistencias;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class CrudMateriaController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCModulos;

    @FXML
    public ComboBox<String> CBGrupo;

    @FXML
    public ComboBox<String> CBOrientacion;

    @FXML
    public ComboBox<String> CBAño;

    @FXML
    private Button OneCargarClick;

    @FXML
    private void initialize(){
        cargarGrupos();
    }

    private void cargarGrupos(){
        ObservableList<String> grupos = FXCollections.observableArrayList(
                "Grupo 1",
                "Grupo 2",
                "A",
                "B",
                "C"
        );

        CBGrupo.setItems(grupos);
        CBGrupo.setPromptText("--Selecciona un grupo--");
    }

    private void cargarAño(){
        ObservableList<String> años = FXCollections.observableArrayList(
                "1° Año",
                "2° Año",
                "3° Año",
                "4° Año",
                "5° Año",
                "6° Año",
                "7° Año"
        );

        CBAño.setItems(años);
        CBAño.setPromptText("--Selecciona un año--");
    }

    private void cargarOrientacion(){
        ObservableList<String> orientacion = FXCollections.observableArrayList(
                "Electromecánica",
                "Programación",
                "E.P.S"
        );
        CBOrientacion.setItems(orientacion);
        CBOrientacion.setPromptText("--Selecciona una orientación");
    }
}
