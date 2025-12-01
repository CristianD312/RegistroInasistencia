package com.sextoProg.registroinasistencias;

import logical.Conexion;
import logical.Usuario;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
    @FXML
    private Button BtnRecuperarPass;
    @FXML
    private Label welcomeText;

    @FXML
    private TextField inputUsuario;

    @FXML
    private TextField inputContraseña;

    @FXML
    private Button oneClickToLogIn;

    @FXML
    private Button oneClickToRegistro;

    @FXML
    protected void oneClickToLogin() {
        GestorVentanas gestor = new GestorVentanas();
        Usuario usuario = new Usuario();

        try {
            Connection conn = Conexion.conectar();
            usuario.setNombre(inputUsuario.getText());
            String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ?";
            PreparedStatement statement = conn.prepareStatement(sql);

            usuario.setContraseña(inputContraseña.getText());
            String sql2 = "SELECT * FROM usuarios WHERE password = ?";
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement.setString(1,  usuario.getNombre() );

            // 1. VALIDAR que el campo no esté vacío
            if (inputUsuario.getText().trim().isEmpty()) {
                gestor.mostrarAdvertencia("Por favor, ingresa un nombre");
                return;
            }


            statement2.setString(1,  usuario.getContraseña() );
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                gestor.crearVentana("Menu.fxml","Menu");
            }
            statement.close();

        } catch (SQLException ex) {

            gestor.mostrarError("error");
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void oneClickToRecuperacion() {
        GestorVentanas gestor = new GestorVentanas();
        gestor.crearVentana("RecuperarPass.fxml","Recuperar Contraseña");
    }

    @FXML
    protected void onClicktoRegistro() {
        GestorVentanas gestor = new GestorVentanas();
        gestor.crearVentana("RegistroUsuario.fxml","Registrar Usuario");
    }
}
