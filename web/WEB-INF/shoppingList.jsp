<%-- 
    Document   : shoppingList
    Created on : 15-Oct-2022, 12:46:38 AM
    Author     : Hashem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            Hello, ${username}<br><br>
            <a href="ShoppingList?action=logout">Logout</a>
        </div>
            <div>
                <h2>List</h2>
                <div>
                    <form action="" method="POST">
                        <label>Add item: </label>
                        <input type="text" name="item" value="">
                        <input type="submit" value="Add">
                        <input type="hidden" name="action" value="add">
                    </form>
                    ${errormessage}
                </div>
                
                <form action="" method="POST"> 
                <ul>
                    <c:forEach var="item" items="${list}">
                        <input type='radio' name='listItem' value='${item}'><c:out value="${item}" /><br>
                    </c:forEach>
                </ul>                  
                  <input type="submit" value="Delete">
                  <input type="hidden" name="action" value="delete">
                </form>

            </div>
    </body>
</html>
