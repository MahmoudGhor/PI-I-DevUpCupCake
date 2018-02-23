/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import pi.idevup.cupcake.entities.ReadRSS;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import pi.idevup.cupcake.entities.Client;
import pi.idevup.cupcake.entities.User;
import pi.idevup.cupcake.services.ServiceClientBd;
import pi.idevup.cupcake.services.ServiceNotification;
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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        anchorModif.setVisible(false);
        ObservableList<String> listeVille = FXCollections.observableArrayList(
        "Tunis","Sfax"
        );
        ville.setItems(listeVille);
        ReadRSS rss = new ReadRSS();
      //  System.out.println(rss.readRss("https://bonnenouvelle.fr/spip.php?page=backend"));
      jtext.setText(rss.readRss("https://bonnenouvelle.fr/spip.php?page=backend"));
       // jtext.setText("aaaaaaaaaaaaa eeeeeeeeeeeeeeee ijijf afoazufh zaopfzapoifhaozifhaozifh ozafh aozfhazoifhp azfhaz faizof haozi oooooooooooooooooooooooo kkkkkkkkkkkkkkkkkkkk jjjjjjjjjjjjjjjj ,,,,,,,,");
       
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
    
        
        
    Image image = new Image("file:"+servClient.getImageClient(User.uName));
        imageProfil.setImage(image);
        FirstLastName.setText(servClient.getInfoClient(User.uName).getFirstname()+" "+servClient.getInfoClient(User.uName).getLastname());
                
   
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
    }

    @FXML
    private void modifierProfilClick(MouseEvent event) {
        anchorModif.setVisible(true);
        showInformationCompte.setVisible(true);
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
                Client client = new Client(EmailActuelle.getText());
                servClient.updateMailClient(client, User.uName);
                anchorModif.setVisible(false);
                ServiceNotification.showNotif("Operation effectué", "Votre email est bien à jour");
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
            System.out.println("Mot de passe correct");
        }
        else
        {
          alert.setTitle("Attention");
                            alert.setHeaderText("Echec");
                            alert.setContentText("Mot de passe incorrecte");
                            alert.show();
                            passwordActuelle.requestFocus();   
        }
        
        
    }
    
    }
    


    
}
