package com.sextoProg.registroinasistencias;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import logical.Conexion;
import logical.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrudPersonalController {


    Personal personal = new Personal();
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCuil;

    @FXML
    private Button BtnEnviar;
    @FXML
    private ComboBox<String> CBPersonal;
    @FXML
    private void initialize(){
        cargarCargos();
    }
    private void cargarCargos(){
        ObservableList<String> cargos= FXCollections.observableArrayList("Profesor","Preceptor","Auxiliar");
        CBPersonal.setItems(cargos);
        //CBPersonal.setPromptText("--Selecciona un cargo--");
    }

    protected void OnVolverClick() {
        GestorVentanas gestor = new GestorVentanas();
        gestor.crearVentana("menu.fxml", "Menú");
    }

    @FXML
    protected void OnEnviarClick() {
        personal.setNombre(txtNombre.getText());
        personal.setApellido(txtApellido.getText());
        personal.setCuil(Integer.parseInt(txtCuil.getText()));
        personal.setCargo(CBPersonal.getValue());
        PreparedStatement statement = null;

        try {
            Connection conn = Conexion.conectar();
            String sql = "INSERT INTO personal (CUIL,nombre, apellido,cargo) VALUES (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, personal.getCuil());
            statement.setString(2, personal.getNombre());
            statement.setString(3, personal.getApellido());
            statement.setString(4, personal.getCargo());

            statement.executeUpdate();
        } catch (Exception e) {
        }

    }
}