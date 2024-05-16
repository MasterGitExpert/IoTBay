/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTBay;

// import IOTBay.DBManager;

import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Krish
 */
public class User{
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String pass;
    private String dob;
    private String phone;
    private String registration_datetime;
    private String access;  // Types: admin, staff, customer 

    public User(int user_id, String first_name, String last_name, String email, String pass, String dob, String phone, String registration_datetime, String access) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.pass = pass;
        this.dob = dob;
        this.phone = phone;
        this.registration_datetime = registration_datetime;
        this.access = access;
    }

    private String getUser(String column_name){
        try {
            ResultSet resultSet = DBManager.readQuery("SELECT * FROM Users "+
            "WHERE email = '" + this.email + "';");
            return resultSet.getString(column_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        this.user_id = Integer.parseInt(getUser("user_id"));
        return this.user_id;
    }

    public void setId(int user_id) {
        int row_altered = DBManager.writeQuery("UPDATE Users" +
            "SET user_id = '" + user_id + "'," +
            "WHERE email = '" + this.email + "';");
        // DBManager.closeConnection();
        if (row_altered != 0){
            this.user_id = user_id;
        }
    }

    public String getFirst_name() {
        this.first_name = getUser("first_name");
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        int row_altered = DBManager.writeQuery("UPDATE Users" +
            "SET first_name = '" + first_name + "'," +
            "WHERE email = '" + this.email + "';");
        // DBManager.closeConnection();
        if (row_altered != 0){
            this.first_name = first_name;
        }
    }

    public String getLast_name() {
        this.last_name = getUser("last_name");
        return last_name;
    }

    public void setLast_name(String last_name) {
        int row_altered = DBManager.writeQuery("UPDATE Users" +
            "SET last_name = '" + last_name + "'," +
            "WHERE email = '" + this.email + "';");
        // DBManager.closeConnection();
        if (row_altered != 0){
            this.last_name = last_name;
        }
    }

    public String getEmail() {
        this.email = getUser("email");
        return this.email;
    }

    public void setEmail(String email) {
        int row_altered = DBManager.writeQuery("UPDATE Users" +
            "SET email = '" + email + "'," +
            "WHERE email = '" + this.email + "';");
        // DBManager.closeConnection();
        if (row_altered != 0){
            this.email = email;
        }
    }

    public String getPass() {
        this.pass = getUser("pass");
        return pass;
    }

    public void setPass(String pass) {
        int row_altered = DBManager.writeQuery("UPDATE Users" +
            "SET pass = '" + pass + "'," +
            "WHERE email = '" + this.email + "';");
        // DBManager.closeConnection();
        if (row_altered != 0){
            this.pass = pass;
        }
    }

    public String getDob() {
        this.dob = getUser("dob");
        return this.dob;
    }

    public void setDob(String dob) {
        int row_altered = DBManager.writeQuery("UPDATE Users" +
            "SET pass = '" + dob + "'," +
            "WHERE email = '" + this.email + "';");
        // DBManager.closeConnection();
        if (row_altered != 0){
            this.dob = dob;
        }
    }
    public String getPhone() {
        this.phone = getUser("phone");
        return phone;
    }

    public void setPhone(String phone) {
        int row_altered = DBManager.writeQuery("UPDATE Users" +
            "SET phone = '" + phone + "'," +
            "WHERE email = '" + this.email + "';");
        // DBManager.closeConnection();
        if (row_altered != 0){
            this.phone = phone;
        }
    }

    public String getRegDate() {
        this.registration_datetime = getUser("registration_datetime");
        return this.registration_datetime;
    }

    public void setRegDate(String registration_datetime) {
        int row_altered = DBManager.writeQuery("UPDATE Users" +
            "SET registration_datetime = '" + registration_datetime + "'," +
            "WHERE email = '" + this.email + "';");
        // DBManager.closeConnection();
        if (row_altered != 0){
            this.registration_datetime = registration_datetime;
        }
    }

    public String getAccess() {
        this.access = getUser("access");
        return access;
    }

    public void setAccess(String access) {
        int row_altered = DBManager.writeQuery("UPDATE Users" +
            "SET access = '" + access + "'," +
            "WHERE email = '" + this.email + "';");
        // DBManager.closeConnection();
        if (row_altered != 0){
            this.access = access;
        }
    }
}
