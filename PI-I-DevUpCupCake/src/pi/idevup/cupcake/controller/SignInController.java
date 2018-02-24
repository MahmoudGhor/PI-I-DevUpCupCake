/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextField;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.messages.TextMessage;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import pi.idevup.cupcake.connectionBD.Session;
import pi.idevup.cupcake.entities.User;
import pi.idevup.cupcake.services.UserService;
import pi.idevup.cupcake.services.serviceCryptage;
import tray.animations.AnimationType;
import static tray.notification.NotificationType.ERROR;
import static tray.notification.NotificationType.SUCCESS;
import tray.notification.TrayNotification;

/**
 *
 * @author mahmo
 */
public class SignInController implements Initializable {

    @FXML
    private AnchorPane frame;
    //   @FXML
    //   private JFXPopup pop;
//     final Popup popup = new Popup();
    @FXML
    private ImageView close;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton login;
    @FXML
    private Label inscrirLabel;
    @FXML
    private JFXButton signupButton;
    @FXML
    private Hyperlink mdoLabel;
    @FXML
    private Label rmpLabel;
    @FXML
    private JFXButton suivantButton;
    @FXML
    private JFXTextField numtelTF;
    @FXML
    private JFXTextField nvmpTF;
    @FXML
    private JFXPasswordField rnvmpTF;
    @FXML
    private JFXTextField codeTF;
    @FXML
    private JFXButton terminerButton1;
    @FXML
    private JFXButton verifierButton;

    Random rand = new Random();
    String code = String.valueOf(rand.nextInt(9000) + 1000);

    public AnchorPane getFrame() {
        return frame;
    }

    public void setFrame(AnchorPane frame) {
        this.frame = frame;
    }

    public ImageView getClose() {
        return close;
    }

    public void setClose(ImageView close) {
        this.close = close;
    }

    public JFXTextField getUsername() {
        return username;
    }

    public void setUsername(JFXTextField username) {
        this.username = username;
    }

    public JFXPasswordField getPassword() {
        return password;
    }

    public void setPassword(JFXPasswordField password) {
        this.password = password;
    }

    public JFXButton getLogin() {
        return login;
    }

    public void setLogin(JFXButton login) {
        this.login = login;
    }

    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rmpLabel.setVisible(false);
        suivantButton.setVisible(false);
        terminerButton1.setVisible(false);
        numtelTF.setVisible(false);
        nvmpTF.setVisible(false);
        rnvmpTF.setVisible(false);
        codeTF.setVisible(false);
        verifierButton.setVisible(false);
    }

    public static void loadWindow(URL loc, String title, Stage parentStage) {
        try {
            Parent parent = FXMLLoader.load(loc);
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void Signup(MouseEvent event) throws IOException {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/Type.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        frame.getScene().getWindow().hide();

    }

    @FXML
    private void closeApplication(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Vous allez quitter l'application");
        alert.setHeaderText("Vous allez quitter l'application");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            alert.close();
        }
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {

        String uname = getUsername().getText();
        String pword = getPassword().getText();
        System.out.println("esmék :" + uname);
        serviceCryptage sc = new serviceCryptage();
        String hashed = sc.cryptWithMD5(pword);
        UserService us = new UserService();
        User user = us.UserByLogin(uname);
        if (us.findByLogin(uname) && us.checkpw(pword, uname)/*BCrypt.checkpw(pword, user.getPassword())*/) {
            System.out.println(1);
            System.out.println(us.Gettype(uname));
            String p = "a:1{i:0;s:10:\"ROLE_CLIENT\";}";
            System.out.println(p);
            if (us.Gettype(uname).equals("a:1{i:0;s:10:\"ROLE_ADMIN\";}")) {
                System.out.println("hello Admin");
                //username.getScene().getWindow().hide();
                loadWindow(getClass().getResource("/pi/idevup/cupcake/GUI/FXMLAdmin.fxml"), "Dashboard", null);
                /*Session.LoggedUser = (Session.iuserService.findByLogin1(login.getText()));
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
                Parent root = loader.load();
                ancor.getScene().setRoot(root);*/

            }
            if (us.Gettype(uname).equals("a:1{i:0;s:10:\"ROLE_CLIENT\";}")) {
                // Session.LoggedUser = (Session.iuserService.UserByLogin(login.getText()));
                // System.out.println(Session.LoggedUser.getLastname());
                User.uName = uname;
                System.out.println(User.uName);
                System.out.println("hello Cl");
                username.getScene().getWindow().hide();
                loadWindow(getClass().getResource("/pi/idevup/cupcake/GUI/interfaceClient.fxml"), "Client", null);

            }
            if ((us.Gettype(uname)).equals("a:1{i:0;s:10:\"ROLE_PAST\";}")) {
                System.out.println("hello Pastry");
                username.getScene().getWindow().hide();
                loadWindow(getClass().getResource("/Views/FXMLPasty.fxml"), "Patiser", null);

            }
        }

        username.getStyleClass().add("wrong-credentials");
        password.getStyleClass().add("wrong-credentials");

    }

    public static final String API_KEY = "1965da7c";
    public static final String API_SECRET = "ca454f2ad634ab36";

    public void sendsms() throws IOException, NexmoClientException {
        String tel = "+216" + numtelTF.getText();
        System.out.println(tel);
        System.out.println(code);
        AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
        NexmoClient client = new NexmoClient(auth);
        client.getSmsClient().submitMessage(
                new TextMessage("Cupcake", tel, "Votre code de vérification est : " + code));
    }

    @FXML
    private void switchMdo(ActionEvent event) {
        mdoLabel.setVisible(false);
        inscrirLabel.setVisible(false);
        rmpLabel.setVisible(true);
        username.setVisible(false);
        password.setVisible(false);
        login.setVisible(false);
        signupButton.setVisible(false);
        numtelTF.setVisible(true);
        verifierButton.setVisible(false);
        suivantButton.setVisible(true);

    }

    @FXML
    private void changepassword(ActionEvent event) {
        //sendSMSCode();
        String nt = numtelTF.getText();
        if (nt.length() < 8 || nt.length() > 8) {
            numtelTF.setPromptText("Vous devez entrez 8 chiffres");
        } else {
            try {
                sendsms();
                System.out.println("dans change pass" + code);
                TrayNotification tray = new TrayNotification("Information", "Code envoyé au numéro " + numtelTF.getText(), SUCCESS);
                tray.setAnimationType(AnimationType.POPUP);
                tray.showAndDismiss(Duration.seconds(3));
            } catch (Exception e) {
                System.out.println(e);
            }
            numtelTF.setVisible(false);
            suivantButton.setVisible(false);
            codeTF.setVisible(true);
            verifierButton.setVisible(false);
        }
    }

    @FXML
    private void switchlogin(ActionEvent event) {
        String s1 = nvmpTF.getText();
        String s2 = rnvmpTF.getText();
        String numtel = numtelTF.getText();
        UserService us = new UserService();
        serviceCryptage sc = new serviceCryptage();
        if (s1.equals(s2) && s1.isEmpty() == false && s2.isEmpty() == false) {
            String hashed = sc.cryptWithMD5(s1);
            us.changepassword(hashed, numtel);
            TrayNotification tray = new TrayNotification("Succés", "Modification terminé", SUCCESS);
            tray.setAnimationType(AnimationType.POPUP);
            tray.showAndDismiss(Duration.ONE);
            mdoLabel.setVisible(false);
            rmpLabel.setVisible(false);
            inscrirLabel.setVisible(true);
            terminerButton1.setVisible(false);
            nvmpTF.setVisible(false);
            rnvmpTF.setVisible(false);
            username.setVisible(true);
            password.setVisible(true);
            signupButton.setVisible(true);
            login.setVisible(true);
            System.out.println("Opération terminé");
        } else {
            TrayNotification tray = new TrayNotification("Oups", "Vérififiez vos paramétre", ERROR);
            tray.setAnimationType(AnimationType.POPUP);
            tray.showAndDismiss(Duration.ONE);
        }
    }

    @FXML
    private void switchupdatepass(ActionEvent event) {
        codeTF.setVisible(false);
        nvmpTF.setVisible(true);
        rnvmpTF.setVisible(true);
    }

    @FXML
    private void verifcode(KeyEvent event) {
        System.out.println(code);
        if (codeTF.getText().equals(code)) {
            nvmpTF.setVisible(true);
            rnvmpTF.setVisible(true);
            verifierButton.setVisible(false);
            terminerButton1.setVisible(true);
            codeTF.setStyle("-fx-background-color:#3cbc53");
            codeTF.setVisible(false);
        } else {
            codeTF.setStyle("-fx-background-color:#ff0000");
        }

    }

}
