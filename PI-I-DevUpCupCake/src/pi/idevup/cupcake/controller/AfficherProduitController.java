/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pi.idevup.cupcake.entities.Product;
import pi.idevup.cupcake.services.ProduitPatissier;

/**
 * FXML Controller class
 *
 * @author omri_
 */
public class AfficherProduitController implements Initializable {

    @FXML
    private Label prixlab;
    @FXML
    private ImageView image;
    @FXML
    private Label unitelab;
    @FXML
    private Label nomlab;
    @FXML
    private Label descriptionlab;
    @FXML
    private Label dispolab;
    @FXML
    private Label typelab;
    private static String nom;
    private static String descript; 
    private static String imgUrl;
    private static String prixx;

    public static String getDescript() {
        return descript;
    }

    public static void setDescript(String descript) {
        AfficherProduitController.descript = descript;
    }

  

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        AfficherProduitController.nom = nom;
    }

    public static String getImgUrl() {
        return imgUrl;
    }

    public static void setImgUrl(String imgUrl) {
        AfficherProduitController.imgUrl = imgUrl;
    }

    public static String getPrixx() {
        return prixx;
    }

    public static void setPrixx(String prixx) {
        AfficherProduitController.prixx = prixx;
    }
    
    
    /**
     * Initializes the controller class.
     */
    List<String> list;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AjouterProduitController aj= new AjouterProduitController();
        nomlab.setText(aj.getNameProduct());
        descriptionlab.setText(AjouterProduitController.getDescrip());
        typelab.setText(AjouterProduitController.getTypepro());
        unitelab.setText(AjouterProduitController.getUnitePro());
        prixlab.setText(AjouterProduitController.getPrixPro());
        dispolab.setText(AjouterProduitController.getDisponibilite());
        
        
      
        File file = new File(AjouterProduitController.getPhotoUrl());
        
            Image img;
        try {
            img = new Image(file.toURI().toURL().toString());
                        image.setImage(img) ;

        } catch (MalformedURLException ex) {
            Logger.getLogger(AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        // TODO
        
       
        // TODO
    }    

    
    @FXML
    private void updateProduct(ActionEvent event) throws IOException {
        descript= nomlab.getText();
        nom = descriptionlab.getText();
        prixx= prixlab.getText();
        imgUrl=AjouterProduitController.getPhotoUrl();
        
        File file = new File(AjouterProduitController.getPhotoUrl());
        
        
            //Image image = new Image(f.toURI().toURL().toString());
            //view.setImage(image) ;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierProduit.fxml"));
        Parent root = loader.load();
        nomlab.getScene().setRoot(root);
        
    }

    @FXML
    private void deleteProduct(ActionEvent event) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("suppression du produit '"+nomlab.getText()+"'");
        alert.setContentText("voulez-vous vraiment supprimer ce produit ?");

        Optional<ButtonType> result = alert.showAndWait();
       if (result.get() == ButtonType.OK)
       {   
           
           ProduitPatissier p= new ProduitPatissier();
           p.remove(nomlab.getText()); 
           System.out.println("product is deleted");
       } else {
            // ... user chose CANCEL or closed the dialog
           }
    }
    
}
