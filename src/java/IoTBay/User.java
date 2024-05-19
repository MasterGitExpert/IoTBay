/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay;

// import IOTBay.DBManager;

import java.lang.String;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.Serializable;


/**
 *
 * @author Krish
 */
public class User implements Serializable{
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String pass;
    private String dob;
    private String phone;
    private String registration_datetime;
    private String access;  // Types: admin, staff, customer 

    public User(String first_name, String last_name, String email, String pass, String dob, String phone, String registration_datetime, String access) {
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
            PreparedStatement statement = DBManager.establishConnection("SELECT * FROM Users WHERE email = ? ");
            statement.setString(1, this.email);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getString(column_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int setUser(String change, String value){
        try {
            PreparedStatement statement = DBManager.establishConnection("UPDATE Users SET ? = ?, WHERE email = ? ");
            statement.setString(1, change);
            statement.setString(2, value);
            statement.setString(3, this.email);
            int response = statement.executeUpdate();
            return response;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getId() {
        this.user_id = Integer.parseInt(getUser("user_id"));
        return this.user_id;
    }

    public void setId(int user_id) {
        int row_altered = 0;
        try{
            PreparedStatement statement = DBManager.establishConnection("UPDATE Users SET ? = ?, WHERE email = ? ");
            statement.setString(1, "user_id");
            statement.setInt(2, user_id);
            statement.setString(3, this.email);
            row_altered = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        int row_altered = setUser("first_name", first_name);
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
        int row_altered = setUser("last_name", last_name);
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
        int row_altered = setUser("email", email);
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
        int row_altered = setUser("pass", pass);
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
        int row_altered = setUser("dob", dob);
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
        int row_altered = setUser("phone", phone);
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
        int row_altered = setUser("registration_datetime", registration_datetime);
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
        int row_altered = setUser("access", access);
        // DBManager.closeConnection();
        if (row_altered != 0){
            this.access = access;
        }
    }
}
