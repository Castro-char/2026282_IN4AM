/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josuecastro.conexiondb;

/**
 *
 * @author DESKTOP
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;

    public boolean validarCredenciales(String userName, String clave) {
        boolean credencialesValidas = false;

        try {
            conexion = ConexionDB.getInstanciaConexionDatabase().getInstanciaConnection();

            String sql = "SELECT * FROM Usuario WHERE user_name = ? AND clave = ?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, userName);
            sentencia.setString(2, clave);

            resultado = sentencia.executeQuery();

            if (resultado.next()) {
                credencialesValidas = true;
            }

        } catch (SQLException errorSQL) {
            JOptionPane.showMessageDialog(null, "Error de conexion o consulta: Validar Credenciales");
            errorSQL.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error Padre: Validar Credenciales");
            errorPadre.printStackTrace();
        } finally {
            try {
                if (resultado != null) resultado.close();
                if (sentencia != null) sentencia.close();
            } catch (SQLException errorCierre) {
                errorCierre.printStackTrace();
            }
        }

        return credencialesValidas;
    }
}
