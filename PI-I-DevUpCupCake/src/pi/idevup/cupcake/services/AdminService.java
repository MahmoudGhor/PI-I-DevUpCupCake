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
import pi.idevup.cupcake.connectionBD.DataSource;
import pi.idevup.cupcake.entities.User;

/**
 *
 * @author Amine Sboui
 */
public class AdminService {

    Connection connection;

    public AdminService() {
        connection = DataSource.getInstance().getConnection();
    }

    public int get_Number_Client() {
        ResultSet rs = null;
        int Message_Number = 989898;
        try {
            String SQL = "SELECT COUNT(roles) FROM `user` where roles= 'a:1{i:0;s:10:\"ROLE_CLIENT\";}'";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Message_Number = rs.getInt(1);
            }
            return Message_Number;
        } catch (Exception e) {
            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());
        }
        return Message_Number;
    }

    public int get_Number_Admin() {
        ResultSet rs = null;
        int Message_Number = 989898;
        try {
            String SQL = "SELECT COUNT(roles) FROM `user` where roles= 'a:1{i:0;s:10:\"ROLE_ADMIN\";}'";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Message_Number = rs.getInt(1);
            }
            return Message_Number;
        } catch (Exception e) {
            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());
        }
        return Message_Number;
    }

    public int get_Number_Infec() {
        ResultSet rs = null;
        int Message_Number = 989898;
        try {
            String SQL = "SELECT COUNT(roles) FROM `user` where roles= 'a:1{i:0;s:10:\"ROLE_PAST\";}'";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Message_Number = rs.getInt(1);
            }
            return Message_Number;
        } catch (Exception e) {
            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());
        }
        return Message_Number;
    }

    public int get_Number_Product() {
        ResultSet rs = null;
        int Product_Number = 989898;
        try {
            String SQL = "SELECT COUNT(*) FROM `product`";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product_Number = rs.getInt(1);
            }
            return Product_Number;
        } catch (Exception e) {
            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());
        }
        return Product_Number;
    }

    public int get_Number_Recipe() {
        ResultSet rs = null;
        int Recipe_Number = 989898;
        try {
            String SQL = "SELECT COUNT(*) FROM `recipe`";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Recipe_Number = rs.getInt(1);
            }
            return Recipe_Number;
        } catch (Exception e) {
            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());
        }
        return Recipe_Number;
    }

    public int get_Number_Upload() {
        ResultSet rs = null;
        int Upload_Number = 989898;
        try {
            String SQL = "select COUNT(r.picture) , COUNT(p.picture) FROM recipe r , product p";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Upload_Number = rs.getInt(1) + rs.getInt(2);
            }
            return Upload_Number;
        } catch (Exception e) {
            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());
        }
        return Upload_Number;
    }

    public int get_Number_Message() {
        ResultSet rs = null;
        int Alert_Number = 989898;
        try {
            String SQL = "select COUNT(*) FROM claim ";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alert_Number = rs.getInt(1);
            }
            return Alert_Number;
        } catch (Exception e) {
            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());
        }
        return Alert_Number;
    }

    public int get_Number_Likes() {
        ResultSet rs = null;
        int Likes_Number = 989898;
        try {
            String SQL = "select COUNT(r.EvaluationNote) , COUNT(p.EvaluationNote) FROM recipeevaluation r , productevaluation p";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Likes_Number = rs.getInt(1) + rs.getInt(2);
            }
            return Likes_Number;
        } catch (Exception e) {
            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());
        }
        return Likes_Number;
    }

    public int get_Number_Comment() {
        ResultSet rs = null;
        int Comment_Number = 989898;
        try {
            String SQL = "select COUNT(r.EvaluationCommentaire) , COUNT(p.EvaluationCommentaire) FROM recipeevaluation r , productevaluation p";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comment_Number = rs.getInt(1) + rs.getInt(2);
            }
            return Comment_Number;
        } catch (Exception e) {
            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());
        }
        return Comment_Number;
    }

    public int get_Number_Alerts() {
        ResultSet rs = null;
        int Claim_Number = 989898;
        try {
            String SQL = "select COUNT(*) FROM claim";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Claim_Number = rs.getInt(1);
            }
            return Claim_Number;
        } catch (Exception e) {
            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());
        }
        return Claim_Number;
    }
}
