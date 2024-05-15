<!--
    To change this license header, choose License Headers in Project Properties.
    To change this template file, choose Tools | Templates
    and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login - IoTBay</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="main.css">
        <style>
            body {
                display: flex; 
                flex-direction: column; 
                align-items: center;
                background-size: cover;
                background-repeat: no-repeat;
                background-image: url("https://www.syte.ai/wp-content/uploads/2021/10/Glossary-Images-1-24_23-1024x625.jpg");
            }
            .transparent-bg {
                margin-top: 150px;
                padding: 15px 85px;
            }
            form > div {
                padding: 10px 30px;
            }
            p {
                text-align: center;
                }
            button{
                margin: 15px 130px;
                margin-bottom: 65px;
            }
        </style>
    </head>
    <body>
        <div class="transparent-bg">
            <div>
                <h1>Internet Of Things Bay</h1>
                <form action="welcome.jsp" method="POST">
                    <table style="border: none;">  
                        <tr>
                            <td><label>Username</label></td><td><input type="text" placeholder="Enter Email" name="username" required="true">                            </td>
                        </tr>
                    <div>  
                        <tr>
                            <td><label>Password&nbsp;</label></td><td><input type="password" placeholder="Enter Password" name="password" required="true"></td>
                        </tr>
                    </table>
                    <input type="hidden" name="form" value="login">
                    <button type="submit" value="submit">Login</button>
                </form>
                <p><a href="register.jsp">Register</a> if your new.</p>
            </div>
        </div>
    </body>
</html>
