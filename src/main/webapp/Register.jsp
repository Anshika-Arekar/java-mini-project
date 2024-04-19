<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register for Library System</title>
<link rel="stylesheet" type="text/css" href="register.css">
</head>
<body>
<div class="container">
    <h2>Register for Library System</h2>
    <form action="registerServlet" method="post">
        <label for="name">Userame:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <label for="confirm_password">Confirm Password:</label>
        <input type="password" id="confirm_password" name="confirm_password" required><br>
        <input type="submit" value="Register">
    </form>
    <p>Already have an account? <a href="Login.jsp">Login here</a></p>
</div>
</body>
</html>