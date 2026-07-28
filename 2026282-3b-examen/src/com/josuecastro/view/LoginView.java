/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josuecastro.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author DESKTOP
 */
public class LoginView extends BorderPane {
    
    private static LoginView instanciaLoginView;
    private HBox barradeVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;
    
    
    private TextField txtNombreUsuario;
    private Label lblNombreUsuario;
    private PasswordField pwdClave;
    private Label lblClave;
    private GridPane formulario;
    private Button btnIniciarSesion;
    private VBox cajaVertical;
    
    
    private LoginView(){
        barradeVentana = new HBox(20);
        
        btnCerrarVentana = new Button ("x");
        lblTituloVentana = new Label ("JAVA - EXAMEN - LOGIN");
        
        barradeVentana.getChildren().addAll(btnCerrarVentana,lblTituloVentana);
        
        this.setTop(barradeVentana);
        
        cajaVertical = new VBox (15);
        
        formulario = new GridPane();
        
        lblNombreUsuario = new Label("Ingrese su usuario");
        txtNombreUsuario = new TextField();

        lblClave = new Label("Ingrese su contraseña");
        pwdClave = new PasswordField();

        formulario.add(lblNombreUsuario, 0, 0);
        formulario.add(txtNombreUsuario, 1, 0);

        formulario.add(lblClave, 0, 1);
        formulario.add(pwdClave, 1, 1);
        
        btnIniciarSesion = new Button("Inicia Sesion");
        
        cajaVertical.setAlignment(Pos.CENTER);
        
        cajaVertical.getChildren().addAll(
                formulario,
                btnIniciarSesion
        
        );
        this.setCenter(cajaVertical);
        
    }

    public static LoginView getInstanciaLoginView() {
        if( instanciaLoginView == null)
            instanciaLoginView = new LoginView();
        return instanciaLoginView;
    }

    public static void setInstanciaLoginView(LoginView instanciaLoginView) {
        LoginView.instanciaLoginView = instanciaLoginView;
    }

    public HBox getBarradeVentana() {
        return barradeVentana;
    }

    public void setBarradeVentana(HBox barradeVentana) {
        this.barradeVentana = barradeVentana;
    }

    public Button getBtnCerrarVentana() {
        return btnCerrarVentana;
    }

    public void setBtnCerrarVentana(Button btnCerrarVentana) {
        this.btnCerrarVentana = btnCerrarVentana;
    }

    public Label getLblTituloVentana() {
        return lblTituloVentana;
    }

    public void setLblTituloVentana(Label lblTituloVentana) {
        this.lblTituloVentana = lblTituloVentana;
    }

    public TextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }

    public void setTxtNombreUsuario(TextField txtNombreUsuario) {
        this.txtNombreUsuario = txtNombreUsuario;
    }

    public Label getLblNombreUsuario() {
        return lblNombreUsuario;
    }

    public void setLblNombreUsuario(Label lblNombreUsuario) {
        this.lblNombreUsuario = lblNombreUsuario;
    }

    public PasswordField getPwdClave() {
        return pwdClave;
    }

    public void setPwdClave(PasswordField pwdClave) {
        this.pwdClave = pwdClave;
    }

    public Label getLblClave() {
        return lblClave;
    }

    public void setLblClave(Label lblClave) {
        this.lblClave = lblClave;
    }

    public GridPane getFormulario() {
        return formulario;
    }

    public void setFormulario(GridPane formulario) {
        this.formulario = formulario;
    }

    public Button getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public void setBtnIniciarSesion(Button btnIniciarSesion) {
        this.btnIniciarSesion = btnIniciarSesion;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }
    
    
    
}
