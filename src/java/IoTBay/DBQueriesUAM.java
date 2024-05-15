/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTBay;

import java.lang.Integer;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Contains queries for user access management feature 
 * @author Krish
 */
public class DBQueriesUAM extends DBManager{

    public static User getUser(String username, String password){
        String query = "SELECT * FROM Users " +
                        "WHERE email = '" + username + "' " +
                        "AND pass = '" + password + "';";

        ResultSet resultSet = readQuery(query);
        User user;
        try{
            user.setId(resultSet.getInt("user_id"));
            user.setFirst_name(resultSet.getString("first_name"));
            user.setLast_name(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("pass"));
            user.setDob(resultSet.getString("dob"));
            user.setPhone(resultSet.getString("phone"));
            user.setRegDate(resultSet.getString("registration_datetime"));
            user.setAccess(resultSet.getString("access"));
            closeConnection();
            return user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
