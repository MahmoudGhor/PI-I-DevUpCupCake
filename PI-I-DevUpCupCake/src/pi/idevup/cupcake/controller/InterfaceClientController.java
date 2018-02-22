/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import pi.idevup.cupcake.entities.ReadRSS;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import pi.idevup.cupcake.entities.User;
import pi.idevup.cupcake.services.ServiceClientBd;
import pi.idevup.cupcake.services.ServiceUserBd;

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
    private JFXButton showInformationPersonnelle1;
    @FXML
    private JFXButton btnChangerEmail;
    @FXML
    private JFXTextField Email;
    @FXML
    private AnchorPane anchorInformationPersonnelle;
    @FXML
    private JFXButton ModifierProfil;
    @FXML
    private AnchorPane anchorInformationLieAuCompte;
    @FXML
    private JFXButton Deconnexion;
    @FXML
    private TextField test;
    @FXML
    private ImageView imageProfil;
    @FXML
    private Label FirstLastName;
    
    ServiceClientBd servClient = new ServiceClientBd();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        anchorModif.setVisible(false);
        
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
    private void informationPersonnelleClick(MouseEvent event) {
        anchorInformationLieAuCompte.setVisible(false);
        anchorInformationPersonnelle.setVisible(true);
        prenom.setText(servClient.getInfoClient(User.uName).getLastname());
        nom.setText(servClient.getInfoClient(User.uName).getFirstname());
        adresse.setText(servClient.getInfoClient(User.uName).getAddress());
        codePostal.setText(servClient.getInfoClient(User.uName).getPostalcode());
        numeroTel.setText(servClient.getInfoClient(User.uName).getPhone());
        
        
    }

    @FXML
    private void informationCompteClick(MouseEvent event) {
        anchorInformationPersonnelle.setVisible(false);
        anchorInformationLieAuCompte.setVisible(true);
    }

    @FXML
    private void modifierProfilClick(MouseEvent event) {
        anchorModif.setVisible(true);
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
        Email.getScene().getWindow().hide();
       
    
    }
    
}
