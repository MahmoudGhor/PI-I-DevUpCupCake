/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pi.idevup.cupcake.services.ServicePatisserieBd;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UpdateProfilePatissierController implements Initializable {

    @FXML
    private ImageView picId;
    @FXML
    private JFXButton updatPic;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField town;
    @FXML
    private Label worktimel;
    @FXML
    private Label dayoff;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXCheckBox lundi;
    @FXML
    private JFXCheckBox mardi;
    @FXML
    private JFXCheckBox vendredi;
    @FXML
    private JFXCheckBox samedi;
    @FXML
    private JFXCheckBox mercredi;
    @FXML
    private JFXCheckBox jeudi;
    @FXML
    private JFXCheckBox dimanche;
    @FXML
    private Label worktimel1;
    @FXML
    private Label worktimel11;
    @FXML
    private JFXTextField codepostal;
    @FXML
    private JFXTextField namePasty;
    @FXML
    private JFXTimePicker timeStart;
    @FXML
    private JFXTimePicker timeEnd;
    @FXML
    private Label lastnamel;
    @FXML
    private Label maill;
    @FXML
    private Label pwdl;
    @FXML
    private Label phonel;
    @FXML
    private JFXTextField website;
    @FXML
    private JFXTextField facebook;
    @FXML
    private JFXCheckBox sale;
    @FXML
    private JFXCheckBox sucre;
    @FXML
    private JFXCheckBox livraison;
    @FXML
    private JFXCheckBox Reservation;
    @FXML
    private JFXCheckBox importer;
    @FXML
    private JFXCheckBox autre;
    @FXML
    private JFXCheckBox espece;
    @FXML
    private JFXCheckBox carteBanquaire;
    @FXML
    private JFXCheckBox cheque;
    @FXML
    private JFXCheckBox withOutSucre;
    @FXML
    private JFXCheckBox withOutGluten;
    @FXML
    private JFXTextField latitude;
    @FXML
    private JFXTextField longitude;
    @FXML
    private Label website1;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXButton ok;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           ProfilePastryController profile = new ProfilePastryController();
           profile.setListe(ServicePatisserieBd.profilePatissier("md.masmoudi"));
           firstname.setText(profile.getListe().get(0));
           lastname.setText(profile.getListe().get(1));
           namePasty.setText(profile.getListe().get(2));
           town.setText(profile.getListe().get(4));
           address.setText(profile.getListe().get(6));
           codepostal.setText(profile.getListe().get(11));
           phone.setText(profile.getListe().get(3));
           website.setText(profile.getListe().get(12));
           facebook.setText(profile.getListe().get(13));
           longitude.setText(profile.getListe().get(17));
           latitude.setText(profile.getListe().get(16));
           
           
           

        
      
        

// TODO
    }    

    @FXML
    private void retourAffiche(ActionEvent event) {
         Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/ProfilePastry.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
        Scene scene = new Scene(root);
        Stage stage  = new Stage();
        stage.setScene(scene);
        stage.show();
        retour.getScene().getWindow().hide();
    }

    @FXML
    private void enregistrer(ActionEvent event) {
         Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/ProfilePastry.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
        Scene scene = new Scene(root);
        Stage stage  = new Stage();
        stage.setScene(scene);
        stage.show();
        ok.getScene().getWindow().hide();
    }
    
}
