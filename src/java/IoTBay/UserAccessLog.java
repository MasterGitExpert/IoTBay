/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay;

/**
 *
 * @author Krish
 */
public class UserAccessLog {
    private int ual_id;
    private int user_id;
    private String login_datetime;
    private String logout_datetime;

    public int getUal_id() {
        return ual_id;
    }

    public void setUal_id(int ual_id) {
        this.ual_id = ual_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLogin_datetime() {
        return login_datetime;
    }

    public void setLogin_datetime(String login_datetime) {
        this.login_datetime = login_datetime;
    }

    public String getLogout_datetime() {
        return logout_datetime;
    }

    public void setLogout_datetime(String logout_datetime) {
        this.logout_datetime = logout_datetime;
    }
}
