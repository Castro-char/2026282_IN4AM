/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josuecastro.view;

/**
 *
 * @author DESKTOP
 */

    import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class RegistroView extends BorderPane {

    private static RegistroView instanciaRegistroView;
    private HBox barraDeVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;

    private TextField txtNombreCompleto;
    private TextField txtNombreUsuario;
    private TextField txtCorreo;
    private PasswordField pwdClave;
    private PasswordField pwdConfirmarClave;
    
    private GridPane formulario;
    private Button btnRegistrar;
    private Button btnVolverLogin;
    private VBox cajaVertical;
  
    
    
    private RegistroView() {
//        this.getStylesheets().add(RUTA_ESTILOS + "loginStyles.css");
        this.setPadding(new Insets(20));

        this.setBorder(new Border(
                new BorderStroke(Color.DARKGREEN,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(22),
                        new BorderWidths(2))
        ));

        this.setBackground(new Background(
                new BackgroundFill(Paint.valueOf("#AFC06a"),
                        new CornerRadii(25),
                        Insets.EMPTY)
        ));

        barraDeVentana = new HBox(20);
        btnCerrarVentana = new Button("X");
        lblTituloVentana = new Label("JAVAFX - REGISTRO");
        barraDeVentana.getChildren().addAll(btnCerrarVentana, lblTituloVentana);
        this.setTop(barraDeVentana);

        cajaVertical = new VBox(10);
        formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);

        formulario.add(new Label("Nombre Completo:"), 0, 0);
        txtNombreCompleto = new TextField();
        formulario.add(txtNombreCompleto, 1, 0);

        formulario.add(new Label("Nombre Usuario:"), 0, 1);
        txtNombreUsuario = new TextField();
        formulario.add(txtNombreUsuario, 1, 1);

        formulario.add(new Label("Correo:"), 0, 2);
        txtCorreo = new TextField();
        formulario.add(txtCorreo, 1, 2);

        formulario.add(new Label("Contraseña:"), 0, 3);
        pwdClave = new PasswordField();
        formulario.add(pwdClave, 1, 3);

        formulario.add(new Label("Confirmar Clave:"), 0, 4);
        pwdConfirmarClave = new PasswordField();
        formulario.add(pwdConfirmarClave, 1, 4);

        btnRegistrar = new Button("Registrar");
        btnVolverLogin = new Button("Volver al Login");

        cajaVertical.setAlignment(Pos.CENTER);
        cajaVertical.getChildren().addAll(formulario, btnRegistrar, btnVolverLogin);
        this.setCenter(cajaVertical);
    }

    public static RegistroView getInstanciaRegisterView() {
        if (instanciaRegistroView == null) {
          instanciaRegistroView = new RegistroView();
        }
        return instanciaRegistroView;
    }

    public Button getBtnCerrarVentana() { return btnCerrarVentana; }
    public TextField getTxtNombreCompleto() { return txtNombreCompleto; }
    public TextField getTxtNombreUsuario() { return txtNombreUsuario; }
    public TextField getTxtCorreo() { return txtCorreo; }
    public PasswordField getPwdClave() { return pwdClave; }
    public PasswordField getPwdConfirmarClave() { return pwdConfirmarClave; }
    public Button getBtnRegistrar() { return btnRegistrar; }
    public Button getBtnVolverLogin() { return btnVolverLogin; }
}

