/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay;
import java.sql.*;


/**
 * This file contains database managment functions for opening and 
 * closing database connections and running sql queries
 * @author Krish
 */

public class DBManager {
    private static final String database_url = "jdbc:derby://localhost:1527/iotbaydb";
    private static final String username = "iotadmin";
    private static final String password = "admin";
    private static Connection connection;
    private static Statement statement;

    public static PreparedStatement establishConnection(String sql){
        /* Opens a connection to db for SQL queries */
        try{
            databaseInjectionFilter(sql);
            connection = DriverManager.getConnection(database_url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(){
        /* Closes open connections to db for security and memory optimisation */
        try{
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static String databaseInjectionFilter(String query){
        /* Removes illegal inputs in the query to prevent SQL injection attacks */

        // Removes SQL comments, to prevent where condition bypass injections 
        query = query.replaceAll("-*", "-");
        query = query.replaceAll("/\\*", "");
        query = query.replaceAll("\\*/", "");
        // Removes two consequtive quotes input to prevent SQL error injections
        query = query.replaceAll("\'\\s*\'", "\'");
        return query;
    }

    // public static ResultSet readQuery(){
    //     /* Only runs select queries on db to prevent unwanted changes (i.e. lower security risks) */
    //     try{
    //         // query = databaseInjectionFilter(query);
    //         ResultSet resultSet = statement.executeQuery();
    //         // closeConnection();
    //         return resultSet;
    //     }catch (SQLException e){
    //         e.printStackTrace();
    //         // closeConnection();
    //     }
    //     return null;
    // }
    
    // public static int writeQuery(){
    //     /* Runs queries that create cause db changes */
    //     try{
    //         // query = databaseInjectionFilter(query);
    //         int response = statement.executeUpdate();
    //         // closeConnection();
    //         return response;
    //     }catch (SQLException e){
    //         e.printStackTrace();
    //         // closeConnection();
    //     }
    //     return 0;
    // }

}
