<%-- 
    Document   : index
    Created on : 01/04/2025, 14:29:00
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
        <form method="post" action="UsuarioController">
            <label>Nome</label>
            <input type="text" name="nome"/>
        <br/>
            <label>Email</label>
            <input type="email" name="email"/>
        <br/>
            <label>Senha</label>
            <input type="password" name="senha"/>
        <br/>
            <label>Acesso</label>
            <select name="nivel">
                <option value="1">Admin</option>
                <option value="2">Usuário</option>
            </select>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
