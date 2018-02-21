/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.connectionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pi.idevup.cupcake.entities.User;
import pi.idevup.cupcake.services.UserService;

/**
 *
 * @author Nourelhouda
 */
public class Session {

    //private static Session instance ; 
    public static User LoggedUser;
    public static UserService iuserService = new UserService();

    public Session() {
    }

    public User getLoggedUser() {
        return LoggedUser;
    }

    public void setLoggedUser(User LoggedUser) {
        this.LoggedUser = LoggedUser;
    }

    /**
     *
     * @param login
     * @return
     * @throws SQLException
     */
    public User SetLoggedUser(String login) throws SQLException {
        Connection connection;
        connection = DataSource.getInstance().getConnection();

        String sql = "SELECT * FROM user WHERE username=? ";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, login);

        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            LoggedUser = new User();
            LoggedUser.setId(resultSet.getInt("id"));

            LoggedUser = iuserService.findById(LoggedUser.getId());
        }

        return LoggedUser;
    }

}
