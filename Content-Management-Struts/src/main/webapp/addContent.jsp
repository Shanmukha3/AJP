<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Content</title>
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
        .form-container {
            width: 50%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
            overflow: hidden;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input[type="text"], .form-group input[type="date"], .form-group input[type="number"], .form-group textarea {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .form-group input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%
    HttpSession session2 = request.getSession(false);
    if (session2 == null || session2.getAttribute("username") == null) {
        // User is not logged in, redirect to login page
        response.sendRedirect("index.jsp");
    } else {
        // User is logged in, display list of tasks and delete form
%>
    <h1>Add Content</h1>

    <div class="form-container">
        <form action="AddContentAction" method="post">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" name="content.title" required />
            </div>
            <div class="form-group">
                <label for="author">Author:</label>
                <input type="text" name="content.author" required />
            </div>
            <div class="form-group">
                <label for="date">Date of Publish:</label>
                <input type="date" name="content.publishDate" required />
            </div>
            <div class="form-group">
                <label for="category">Category:</label>
                <input type="text" name="content.category" required />
            </div>
            <div class="form-group">
                <label for="content">Content:</label>
                <textarea name="content.content" rows="6" required></textarea>
            </div>
            <div class="form-group">
                <input type="submit" value="Add Content" />
            </div>
        </form>
    </div>
    <%
    }
%>
</body>
</html>
