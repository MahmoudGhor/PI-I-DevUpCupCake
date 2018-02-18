/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pi.idevup.cupcake.entities.Patissier;
import pi.idevup.cupcake.entities.User;
import pi.idevup.cupcake.services.ServicePatisserieBd;
import pi.idevup.cupcake.services.ServiceUserBd;

/**
 *
 * @author Dorra
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/pi/idevup/cupcake/GUI/AddPasty.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      launch(args);
//     //User u = new Patissier("a", "a", "a", "a", "a", "a", "a", "a", "1", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
//      Patissier p = new Patissier("a", "a", "a", "a", "a", "a", "a", "a", "1", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
//    //  ServicePatisserieBd.insererUser(u);
      // System.out.println(ServicePatisserieBd.profilePatissier("nasr").get(0));
//ServicePatisserieBd.insertPatissier(p);
//   
    }
    
}
