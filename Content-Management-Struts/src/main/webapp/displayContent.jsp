<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.example.Content" %>
<%@ page import="com.example.FactoryProvider" %>
<!DOCTYPE html>
<html>
<head>
<%
    HttpSession session2 = request.getSession(false);
    if (session2 == null || session2.getAttribute("username") == null) {
        // User is not logged in, redirect to login page
        response.sendRedirect("index.jsp");
    } else {
        // User is logged in, display list of tasks and delete form
%>
    <meta charset="UTF-8">
    <title>List Articles</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
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
    </style>
</head>
<body>
    <h1>List of Articles</h1>
    
    <table>
        <tr>
        	<th>Id</th>
            <th>Author</th>
            <th>category</th>
            <th>content</th>
            <th>publish date</th>
            <th>title</th>

        </tr>
        
        <% 
   
            Session session1 = FactoryProvider.getFactory().openSession();
            
            try {
                session1.beginTransaction();
                List<Content> content = session1.createQuery("from Content").getResultList();
                
                for (Content b : content) {
        %>
                <tr>
                	<td><%= b.getId() %></td>
                    <td><%= b.getAuthor() %></td>
                    <td><%= b.getCategory() %></td>
                    <td><%= b.getContent() %></td>
                    <td><%= b.getPublishDate() %></td>
                    <td><%= b.getTitle() %></td>
                </tr>
        <%
                }
                session1.getTransaction().commit();
            } finally {
                if (session1 != null && session1.isOpen()) {
                    session1.close();
                }
            }
        %>
        <div class="container text-center mt-2">
        	<a href="index.jsp" class="btn btn-primary">Home</a>
        </div>
    </table>
    <%
    }
%>
</body>
</html>
