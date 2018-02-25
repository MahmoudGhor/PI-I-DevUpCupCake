/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Amine Sboui
 */
public class FXMLAdminController implements Initializable {

    @FXML
    private JFXButton btnHome;
    @FXML
    private AnchorPane holderPane;

    AnchorPane Home, Inbox, Client, Pastry, Product, Recipe, Alerts;
    @FXML
    private JFXButton btnAlerts;
    @FXML
    private JFXButton btnInbox;
    @FXML
    private JFXButton btnClients;
    @FXML
    private JFXButton btnPastry;
    @FXML
    private JFXButton btnProduct;
    @FXML
    private JFXButton btnRecipe;
    @FXML
    private JFXButton btnAdmin;
    @FXML
    private JFXButton logoutB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            setNode(FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLHome.fxml")));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void switchAlert(ActionEvent event) throws IOException {
        setNode(FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLHome.fxml")));
    }

    @FXML
    private void switchHome(ActionEvent event) throws IOException {
        setNode(FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLHome.fxml")));
    }

    @FXML
    private void switchInbox(ActionEvent event) throws IOException {
        setNode(FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLInbox.fxml")));
    }

    @FXML
    private void switchClient(ActionEvent event) throws IOException {
        setNode(FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLCRUDClient.fxml")));
    }

    @FXML
    private void switchPastry(ActionEvent event) throws IOException {
        setNode(FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLHome.fxml")));
    }

    @FXML
    private void switchProduct(ActionEvent event) throws IOException {
        setNode(FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLHome.fxml")));
    }

    @FXML
    private void switchRecipe(ActionEvent event) throws IOException {
        setNode(FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLHome.fxml")));
    }

    @FXML
    private void switchAdmin(ActionEvent event) throws IOException {
        setNode(FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLCrudAdmin.fxml")));
    }

    @FXML
    private void logout(ActionEvent event) {
        System.exit(0);
    }


}
