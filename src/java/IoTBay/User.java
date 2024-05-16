/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTBay;
import java.lang.String;

import IOTBay.DBManager;

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

    public User(int user_id, String first_name, String last_name, String email, String pass, String dob, String access) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.pass = pass;
        this.dob = dob;
        this.access = access;
    }

    public int getId() {
        return user_id;
    }

    // public void setId(int user_id) {
    //     this.user_id = user_id;
    // }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        DBManager.writeQuery("UPDATE Users" +
        "SET first_name = '" + first_name + "'," +
        "WHERE email = '" + this.email + "';");
        DBManager.closeConnection();
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        DBManager.writeQuery("UPDATE Users" +
        "SET last_name = 'Admin'," +
        "WHERE email = 'admin@mail.com';");
        DBManager.closeConnection();
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegDate() {
        return registration_datetime;
    }

    public void setRegDate(String registration_datetime) {
        this.registration_datetime = registration_datetime;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
