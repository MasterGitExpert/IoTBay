<!DOCTYPE html>
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
             .modal-content {
                text-align: center;
             }
        </style>
    </head>
    <body>
        <div id="logoutModal" class="modal">
            <div class="modal-content">
                <h1>Logout</h1>
                <p>Are you sure you want to logout?</p>
                <form action="logoutFunction.jsp" method="POST">
                    <button type="submit" >Logout</button>  <%-- Logout event will be processed in logoutFunction.jsp --%>
                    <button type="button" onclick="cancelLogout()">Cancel</button>
                </form>
            </div>
        </div>
        <script>
            function cancelLogout() {
                // Cancel Logout Button Event  
                console.log("Logout cancelled");
                window.history.back();
            }
        </script>
    </body>
</html>