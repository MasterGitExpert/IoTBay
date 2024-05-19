<!DOCTYPE html>
<%@ page import="IoTBay.*"%>
<%@ page import="java.sql.*"%>

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
            body {
                text-align: center;
            }
            .loading-bar {
                background-color: #0ABEFF;
                height: 12px;
                border-radius: 5px;
                animation-name: loading-bar;
                animation-duration: 5s;
            }
            @keyframes loading-bar{
                0% {width: 0%;}
                100% {width: 100%}
            }
        </style>
    </head>
    <body>
        <div class="loading-bar"></div>
        <h1>Internet Of Things</h1>
        <div>
            <%  
                boolean loggedIn = false;
                if ("login".equals(request.getParameter("form"))){
                    User user = Controller.checkCredentials(request.getParameter("username"), request.getParameter("password"));
                    if (user == null){
                        out.println("Incorrect crendentials, please try again. ");
                    } else {        
                        out.println("Welcome " + user.getFirst_name());
                        loggedIn = true;
                        // session.setAttribute("User", user);
                        // session.setAttribute("user_id", user.getId());
                        session.setAttribute("first_name", user.getFirst_name());
                        session.setAttribute("last_name", user.getLast_name());
                        session.setAttribute("email", user.getEmail());
                        session.setAttribute("login", new Timestamp(System.currentTimeMillis()).toString());
                        session.setAttribute("access", user.getAccess());
                        response.setHeader("Refresh", "5;url=main.jsp");
                        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
                        response.setHeader("Pragma", "no-cache");
                        response.setHeader("Expires", "0");
                    }    
                } else {
                    boolean exists = Controller.userExists(request.getParameter("email"));
                    if (!exists){
                        boolean valid = true;
                        valid = Validator.validName(request.getParameter("first_name"));
                        valid = Validator.validName(request.getParameter("last_name"));
                        valid = Validator.validName(request.getParameter("email"));
                        // valid = Validator.validName(request.getParameter("phone"));
                        if (!valid){
                            response.setHeader("Refresh", "5;url=register.jsp");
                            out.println("One or more of your fields have invalid data.");
                        }else{
                            User user = Controller.addUser(request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("email"), request.getParameter("pass"), request.getParameter("dob"), request.getParameter("phone"));
                            out.println("You have successfully registered an account, " + request.getParameter("first_name") + ". ");
                            loggedIn = true;
                            // session.setAttribute("User", user);
                            // session.setAttribute("user_id", user.getId());
                            session.setAttribute("first_name", user.getFirst_name());
                            session.setAttribute("last_name", user.getLast_name());
                            session.setAttribute("email", user.getEmail());
                            session.setAttribute("login", new Timestamp(System.currentTimeMillis()).toString());
                            session.setAttribute("access", user.getAccess());
                            response.setHeader("Refresh", "5;url=main.jsp");
                            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Expires", "0");
                        }
                    }else {
                        out.println("Account may already exist please check and try again. ");
                    }
                }
                if (!loggedIn){
                    response.setHeader("Refresh", "5;url=login.jsp");
                }
            %>
    </body>
</html>
