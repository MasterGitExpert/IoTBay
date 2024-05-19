<%-- 
    Document   : register
    Created on : 5 Apr 2024, 3:36:22 pm
    Author     : arianhassani
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>IoTBay Registration Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            html, body {
                margin: 0;
                padding: 0;
                width: 100%;
                height: auto;
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
            }
            /* Navigation menu styles */
            .menu ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                background-color: #333;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                display: flex;
                justify-content: space-around;
                align-items: center;
                z-index: 1000;
                height: 60px;
            }
            .menu li {
                flex-grow: 1;
                text-align: center;
            }
            .menu li a {
                display: block;
                color: white;
                padding: 14px 16px;
                text-decoration: none;
            }
            .menu li a:hover {
                background-color: #111;
            }
            /* Adjustments for the form */
            h1 {
                margin-top: 80px; /* Make sure the heading is visible below the navbar */
                color: #333;
                text-align: center;
            }
            form {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                width: 80%;
                max-width: 500px;
                margin: 20px auto; /* Center the form horizontally with automatic margins */
                display: block; /* Ensure the form is displayed as a block-level element */
            }
            table, input, button, a {
                width: 100%;
            }
            input[type="text"],
            input[type="password"],
            input[type="date"],
            input[type="submit"], button {
                padding: 10px;
                margin: 5px 0;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box; /* Include padding in the input width */
            }
            a {
                display: block;
                margin: 10px 0;
                color: #007bff;
                text-decoration: none;
                text-align: center;
            }
            a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <nav class="menu">
            <ul>
                <li><a href="index.html" class="logo">Internet Of Things Bay</a></li>
                <li><a href="fallback.jsp">Products</a></li>
                <li><a href="fallback.jsp">Locations</a></li>
                <li><a href="fallback.jsp">About</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>
        </nav>
        <h1>Register</h1>
        <form action="welcome.jsp" method="POST">
            <table>
                <tr><td>First Name:</td></tr><tr><td><input type="text" placeholder="Enter Name" name="first_name" required="true"></td></tr>
                <tr><td>Last Name:</td></tr><tr><td><input type="text" placeholder="Enter Last Name" name="last_name" required="true"></td></tr>
                <tr><td>Email:</td></tr><tr><td><input type="text" placeholder="Enter Email" name="email" required="true"></td></tr>
                <tr><td>Password:</td></tr><tr><td><input type="password" placeholder="Enter Password" name="pass" required="true"></td></tr>
                <tr><td>Date of Birth:</td></tr><tr><td><input type="date" placeholder="Enter DOB" name="dob" required="true" max="2012-05-17"></td></tr>
                <tr><td>Phone: </td></tr><tr><td><input type="text" placeholder="Enter Phone" name="phone" required="true"></td></tr>
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