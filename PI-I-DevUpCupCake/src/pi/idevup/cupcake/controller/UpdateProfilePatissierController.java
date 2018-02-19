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
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pi.idevup.cupcake.entities.Patissier;
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
    @FXML
    private JFXCheckBox reservation;
        String picture,jt;
        List<String> listeFile;
         Map<Integer, String>  jourtravail= new TreeMap<>();
    Map <Integer, String> specialmap = new TreeMap<>();
    Map <Integer, String> servicemap = new TreeMap<>();
    Map <Integer, String> paymentmap = new TreeMap<>();
    Map <Integer, String> exigencemap = new TreeMap<>();
             
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           listeFile=new ArrayList<>();
       listeFile.add("*.pnj");
       listeFile.add("*.jpg");
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
            File f= new File(/*url de type string*/profile.getListe().get(5));
        
        try {
            picture=f.getAbsolutePath();
            Image image=new Image(f.toURI().toURL().toString());
     picId.setImage(image);
      
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProfilePastryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        String[] jourDeRepos = profile.getListe().get(8).split(",");
        if(jourDeRepos.length!=0){
        for (String jourDeRepo : jourDeRepos) {

            if (" Lundi".equals(jourDeRepo)) {
                lundi.setSelected(true);
            }
            if (" Mardi".equals(jourDeRepo)) {
                mardi.setSelected(true);
            }
              if (" Mercredi".equals(jourDeRepo)) {
                mercredi.setSelected(true);
            }
                if (" Jeudi".equals(jourDeRepo)) {
                    System.out.println("ali");
                jeudi.setSelected(true);
            }
                  if (" Vendredi".equals(jourDeRepo)) {
                vendredi.setSelected(true);
            }
                    if (" Samedi".equals(jourDeRepo)) {
                samedi.setSelected(true);
            }
                      if (" Dimanche".equals(jourDeRepo)) {
                dimanche.setSelected(true);
            }
           
        }
        
        }
        String[] nosSpecialite=profile.getListe().get(9).split(",");
        for(String nosSpec : nosSpecialite){
            if ("Salé".equals(nosSpec)) {
                sale.setSelected(true);
            }
                      if ("Sucré".equals(nosSpec)) {
                sucre.setSelected(true);     
                      }
        }
        String[] nosService=profile.getListe().get(10).split(",");
        
        for(String nosSpec : nosService){
            if ("Livraison".equals(nosSpec)) {
                livraison.setSelected(true);
            }
                      if ("Reservation".equals(nosSpec)) {
                reservation.setSelected(true);     
                      }
                      if ("Importer".equals(nosSpec)) {
                importer.setSelected(true);     
                      }
                      if ("autre".equals(nosSpec)) {
                autre.setSelected(true);     
                      }
        }
        String[] payment=profile.getListe().get(14).split(",");
        
        for(String nosSpec : payment){
            if ("Espéce".equals(nosSpec)) {
                espece.setSelected(true);
            }
                      if ("Carte Banquaire".equals(nosSpec)) {
                carteBanquaire.setSelected(true);     
                      }
                      if ("Cheque".equals(nosSpec)) {
                cheque.setSelected(true);     
                      }
               
        }
         String[] nosExigence=profile.getListe().get(15).split(",");
        
        for(String nosSpec : nosExigence){
            if ("Sans Sucre".equals(nosSpec)) {
                withOutSucre.setSelected(true);
            }
                      if ("sans Gluten".equals(nosSpec)) {
                withOutGluten.setSelected(true);     
                      }
                   
               
        }
        String[] horaireDeTravailtest=profile.getListe().get(7).split("De  ");
        String[] horaireDeTravail=horaireDeTravailtest[1].split(" à ");
             timeStart.getEditor().setText(horaireDeTravail[0]);
             timeEnd.getEditor().setText(horaireDeTravail[1]);
        
           
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
                    
            if( lundi.isSelected()){
           jourtravail.put(1,"Lundi");
        }
           if(mardi.isSelected()){
                            jourtravail.put(2,"Mardi");
         

           }
           if(mercredi.isSelected()){
           jourtravail.put(3,"Mercredi");

           }
            if(jeudi.isSelected()){
                                          
 jourtravail.put(4,"Jeudi");
           }
             if(vendredi.isSelected()){
 jourtravail.put(5,"Vendredi");
           }
              if(samedi.isSelected()){
 jourtravail.put(6,"Samedi");
           }
               if(dimanche.isSelected()){
 jourtravail.put(7,"Dimanche");
           }
                             jt =  jourtravail.values().stream().reduce("",(a,b)-> a +" "+b );
                             if(sale.isSelected()){
             specialmap.put(1,"Salé");
         }
             if(sucre.isSelected()){
             specialmap.put(2,"Sucré");
            }
             
            if(livraison.isSelected()){
             servicemap.put(1,"Livraison");

            }
             if(reservation.isSelected()){
             servicemap.put(2,"Reservation");

             }
              if(importer.isSelected()){
             servicemap.put(3,"Importer");
            }
               if(autre.isSelected()){
             servicemap.put(4,"autre");
            }
               if(espece.isSelected()){
                                paymentmap.put(1,"Espéce");

               }
               if(carteBanquaire.isSelected()){
             paymentmap.put(2,"Carte Banquaire");

               }
                if(cheque.isSelected()){
             paymentmap.put(3,"Cheque");

                }
                if(withOutSucre.isSelected()){
             exigencemap.put(1,"Sans Sucre");
               }
                if(withOutGluten.isSelected()){
             exigencemap.put(2,"sans Gluten");
               }
             String service =  servicemap.values().stream().reduce("",(a,b)-> a +","+b );
             String specialte =  specialmap.values().stream().reduce("",(a,b)-> a +","+b );
             String meansOfPayment =  paymentmap.values().stream().reduce("",(a,b)-> a +","+b );
             String exigence =  exigencemap.values().stream().reduce("",(a,b)-> a +","+b );
            
             picture=picture.replaceAll("\\\\", "/");
              if ((!"".equals(specialte))&&(!"".equals(service))&&(!"".equals(meansOfPayment))&&(!"".equals(latitude.getText()))&&(!"".equals(longitude.getText())) && (!"".equals(firstname.getText())) && (!"".equals(lastname.getText()))  && (!"".equals(phone.getText())) && ((!"".equals(town.getText())) && (!"".equals(address.getText())))   && ((!"".equals(codepostal.getText())) && (!"".equals(namePasty.getText()))))

        {            

                              Patissier p = new Patissier("md.masmoudi", firstname.getText(), lastname.getText(), phone.getText(),town.getText(),address.getText(),codepostal.getText(),picture , facebook.getText(),namePasty.getText(), "De  "+timeStart.getEditor().getText()+" à "+timeEnd.getEditor().getText(), jt, specialte, service, website.getText(), meansOfPayment, exigence, latitude.getText(), longitude.getText() );
                              ServicePatisserieBd.updatePatissier(p, "md.masmoudi");
                               System.out.println("ali++");
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
              else {
                  Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle(null);
alert.setHeaderText("   Vérifier vos champs  ");
alert.setContentText(null);

alert.showAndWait();
              }
}

    @FXML
    private void updatePic(MouseEvent event) throws MalformedURLException {
        FileChooser fc = new FileChooser();
       // System.out.println("0");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("word file", listeFile));
       // System.out.println("1");
        File f = fc.showOpenDialog(null);
        
        if (f!=null)
        {   picture=f.getAbsolutePath();
            Image image = new Image(f.toURI().toURL().toString());
            picId.setImage(image) ;
        }
    }
    
}