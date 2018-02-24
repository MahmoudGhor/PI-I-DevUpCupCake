/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;
import java.util.ArrayList;
import java.util.List;
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
import pi.idevup.cupcake.entities.Product;
import pi.idevup.cupcake.services.ProduitPatissier;

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
    private Button addP;
    @FXML
    private ToggleGroup dispo;
    @FXML
    private ToggleGroup unite;
    @FXML
    private ToggleGroup type;
    @FXML
    private ImageView view;
    @FXML
    private Label champvide4;
    @FXML
    private Label champvide3;
    @FXML
    private Label champvide2;
    @FXML
    private Label champvide1;
    @FXML
    private Label nameexist;
    
    boolean dispoP = true;
    String uniteP ="par piéce";
    String typeP ="sucré";
    List <String> lstFile;
    
    private static String nameProduct;
    private static String descrip;
    private static String photoUrl;
    private static String disponibilite;
    private static String prixPro;
    private static String unitePro;
    private static String typepro;

    public TextField getPhoto() {
        return photo;
    }

    public void setPhoto(TextField photo) {
        this.photo = photo;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      lstFile = new ArrayList<>();
        lstFile.add("*.png");
        lstFile.add("*.jpg");
    }    
   

    @FXML
    private void addProduit(ActionEvent event) throws IOException {
       
        System.out.println("amal");
        int i =1;
        String nomP = nom.getText();
        String descriptionP =description.getText();
        String photoP = photo.getText();
        String prixP=prix.getText();
        ProduitPatissier crud = new ProduitPatissier();
//        System.out.println(Float.parseFloat(prixP));
        String username="omri_amal";
        boolean exist = crud.productUnique(username,nomP);
        
        if (!exist)
        {
            nameexist.setText("Nom du produit existe deja ");  
            i=1;
        }
        else i=0;
        
         if ("".equals(nomP))
        {
            champvide1.setText("champ obligatoire");  
            i=1;
        }
        else i=0;
        
        if ("".equals(descriptionP))
        {
            champvide2.setText("champ obligatoire");  
            i=1;
        }
        else i=0;
        
        
         if ("".equals(photoP))
        {
            champvide3.setText("champ obligatoire");
            i=1;
        }
         else i=0;
         
        if ("".equals(prixP))
        {
            champvide4.setText("champ obligatoire");  
            i=1;
        }
        else i=0;
         //if (type(Float.parseFloat(prixP))==float)
  
        if (i==0){
            System.out.println("ali");
        Product p = new Product(nomP,descriptionP,photoP,dispoP,typeP,Integer.parseInt(prixP),uniteP);
        
        nameProduct=nomP;
        descrip=descriptionP;
        photoUrl=photoP;
        prixPro=prixP;
        unitePro=uniteP;
        typepro=typeP; 
        if(dispoP){ disponibilite="disponible";}
        else disponibilite="Non disponible";
        
        crud.add(p);

        
        /*nom.setText("");
        description.setText("");
        prix.setText("");
        photo.setText("");
        disponible_oui.setSelected(true);
        piece.setSelected(true);
        sucre.setSelected(true);
        view.setImage(null);*/
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherProduit.fxml"));
        Parent root = loader.load();
        addP.getScene().setRoot(root);

          }
        else System.out.println("aaa");
     
        } 

    @FXML
    private void dispon(ActionEvent event) {
        disponible_oui.setOnAction(actionEvent -> {  dispoP=true; });
        

    }
       @FXML
    private void nondispon(ActionEvent event) {
        disponible_non.setOnAction(actionEvent -> {  dispoP=false; });
    }
    


    @FXML
    private void changeUnite(ActionEvent event) {
        piece.setOnAction(actionEvent -> {  uniteP="par piéce"; });
       
    }
      @FXML
    private void changeUniteKilo(ActionEvent event) {
         kilogramme.setOnAction(actionEvent -> {  uniteP="kilogramme"; });
    }

    @FXML
    private void changeUniteLit(ActionEvent event) {
         littre.setOnAction(actionEvent -> {  uniteP="littre"; });
    }

    @FXML
    private void changeType(ActionEvent event) {
        sucre.setOnAction(actionEvent -> {  typeP="sucré"; });
       
        
        
    }
     @FXML
    private void changeTypeSale(ActionEvent event) {
         sale.setOnAction(actionEvent -> {  typeP="salé"; });
    }

    @FXML
    private void changeTypeSucreSale(ActionEvent event) {
        sucre.setOnAction(actionEvent -> {  typeP="sucré Salé"; });
    }

    @FXML
    private void addPictures(ActionEvent event) throws MalformedURLException {
        
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

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public static String getPhotoUrl() {
        return photoUrl;
    }

    public static void setPhotoUrl(String photoUrl) {
        AjouterProduitController.photoUrl = photoUrl;
    }

    public static String getDisponibilite() {
        return disponibilite;
    }

    public static void setDisponibilite(String disponibilite) {
        AjouterProduitController.disponibilite = disponibilite;
    }

    public static String getPrixPro() {
        return prixPro;
    }

    public static void setPrixPro(String prixPro) {
        AjouterProduitController.prixPro = prixPro;
    }

    public static String getUnitePro() {
        return unitePro;
    }

    public static void setUnitePro(String unitePro) {
        AjouterProduitController.unitePro = unitePro;
    }

    public static String getTypepro() {
        return typepro;
    }

    public static void setTypepro(String typepro) {
        AjouterProduitController.typepro = typepro;
    }

    public static String getDescrip() {
        return descrip;
    }

    public static void setDescrip(String descrip) {
        AjouterProduitController.descrip = descrip;
    }

    @FXML
    private void addPictures(MouseEvent event) {
    }

  

 
    
   
    
}