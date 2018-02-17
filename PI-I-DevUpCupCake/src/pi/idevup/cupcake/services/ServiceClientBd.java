/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.idevup.cupcake.connectionBD.DataSource;
import pi.idevup.cupcake.entities.Client;

/**
 *
 * @author Asus
 */
public class ServiceClientBd {
     static  DataSource ds= DataSource.getInstance();
     
     public static void insertClient(Client c){
         try {
             ServiceUserBd.insererUser(c);
             String req ="INSERT INTO client (roles) VALUES (?)";
             PreparedStatement ste1 = DataSource.getInstance().getConnection().prepareStatement(req);
             ste1.setString(1, "Client");
             ste1.executeUpdate();
         } catch (SQLException ex) {
                         Logger.getLogger(ServiceClientBd.class.getName()).log(Level.SEVERE, null, ex);

         }
         
     }
}
