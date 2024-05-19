<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="IoTBay.*"%>
<%@ page import="java.sql.*"%>
<%-- <%@ page import="javax.servlet.http.*" %> --%>
<%-- <%@ page import="java.io.*" %> --%>
<%
    // HttpSession session = request.getSession(false);
    // Controller.saveSession(session.getAttribute("user_id"), session.getAttribute("login"), new Timestamp(System.currentTimeMillis()).toString());
    if (session != null) {
        session.invalidate();  // Closes the session until logged back in
    }
    response.sendRedirect("index.html");  // will auto redirect back to index.html
%>