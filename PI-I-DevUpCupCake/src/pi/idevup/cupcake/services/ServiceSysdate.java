/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.services;

import pi.idevup.cupcake.connectionBD.DataSource;
//import crudclient.CrudClient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmo
 */
public class ServiceSysdate {
    static DataSource ds = DataSource.getInstance();
     public Date selectDate()
             
     {
         Date datee=null;
         try {
         Statement ste = ds.getConnection().createStatement();
         String req = "select sysdate()";
         ResultSet rs =ste.executeQuery(req);
           while (rs.next()) {
              Date datenow = rs.getDate(1);
              //id=result.getInt("id");
             datee=datenow;
               // list.add( new Personne (rs.getString"nom",rs.getString"prenom))
           }
            } catch (SQLException ex) {
            Logger.getLogger(ServiceClientBd.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return  datee;
       
       }
     }

