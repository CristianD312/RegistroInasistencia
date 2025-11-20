package com.sextoProg.registroinasistencias;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logical.Conexion;
import logical.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecuperarPassController {
    GestorVentanas gestor = new GestorVentanas();
    @FXML
    private TextField TxtCampoRespuesta;
    @FXML
    private Button BtnIngresar;
    @FXML
    private Label LabelPregunta;
    @FXML
    private TextField TxtCampoUsuario;
    @FXML
    private Button BtnBuscar;

    public RecuperarPassController() {
    }

    @FXML
    protected void OnBuscarUsuarioClick() {
        Usuario usuario = null;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String nombreUsuario = this.TxtCampoUsuario.getText();

        try {
            conn = Conexion.conectar();
            String sql = "SELECT * FROM usuarios WHERE nombre_usuario=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String preguntaSecreta = resultSet.getString("pregunta_secreta");
                this.LabelPregunta.setText(preguntaSecreta);
            } else {
                this.gestor.mostrarError("no se encontro el usuario");
            }
        } catch (SQLException var16) {
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException var15) {
                SQLException ex = var15;
                this.gestor.mostrarError("error" + ex.toString());
            }

        }

    }

    @FXML
    protected void OnIngresarClick() {
        Usuario usuario = null;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String respuestaIngresada = this.TxtCampoRespuesta.getText();
        String nombreUsuario = this.TxtCampoUsuario.getText();
        String respuestaSecreta = null;

        try {
            conn = Conexion.conectar();
            String sql = "SELECT*FROM usuarios WHERE nombre_usuario=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                respuestaSecreta = resultSet.getString("respuesta_secreta");
            }

            if (respuestaSecreta.equalsIgnoreCase(respuestaIngresada)) {
                this.gestor.crearVentana("CambiarPass.fxml", "cambiar contraseña");
            } else {
                this.gestor.mostrarError("respuesta invalida");
            }
        } catch (SQLException var17) {
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException var16) {
                SQLException ex = var16;
                this.gestor.mostrarError("error" + ex.toString());
            }

        }

    }
}
