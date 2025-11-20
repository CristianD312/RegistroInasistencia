package com.sextoProg.registroinasistencias;

import logical.Conexion;
import logical.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroUsuarioController {

    @FXML
    private TextField txtCampoNombreUsuario;
    @FXML
    private TextField txtCampoContraseña;
    @FXML
    private TextField txtCampoEsAdmin;
    @FXML
    private TextField txtCampoPreguntaSecreta;
    @FXML
    private TextField txtCampoRespuestaSecreta;
    @FXML
    private Button BtnIngresar;



    @FXML
    private void onIngresarClick() {
        GestorVentanas gestor = new GestorVentanas();
        Usuario usuario = new Usuario();
        PreparedStatement statement = null;
        Connection conn = null;
        ResultSet resultSet = null;
        try {
            conn = Conexion.conectar();

            usuario.setNombre(txtCampoNombreUsuario.getText());
            usuario.setContraseña(txtCampoContraseña.getText());
            usuario.setEs_admin(Boolean.parseBoolean(txtCampoEsAdmin.getText()));
            usuario.setPregunta_secreta(txtCampoPreguntaSecreta.getText());
            usuario.setRespuesta_secreta(txtCampoRespuestaSecreta.getText());
            String sql = "INSERT INTO `usuarios` (`nombre_usuario`,`password`,`es_admin`,`pregunta_secreta`,`respuesta_secreta`) VALUES (?,?,?,?,?)";
            statement = conn.prepareStatement(sql);

            statement.setString(1,usuario.getNombre());
            statement.setString(2,usuario.getContraseña());
            statement.setBoolean(3,usuario.isEs_admin());
            statement.setString(4,usuario.getPregunta_secreta());
            statement.setString(5,usuario.getRespuesta_secreta());

            statement.executeUpdate();

            gestor.mostrarExito("Creado exitosamente");

        } catch (Exception e) {
            Logger.getLogger(RegistroUsuarioController.class.getName()).log(Level.SEVERE,null,e);
            gestor.mostrarError("error");
            e.printStackTrace();
        }finally {
            cerrarRecursos(conn, statement, null);
        }
    }
    private void cerrarRecursos(Connection conn, PreparedStatement statement, ResultSet resultSet){
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        }catch (SQLException e){
            Logger.getLogger(RegistroUsuarioController.class.getName()).log(Level.SEVERE,null,e);
        }}
}

