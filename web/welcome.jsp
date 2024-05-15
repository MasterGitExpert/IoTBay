<!DOCTYPE html>
<%@ page import="IOTBay.*"%>
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
                Controller.addRootUser();
                User user = null;
                boolean loggedIn = false;
                if ("login".equals(request.getParameter("form"))){
                    user = Controller.checkCredentials(request.getParameter("username"), request.getParameter("password"));
                    if (user == null){
                        out.println("Incorrect crendentials, please try again. ");
                    } else {        
                        out.println("Welcome " + user.getFirst_name());
                        loggedIn = true;
                    }    
                } else {
                    Controller.addUser("Customer", request.getParameter("fname"), request.getParameter("lname"), request.getParameter("email"), request.getParameter("password"), request.getParameter("dob"));
                    user = Controller.checkCredentials(request.getParameter("email"), request.getParameter("password"));
                    out.println("You have successfully registered an account.");
                    loggedIn = true;
                }
                if (loggedIn){
                    session.setAttribute("User", user);
                    response.setHeader("Refresh", "5;url=main.jsp");
                } else {
                    response.setHeader("Refresh", "5;url=login.jsp");
                }
            %>
    </body>
</html>
