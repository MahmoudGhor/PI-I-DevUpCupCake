/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.services;

import pi.idevup.cupcake.connectionBD.DataSource;
import pi.idevup.cupcake.entities.Patissier;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ServicePatisserieBd {
    
    public static void  insertPatissier(Patissier p){
          
            try {
              
              String req = "INSERT INTO personne (roles,username,email,password,last_login,firstname,"
                      + "lastname,pastryname,phone,town,picture,address,worktime,dayoff,"
                      + "specialty,service,postalcode,website,facebook,meansofpayment,"
                      + "requirement,latitude,longitude) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                      PreparedStatement ste = DataSource.getInstance().getConnection().prepareStatement(req);
                      
                     ste.setString(1, "Patissier");
                     
                      ste.setString(9, p.getNomPatisserie());
                      
                      ste.setString(14, p.getWorktime());
                      ste.setString(15, p.getDayOff());
                      ste.setString(16, p.getSpeciality());
                      ste.setString(17, p.getService());
                      ste.setString(19, p.getWebsite());
                      ste.setString(21, p.getMeansOfPayment());
                      ste.setString(22, p.getRequirement());
                      ste.setString(23, p.getLatitude());
                      ste.setString(24, p.getLongitude());
                              ste.executeUpdate();
                System.out.println("Patisser added");
               //ste.executeQuery(req);
            } catch (SQLException ex) {
                Logger.getLogger(ServicePatisserieBd.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Probleme de connexion");
            }
           
           
                
            }
    
}
