/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.services;

import pi.idevup.cupcake.connectionBD.DataSource;
import pi.idevup.cupcake.entities.Patissier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ServicePatisserieBd  {
    
    public static void  insertPatissier(Patissier p){

            try {
                
                ServiceUserBd.insererUser(p);
                Statement ste=DataSource.getInstance().getConnection().createStatement();
                String reqS="SELECT id FROM user ORDER BY id DESC LIMIT 1";
                ResultSet res=ste.executeQuery(reqS);
                int id=0;
                while(res.next()){
                    id =res.getInt("id");
                }
                System.out.println(id);
                System.out.println("++++ali");
                String req = "UPDATE user SET roles='Patissier',pastryname='"+p.getNomPatisserie()+"', worktime='"+p.getWorktime()+"',dayoff='"+p.getDayOff()+"',specialty='"+p.getSpeciality()+"',service='"+p.getService()+"'"
                        + ",website='"+p.getWebsite()+"',meansofpayment='"+p.getMeansOfPayment()+"',requirement='"+p.getRequirement()+"',latitude='"+ p.getLatitude()+"',longitude='"+ p.getLongitude()+"' WHERE id='"+id+"'";
                    PreparedStatement ste1 = DataSource.getInstance().getConnection().prepareStatement(req);
                                    
                    System.out.println("ali");
                    ste1.executeUpdate();
               System.out.println("Patisser added");
               //ste.executeQuery(req);
            } catch (SQLException ex) {
                Logger.getLogger(ServicePatisserieBd.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Probleme de connexion");
                System.out.println(ex);
            }
           
           
                
            }
    
}
