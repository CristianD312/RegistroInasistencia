package com.sextoProg.registroinasistencias;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logical.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CambiarPassController {
    @FXML
    private Label LabelCambiar;
    @FXML
    private TextField TxtCampoCambiar;
    @FXML
    private Label LabelConfirmar;
    @FXML
    private TextField TxtCampoConfirmar;
    @FXML
    private Button BtnCambiar;



    @FXML
    protected void OnCambiarContraseñaClick() {
        GestorVentanas gestor = new GestorVentanas();
        String contraseña1 = this.TxtCampoCambiar.getText();
        String contraseña2 = this.TxtCampoConfirmar.getText();
        Connection conn = null;
        PreparedStatement statement = null;
        if (contraseña1.equals(contraseña2)) {
            try {
                conn = Conexion.conectar();
                String sql = "UPDATE Usuario SET nombre_usuario=?";
                statement = conn.prepareStatement(sql);
                statement.setString(1, contraseña1);
                statement.executeUpdate();
            } catch (SQLException var7) {
                SQLException ex = var7;
                gestor.mostrarError("error" + ex.toString());
            }
        }

    }





}
