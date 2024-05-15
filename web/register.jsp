<%-- 
    Document   : register
    Created on : 5 Apr 2024, 3:36:22 pm
    Author     : arianhassani
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>IoTBay</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="main.css">
        <title>Registration Page</title>
        <style>
            body {                
                align-content: center;
                display: flex;
                flex-wrap: wrap;
                flex-direction: column;
                justify-content: center;
                align-items: center;
            }
        </style>
    </head>
    <body>
        <h1>Sign Up</h1>
        <form action="welcome.jsp" method="POST">
            <table>
                <tr><td>Full Name:</td></tr><tr><td><input type="text" placeholder="Enter Name" name="fname" required="true"></td></tr>
                <tr><td>Last Name:</td></tr><tr><td><input type="text" placeholder="Enter Last Name" name="lname" required="true"></td></tr>
                <tr><td>Email:</td></tr><tr><td><input type="text" placeholder="Enter Email" name="email" required="true"></td></tr>
                <tr><td>Password:</td></tr><tr><td><input type="password" placeholder="Enter Password" name="password" required="true"></td></tr>
                <tr><td>Date of Birth:</td></tr><tr><td><input type="date" placeholder="Enter DOB" name="dob" required="true"></td></tr>
                <tr> 
                    <td><input type="hidden" name="form" value="register"></td>
                </tr>
                <tr>
                    <td><a href="index.html">Cancel</a><td><td><button type="submit" value="submit">Sign Up</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>