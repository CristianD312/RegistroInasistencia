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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private void initialize() {
        cargarCargos();
    }

    @FXML
    private void cargarCargos() {
        ObservableList<String> cargos = FXCollections.observableArrayList("Profesor", "Preceptor", "Auxiliar");
        CBPersonal.setItems(cargos);
        CBPersonal.setPromptText("--Selecciona un cargo--");
    }

    @FXML
    protected void OnVolverClick() {
        GestorVentanas gestor = new GestorVentanas();
        gestor.crearVentana("menu.fxml", "Menú");
    }

    @FXML
    protected void OnEnviarClick() {
        GestorVentanas gestor = new GestorVentanas();
        personal.setNombre(txtNombre.getText());
        personal.setApellido(txtApellido.getText());
        String cuilText = txtCuil.getText();

        // 1. VALIDACIÓN: Verificar que el campo no esté vacío
        if (cuilText == null || cuilText.trim().isEmpty()) {
            // Muestra un mensaje de error al usuario (puedes usar un Alert)
            System.err.println("ERROR: El campo CUIL no puede estar vacío.");
            // **IMPORTANTE**: Salir del método para evitar la ejecución del resto del código.
            return;
        }
        personal.setCuil(Integer.parseInt(cuilText.trim()));
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
        } catch (NumberFormatException e) {
            // Manejar error si el texto no es un número (ej. ingresó letras)
            System.err.println("ERROR: El CUIL debe ser un número válido.");
        } catch (Exception e) {
            e.printStackTrace();
            gestor.mostrarError("ERROR de Base de Datos: " + e.getMessage());
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}