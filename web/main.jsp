<!DOCTYPE html>
<%@ page import="IoTBay.*" %>
<%@ page import="java.sql.*" %>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>IoTBay</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="main.css">
        <style>
            .logout{
                margin-left: 240px;
            }
            #end-of-session-page {
                align-items: center;
                display: flex;
                align-content: center;
                justify-content: center;
                flex-direction: column;
                flex-wrap: wrap;
            }
        </style>
    </head>
    <body>
        <div hidden id="session-state"><% out.println(session.getAttribute("access"));%></div>
        <div id="session-page">
            <nav>
                <ul class="menu">
                    <li class="nav"><a href="index.html" class="logo">Internet Of Things Bay</a></li>
                    <li class="nav">
                        Hi,
                        <% out.println(session.getAttribute("first_name")); %> <%-- Shows the users first name --%>
                        <% out.println(session.getAttribute("last_name")); %> - <%-- Shows the users last name --%>
                        <% out.println(session.getAttribute("access")); %> <%-- Shows the users access level --%>
                    </li>
                    <li class="nav" class="logout"><a class="logout" href="logout.jsp">Logout</a></li>
                </ul>
            </nav>
        </div>
        <%-- <table>
            <% 
                try{
                    ResultSet rs = Controller.userActivity(session.getAttribute("email"));
                    out.println("<tr> <td>#</td> <td>User ID</td> <td>Login Date/Time</td> <td>Logout Date/Time</td> </tr>");
                    while (rs.next()) {
                        out.println("<tr>");
                        
                        out.println("<td>");
                        rs.getInt("ual_id");
                        out.println("</td>");

                        out.println("<td>");
                        rs.getInt("user_id");
                        out.println("</td>");

                        out.println("<td>");
                        rs.getString("login_datetime");
                        out.println("</td>");

                        out.println("<td>");
                        rs.getString("logout_datetime");
                        out.println("</td>");

                        out.println("</tr>");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } 
            %>
        </table> --%>

        <div id="end-of-session-page" style="display: none;">
            <h1>Session Terminated</h1> 
            <p>Please <a href="login.jsp">login</a> again to access your account.<p>
        </div>
        <%  
            // Prevent Caching and saving of sensitive data allows page to reload everytime its viewed 
            // Reference https://stackoverflow.com/questions/49547/how-do-we-control-web-page-caching-across-all-browsers/2068407#2068407
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        %>
        <%-- <script>
            window.onload = main();  // Runs function when page loads
            function main(){
                // Disable or enable view depending on session state either running or not running 
                try{
                    console.log("Started");
                    var state = document.getElementById("session-state").textContent;
                    state = state.trim();
                    console.log(state == null)
                    console.log(null == state)
                    console.log('null' == state)
                    console.log(state == 'null')
                    if (state == null || null == state || 'null' == state || state == 'null'){
                        console.log("Null Zone");
                        document.getElementById("session-page").style.display = 'none';
                        document.getElementById("end-of-session-page").style.removeProperty('display');
                    } else {
                        console.log("Display Zone");
                        document.getElementById("session-page").style.removeProperty('display');
                        document.getElementById("end-of-session-page").style.display = 'none';
                    }
                } catch (error) {
                    console.log(error);
                }
            }
        </script> --%>
    </body>
</html>