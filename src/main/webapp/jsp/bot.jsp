<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en-EN">
<head>
    <title>JavaBean</title>
</head>
<body>

<section>
    <h3>Bot info</h3>
    <jsp:useBean id="bot" scope="request" class="module3.lecture8.Bot"/>
    <tr>
        <td>ID: ${bot.id} | Name: ${bot.name} | Serial number: ${bot.serial}</td>
        <td><a href="/user-program/lesson8/bot?action=update">Update</a></td>
    </tr>
</section>

</body>
</html>