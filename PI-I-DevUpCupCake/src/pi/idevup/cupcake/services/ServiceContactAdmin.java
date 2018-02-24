/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.services;

import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.idevup.cupcake.connectionBD.DataSource;
import pi.idevup.cupcake.entities.Client;
import pi.idevup.cupcake.entities.ContacterAdmin;
import pi.idevup.cupcake.main.Main;
import static pi.idevup.cupcake.services.ServiceClientBd.ds;

/**
 *
 * @author mahmo
 */
public class ServiceContactAdmin {
    static  DataSource ds= DataSource.getInstance();
    
    public static void InsererMsg(ContacterAdmin contact){
         try {
          
        String req = "insert into contactadmin (description , username , date , seen , status) values (?,?,?,?,?)";
         PreparedStatement ste1 = ds.getInstance().getConnection().prepareStatement(req);
         ste1.setString(1, contact.getDescription());
         ste1.setString(2, contact.getUsername());
         ste1.setDate(3, contact.getDateEnvoye());
         ste1.setInt(4, contact.getSeen());
         ste1.setInt(5,contact.getStatus());
         ste1.executeUpdate(); //exécution
            System.out.println("ok");
         //  } catch (Exception e) {
            //      System.out.println("probleme");
            // }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    
     }
    
}
