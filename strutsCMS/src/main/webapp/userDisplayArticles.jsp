<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.example.Article" %>
<%@ page import="com.example.FactoryProvider" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Articles</title>
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
            background-color: #4CAF50; /* Changed to green */
            color: #fff;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .container {
            text-align: center;
            margin-top: 20px;
        }
        .btn {
            margin-top: 10px;
            text-decoration: none;
            padding: 10px 20px;
            background-color: #4CAF50; /* Changed to green */
            color: #fff;
            border: 1px solid #388E3C; /* Changed border color */
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .btn:hover {
            background-color: #388E3C; /* Changed hover color */
        }
    </style>
</head>
<body>
    <h1>List of Articles</h1>
    
    <table>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Content</th>
            <th>Publication Date</th>
            <th>Author Information</th>
            <th>Category</th>
        </tr>
        
        <% 
            HttpSession session2 = request.getSession(false);
            if (session2 != null && session2.getAttribute("username") != null) {
                Session session1 = FactoryProvider.getFactory().openSession();
                try {
                    session1.beginTransaction();
                    List<Article> articles = session1.createQuery("from Article").getResultList();
                    
                    for (Article i : articles) {
        %>
                    <tr>
                        <td><%= i.getId() %></td>
                        <td><%= i.getTitle() %></td>
                        <td><%= i.getContent() %></td>
                        <td><%= i.getPublicationDate() %></td>
                        <td><%= i.getAuthorInformation() %></td>
                        <td><%= i.getCategory() %></td>
                    </tr>
        <%
                    }
                    session1.getTransaction().commit();
                } finally {
                    if (session1 != null && session1.isOpen()) {
                        session1.close();
                    }
                }
            } else {
                out.println("<tr><td colspan='6'>You are not logged in.</td></tr>");
            }
        %>
    </table>
    
    <div class="container">
        <a href="userHome.jsp" class="btn">User Home</a>
    </div>
</body>
</html>
