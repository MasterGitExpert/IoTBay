/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Krish
 */
public class Validator {

    public static boolean validEmail(String email){
        Pattern pattern = Pattern.compile("[a-zA-Z0-9\\._-]+@[a-zA-Z0-9\\._-]+");
        Matcher matcher = pattern.matcher(email);
        boolean matched = matcher.find();
        if(matched) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validPhone(String phone){
        Pattern pattern = Pattern.compile("[\\d]+");
        Matcher matcher = pattern.matcher(phone);
        boolean matched = matcher.find();
        if(matched) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validName(String name){
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(name);
        boolean matched = matcher.find();
        if(matched) {
            return true;
        } else {
            return false;
        }
    }

}
