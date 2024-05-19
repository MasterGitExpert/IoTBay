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

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.RequestDispatcher;

import IoTBay.Controller;
import IoTBay.DBManager; 
import IoTBay.User;


/**
 *
 * @author Krish
 */
// @WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

    // /**
    //  * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
    //  * methods.
    //  *
    //  * @param request servlet request
    //  * @param response servlet response
    //  * @throws ServletException if a servlet-specific error occurs
    //  * @throws IOException if an I/O error occurs
    //  */

public static ResultSet DBQuery(String email, String pass){
        try {
            PreparedStatement statement2 = DBManager.establishConnection("SELECT * FROM Users WHERE email = ? AND pass = ? ;");
            statement2.setString(1, email);
            statement2.setString(2, pass);
            ResultSet response = statement2.executeQuery();
            return response;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResultSet rs = DBQuery(username, password);
        User user = Controller.checkCredentials(username, password);
        HttpSession session = request.getSession();
        session.setAttribute("User", user);
        RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
        rd.forward(request, response);
        // response.sendRedirect("/welcome");
        // out.println("<script>alert(\"Login credentials are not valid, Please try again.\")</script>");
        // RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        // rd.include(request, response);
    }

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
        return "Is a controller Login page front-end and back-end ";
    }

}
