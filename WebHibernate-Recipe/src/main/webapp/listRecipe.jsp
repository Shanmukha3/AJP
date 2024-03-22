<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.vignan.Recipe" %>
<%@ page import="com.helper.FactoryProvider" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Recipes</title>
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
    <h1>List of Recipes</h1>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Recipe Name</th>
            <th>Ingredients</th>
            <th>Instructions</th>
            <th>difficultyLevel</th>
        </tr>
        
        <% 
   
            Session session2 = FactoryProvider.getFactory().openSession();
            
            try {
                session2.beginTransaction();
                List<Recipe> recipes = session2.createQuery("from Recipe",Recipe.class).getResultList();
                
                for (Recipe recipe : recipes) {
        %>
                <tr>
                    <td><%= recipe.getRecipeid() %></td>
                    <td><%= recipe.getRecipename() %></td>
                    <td><%= recipe.getIngredients() %></td>
                    <td><%= recipe.getInstructions() %></td>
                    <td><%= recipe.getDifficultylevel() %></td>
                </tr>
        <%
                }
                session2.getTransaction().commit();
            } finally {
            	session2.close();
            }
        %>
        <div class="container text-center mt-2">
        	<a href="index.jsp" class="btn btn-primary">Home</a>
        </div>
    </table>
</body>
</html>
