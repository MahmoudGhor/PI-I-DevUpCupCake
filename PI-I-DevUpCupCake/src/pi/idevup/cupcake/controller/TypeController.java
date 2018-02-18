/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author mahmo
 */
public class TypeController implements Initializable {

    @FXML
    private ImageView client;
    @FXML
    private ImageView patissierPic;
    @FXML
    private Label patissierBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signupclient(MouseEvent event) {
        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/Signup.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
        Scene scene = new Scene(root);
        Stage stage  = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        client.getScene().getWindow().hide();
    }

    @FXML
    private void signUpPastry(MouseEvent event) {
         Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/AddPasty.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
        Scene scene = new Scene(root);
        Stage stage  = new Stage();
        stage.setScene(scene);
        stage.show();
        patissierBtn.getScene().getWindow().hide();
    }
    
}
