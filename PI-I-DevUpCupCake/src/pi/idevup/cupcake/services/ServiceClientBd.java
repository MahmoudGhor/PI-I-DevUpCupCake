/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import pi.idevup.cupcake.connectionBD.DataSource;
import pi.idevup.cupcake.entities.Client;
import pi.idevup.cupcake.main.Main;

/**
 *
 * @author Asus
 */
public class ServiceClientBd {
     static  DataSource ds= DataSource.getInstance();
     
     public static void insertClient(Client c,File file , FileInputStream fis){
        
         try {
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
         ste1.setString(5, "a:1{i:0;s:10:\"ROLE_CLIENT\";}");
         ste1.setString(6, c.getFirstname());
         ste1.setString(7, c.getLastname());
         ste1.setString(8, c.getPhone());
         ste1.setString(9, c.getTown());
         ste1.setBinaryStream(10, fis , (int)file.length());
         //ste1.setString(10, c.getPicture());
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
            
            
                public String getImageClient(String cli)
     {
         String image = null ;
         try {
         Statement ste = ds.getConnection().createStatement();
         String req = "select picture from user where username='"+cli+"'";
         ResultSet rs =ste.executeQuery(req);
           while (rs.next()) {
               String s = rs.getString(1);
               image=s;
           }
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return  image;
     }
     
     public Client getInfoClient(String cli)
     {
         Client c = new Client();
         try {
         Statement ste = ds.getConnection().createStatement();
         String req = "select firstname , lastname , email , phone , town , address , postalcode , facebook from user where username='"+cli+"'";
         ResultSet rs =ste.executeQuery(req);
           while (rs.next()) {
               String firstname = rs.getString(1);
               String lastname = rs.getString(2);
               String email = rs.getString(3);
               String phone = rs.getString(4);
               String town = rs.getString(5);
               String address = rs.getString(6);
               String postalcode = rs.getString(7);
               String facebook = rs.getString(8);
                c = new Client(email, firstname, lastname, phone, town, address, postalcode, facebook);
              
           }
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
       
       
     }
     
     
           public void updateClient(Client c , String username) {
        try {
            System.out.println(c.getPicture());
         Statement ste = ds.getConnection().createStatement();
         String req = "update user set firstname='"+c.getFirstname()+"',lastname='"+c.getLastname()+"' ,email='"+c.getEmail()+"',phone='"+c.getPhone()+"',town='"+c.getTown()+"', picture='"+c.getPicture()+"',address='"+c.getAddress()+"',postalcode='"+c.getPostalcode()+"',facebook='"+c.getFacebook()+"'  where username='"+username+"'";
         ste.executeUpdate(req);
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
}
               public void updateClientInfoPersonnelle(Client c , String username) {
        try {
         Statement ste = ds.getConnection().createStatement();
         String req = "update user set firstname='"+c.getFirstname()+"',lastname='"+c.getLastname()+"',phone='"+c.getPhone()+"',town='"+c.getTown()+"',address='"+c.getAddress()+"',postalcode='"+c.getPostalcode()+"',facebook='"+c.getFacebook()+"'  where username='"+username+"'";
         ste.executeUpdate(req);
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
}
               
                     public void updateMailClient(Client c , String username) {
        try {
           // System.out.println(c.getPicture());
         Statement ste = ds.getConnection().createStatement();
         String req = "update user set email='"+c.getEmail()+"'  where username='"+username+"'";
         ste.executeUpdate(req);
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
}
                     
         public boolean verifMotDePasseExistant(String pwd , String username)
         {
             String pass="";
         try {
         Statement ste = ds.getConnection().createStatement();
         String req = "select password from user where username='"+username+"'";
         ResultSet rs =ste.executeQuery(req);
         while (rs.next()) {
              pass = rs.getString(1);
              if (pass.equals(pwd))
              {
                  return true;
              }
                             }
            }
         catch (SQLException ex) {
             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
       
                        return  false;
     
                         
                     }
         
         public Image getImage2 (String nom )throws FileNotFoundException, IOException 
        {
            Image image=null;
         try {
         Statement ste = ds.getConnection().createStatement();
         String req = "select picture from user where username='"+nom+"'";
         ResultSet rs =ste.executeQuery(req);
           while (rs.next()) {
              InputStream is = rs.getBinaryStream(1);
               OutputStream os = new FileOutputStream(new File("photo.jpg"));
               byte[] contents = new byte[1024];
               int size=0;
               while ((size = is.read(contents))!=-1)
               {
                os.write(contents,0,size);
               }
               return image;//=new Image("file:photo.jpg",imageview2.getFitWidth(),imageview2.getFitHeight(),true,true);
              // imageview2.setImage(image);
               
           }
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         return image;
       
}
         
                     public void updatePassword(String password , String username) {
        try {
         
         Statement ste = ds.getConnection().createStatement();
         String req = "update user set password='"+password+"'  where username='"+username+"'";
         ste.executeUpdate(req);
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
}
                     public void updateImage(File file , FileInputStream fis , String username) {
        try {
         
         String req = "update user set picture= ? where username= ?";
         PreparedStatement ste1 = ds.getInstance().getConnection().prepareStatement(req);
         ste1.setBinaryStream(1, fis , (int)file.length());
         ste1.setString(2,username);
         ste1.executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
}
}
         
     

