<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Management</title>
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
            background-color: #4CAF50; /* Changed to green */
            color: #fff;
            border: 1px solid #388E3C; /* Changed border color */
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .operation-links a:hover {
            background-color: #388E3C; /* Changed hover color */
        }
    </style>
</head>
<body>
    <h1>Product Management</h1>
    
    <div class="operation-links">
        <s:a href="addProduct.jsp">Add Product</s:a>
        <s:a href="displayProducts.jsp">Display Products</s:a>
        <s:a href="updateProduct.jsp">Update Product</s:a>
        <s:a href="deleteProduct.jsp">Delete Product</s:a>
    </div>
</body>
</html>
