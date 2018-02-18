/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;
import java.util.ArrayList;
import java.util.List;
import pi.idevup.cupcake.entities.Product;
import pi.idevup.cupcake.services.ProduitPatissier;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.MalformedURLException;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author omri_
 * 
 */
public class AjouterProduitController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextArea description;
    @FXML
    private RadioButton disponible_oui;
    @FXML
    private RadioButton disponible_non;
    @FXML
    private TextField prix;
    @FXML
    private RadioButton piece;
    @FXML
    private TextField photo;
    @FXML
    private RadioButton kilogramme;
    @FXML
    private RadioButton littre;
    @FXML
    private RadioButton sucre;
    @FXML
    private RadioButton sale;
    @FXML
    private RadioButton sucreSale;
    @FXML
    private Button upload;
    @FXML
    private Button addP;
    @FXML
    private ToggleGroup dispo;
    @FXML
    private ToggleGroup unite;
    @FXML
    private ToggleGroup type;
    
    boolean dispoP = true;
    String uniteP ="par piéce";
    String typeP ="sucré";
    List <String> lstFile;
    
    @FXML
    private ImageView view;
    @FXML
    private Button plus;
    @FXML
    private Label champvide4;
    @FXML
    private Label champvide3;
    @FXML
    private Label champvide2;
    @FXML
    private Label champvide1;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      lstFile = new ArrayList<>();
        lstFile.add("*.png");
        lstFile.add("*.jpg");
    }    

    @FXML
    private void addPictures(ActionEvent event) throws MalformedURLException
    {
        
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("word file", lstFile));
        File f = fc.showOpenDialog(null);
        
        if (f!=null)
        {
            photo.setText(f.getAbsolutePath());
            Image image = new Image(f.toURI().toURL().toString());
            view.setImage(image) ;
        } 
        
        
    }

    @FXML
    private void addProduit(ActionEvent event) throws IOException {
        System.out.println("amal");
        int i =1;
        String nomP = nom.getText();
        String descriptionP =description.getText();
        String photoP = photo.getText();
        String prixP=prix.getText();
        
//        
//        System.out.println(Float.parseFloat(prixP));
        if ("".equals(nom.getText()))
        {
            champvide1.setText("champ obligatoire");  
            i=1;
        }
        else
        {
        i=0;
        }
        if ("".equals(description.getText()))
        {
            champvide2.setText("champ obligatoire");  
            i=1;
        }
        else i=0;
         if ("".equals(photo.getText()))
        {
            champvide3.setText("champ obligatoire");
            i=1;
        }
         else i=0;
        if ("".equals(prix.getText()))
        {
            champvide4.setText("champ obligatoire");  
            i=1;
        }
        else i=0;
         //if (type(Float.parseFloat(prixP))==float)
  
        if (i==0){
            System.out.println("ali");
        Product p = new Product(nomP,descriptionP,photoP,dispoP,typeP,Float.parseFloat(prixP),uniteP);
        ProduitPatissier crud = new ProduitPatissier();
        crud.add(p);
        //nom.setText("");
        //description.setText("");
        //prix.setText("");
        //photo.setText("");
        //disponible_oui.setSelected(true);
        //piece.setSelected(true);
        //sucre.setSelected(true);
        //view.setImage(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficheAfterAdd.fxml"));
        Parent root = loader.load();
        addP.getScene().setRoot(root);
          }
        else System.out.println("aaa");
     
        } 

    @FXML
    private void dispon(ActionEvent event) {
        disponible_oui.setOnAction(actionEvent -> {  dispoP=true; });
        disponible_non.setOnAction(actionEvent -> {  dispoP=false; });

    }

    @FXML
    private void changeUnite(ActionEvent event) {
        piece.setOnAction(actionEvent -> {  uniteP="par piéce"; });
        kilogramme.setOnAction(actionEvent -> {  uniteP="kilogramme"; });
        littre.setOnAction(actionEvent -> {  uniteP="littre"; });
    }

    @FXML
    private void changeType(ActionEvent event) {
        sucre.setOnAction(actionEvent -> {  typeP="sucré"; });
        sale.setOnAction(actionEvent -> {  typeP="salé"; });
        sucre.setOnAction(actionEvent -> {  typeP="sucré Salé"; });
        
    }

    @FXML
    private void addPic(ActionEvent event)throws MalformedURLException
    {
        

        } 
    }
        
    

    

