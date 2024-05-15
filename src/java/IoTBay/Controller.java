/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOTBay;
import java.lang.String;

/**
 *
 * @author Krish
 */
public class Controller {

    public static User checkCredentials(String email, String password){
        // for (Users user: Users.getUsers()){
        //     System.out.println(email + " " + password + " " + user.getEmail() + " " + user.getPassword());
        //     if (email.equals(user.getEmail()) && password.equals(user.getPassword())){
        //         return user;
        //     }
        // }         
        return DBQueriesUAM.getUser(email, password); 
    }

    public static void addRootUser(){
        User.addRootUser();
    }

    public static void addUser(String access, String fname, String lname, String email, String password, String dob){
        if (access.equals("Admin")){
            User.addUser(new Admin(User.getNextId(), fname, lname, email, password, dob));
        }else if (access.equals("Staff")){
            User.addUser(new Staff(User.getNextId(), fname, lname, email, password, dob));
        }else {
            User.addUser(new Customer(User.getNextId(), fname, lname, email, password, dob));
        }
    }

    public static void removeUser(String email, String pardoned_role){
        int index = 0;
        for (User user: User.getUsers()){
            if (email.equals(user.getEmail()) && !pardoned_role.equals(user.getAccount_type())){
                User.removeUser(index);
            }
            index += 1;
        }
    }

    public static void changeAccess(String email, String updated_access){
        for (User user: User.getUsers()){
            if (email.equals(user.getEmail())){
                addUser(updated_access, user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPassword(), user.getDob());

            }
        }
    }
    
}
