/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josuecastro.controller;

/**
 *
 * @author informatica
 */
import com.josuecastro.view.RegistroView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import com.josuecastro.view.RegistroView;

public class RegistroController {
    private final RegistroView REGISTER_VIEW;
    private AuthSistema authSistema = new AuthSistema();
    private double ejeX = 0;
    private double ejeY = 0;
    private Stage escenario = SceneManager.getInstanciaSceneManager().getEscenarioPrincipal();

    public RegistroController(RegistroView registroView) {
        this.REGISTER_VIEW = registroView;
        construirAcciones();
    }

    private void construirAcciones() {
        this.REGISTER_VIEW.getBtnCerrarVentana().setOnMouseClicked(e -> System.exit(0));

        this.REGISTER_VIEW.getBtnVolverLogin().setOnMouseClicked(e -> {
            SceneManager.getInstanciaSceneManager().ventanaLogin();
        });

        this.REGISTER_VIEW.setOnMouseClicked(evento -> {
            ejeX = evento.getSceneX();
            ejeY = evento.getSceneY();
        });

        this.REGISTER_VIEW.setOnMouseDragged(evento -> {
            double desplazamientoX = evento.getScreenX();
            double desplazamientoY = evento.getScreenY();
            escenario.setX(desplazamientoX - ejeX);
            escenario.setY(desplazamientoY - ejeY);
        });

        this.REGISTER_VIEW.getBtnRegistrar().setOnMouseClicked(e -> registrar());
    }

    private void registrar() {
        String nombreCompleto = REGISTER_VIEW.getTxtNombreCompleto().getText().trim();
        String usuario = REGISTER_VIEW.getTxtNombreUsuario().getText().trim();
        String correo = REGISTER_VIEW.getTxtCorreo().getText().trim();
        String clave = REGISTER_VIEW.getPwdClave().getText().trim();
        String confirmar = REGISTER_VIEW.getPwdConfirmarClave().getText().trim();

        if (nombreCompleto.isEmpty() || usuario.isEmpty() || correo.isEmpty() || clave.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACÍOS");
        } else if (!clave.equals(confirmar)) {
            JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
        } else {
            boolean exito = authSistema.regsitrarUsuario(nombreCompleto, usuario, correo, clave);
            if (exito) {
                JOptionPane.showMessageDialog(null, "¡REGISTRO EXITOSO!");
                SceneManager.getInstanciaSceneManager().ventanaLogin();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR: El usuario o correo ya existen en la base de datos.");
            }
        }
    }
}
