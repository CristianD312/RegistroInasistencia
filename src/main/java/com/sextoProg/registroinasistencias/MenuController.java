package com.sextoProg.registroinasistencias;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logical.Conexion;

import java.sql.Connection;

public class MenuController {

    @FXML
    private Button BtnCRUDMateria;

    @FXML
    private Button BtnCargaDeInasistencias;

    @FXML
    private Button BtnCRUDPersonal;

    @FXML
    protected void onCrudMateriaClick() {
        GestorVentanas gestor = new GestorVentanas();
        try{
            Connection conn = Conexion.conectar(); //crea objeto "conn" y se conecta con la BDD
            //llama al objeto y el metodo
            gestor.crearVentana("CrudMateria.fxml","Menu");
        }catch (Exception e) {
            gestor.mostrarError("error");
            e.printStackTrace();//te permite seguir trabajando pero te marca el error

        }
    }
    @FXML
    protected void onCrudPersonalClick() {
        GestorVentanas gestor = new GestorVentanas();
        try{
            Connection conn = Conexion.conectar(); //crea objeto "conn" y se conecta con la BDD
            //llama al objeto y el metodo
            gestor.crearVentana("CrudPersonal.fxml","crud personal");
        }catch (Exception e) {
            gestor.mostrarError("error");
            e.printStackTrace();//te permite seguir trabajando pero te marca el error

        }
    }
    @FXML
    protected void onCargaInasistenciasClick() {
        GestorVentanas gestor = new GestorVentanas();
        try{
            Connection conn = Conexion.conectar(); //crea objeto "conn" y se conecta con la BDD
            //llama al objeto y el metodo
            gestor.crearVentana("CargaDeInasistencias.fxml","carga inasistencias");
        }catch (Exception e) {
            gestor.mostrarError("error");
            e.printStackTrace();//te permite seguir trabajando pero te marca el error

        }
    }


}
