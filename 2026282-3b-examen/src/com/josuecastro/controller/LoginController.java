/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josuecastro.controller;

import com.josuecastro.conexiondb.Repository;
import com.josuecastro.conexiondb.UsuarioDAO;
import com.josuecastro.model.Usuario;
import com.josuecastro.view.LoginView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author DESKTOP
 */
public class LoginController {
    private final LoginView LOGIN_VIEW;
    
    private Stage escenario = SceneManager.getInstanciaSceneManager().getEscenarioPrincipal();
    
    public LoginController(LoginView loginView ){
        this.LOGIN_VIEW = loginView;
        construirAcciones();
    }
    public void construirAcciones(){
        this.LOGIN_VIEW.getBtnCerrarVentana().setOnMouseClicked(
            (evento)->{
                System.exit(0);
            }
        );
    
        
        
        this.LOGIN_VIEW.getBtnIniciarSesion().setOnMouseClicked(
             (evento)->{
                 iniciarSecion();
             }
        );
    }

   AuthSistema auth = new AuthSistema();
        public void iniciarSecion(){
        String nombreUsuario = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String clave = this.LOGIN_VIEW.getPwdClave().getText().trim();
        
        if( nombreUsuario.isEmpty() ) {
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("empty");
            JOptionPane.showMessageDialog(null,
                    "NO DEJE EL CAMPO NOMBRE USUARIO VACIO");
            
        } else if ( clave.isEmpty() ) {
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().remove("empty");
            this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");
            JOptionPane.showMessageDialog(null,
                    "NO DEJE EL CAMPO CONTRASEÑA VACIA");
            
        } else{
            this.LOGIN_VIEW.getPwdClave().getStyleClass().remove("empty");
           Usuario usuario;
            usuario = auth.login(nombreUsuario, clave);
            if (usuario == null)
                JOptionPane.showMessageDialog(null, "VALIDE SUS CREDENCIALES");
            else {
                JOptionPane.showMessageDialog(null, "Sesion iniciada correctamente");
                SceneManager.getInstanciaSceneManager().ventanaBienvenida();
            }
      }
    }
}

   

