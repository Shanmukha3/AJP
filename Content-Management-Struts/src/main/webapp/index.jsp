<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7; /* Light gray */
        }
        h1 {
            color: #fff;
            text-align: center;
            padding: 20px 0;
            background-color: blue; /* Blue */
            margin: 0;
        }
        .form-container {
            width: 30%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 20px;
            overflow: hidden;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #333; /* Dark gray */
        }
        .form-group input[type="text"], .form-group input[type="password"], .form-group input[type="date"], .form-group input[type="number"] {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
            outline: none;
        }
        .form-group input[type="submit"] {
            background-color: blue; /* Blue */
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        .form-group input[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue */
        }
        .form-group input[type="submit"]:focus {
            outline: none;
        }
        .container {
            text-align: center;
        }
        .container .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: blue; /* Blue */
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            margin-top: 10px;
        }
        .container .btn:hover {
            background-color: #0056b3; /* Darker blue */
        }
    </style>
</head>
<body>
    <h1>Login</h1>

    <div class="form-container">
        <%-- Check if username is in session --%>
        <% String username = (String) session.getAttribute("username");
           if (username != null && !username.isEmpty()) { %>
               <%-- Redirect to home page if username is in session --%>
               <% response.sendRedirect("home.jsp"); %>
        <% } else { %>
               <%-- Display login form if username is not in session --%>
               <form action="LoginAction" method="post">
                   <div class="form-group">
                       <label for="username">Username:</label>
                       <input type="text" name="username" required />
                   </div>
                   <div class="form-group">
                       <label for="password">Password:</label>
                       <input type="password" name="password" required />
                   </div>
                   
                   <div class="form-group">
                       <input type="submit" value="Login" />
                   </div>
               </form>
        <% } %>
    </div>
    <div class="container">
         <a href="signup.jsp" class="btn">SignUp</a>
    </div>
    
</body>
</html>
