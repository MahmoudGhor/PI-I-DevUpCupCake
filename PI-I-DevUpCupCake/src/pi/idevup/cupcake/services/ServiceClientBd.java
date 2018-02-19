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
            //  try {
        // Statement ste = ds.getConnection().createStatement();
        //String req = "insert into personne (`nom`,`prenom`) values ('"+p.getNom()+"','"+p.getPrenom()+"')";
         //ste.executeUpdate(req);
              System.out.println(c.getUsername());
              System.out.println(c.getEmail());
              System.out.println(c.getPassword());
              System.out.println(c.getPicture());
        String req = "insert into user (username , email , enabled , password , roles , firstname , lastname , phone , town ,  picture , address , postalcode , facebook) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement ste1 = ds.getInstance().getConnection().prepareStatement(req);
         ste1.setString(1, c.getUsername());
         ste1.setString(2, c.getEmail());
         ste1.setInt(3, 1);
         ste1.setString(4, c.getPassword());
         ste1.setString(5, "Client");
         ste1.setString(6, c.getFirstname());
         ste1.setString(7, c.getLastname());
         ste1.setString(8, c.getPhone());
         ste1.setString(9, c.getTown());
         ste1.setString(10, c.getPicture());
         ste1.setString(11, c.getAddress());
         ste1.setString(12, c.getPostalcode());
         ste1.setString(13, c.getFacebook());
         ste1.executeUpdate(); //exécution
            System.out.println("ok");
         //  } catch (Exception e) {
            //      System.out.println("probleme");
            // }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
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
