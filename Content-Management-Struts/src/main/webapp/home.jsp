<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    HttpSession session1 = request.getSession(false);
    if (session1 != null && session.getAttribute("username") != null) {
        // Username is in session, display the content
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Content Management</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
            text-align: center;
            padding: 20px 0;
            background-color: #007bff;
            color: #fff;
            margin: 0;
        }
        .operation-links {
            text-align: center;
            margin-top: 20px;
        }
        .operation-links a {
            margin: 0 10px;
            text-decoration: none;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: 1px solid #0056b3;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .operation-links a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Content Management</h1>
    
    <div class="operation-links">
        <a href="addContent.jsp">Add Content</a>
        <a href="displayContent.jsp">Display Content</a>
        <a href="updateContent.jsp">Update Content</a>
        <a href="deleteContent.jsp">Delete Content</a>
    </div>
</body>
</html>
<%
    } else {
        // Redirect to index.jsp if username is not in session
        response.sendRedirect("index.jsp");
    }
%>
