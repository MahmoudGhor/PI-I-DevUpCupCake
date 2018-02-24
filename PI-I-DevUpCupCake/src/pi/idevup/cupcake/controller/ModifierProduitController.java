/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author omri_
 */
public class ModifierProduitController implements Initializable {

    @FXML
    private TextField n;
    @FXML
    private TextField im;
    @FXML
    private TextField pri;
    @FXML
    private TextArea des;
    @FXML
    private RadioButton disponible_oui;
    @FXML
    private ToggleGroup dispo;
    @FXML
    private RadioButton disponible_non;
    @FXML
    private RadioButton piece;
    @FXML
    private ToggleGroup unite;
    @FXML
    private RadioButton kilogramme;
    @FXML
    private RadioButton littre;
    @FXML
    private RadioButton sucre;
    @FXML
    private ToggleGroup type;
    @FXML
    private RadioButton sale;
    @FXML
    private RadioButton sucreSale;
    @FXML
    private ImageView view;
    @FXML
    private Button addP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
         n.setText(AfficherProduitController.getNom());
         des.setText(AfficherProduitController.getDescript());
         pri.setText(AfficherProduitController.getPrixx());
         
  
        // des.setText(AfficherProduitController.getDescription());
        
       
    }    

    @FXML
    private void dispon(ActionEvent event) {
    }

    @FXML
    private void nondispon(ActionEvent event) {
    }

    @FXML
    private void changeUnite(ActionEvent event) {
    } 

    @FXML
    private void changeUniteKilo(ActionEvent event) {
    }

    @FXML
    private void changeUniteLit(ActionEvent event) {
    }

    @FXML
    private void updateProduit(ActionEvent event) {
    }

    @FXML
    private void changeType(ActionEvent event) {
    }

    @FXML
    private void changeTypeSale(ActionEvent event) {
    }

    @FXML
    private void changeTypeSucreSale(ActionEvent event) {
    }
    
}
