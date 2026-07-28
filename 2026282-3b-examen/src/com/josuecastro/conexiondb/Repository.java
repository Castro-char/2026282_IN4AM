/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josuecastro.conexiondb;
import com.josuecastro.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author informatica
 */
public class Repository {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    public void guardarUsuarioDB(int idUsuario, String userName,
                                String nombreCompleto,
                                String email,
                                String clave,
                                String rol){
            try{
                PreparedStatement prepararLlamada = ConexionDB
                                                        .getInstanciaConexionDatabase()
                                                        .getInstanciaConnection()
                                                        .prepareCall("{call sp_create_registro_resultado(?,?,?,?,?,?)}");
                prepararLlamada.setInt(1, idUsuario);
               prepararLlamada.setString(2, userName);
               prepararLlamada.setString(3, nombreCompleto);
               prepararLlamada.setString(4, email);
               prepararLlamada.setString(5, clave);
               prepararLlamada.setString(6, rol);
               

                prepararLlamada.execute();  
            } catch(SQLException errorSQL){
                System.out.println("Error al Guardar el Resultado");
            } catch(Exception errorPadre){
                System.out.println("Error top");
            }
        }
    
        public Usuario login(String userName, String clave){
        for(Usuario usuarioBuscado : listaUsuarios ){
            
            if( usuarioBuscado.getUserName().equals(userName)
                    && usuarioBuscado.getClave().equals(clave)  ){
                return usuarioBuscado;
            }
        }
        return null;
    }
    
    
    
}