/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.idevup.cupcake.connectionBD.DataSource;
import pi.idevup.cupcake.entities.Client;
import pi.idevup.cupcake.main.Main;

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
     
     
            public boolean searchClientByEmail(String mail)
     {
         
         try {
         Statement ste = ds.getConnection().createStatement();
         String req = "select * from user where email='"+mail+"'";
         ResultSet rs =ste.executeQuery(req);
           while (rs.next()) {
              return true;
           }
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return  false;
     }
            
            public boolean searchClientByUserName(String username)
     {
         
         try {
         Statement ste = ds.getConnection().createStatement();
         String req = "select * from user where username='"+username+"'";
         ResultSet rs =ste.executeQuery(req);
           while (rs.next()) {
              return true;
           }
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return  false;
     }
     
}
