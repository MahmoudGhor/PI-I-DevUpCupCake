/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import pi.idevup.cupcake.entities.Client;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import pi.idevup.cupcake.services.ServiceClientBd;
import pi.idevup.cupcake.services.serviceCryptage;

/**
 *
 * @author mahmo
 */
public class FXMLDocumentController implements Initializable {
    
    List<String> lstFile;
    private Label label;
    @FXML
    private ImageView view;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField town;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField postalcode;
    @FXML
    private JFXTextField facebook;
    @FXML
    private JFXButton bt1;
    @FXML
    private Label lab;
    @FXML
    private JFXButton enreg;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstFile = new ArrayList<>();
        lstFile.add("*.png");
        lstFile.add("*.jpg");
    }    

    @FXML
    private void choseimage(MouseEvent event) throws MalformedURLException{
        
        FileChooser fc = new FileChooser();
       // System.out.println("0");
        fc.getExtensionFilters().add(new ExtensionFilter("word file", lstFile));
       // System.out.println("1");
        File f = fc.showOpenDialog(null);
        
        if (f!=null)
        {
            lab.setText(f.getAbsolutePath());
            Image image = new Image(f.toURI().toURL().toString());
            view.setImage(image) ;
        }
    }

    @FXML
    private void enregistrer(MouseEvent event) {
        
        
//        if (phone.getText()!="")
//        {
//            System.out.println("aaaaaa");
//            System.out.println(phone.getText());
//        }
        if ((lab.getText()!="")&& (username.getText()!="")&& (email.getText()!="")&& (password.getText()!="") && (firstname.getText()!="") && (lastname.getText()!="") && (phone.getText()!="") && (town.getText()!="") && (address.getText()!="") && (postalcode.getText()!="" && (facebook.getText()!="")))
        {
            System.out.println("eee");
            serviceCryptage crypt = new serviceCryptage();
            String mdpCrypte = crypt.cryptWithMD5(password.getText());
            Client c = new Client(username.getText(), email.getText(), mdpCrypte.toString(),firstname.getText(), lastname.getText(), phone.getText(), town.getText(), address.getText(), postalcode.getText(), lab.getText(), facebook.getText());
            ServiceClientBd serv = new ServiceClientBd();
            serv.insererClient(c);
            username.setText("");
            email.setText("");
            firstname.setText("");
            lastname.setText("");
            phone.setText("");
            town.setText("");
            address.setText("");
            postalcode.setText("");
            lab.setText("");
            facebook.setText("");
            
            
            
            
        }
                }
    
}
