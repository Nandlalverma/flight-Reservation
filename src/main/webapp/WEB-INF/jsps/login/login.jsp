<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
        <h2>Login Here</h2>
        ${error}
        <form action="verifylogin" method="post">
         Email Id<input type="text"name="emailId" />
          Password<input type="text" name="password" />
          <input type="submit" name="login">
        
        </form>
</body>
</html>