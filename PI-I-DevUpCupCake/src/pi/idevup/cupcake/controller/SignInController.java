/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextField;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pi.idevup.cupcake.entities.User;
import pi.idevup.cupcake.services.UserService;
import pi.idevup.cupcake.services.serviceCryptage;


/**
 *
 * @author mahmo
 */
public class SignInController implements Initializable {

    @FXML
    private AnchorPane frame;
 //   @FXML
 //   private JFXPopup pop;
//     final Popup popup = new Popup();
    @FXML
    private ImageView close;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton login;

    public AnchorPane getFrame() {
        return frame;
    }

    public void setFrame(AnchorPane frame) {
        this.frame = frame;
    }

    public ImageView getClose() {
        return close;
    }

    public void setClose(ImageView close) {
        this.close = close;
    }

    public JFXTextField getUsername() {
        return username;
    }

    public void setUsername(JFXTextField username) {
        this.username = username;
    }

    public JFXPasswordField getPassword() {
        return password;
    }

    public void setPassword(JFXPasswordField password) {
        this.password = password;
    }

    public JFXButton getLogin() {
        return login;
    }

    public void setLogin(JFXButton login) {
        this.login = login;
    }
 

      
    
    private void handleButtonAction(ActionEvent event) {
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb ) {
    }
            public static void loadWindow(URL loc, String title, Stage parentStage) {
        try {
            Parent parent = FXMLLoader.load(loc);
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
   
    @FXML
    private void Signup(MouseEvent event) throws IOException{
          Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/Type.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
        Scene scene = new Scene(root);
        Stage stage  = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        frame.getScene().getWindow().hide();
       
    }

    @FXML
    private void closeApplication(MouseEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Vous allez quitter l'application");
        alert.setHeaderText("Vous allez quitter l'application");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
                System.exit(0);
        } else {
            alert.close();
        }
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        
        String uname = getUsername().getText();
        String pword = getPassword().getText();
        System.out.println("esmék :"+uname);
        serviceCryptage sc = new serviceCryptage();
        String hashed = sc.cryptWithMD5(pword);
        UserService us = new UserService();
        User user = us.UserByLogin(uname);
        if (us.findByLogin(uname) && us.checkpw(pword, uname)/*BCrypt.checkpw(pword, user.getPassword())*/) {
            System.out.println(1);
            System.out.println(us.Gettype(uname));
            String p = "a:1{i:0;s:10:\"ROLE_CLIENT\";}";
            System.out.println(p);
            if (us.Gettype(uname).equals("a:1{i:0;s:10:\"ROLE_ADMIN\";}")) {
                System.out.println("hello Admin");
                //username.getScene().getWindow().hide();
                loadWindow(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLAdmin.fxml"), "Dashboard", null);
                /*Session.LoggedUser = (Session.iuserService.findByLogin1(login.getText()));
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
                Parent root = loader.load();
                ancor.getScene().setRoot(root);*/

            }
            System.out.println("Role du "+uname+"est"+us.Gettype(uname));
            System.out.println(us.Gettype(us.Gettype(uname)).equals("a:1{i:0;s:10:\"ROLE_CLIENT\";}"));
            if (us.Gettype(uname).equals("a:1{i:0;s:10:\"ROLE_CLIENT\";}")) {
                System.out.println("hello Cl");
                username.getScene().getWindow().hide();
                loadWindow(getClass().getResource("/Views/FXMLClient.fxml"), "Client", null);

            }
            if ((us.Gettype(uname)).equals("a:1{i:0;s:10:\"ROLE_PAST\";}")) {
                System.out.println("hello Pastry");
                username.getScene().getWindow().hide();
                loadWindow(getClass().getResource("/Views/FXMLPasty.fxml"), "Patiser", null);

            }
        }

        username.getStyleClass().add("wrong-credentials");
        password.getStyleClass().add("wrong-credentials");

    }


   
    
}
