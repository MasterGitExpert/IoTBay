/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTBay;
import java.sql.*;


/**
 * This file contains database managment functions for opening and 
 * closing database connections and running sql queries
 * @author Krish
 */

public class DBManager {
    private final String database_url = "jdbc:derby://localhost:1527/iotdb";
    private final String username = "iotadmin";
    private final String password = "admin";
    private Connection connection;
    private Statement statement;

    private void establishConnection(){
        /* Opens a connection to db for SQL queries */
        try{
            this.connection = DriverManager.getConnection(database_url, username, password);
            this.statement = this.connection.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        /* Closes open connections to db for security and memory optimisation */
        try{
            this.statement.close();
            this.connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String databaseInjectionFilter(String query){
        /* Removes illegal inputs in the query to prevent SQL injection attacks */

        // Removes SQL comments, to prevent where condition bypass injections 
        query = query.replaceAll("--", "");
        query = query.replaceAll("/\\*", "");
        query = query.replaceAll("\\*/", "");
        // Removes two consequtive quotes input to prevent SQL error injections
        query = query.replaceAll("\'\\s*\'", "\'");
        return query;
    }

    public ResultSet readQuery(String query){
        /* Only runs select queries on db to prevent unwanted changes (i.e. lower security risks) */
        establishConnection();
        try{
            query = databaseInjectionFilter(query);
            ResultSet resultSet = this.statement.executeQuery(query);
            return resultSet;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public int writeQuery(String query){
        /* Runs queries that create cause db changes */
        establishConnection();
        try{
            query = databaseInjectionFilter(query);
            int response = this.statement.executeUpdate(query);
            return response;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

}
