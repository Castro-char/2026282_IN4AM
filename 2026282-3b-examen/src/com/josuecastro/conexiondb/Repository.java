/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josuecastro.conexiondb;

/**
 *
 * @author informatica
 */
import com.josuecastro.conexiondb.ConexionDB;
import com.josuecastro.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Repository  {

    public Usuario buscarPorCredenciales(String nombreUsuario, String clave) {
        Usuario usuario = null;
        
        String sql = "SELECT * FROM usuario WHERE (nombre_usuario = ? OR email = ?) AND clave = ?";
        
        try {
            Connection conn = ConexionDB.getInstanciaConexionDatabase().getInstanciaConnection();
            
            if (conn == null) {
                System.out.println("Error: No hay conexión disponible con la base de datos");
                return null;
            }
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, nombreUsuario);
            pstmt.setString(3, clave);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("user_name"),
                    rs.getString("clave"),
                    rs.getString("nombre_completo"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error en repositorio al buscar usuario: " + e.getMessage());
        }
        return usuario;
    }

    public boolean guardar(String nombreCompleto, String nombreUsuario, String correo, String clave) {
        String sql = "INSERT INTO usuario (nombre_completo, user_name, email, clave) VALUES (?, ?, ?, ?)";
        
        try {
            Connection conn = ConexionDB.getInstanciaConexionDatabase().getInstanciaConnection();
            
            if (conn == null) {
                System.out.println("Error: La conexión es Null, revisa tus credenciales");
                return false;
            }
                        
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombreCompleto);
            pstmt.setString(2, nombreUsuario);
            pstmt.setString(3, correo);
            pstmt.setString(4, clave);
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar en repositorio " + e.getMessage());
            return false;
        }
    }
}