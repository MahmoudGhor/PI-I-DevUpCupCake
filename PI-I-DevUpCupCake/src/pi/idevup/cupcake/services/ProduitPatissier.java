/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.services;

import pi.idevup.cupcake.main.Main;
import pi.idevup.cupcake.entities.Product;
import pi.idevup.cupcake.connectionBD.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Yousfi Oussama
 */
public class ProduitPatissier {

    Connection connection;

    public ProduitPatissier() {
        connection = DataSource.getInstance().getConnection();
    }

    public void add(Product p) {
        
        PreparedStatement preparedStatement;
        
        String req = "insert into product (productname,description,picture,available,type,price,unite,addedDate,confectionerid) values (?,?,?,?,?,?,?,?,?) ";
        

        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        System.out.println(date_sql);
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getId());
            //preparedStatement.setInt(1, t.getUser().getId());
            //preparedStatement.setInt(1, Session.LoggedUser.getId());
            preparedStatement.setString(1,p.getProductName());
            preparedStatement.setString(2,p.getDescription());
            preparedStatement.setString(3,p.getPictures());
            preparedStatement.setBoolean(4, p.isAvailable());
            preparedStatement.setString(5, p.getType());
            preparedStatement.setFloat(6,p.getPrice());
            preparedStatement.setString(7, p.getUnite());
            preparedStatement.setDate(8, date_sql);
            preparedStatement.setInt(9,p.getPatissierId());
            preparedStatement.executeUpdate();
            System.out.println("product is aded");
        } catch (SQLException ex) {
            System.out.println("ERREUR");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null , ex);
        }
        }
    
    public void remove(Integer r) {
        String req = "delete from Product where productid =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
            System.out.println("product is deleted");
        } catch (SQLException ex) {
            System.out.println("ERREUR");
            System.out.println(ex);
        }
    }
    

   public void update( Product p) {
       String req = "update produit set productname=?,description=?,picture=?,available=?,type=?,price=? ";
       PreparedStatement preparedStatement;
       java.util.Date date_util = new java.util.Date();

        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1,p.getProductName());
            preparedStatement.setString(2,p.getDescription());
            preparedStatement.setString(3,p.getPictures());
            preparedStatement.setBoolean(4, p.isAvailable());
            preparedStatement.setString(5, p.getType());
            preparedStatement.setFloat(6,p.getPrice());
            preparedStatement.executeUpdate();
            System.out.println("product has been uptated");
        } catch (SQLException ex) {
            System.out.println("ERREUR");
            System.out.println(ex);
        }
    }

    
    
}

