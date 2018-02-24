/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pi.idevup.cupcake.connectionBD.DataSource;
import pi.idevup.cupcake.entities.Product;

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

        String req = "insert into product (productname,description,picture,available,type,"
                + "price,unite,addedDate,confectionerName ) values (?,?,?,?,?,?,?,?,?) ";

        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        System.out.println(date_sql);
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, p.getProductName());
            preparedStatement.setString(2, p.getDescription());
            preparedStatement.setString(3, p.getPictures());
            preparedStatement.setBoolean(4, p.isAvailable());
            preparedStatement.setString(5, p.getType());
            preparedStatement.setFloat(6, p.getPrice());
            preparedStatement.setString(7, p.getUnite());
            preparedStatement.setDate(8, date_sql);
            preparedStatement.setString(9, "omri_amal");
            preparedStatement.executeUpdate();
            System.out.println("product is aded");
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
    }

    public void remove(String name) {
        String req = "delete from Product where productname=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("product is deleted");
        } catch (SQLException ex) {
            System.out.println("ERREUR");
            System.out.println(ex);
        }
    }

    public void update(Product p) {
        String req = "update produit set productname=?,description=?,picture=?,available=?,type=?,price=?,unite=?";
        PreparedStatement preparedStatement;
        java.util.Date date_util = new java.util.Date();

        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, p.getProductName());
            preparedStatement.setString(2, p.getDescription());
            preparedStatement.setString(3, p.getPictures());
            preparedStatement.setBoolean(4, p.isAvailable());
            preparedStatement.setString(5, p.getType());
            preparedStatement.setFloat(6, p.getPrice());
            preparedStatement.setString(7, p.getUnite());
            preparedStatement.executeUpdate();
            System.out.println("product has been uptated");
        } catch (SQLException ex) {
            System.out.println("ERREUR");
            System.out.println(ex);
        }
    }

    public Product findById(Integer r) {
        Product p = null;
        String req = "select * from Product where productid=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new Product(
                        resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBoolean(4),
                        resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
     public Product findByProductName(String nomProduit) {
        
         Product p = null;
        String req = "select * from Product where productname='"+nomProduit+"'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1,nomProduit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new Product(
                        resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getBoolean(4),
                        resultSet.getString(5), resultSet.getInt(6), 
                        resultSet.getString(7),resultSet.getDate(8));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
        
    public List<Product> getAll() {
        Product p = null;
        List<Product> produits = new ArrayList<>();
        String req = "select * from Product";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               p = new Product(
                        resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBoolean(4),
                        resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7),resultSet.getDate(8));
                produits.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produits;
    }

    public ObservableList<Product> displayAllProduct() {
        ObservableList<Product> listPro = FXCollections.observableArrayList();
        String req = "select * from Product ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

               Product p = new Product(
                        resultSet.getString(2),
                       resultSet.getString(3),
                       resultSet.getString(4), 
                       resultSet.getBoolean(5),
                        resultSet.getString(6),
                       resultSet.getInt(7),
                       resultSet.getString(8),
                       resultSet.getDate(9));

                System.out.println(p);
                listPro.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitPatissier.class.getName()).log(Level.SEVERE, null, ex);

        }

        return listPro;
    }
     public ObservableList<Product> displayAllProductByUser() {
        ObservableList<Product> listPro = FXCollections.observableArrayList();
        String req = "select * from Product where confectionerName='omri_amal'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

              Product p = new Product(
                        resultSet.getString(2),
                       resultSet.getString(3),
                       resultSet.getString(4), 
                       resultSet.getBoolean(5),
                        resultSet.getString(6),
                       resultSet.getInt(7),
                       resultSet.getString(8),
                       resultSet.getDate(9));


                System.out.println(p);
                listPro.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitPatissier.class.getName()).log(Level.SEVERE, null, ex);

        }

        return listPro;
    }

                  public static boolean productUnique(String username,String nomProduit){
        
          int i=0;
           try {
               Statement ste= DataSource.getInstance().getConnection().createStatement();
               String req= "Select * from Product WHERE confectionerName='"+username+"' and productname='"+nomProduit+"'";
               ResultSet result=ste.executeQuery(req);
               
               while(result.next()){
          
                i++;
                  
               }
               
           } catch (SQLException ex) {
               Logger.getLogger(ProduitPatissier.class.getName()).log(Level.SEVERE, null, ex);
           }
           return i==0;
            
        
        
    }
}
