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
import pi.idevup.cupcake.entities.User;
import pi.idevup.cupcake.connectionBD.DataSource;

/**
 *
 * @author Mariem
 */
public class UserService {

    Connection connection;

    public UserService() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addAdmin(User u) {
        try {
            System.out.println(u.toString());
            String requete = "INSERT INTO user (username,username_canonical,email,email_canonical,enabled,password,roles,firstname,lastname) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getUsername());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getEmail());
            pst.setInt(5, u.getEnabled());
            pst.setString(6, u.getPassword());
            pst.setString(7, u.getRoles());
            pst.setString(8, u.getFirstname());
            pst.setString(9, u.getLastname());
            pst.executeUpdate();
            System.out.println("Insertion effectué avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateAdmin(User u) {
        try {
            System.out.println(u.toString());
            String requete = "update user set username=?,username_canonical=?,email=?,email_canonical=?,password=?,enabled=?,firstname=?,lastname=? where id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getUsername_canonical());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getEmail_canonical());
            pst.setString(5, u.getPassword());
            pst.setInt(6, u.getEnabled());
            pst.setString(7, u.getFirstname());
            pst.setString(8, u.getLastname());
            pst.setInt(9, u.getId());

            pst.executeUpdate();
            System.out.println("Modification effectué avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void removeAdmin(Integer r) {
        try {
            String requete = "delete from user where id=?";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, r);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<User> getAllAdmin() {
        List<User> user = new ArrayList<>();
        String req = "select * from user where roles= 'a:1{i:0;s:10:\"ROLE_ADMIN\";}'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("enabled"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"));

                user.add(u);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public void addClient(User u) {
        try {
            System.out.println(u.toString());
            String requete = "INSERT INTO user (username,username_canonical,email,email_canonical,enabled,password,roles,firstname,lastname,phone,town,picture,banneddate,address,facebook) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getUsername());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getEmail());
            pst.setInt(5, 1);
            pst.setString(6, u.getPassword());
            pst.setString(7, u.getRoles());
            pst.setString(8, u.getFirstname());
            pst.setString(9, u.getLastname());
            pst.setString(10, u.getPhone());
            pst.setString(11, u.getTown());
            pst.setString(12, u.getPicture());
            pst.setString(13, u.getBanneddate());
            pst.setString(14, u.getAddress());
            pst.setString(15, u.getFacebook());
            pst.executeUpdate();
            System.out.println("Insertion effectué avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateClient(User u) {
        try {
            System.out.println(u.toString());
            String requete = "update user set username=?,username_canonical=?,email=?,email_canonical=?,password=?,firstname=?,lastname=?,phone=?,town=?,picture=?,address=?,facebook=? where id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getUsername());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getEmail());
            pst.setString(6, u.getPassword());
            pst.setString(8, u.getFirstname());
            pst.setString(9, u.getLastname());
            pst.setString(10, u.getPhone());
            pst.setString(11, u.getTown());
            pst.setString(12, u.getPicture());
            pst.setString(14, u.getAddress());
            pst.setString(15, u.getFacebook());

            pst.setInt(12, u.getId());

            pst.executeUpdate();
            System.out.println("Modification effectué avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<User> getClientAll() {
        List<User> user = new ArrayList<>();
        String req = "select * from users";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone"),
                        resultSet.getString("town"),
                        resultSet.getString("picture"),
                        resultSet.getString("address"),
                        resultSet.getString("facebook"));
                user.add(u);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public void remove(Integer r) {
        try {
            String requete = "delete from users where id_user=?";
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setInt(1, r);

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public User findById(Integer r) {
        User user = null;
        String req = "select * from user where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone"),
                        resultSet.getString("town"),
                        resultSet.getString("picture"),
                        resultSet.getString("address"),
                        resultSet.getString("facebook"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public boolean findByLogin(String s) {
        User user = null;
        String req = "select * from user where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone"),
                        resultSet.getString("town"),
                        resultSet.getString("picture"),
                        resultSet.getString("address"),
                        resultSet.getString("facebook"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (user == null) {
            return false;
        }
        return true;
    }

    public User UserByLogin(String s) {
        User user = null;
        String req = "select * from user where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone"),
                        resultSet.getString("town"),
                        resultSet.getString("picture"),
                        resultSet.getString("address"),
                        resultSet.getString("facebook"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    public boolean findByPassword(String s, String p) {
        User user = null;
        String req = "select password from user where username =?";
        System.out.println(s + "     " + p);
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone"),
                        resultSet.getString("town"),
                        resultSet.getString("picture"),
                        resultSet.getString("address"),
                        resultSet.getString("facebook"));
            }
            System.out.println(user.getPassword());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (user == null) {
            return false;
        }
        if (user.getPassword().equals(p)) {
            return true;

        }
        return false;
    }

    public String Gettype(String s) {
        String s1 = "";
        String req = "select roles from user where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString("roles");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s1;
    }

    public ResultSet buildData() {

        ResultSet rs = null;

        try {

            String SQL = "SELECT roles as roles, COUNT(roles) as nbr FROM `user`group by roles";
            PreparedStatement ps;
            ps = connection.prepareStatement(SQL);

            rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {

            System.out.println("Error on DB connection");
            System.out.println(e.getMessage());

        }
        return rs;
    }
    public Boolean checkpw(String pword, String uname){
        String s1="";
        String req = "Select password from user where username= ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, uname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString(1);
                serviceCryptage sc = new serviceCryptage();
                if (s1.equals(sc.cryptWithMD5(pword)))
                        {
                            return true;
                        }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    
    }
        public void changepassword(String s1,String numtel) {
        try {
            String requete = "update user set password=? where phone=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, s1);
            pst.setString(2,numtel);
            pst.executeUpdate();
            System.out.println("Modification effectué avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
                public User findByname(String s) {
        User user = null;
        String req = "select * from user where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone"),
                        resultSet.getString("town"),
                        resultSet.getString("picture"),
                        resultSet.getString("address"),
                        resultSet.getString("facebook"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

}
