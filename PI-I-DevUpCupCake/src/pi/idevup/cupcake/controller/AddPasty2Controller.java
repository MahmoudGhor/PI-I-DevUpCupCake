/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AddPasty2Controller implements Initializable {

    @FXML
    private Label lastnamel;
    @FXML
    private Label maill;
    @FXML
    private Label pwdl;
    @FXML
    private Label phonel;
    @FXML
    private JFXButton signin;
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
    private JFXButton retour;
    @FXML
    private Label website1;
    @FXML
    private JFXCheckBox withOutSucre;
    @FXML
    private JFXCheckBox withOutGluten;
    @FXML
    private JFXTextField latitude;
    @FXML
    private JFXTextField longitude;
    @FXML
    private Label phonel1;
    @FXML
    private ImageView pic;
    @FXML
    private JFXButton addPic;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signIn(ActionEvent event) {
    }

    @FXML
    private void selectSale(ActionEvent event) {
    }

    @FXML
    private void selectSucre(ActionEvent event) {
    }

    @FXML
    private void selectLivraison(ActionEvent event) {
    }

    @FXML
    private void selectReservation(ActionEvent event) {
    }

    @FXML
    private void selectImporter(ActionEvent event) {
    }

    @FXML
    private void selectAutre(ActionEvent event) {
    }

    @FXML
    private void selectEspece(ActionEvent event) {
    }

    @FXML
    private void selectCarte(ActionEvent event) {
    }

    @FXML
    private void selectCheque(ActionEvent event) {
    }

    @FXML
    private void retourPage(ActionEvent event) {
    }

    @FXML
    private void selectWithOutSucre(ActionEvent event) {
    }

    @FXML
    private void selectWithOutGluten(ActionEvent event) {
    }

    @FXML
    private void selectPic(ActionEvent event) {
    }
    
}
