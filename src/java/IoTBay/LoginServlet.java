/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import IOTBay.DBManager; 
import IOTBay.User;


/**
 *
 * @author Krish
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // /**
    //  * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
    //  * methods.
    //  *
    //  * @param request servlet request
    //  * @param response servlet response
    //  * @throws ServletException if a servlet-specific error occurs
    //  * @throws IOException if an I/O error occurs
    //  */
    // protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {
    //     response.setContentType("text/html;charset=UTF-8");
    //     try (PrintWriter out = response.getWriter()) {
    //         /* TODO output your page here. You may use following sample code. */
    //         out.println("<!DOCTYPE html>");
    //         out.println("<html>");
    //         out.println("<head>");
    //         out.println("<title>Servlet LoginServelet</title>");            
    //         out.println("</head>");
    //         out.println("<body>");
    //         out.println("<h1>Servlet LoginServelet at " + request.getContextPath() + "</h1>");
    //         out.println("</body>");
    //         out.println("</html>");
    //     }
    // }

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
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try{
            int count = DBManager.readQuery("SELECT COUNT(*) as user_count FROM Users " +
                "WHERE email = '" + username + "' " +
                "AND pass = '" + password + "'; ").getInt("user_count");
            if (count == 1){
                ResultSet rs = DBManager.readQuery("SELECT * FROM Users " +
                "WHERE email = '" + username + "' " +
                "AND pass = '" + password + "';");
                User user = new User(rs.getInt("user_id"), 
                                    rs.getString("first_name"), 
                                    rs.getString("last_name"),
                                    rs.getString("email"),
                                    rs.getString("pass"),
                                    rs.getString("dob"),
                                    rs.getString("phone"),
                                    rs.getString("registration_datetime"),
                                    rs.getString("access"));
                RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
                rd.include(request, response);

                return;            
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        out.println("<script>alert(\"Login credentials are not valid, Please try again.\")</script>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Is a controller Login page front-end and back-end ";
    }// </editor-fold>

}
