<%-- 
    Document   : login
    Created on : 13/05/2025, 14:24:20
    Author     : 363707
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="AuthController">
            <label for="email"> Email:</label>>
            <input type="text" name="nome" id="email"/>
            <br/>
            <label>Senha:</label>>
            <input type="password" name="senha"/>
            <br/>
            <button type="submit">Entrar</button>
        </form>
        <a href="index.jsp">Sou novo aqui</a>
    </body>
</html>
