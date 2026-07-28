/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josuecastro.conexiondb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author DESKTOP
 */
public class ConexionDB {
    private static ConexionDB instanciaConexionDB;
    private String usuario = "IN4AM";
    private String clave = "@dmin4AM"; // Mi compu personal
    private String url = "jdbc:mysql://localhost:3306/exam_3B_IN4AM";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection instanciaConnection;

    //Ocultar el constructor vacio
    private ConexionDB() {
        try {
            Class.forName(DRIVER);
            
            instanciaConnection = DriverManager.getConnection(url,usuario,clave);
            
        } catch( ClassNotFoundException errorClassNotFound){
            System.out.println("Error de clase no encontrada");
        } catch( SQLException errorSQL){
            System.out.println("Error de SQL");
        } catch (Exception errorPadre){
            System.out.println("Error top");
        }
    }
    
    public Connection getInstanciaConnection(){
        return instanciaConnection;
    }

    public static ConexionDB getInstanciaConexionDatabase() {
        if (instanciaConexionDB == null) {
            instanciaConexionDB = new ConexionDB();
        }
        return instanciaConexionDB;
    }
}
