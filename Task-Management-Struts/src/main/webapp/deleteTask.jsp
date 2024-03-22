<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="com.example.Task"%>
<%@ page import="com.example.FactoryProvider"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Article</title>
<style>
/* Add your CSS styles here */
body {
	font-family: Arial, sans-serif;
}

h1 {
	color: #333;
}

form {
	width: 50%;
	margin: 20px auto;
}

label {
	display: block;
	margin-bottom: 5px;
}

input {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
}

button {
	padding: 10px;
	background-color: #d9534f;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #c9302c;
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
	<h1>List of Tasks</h1>
    
    <table>
        <tr>
        	<th>Id</th>
            <th>Task name</th>
            <th>Description</th>
            <th>Due date</th>
            <th>priority level</th>

        </tr>
        
        <% 
   
            Session session1 = FactoryProvider.getFactory().openSession();
            
            try {
                session1.beginTransaction();
                List<Task> task = session1.createQuery("from Task").getResultList();
                
                for (Task b : task) {
        %>
                <tr>
                	<td><%= b.getId() %></td>
                    <td><%= b.getTask_Name() %></td>
                    <td><%= b.getDescription() %></td>
                    <td><%= b.getDueDate() %></td>
                    <td><%= b.getPriority_Level() %></td>
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
	<h1>Delete Task</h1>

	<form action="deleteTaskAction" method="post">
		<label for="id">ID:</label> <input type="text" id="id" name="id"
			placeholder="Enter Task ID to Delete" required />

		<button type="submit">Delete Task</button>
	</form>
</body>
</html>
