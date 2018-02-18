/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pi.idevup.cupcake.services.ServicePatisserieBd;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ProfilePastryController implements Initializable {

    @FXML
    private Label namePastry;
    @FXML
    private Label address;
    @FXML
    private Label workTime;
    @FXML
    private Label dayOff;
    @FXML
    private Label phone;
    @FXML
    private Label website;
    @FXML
    private Label facebbok;
    @FXML
    private Label specialite;
    @FXML
    private Label service;
    @FXML
    private Label meansOfPayment;
    @FXML
    private Label exigence;
    @FXML
    private JFXButton produits;
    @FXML
    private JFXButton ajouterProduits;
    @FXML
    private JFXButton recettes;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton ajouterRecette;
    @FXML
    private Label responsable;
    @FXML
    private ImageView picId;
    private List<String> liste;

    public List<String> getListe() {
        return liste;
    }

    public void setListe(List<String> liste) {
        this.liste = liste;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         liste= ServicePatisserieBd.profilePatissier("md.masmoudi");
      responsable.setText("Nom de responsable: "+liste.get(0)+" "+liste.get(1) );
      namePastry.setText("Nom de patesserie: "+liste.get(2));
      address.setText("Mon adresse : "+liste.get(4)+", "+liste.get(6)+", "+liste.get(11));
      workTime.setText("Horaires de travail : \n"+liste.get(7));
     if("".equals(liste.get(8)))dayOff.setText("On travaille 7/7"); else dayOff.setText("Jour de repos: "+liste.get(8));
      phone.setText("Mon némuro : "+liste.get(3));
      website.setText("Notre site web : "+liste.get(12));
      facebbok.setText("Notre page facebook: "+liste.get(13));
      specialite.setText("Notre specialité : "+liste.get(9));
      service.setText("Notre service : "+liste.get(10));
      meansOfPayment.setText("Notre moyens de payment: "+liste.get(14));
     if("".equals(liste.get(15))) exigence.setVisible(false);else exigence.setText("On peut faire des commandes spécifiques : "+liste.get(15));
        System.out.println(liste.get(5));
        
        File f= new File(/*url de type string*/liste.get(5));
        
        try {
            Image image=new Image(f.toURI().toURL().toString());
     picId.setImage(image);
      
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProfilePastryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }    

    @FXML
    private void consulerProduits(ActionEvent event) {
        //amal
    }

    @FXML
    private void ajoutProduits(ActionEvent event) {
        //amal
    }

    @FXML
    private void consulterRecettes(ActionEvent event) {
        //dorra 
    }

    @FXML
    private void ajoutRecette(ActionEvent event) {
        //dorra
    }

    @FXML
    private void updateProfile(ActionEvent event) {
        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/UpdateProfilePatissier.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
        Scene scene = new Scene(root);
        Stage stage  = new Stage();
        stage.setScene(scene);
        stage.show();
        update.getScene().getWindow().hide();
        
    }
    
}
