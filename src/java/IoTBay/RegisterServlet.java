/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

// @ts-ignore
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IoTBay.DBManager; 
import IoTBay.User;

/**
 *
 * @author Krish
 */
public class RegisterServlet extends HttpServlet {

    public static int DBQuery(String first_name, String last_name, String email, String pass, String dob, String phone, String registration_datetime, String access){
        try {
            PreparedStatement statement2 = DBManager.establishConnection("INSERT INTO Users(first_name, last_name, email, pass, dob, phone, registration_datetime, access) VALUES ( ? , ? , ? , ? , ? , ? , ? , ?)");
            statement2.setString(1, first_name);
            statement2.setString(2, last_name);
            statement2.setString(3, email);
            statement2.setString(4, pass);
            statement2.setString(5, dob);
            statement2.setString(6, phone);
            statement2.setString(7, registration_datetime);
            statement2.setString(8, access);
            int response = statement2.executeUpdate();
            return response;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 2;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String registration_datetime = new Timestamp(System.currentTimeMillis()).toString();
        String access = "CUSTOMER";
        try {
            PreparedStatement statement = DBManager.establishConnection("SELECT COUNT(*) as user_count FROM Users WHERE email = ? AND pass = ? ");
            statement.setString(1, email);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("user_count");
            if (count == 0){
                int response2 = DBQuery(first_name, last_name, email, pass, dob, phone, registration_datetime, access);
                if (response2 == 1){
                    User user = new User(first_name, last_name, email, pass, dob, phone, registration_datetime, access);
                    HttpSession session = request.getSession();
                    session.setAttribute("User", user);
                    return true;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    // // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    // /**
    //  * Handles the HTTP <code>GET</code> method.
    //  *
    //  * @param request servlet request
    //  * @param response servlet response
    //  * @throws ServletException if a servlet-specific error occurs
    //  * @throws IOException if an I/O error occurs
    //  */
    // @Override
    // protected void doGet(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {
    //     processRequest(request, response);
    // }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                processRequest(request, response);
            }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
