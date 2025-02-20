<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-EN">
<head>
    <title>JavaBean</title>
</head>
<body>

<jsp:useBean id="user" class="module3.lecture8.User" scope="session"/>
<jsp:setProperty name="user" property="name" value="Java"/>
<jsp:setProperty name="user" property="age" value="55"/>

<h1>User info:</h1>
<p>Name: <jsp:getProperty name="user" property="name"/></p>
<p>Age: <jsp:getProperty name="user" property="age"/></p>

</body>
</html>