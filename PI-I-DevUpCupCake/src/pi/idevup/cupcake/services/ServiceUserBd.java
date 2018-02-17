/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.services;

import pi.idevup.cupcake.connectionBD.DataSource;
//import crudclient.CrudClient;
import pi.idevup.cupcake.entities.Client;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.idevup.cupcake.entities.User;

/**
 *
 * @author mahmo
 */
public class ServiceUserBd {
    static DataSource ds = DataSource.getInstance();
    
     public static void insererUser(User c) {
        try {
            //  try {
        // Statement ste = ds.getConnection().createStatement();
        //String req = "insert into personne (`nom`,`prenom`) values ('"+p.getNom()+"','"+p.getPrenom()+"')";
         //ste.executeUpdate(req);
              
        String req = "insert into user (username , email , enabled , password  , firstname , lastname , phone , town ,  picture , address , postalcode , facebook) values (?,?,?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement ste1 = DataSource.getInstance().getConnection().prepareStatement(req);
         ste1.setString(1, c.getUsername());
         ste1.setString(2, c.getEmail());
         ste1.setInt(3, 1);
         ste1.setString(4, c.getPassword());
        
         ste1.setString(5, c.getFirstname());
         ste1.setString(6, c.getLastname());
         ste1.setString(7, c.getPhone());
         ste1.setString(8, c.getTown());
         ste1.setString(9, c.getPicture());
         ste1.setString(10, c.getAddress());
         ste1.setString(11, c.getPostalcode());
         ste1.setString(12, c.getFacebook());
            System.out.println("ali");
         ste1.executeUpdate(); //exécution
            System.out.println("ok");
            ste1.close();
         //  } catch (Exception e) {
            //      System.out.println("probleme");
            // }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUserBd.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
        
}
}
