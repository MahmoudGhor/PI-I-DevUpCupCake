/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pi.idevup.cupcake.services.AdminService;

/**
 * FXML Controller class
 *
 * @author Amine Sboui
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private AnchorPane Homepane;
    @FXML
    private Label labelhome;
    @FXML
    private Separator sep;
    @FXML
    private VBox vboxx;
    @FXML
    private HBox hbx;
    @FXML
    private Label messageL;
    @FXML
    private HBox hbxx;
    @FXML
    private HBox hbxxx;
    @FXML
    private Label AlertL;
    @FXML
    private Label likeL;
    @FXML
    private Label commentL;
    @FXML
    private Label messageLp;
    @FXML
    private Label uploadLp;
    @FXML
    private Label likesLp;
    @FXML
    private Label InfectL;
    @FXML
    private Label clientL;
    @FXML
    private Label produitL;
    @FXML
    private Label recipeL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CollectData();
        // TODO
    }

    AdminService as = new AdminService();

    public void CollectData() {
        InfectL.setText(String.valueOf(as.get_Number_Infec()));
        clientL.setText(String.valueOf(as.get_Number_Client()));
        produitL.setText(String.valueOf(as.get_Number_Product()));
        recipeL.setText(String.valueOf(as.get_Number_Recipe()));
        uploadLp.setText(String.valueOf(as.get_Number_Upload()));
        messageL.setText(String.valueOf(as.get_Number_Message()));
        messageLp.setText(String.valueOf(as.get_Number_Message()));
        likeL.setText(String.valueOf(as.get_Number_Likes()));
        likesLp.setText(String.valueOf(as.get_Number_Likes()));
        commentL.setText(String.valueOf(as.get_Number_Comment()));
        AlertL.setText(String.valueOf(as.get_Number_Alerts()));
    }

}
