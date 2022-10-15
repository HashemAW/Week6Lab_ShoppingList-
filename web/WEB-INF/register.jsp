<%-- 
    Document   : register
    Created on : 15-Oct-2022, 12:21:02 AM
    Author     : Hashem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register </title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            <label>Username: </label>
            <input type="text" name="username" value=""/>
            <input type="hidden" name="action" value="register"/>
            <input type="submit" value="Register name"/>
            <br><br>
            ${message}${logout}
        </form>
    </body>
</html>
