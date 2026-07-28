/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josuecastro.controller;

import com.josuecastro.view.BienvenidaView;
import com.josuecastro.view.LoginView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author informatica
 */
public class SceneManager {

    private static SceneManager instanciaSceneManager;
    private Stage escenarioPrincipal;
    private Stage escenarioSecunadario;
    private Scene escenaPrincipal;

    private SceneManager() {

    }

    public void cambiarEscenaPrincipal(Pane panel, int ancho, int alto) {
        try {
            escenaPrincipal = new Scene(panel, ancho, alto);
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.sizeToScene();
            escenarioPrincipal.show();
        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Al momento de cambiar la escena ");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Cambiar Escena Principal");
            errorPadre.printStackTrace();
        }

    }

    public void ventanaLogin() {
        try {
            this.escenarioPrincipal.initStyle(StageStyle.TRANSPARENT);
            LoginView login = LoginView.getInstanciaLoginView();
            cambiarEscenaPrincipal(login, 450, 500);
            this.escenaPrincipal.setFill(Color.TRANSPARENT);
            new LoginController(login);
        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto Nulo : Ventana Login");
            objetoNulo.printStackTrace();
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error Padre : Ventana Login");
            errorPadre.printStackTrace();
        }

    }

    public void ventanaBienvenida() {
        try {
            escenarioSecunadario = new Stage();
            this.escenarioSecunadario.initStyle(StageStyle.TRANSPARENT);
            escenarioSecunadario = new Stage();
            this.escenarioSecunadario.initStyle(StageStyle.TRANSPARENT);
            this.escenarioSecunadario.initModality(Modality.APPLICATION_MODAL);
            BienvenidaView bienvenida = new BienvenidaView();
            escenaPrincipal = new Scene(bienvenida, 200, 300);
            this.escenarioSecunadario.setScene(escenaPrincipal);
            this.escenarioSecunadario.sizeToScene();
            this.escenarioSecunadario.showAndWait();

        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Ventana Bienvenida");
            objetoNulo.printStackTrace(); // imprime todo el camino hacia el error
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Ventana Bienvenida");
            errorPadre.printStackTrace();
        }
    }

    public static SceneManager getInstanciaSceneManager() {
        if(instanciaSceneManager == null)
            instanciaSceneManager = new SceneManager();
        return instanciaSceneManager;
    }

    public static void setInstanciaSceneManager(SceneManager instanciaSceneManager) {
        SceneManager.instanciaSceneManager = instanciaSceneManager;
    }

    public Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public Stage getEscenarioSecunadario() {
        return escenarioSecunadario;
    }

    public void setEscenarioSecunadario(Stage escenarioSecunadario) {
        this.escenarioSecunadario = escenarioSecunadario;
    }

    public Scene getEscenaPrincipal() {
        return escenaPrincipal;
    }

    public void setEscenaPrincipal(Scene escenaPrincipal) {
        this.escenaPrincipal = escenaPrincipal;
    }
    
    
    
}
