/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AddPastyController implements Initializable {

    @FXML
    private JFXButton suivant;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField mail;
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
    private JFXPasswordField pswd;
    @FXML
    private JFXPasswordField pswd_verif;
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
    private JFXTimePicker worktime;
    @FXML
    private Label worktimel1;
    @FXML
    private Label worktimel11;
    @FXML
    private JFXTimePicker worktime1;
    @FXML
    private JFXTextField codepostal;
    @FXML
    private JFXTextField namePasty;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nextPage(ActionEvent event) {
    }

    @FXML
    private void selectLundi(ActionEvent event) {
    }

    @FXML
    private void selectMardi(ActionEvent event) {
    }

    @FXML
    private void selectVendredi(ActionEvent event) {
    }

    @FXML
    private void selectSamedi(ActionEvent event) {
    }

    @FXML
    private void selectMercredi(ActionEvent event) {
    }

    @FXML
    private void selectJeudi(ActionEvent event) {
    }

    @FXML
    private void selectDimanche(ActionEvent event) {
    }
    
}
