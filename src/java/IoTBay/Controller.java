/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay;
import java.beans.Statement;
import java.lang.String;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Krish
 */
public class Controller {
    // private static User user;

    public static User checkCredentials(String username, String password){
        try{
            PreparedStatement statement = DBManager.establishConnection("SELECT COUNT(*) as user_count FROM Users WHERE email = ? AND pass = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("user_count");
            // if (count != 1){
                statement = DBManager.establishConnection("SELECT * FROM Users WHERE email = ? AND pass = ? ");
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();
                rs.next();
                User user = new User(rs.getString("first_name"), 
                                    rs.getString("last_name"),
                                    rs.getString("email"),
                                    rs.getString("pass"),
                                    rs.getString("dob"),
                                    rs.getString("phone"),
                                    rs.getString("registration_datetime"),
                                    rs.getString("access"));
                System.out.println("---------------------------------------------------------------------------------------------------->>>");
                System.out.println(user);

                return user;
            // }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;      
    }

    // public static void addRootUser(){
    //     Users.addRootUser();
    // }

    public static boolean userExists(String username){
        try{
            PreparedStatement statement = DBManager.establishConnection("SELECT * FROM Users WHERE email = ? ");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            rs.next();
            if (username.equals(rs.getString("email"))){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static User addUser(String first_name, String last_name, String email, String pass, String dob, String phone){
        // first_name = DBManager.databaseInjectionFilter(first_name);
        // last_name = DBManager.databaseInjectionFilter(last_name);
        // email = DBManager.databaseInjectionFilter(email);
        // pass = DBManager.databaseInjectionFilter(pass);
        // phone = DBManager.databaseInjectionFilter(phone);

        try{
            PreparedStatement statement = DBManager.establishConnection("INSERT INTO Users(first_name, last_name, email, pass, dob, phone, registration_datetime, access) VALUES ( ? , ? , ? , ? , ? , ? , ? , ?)");
            String registration_datetime = new Timestamp(System.currentTimeMillis()).toString();
            String access = "CUSTOMER";
            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setString(3, email);
            statement.setString(4, pass);
            statement.setString(5, dob);
            statement.setString(6, phone);
            statement.setString(7, registration_datetime);
            statement.setString(8, access);
            int response = statement.executeUpdate();
            User user = new User(first_name, last_name, email, pass, dob, phone, registration_datetime, access);
            return user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet userActivity(String email){
        try {
            email = DBManager.databaseInjectionFilter(email);
            PreparedStatement statement = DBManager.establishConnection("SELECT * FROM UserAccessLog WHERE user_id = (SELECT user_id FROM Users WHERE email = ? ) ");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void saveSession(int user_id, String login, String logout){ 
        try {
            PreparedStatement statement = DBManager.establishConnection("INSERT INTO UsersAccessLog (user_id, login_datetime, logout_datetime) VALUES ( ? , ? , ? )");
            statement.setInt(1, user_id);
            statement.setString(1, login);
            statement.setString(1, logout);
            int response = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        
    }
}
