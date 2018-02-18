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
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import pi.idevup.cupcake.entities.Patissier;
import pi.idevup.cupcake.services.ServicePatisserieBd;
import pi.idevup.cupcake.services.ServiceUserBd;
import pi.idevup.cupcake.services.serviceCryptage;

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
    
    private String usernamebd ;
    @FXML
    private JFXTextField firstname;
    
    private String firstnamebd;

    @FXML
    private JFXTextField lastname;
        private String lastnamebd;
    @FXML
    private JFXTextField mail;
        private String mailbd;
    @FXML
    private JFXTextField phone;
    private String phonebd;
    
    @FXML
    private JFXTextField town;
    private String townbd;
    @FXML
    private Label worktimel;
    @FXML
    private Label dayoff;
    @FXML
    private JFXTextField address;
    private String addressbd;
    @FXML
    private JFXPasswordField pswd;
    private String mdp;
    
    @FXML
    private JFXPasswordField pswd_verif;
        private String mdp_verif;

    
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
        private String worktimeStart;

    @FXML
    private Label worktimel1;
    @FXML
    private Label worktimel11;
    @FXML
    private AnchorPane part1;
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
    @FXML
    private AnchorPane part2;
    @FXML
    private JFXTimePicker timeStart;
    @FXML
    private JFXTimePicker timeEnd;
    @FXML
    private Label er1;
    @FXML
    private Label er2;
    @FXML
    private Label er3;
    @FXML
    private Label er4;
    @FXML
    private Label er5;
    @FXML
    private Label er6;
    @FXML
    private Label er7;
    @FXML
    private Label er8;
    @FXML
    private Label er9;
    @FXML
    private Label er10;
    @FXML
    private Label er11;
    @FXML
    private Label er13;
    @FXML
    private  ImageView valide;
    
    @FXML
    private  ImageView valide2;
    @FXML
    private Label er14;
    @FXML
    private Label er15;
    @FXML
    private Label er16;
    @FXML
    private Label er18;
    @FXML
    private Label er17;
    String jt;
    String picture;
    @FXML
    private Label er12;

    public Label getEr1() {
        return er1;
    }

    public void setEr1(Label er1) {
        this.er1 = er1;
    }

    public Label getEr2() {
        return er2;
    }

    public void setEr2(Label er2) {
        this.er2 = er2;
    }

    public Label getEr3() {
        return er3;
    }

    public void setEr3(Label er3) {
        this.er3 = er3;
    }

    public Label getEr4() {
        return er4;
    }

    public void setEr4(Label er4) {
        this.er4 = er4;
    }

    public Label getEr5() {
        return er5;
    }

    public void setEr5(Label er5) {
        this.er5 = er5;
    }

    public Label getEr6() {
        return er6;
    }

    public void setEr6(Label er6) {
        this.er6 = er6;
    }

    public Label getEr7() {
        return er7;
    }

    public void setEr7(Label er7) {
        this.er7 = er7;
    }

    public Label getEr8() {
        return er8;
    }

    public void setEr8(Label er8) {
        this.er8 = er8;
    }

    public Label getEr9() {
        return er9;
    }

    public void setEr9(Label er9) {
        this.er9 = er9;
    }

    public Label getEr10() {
        return er10;
    }

    public void setEr10(Label er10) {
        this.er10 = er10;
    }

    public Label getEr11() {
        return er11;
    }

    public void setEr11(Label er11) {
        this.er11 = er11;
    }

    public Label getEr13() {
        return er13;
    }

    public void setEr13(Label er13) {
        this.er13 = er13;
    }

    public String getWorktimeStart() {
        return worktimeStart;
    }

    public void setWorktimeStart(String worktimeStart) {
        this.worktimeStart = worktimeStart;
    }

    public String getWorktimeEnd() {
        return worktimeEnd;
    }

    public void setWorktimeEnd(String worktimeEnd) {
        this.worktimeEnd = worktimeEnd;
    }
    private String worktimeEnd;
    @FXML
    private JFXTextField codepostal;
    private String codepostalebd;
    @FXML
    private JFXTextField namePasty;
    private String namePastybd;
    String dayOFF;
    List<String> listeFile;
    
    public String getUsernamebd() {
        return usernamebd;
        
    }    

    public void setUsernamebd(String usernamebd) {
        this.usernamebd = usernamebd;
    }

    public String getFirstnamebd() {
        return firstnamebd;
    }

    public void setFirstnamebd(String firstnamebd) {
        this.firstnamebd = firstnamebd;
    }

    public String getLastnamebd() {
        return lastnamebd;
    }

    public void setLastnamebd(String lastnamebd) {
        this.lastnamebd = lastnamebd;
    }

    public String getMailbd() {
        return mailbd;
    }

    public void setMailbd(String mailbd) {
        this.mailbd = mailbd;
    }

    public String getPhonebd() {
        return phonebd;
    }

    public void setPhonebd(String phonebd) {
        this.phonebd = phonebd;
    }

    public String getTownbd() {
        return townbd;
    }

    public void setTownbd(String townbd) {
        this.townbd = townbd;
    }

    public String getAddressbd() {
        return addressbd;
    }

    public void setAddressbd(String addressbd) {
        this.addressbd = addressbd;
    }

    public String getCodepostalebd() {
        return codepostalebd;
    }

    public void setCodepostalebd(String codepostalebd) {
        this.codepostalebd = codepostalebd;
    }

    public String getNamePastybd() {
        return namePastybd;
    }

    public void setNamePastybd(String namePastybd) {
        this.namePastybd = namePastybd;
    }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       listeFile=new ArrayList<>();
       listeFile.add("*.pnj");
       listeFile.add("*.jpg");
        valide.setVisible(false);
                                part2.setVisible(false);
                                part1.setVisible(true);
                                er1.setVisible(false);
                                er2.setVisible(false);
                                er3.setVisible(false);
                                er4.setVisible(false);
                                er5.setVisible(false);
                                er6.setVisible(false);
                                er8.setVisible(false);
                                er10.setVisible(false);
                                er9.setVisible(false);
                                er11.setVisible(false);
                                er7.setVisible(false);
                                er13.setVisible(false);
                                er14.setVisible(false);
                                er15.setVisible(false);
                                er16.setVisible(false);
                                er17.setVisible(false);
                                er18.setVisible(false);
                                er12.setVisible(false);
        
    }    
    Map<Integer, String>  jourtravail= new TreeMap<>();
    Map <Integer, String> specialmap = new TreeMap<>();
    Map <Integer, String> servicemap = new TreeMap<>();
    Map <Integer, String> paymentmap = new TreeMap<>();
    Map <Integer, String> exigencemap = new TreeMap<>();
    
    @FXML
    private void nextPage(ActionEvent event) {
   
        if(("".equals(namePasty.getText())))er1.setVisible(true); else er1.setVisible(false);
        if(("".equals(username.getText())))er2.setVisible(true); else er2.setVisible(false);
     if(!ServiceUserBd.usernameUnique(username.getText()))er12.setVisible(true);else er12.setVisible(false);
        if("".equals(firstname.getText()))er3.setVisible(true); else er3.setVisible(false);
        if("".equals(lastname.getText())) er4.setVisible(true); else er4.setVisible(false);
        if("".equals(mail.getText()))er5.setVisible(true);else er5.setVisible(false);
        if("".equals(pswd.getText())) er6.setVisible(true);else er6.setVisible(false);
         if("".equals(pswd_verif.getText()))
                           er7.setVisible(true);else er7.setVisible(false);
  
        if("".equals(phone.getText()))er8.setVisible(true);else er8.setVisible(false);
  
         if("".equals(town.getText()))er9.setVisible(true);else er9.setVisible(false);
        if("".equals(address.getText()))
                                      er10.setVisible(true);else er10.setVisible(false);
        if("".equals(codepostal.getText()))
          er11.setVisible(true);else er11.setVisible(false);
   
                                    
          if(("".equals(timeEnd.getEditor().getText())) || (timeStart.getEditor().getText().equals("")))
                                 er13.setVisible(true);else er13.setVisible(false);
//                                     
                                           
      //  
            if ( (ServiceUserBd.mailUnique(mail.getText())) &&(ServiceUserBd.usernameUnique(username.getText()))&&((pswd.getText().equals(pswd_verif.getText())) && (!"".equals(firstname.getText())) ) && ( (!"".equals(username.getText()))&& (!"".equals(lastname.getText()))) && ((!"".equals(mail.getText())) && (!"".equals(phone.getText()))) && ((!"".equals(town.getText())) && (!"".equals(address.getText()))) && ((!"".equals(pswd.getText())) && (!"".equals(pswd_verif.getText()))) && ((!"".equals(codepostal.getText())) && (!"".equals(namePasty.getText())))){

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
                 townbd=town.getText().replaceFirst(".",(""+town.getText().charAt(0)).toUpperCase());
              mailbd=mail.getText().toLowerCase();
          usernamebd=username.getText();
          firstnamebd=firstname.getText().replaceFirst(".",(""+firstname.getText().charAt(0)).toUpperCase());
          lastnamebd=lastname.getText().replaceFirst(".",(""+lastname.getText().charAt(0)).toUpperCase());
          phonebd=phone.getText();
          addressbd=address.getText();
          codepostalebd=codepostal.getText();
          namePastybd=namePasty.getText().replaceFirst(".",(""+namePasty.getText().charAt(0)).toUpperCase());
          worktimeStart=timeStart.getEditor().getText();
          worktimeEnd=timeEnd.getEditor().getText();
          serviceCryptage crypt = new serviceCryptage();
            mdp = serviceCryptage.cryptWithMD5(pswd.getText());
            mdp_verif=serviceCryptage.cryptWithMD5(pswd.getText());
            worktimeEnd="De  "+worktimeStart+" à "+worktimeEnd;
           System.out.println("ali");
           System.out.println(mdp);
           System.out.println(lastnamebd);
           System.out.println(worktimeEnd);
               
           part1.setVisible(false);
                part2.setVisible(true);
//                Patissier pa = new Patissier(usernamebd, mailbd, mailbd, firstnamebd, lastnamebd, phonebd, townbd, addressbd, lastnamebd, phonebd, mailbd, mdp_verif, worktimeEnd, mailbd, usernamebd, usernamebd, mailbd, lastnamebd, worktimeEnd, mailbd, mailbd);
//                ServicePatisserieBd.insertPatissier(pa);
//          
   }
              
                                             
    }


    @FXML
    private void signIn(ActionEvent event) {
         
  
         if(sale.isSelected()){
             specialmap.put(1,"Salé");
         }
             if(sucre.isSelected()){
             specialmap.put(2,"Sucré");
            }
             
            if(livraison.isSelected()){
             servicemap.put(1,"Livraison");

            }
             if(Reservation.isSelected()){
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
             if("".equals(specialte)) er14.setVisible(true); else er14.setVisible(false);
        if("".equals(service))er15.setVisible(true);else er15.setVisible(false);
        if("".equals(meansOfPayment)) er16.setVisible(true);else er16.setVisible(false);
         if("".equals(latitude.getText()))
                           er17.setVisible(true);else er17.setVisible(false);
  
        if("".equals(longitude.getText()))er18.setVisible(true);else er18.setVisible(false);
             System.out.println(service);
             if((!"".equals(specialte))&&(!"".equals(service))&&(!"".equals(meansOfPayment))&&(!"".equals(latitude.getText()))&&(!"".equals(longitude.getText()))){
                 Patissier p = new Patissier(usernamebd, mailbd, mdp, firstnamebd, lastnamebd, phonebd,townbd,addressbd,codepostalebd,picture , facebook.getText(),namePasty.getText(), worktimeEnd, jt, specialte, service, website.getText(), meansOfPayment, exigence, latitude.getText(), longitude.getText() );
                 
                 ServicePatisserieBd.insertPatissier(p);
                 
                 System.out.println("ali");
                 
                 
                 
             }
    }


    @FXML
    private void retourPage(ActionEvent event) {
        part2.setVisible(false);
        part1.setVisible(true);
        
        
    }


    @FXML
    private void selectPic(MouseEvent event) throws MalformedURLException{
        System.out.println("ali");
        FileChooser fc = new FileChooser();
       // System.out.println("0");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("word file", listeFile));
       // System.out.println("1");
        File f = fc.showOpenDialog(null);
        
        if (f!=null)
        {   picture=f.getAbsolutePath();
            Image image = new Image(f.toURI().toURL().toString());
            pic.setImage(image) ;
        }
    }

    @FXML
    private void verifPswd(KeyEvent event) {
               if(pswd.getText().equals(pswd_verif.getText()))  {
                                              File file = new File("src/pi/idevup/cupcake/images/ok.png");
                                                Image image = new Image(file.toURI().toString());
                                                valide.setImage(image);
                                                valide2.setImage(image);
                                                valide.setVisible(true);
                                                valide2.setVisible(true);
                                             
                                         } else{
                                          File file = new File("src/pi/idevup/cupcake/images/warning.png");
                                                Image image = new Image(file.toURI().toString());
                                                valide.setImage(image);
                                                valide2.setImage(image);
                                                 valide.setVisible(true);
                                                valide2.setVisible(true);
                                             
         }
       
    }



    
}
