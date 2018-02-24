/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import pi.idevup.cupcake.entities.ReadRSS;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import pi.idevup.cupcake.entities.Client;
import pi.idevup.cupcake.entities.ContacterAdmin;
import pi.idevup.cupcake.entities.Mailing;
import pi.idevup.cupcake.entities.User;
import pi.idevup.cupcake.services.ServiceClientBd;
import pi.idevup.cupcake.services.ServiceContactAdmin;
import pi.idevup.cupcake.services.ServiceNotification;
import pi.idevup.cupcake.services.ServiceRandomMailConfirmation;
import pi.idevup.cupcake.services.ServiceSysdate;
import pi.idevup.cupcake.services.ServiceUserBd;
import pi.idevup.cupcake.services.serviceCryptage;

/**
 * FXML Controller class
 *
 * @author mahmo
 */
public class InterfaceClientController implements Initializable {

    @FXML
    private Pane paneflux;
    @FXML
    private Text jtext;
    @FXML
    private AnchorPane anchorModif;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField numeroTel;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextField codePostal;
    @FXML
    private JFXTextField Facebook;
    @FXML
    private JFXButton enregistrerInformationPersonnelle;
    @FXML
    private JFXButton annulerInformationPersonnelle;
    @FXML
    private JFXButton showInformationPersonnelle;
    @FXML
    private JFXButton btnChangerEmail;
    @FXML
    private AnchorPane anchorInformationPersonnelle;
    @FXML
    private JFXButton ModifierProfil;
    @FXML
    private AnchorPane anchorInformationLieAuCompte;
    @FXML
    private JFXButton Deconnexion;
    @FXML
    private ImageView imageProfil;
    @FXML
    private Label FirstLastName;
    
    ServiceClientBd servClient = new ServiceClientBd();
    serviceCryptage servCrypt = new serviceCryptage();
    ServiceContactAdmin contact = new ServiceContactAdmin();
    ServiceRandomMailConfirmation serviceMail = new ServiceRandomMailConfirmation();
    ServiceSysdate dateNow = new ServiceSysdate();
    @FXML
    private JFXButton showInformationCompte;
    @FXML
    private JFXTextField EmailActuelle;
    @FXML
    private JFXComboBox<String> ville;
    @FXML
    private JFXButton ChangerMailButton;
    @FXML
    private JFXButton btnChangerMotDePasse;
    @FXML
    private JFXPasswordField passwordActuelle;
    @FXML
    private JFXButton annulerInformationCompte;
    @FXML
    private JFXPasswordField newPassword;
    @FXML
    private JFXPasswordField newPassword1;
    @FXML
    private JFXButton buttonSaveNewPassword;
    @FXML
    private JFXButton UpdateImage;
    
    FileInputStream fis = null;
    File f=null;
    List<String> lstFile;
    @FXML
    private AnchorPane AnchroContacterAdmin;
    @FXML
    private JFXButton ButtonContacterAdmin;
    @FXML
    private JFXTextArea Description;
    @FXML
    private JFXButton buttonAjouter;

    
    

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        anchorModif.setVisible(false);
        AnchroContacterAdmin.setVisible(false);
        ObservableList<String> listeVille = FXCollections.observableArrayList(
        "Tunis","Sfax"
        );
        ville.setItems(listeVille);
        ReadRSS rss = new ReadRSS();
      //  System.out.println(rss.readRss("https://bonnenouvelle.fr/spip.php?page=backend"));
      jtext = new Text(10 , 50, "this");
      
      jtext.setText(rss.readRss("https://bonnenouvelle.fr/spip.php?page=backend"));
     //   jtext.setText("aaaaaaaaaaaaa eeeeeeeeeeeeeeee ijijf afoazufh zaopfzapoifhaozifhaozifh ozafh aozfhazoifhp azfhaz faizof haozi oooooooooooooooooooooooo kkkkkkkkkkkkkkkkkkkk jjjjjjjjjjjjjjjj ,,,,,,,,");
       //VBox root = new VBox(jtext);
      // jtext.setWrappingWidth(200);
       jtext.setTextOrigin(VPos.TOP);
       
        
    //    jtext.maxWidth(12);
       // paneflux=new Pane(jtext);
       // jtext.setFont(Font.font(24));
        double sceneWidth = paneflux.getWidth();
    double msgWidth = jtext.getLayoutBounds().getWidth();
      
    KeyValue initKeyValue = new KeyValue(jtext.translateXProperty(), sceneWidth);
    KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);

    KeyValue endKeyValue = new KeyValue(jtext.translateXProperty(),msgWidth);
    KeyFrame endFrame = new KeyFrame(Duration.seconds(10), endKeyValue);

    Timeline timeline = new Timeline(initFrame, endFrame);

    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
    
        
        Image im;
        try {
            //Image image = new Image("file:"+servClient.getImageClient(User.uName));
             im = servClient.getImage2(User.uName);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    im =new Image("file:photo.jpg",imageProfil.getFitWidth(),imageProfil.getFitHeight(),true,true);
    imageProfil.setImage(im);
    //imageProfil.setImage(image);
        FirstLastName.setText(servClient.getInfoClient(User.uName).getFirstname()+" "+servClient.getInfoClient(User.uName).getLastname());
                 lstFile = new ArrayList<>();
        lstFile.add("*.png");
        lstFile.add("*.jpg");
   
    }    

    @FXML
    private void informationPersonnelleClick(MouseEvent event) throws IOException{
       // setNode((FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/AnchoPaneInfoPersonnelle.fxml"))));
        anchorInformationLieAuCompte.setVisible(false);
        anchorInformationPersonnelle.setVisible(true);
        prenom.setText(servClient.getInfoClient(User.uName).getLastname());
        nom.setText(servClient.getInfoClient(User.uName).getFirstname());
        adresse.setText(servClient.getInfoClient(User.uName).getAddress());
        codePostal.setText(servClient.getInfoClient(User.uName).getPostalcode());
        numeroTel.setText(servClient.getInfoClient(User.uName).getPhone());
        ville.setValue(servClient.getInfoClient(User.uName).getTown());
        showInformationCompte.setVisible(false);
        
        
    }

    @FXML
    private void informationCompteClick(MouseEvent event) {
        anchorInformationPersonnelle.setVisible(false);
        anchorInformationLieAuCompte.setVisible(true);
        EmailActuelle.setVisible(false);
        ChangerMailButton.setVisible(false);
        passwordActuelle.setVisible(false);
        btnChangerMotDePasse.setVisible(true);
        showInformationPersonnelle.setVisible(false);
        newPassword.setVisible(false);
        newPassword1.setVisible(false);
        annulerInformationCompte.setVisible(false);
        buttonSaveNewPassword.setVisible(false);
    }

    @FXML
    private void modifierProfilClick(MouseEvent event) {
        anchorModif.setVisible(true);
        showInformationCompte.setVisible(true);
        showInformationPersonnelle.setVisible(true);
        anchorInformationLieAuCompte.setVisible(false);
        anchorInformationPersonnelle.setVisible(false);
        
    }

    @FXML
    private void deconnection(MouseEvent event) throws IOException{
              Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/SignIn.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        User.uName="";
        Scene scene = new Scene(root);
        Stage stage  = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        anchorModif.getScene().getWindow().hide();
        
        //btnChangerEmail.getScene().getWindow().hide();
         //anchorModif.getChildren().clear();
       
    
    }
    
    

    @FXML
    private void Annuler(MouseEvent event) {
       anchorModif.setVisible(true);
       showInformationCompte.setVisible(true);
       anchorInformationLieAuCompte.setVisible(false);
       anchorInformationPersonnelle.setVisible(false);
    }

    @FXML
    private void buttonToChangeMail(MouseEvent event) {
        EmailActuelle.setVisible(true);
        ChangerMailButton.setVisible(true);
        EmailActuelle.setText(servClient.getInfoClient(User.uName).getEmail());
        btnChangerMotDePasse.setVisible(false);
        passwordActuelle.setVisible(false);
    }

    @FXML
    private void EnregistrerInfoPersonnelle(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (numeroTel.getText().trim().length()!=8)
        {
            alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Votre numéro de telephone doit être composer de 8 chiffre");
                            alert.show();
                            numeroTel.requestFocus();
                           
        }
        else if ("".equals(nom.getText()))
        {
            alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Veillez remplir votre nom");
                            alert.show();
                            nom.requestFocus();
                           
        }
        else if ("".equals(prenom.getText()))
        {
            alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Veillez remplir votre prenom");
                            alert.show();
                            prenom.requestFocus();
                           
        }
        else if ("".equals(adresse.getText()))
        {
            alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Veillez remplir votre addresse");
                            alert.show();
                            adresse.requestFocus();
                           
        }
        else if ("".equals(codePostal.getText()))
        {
            alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Veillez remplir votre Code postal");
                            alert.show();
                            codePostal.requestFocus();
                           
        }
        else
        {
        Client client = new Client(nom.getText(), prenom.getText(), numeroTel.getText(), ville.getValue(), adresse.getText(), codePostal.getText(), Facebook.getText());
        servClient.updateClientInfoPersonnelle(client, User.uName);
        anchorModif.setVisible(false);
        FirstLastName.setText(servClient.getInfoClient(User.uName).getFirstname()+" "+servClient.getInfoClient(User.uName).getLastname());
        ServiceNotification.showNotif("Operation effectué", "Vos informations personnelles sont à jour");
        }
    }

    @FXML
    private void OnlyNumberPhone(KeyEvent ev) {
                 String c = ev.getCharacter();
    if("1234567890".contains(c)) 
    {
    }
    else {
        ev.consume();
    }
    }

    @FXML
    private void OnlyNumberCodePostal(KeyEvent ev) {
                 String c = ev.getCharacter();
    if("1234567890".contains(c)) 
    {
    }
    else {
        ev.consume();
    }
    }

    @FXML
    private void ChangerMailButtonSave(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);     
        String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"+"[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(masque);
        Matcher controler = pattern.matcher(EmailActuelle.getText());
        
        if (controler.matches()){     
            if (servClient.searchClientByEmail(EmailActuelle.getText())==true)
            {
                 alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Veillez verifier votre Email");
                            alert.show();
                            EmailActuelle.requestFocus();
            }
            else 
            {
                String code =  serviceMail.generateRandomString();
                String to = servClient.getInfoClient(User.uName).getEmail();
                String subject = "Confirmation d'inscription";
                String message =  "Voici le code de confirmation de changement mail "+ code + "  Veillez saisir votre code pour confirmer le changement" ;
                String usermail = "pi.dev.esrpit2017@gmail.com";
                String passmail = "aZERTY123";
                 Mailing.send(to,subject, message, usermail, passmail);
//                TextInputDialog dialog = new TextInputDialog("");
//                dialog.setTitle("Confirmez votre inscription");
//                dialog.setHeaderText("Un mail vous a été envoyer où vous trouvez le code");
//                dialog.setContentText("Entrez votre code de confirmation:");
//                Optional<String> result = dialog.showAndWait();
//                if (result.get().equals(code)){
//                    System.out.println(result.get());
//                        if (result.get().equals(code))
//                        {
                                if (verifconfirMail(code)==true)
                                {
                                    
                Client client = new Client(EmailActuelle.getText());
                servClient.updateMailClient(client, User.uName);
                anchorModif.setVisible(false);
                ServiceNotification.showNotif("Operation effectué", "Votre email est bien à jour");
            
                                    
                                }
                
                
                
                
                
                
            }
            
        }
        else{
            alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Veillez verifier votre Email");
                            alert.show();
                            EmailActuelle.requestFocus();
        
    }
    }

    @FXML
    private void buttonToChangePassword(MouseEvent event) {
    EmailActuelle.setVisible(false);
        ChangerMailButton.setVisible(false);
        passwordActuelle.setVisible(true);
        EmailActuelle.setVisible(false);
        ChangerMailButton.setVisible(false);
    }


    @FXML
    private void AnnulerInforCompte(MouseEvent event) {
       anchorModif.setVisible(true);
       showInformationPersonnelle.setVisible(true);
       anchorInformationLieAuCompte.setVisible(false);
       anchorInformationPersonnelle.setVisible(false);
    
    }

    @FXML
    private void VerifPasswordActuelle(KeyEvent event) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
        if (event.getCode()==KeyCode.ENTER)
    {
        if (servClient.verifMotDePasseExistant(servCrypt.cryptWithMD5(passwordActuelle.getText()), User.uName)==true)
        {
            passwordActuelle.setVisible(false);
            passwordActuelle.setText("");
            buttonSaveNewPassword.setVisible(true);
            newPassword.setVisible(true);
            newPassword1.setVisible(true);
            annulerInformationCompte.setVisible(true);
        }
        else
        {
          alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Mot de passe incorrecte");
                            alert.show();
                            passwordActuelle.requestFocus();     }
         }
         }

    @FXML
    private void saveNewPassword(MouseEvent event) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           if (newPassword.getText().trim().length()<6)
           {
                alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Mot de passe doit contenir au minimum 6 caractére");
                            alert.show();
                            newPassword.requestFocus();  
           }
           else if (!(newPassword.getText().equals(newPassword1.getText())))
           {
                alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Veillez verifier votre mot de passe");
                            alert.show();
                            newPassword1.requestFocus();  
           }
           else
           {
               servClient.updatePassword(servCrypt.cryptWithMD5(newPassword.getText()),User.uName);
                    anchorModif.setVisible(false);
                    newPassword.setText("");
                    newPassword1.setText("");
                ServiceNotification.showNotif("Operation effectué", "Votre mot de passe est bien à jour");
          }

  
       
        
        
    }
    
    
      @FXML
    private void UpdateImage(MouseEvent event) throws MalformedURLException, FileNotFoundException  {
        
         FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("word file", lstFile));
        f = fc.showOpenDialog(null);
        
        if (f!=null)
        {
             Image image = new Image(f.toURI().toURL().toString());
            imageProfil.setImage(image) ;
            fis = new FileInputStream(f);
            servClient.updateImage(f, fis, User.uName);
                   ServiceNotification.showNotif("Operation effectué", "Votre image est bien à jour");
                   anchorModif.setVisible(false);
                   
        }
           }
    
   
     public boolean verifconfirMail(String code)
    {
        TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Confirmez votre Changement de mail");
                dialog.setHeaderText("Un mail vous a été envoyer où vous trouvez le code");
                dialog.setContentText("Entrez votre code de confirmation:");
                Optional<String> result = dialog.showAndWait();
                if (result.get().equals(code)){
                    
                        if (result.get().equals(code))
                        {
                            return true;
                        }
                }
                else
                {
                    return verifconfirMail(code);
                }
                return false;
    }

    @FXML
    private void ClickContactAdmin(MouseEvent event) {
        anchorModif.setVisible(false);
        AnchroContacterAdmin.setVisible(true);
        
    }

    @FXML
    private void ajouterReclamationClick(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
         
        if (Description.getText().equals(""))
        {
            alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Veillez saisir votre description de reclamation");
                            alert.show();
                            numeroTel.requestFocus();
                           
        }
         else
         {
        ContacterAdmin cont = new ContacterAdmin(Description.getText(), User.uName, dateNow.selectDate(), 0, 0);
        contact.InsererMsg(cont);
        ServiceNotification.showNotif("Operation effectué", "Votre reclamation est bien envoyée");
        Description.setText("");
        AnchroContacterAdmin.setVisible(false);
         }
    }



    
}
