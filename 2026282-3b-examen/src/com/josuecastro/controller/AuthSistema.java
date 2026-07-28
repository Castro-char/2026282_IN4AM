/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josuecastro.controller;
import com.josuecastro.conexiondb.Repository;
import com.josuecastro.model.Usuario;
/**
 *
 * @author DESKTOP
 */
public class AuthSistema {
    private Repository usuarioRepositorio = new Repository ();
    public Usuario login (String userName, String clave) {
        return usuarioRepositorio.buscarPorCredenciales(userName, clave);
    }
    
    public boolean regsitrarUsuario(String nombreCompleto, String userName, String correo, String clave){
        return usuarioRepositorio.guardar(nombreCompleto, userName,correo,clave);
    }
}
