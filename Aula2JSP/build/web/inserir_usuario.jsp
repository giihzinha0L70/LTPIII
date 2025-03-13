<%-- 
    Document   : inserir_usuario
    Created on : 11/03/2025, 15:00:20
    Author     : 363707
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados do Usuário</title>
    </head>
    <body>
        <h1>Olá, <%= request.getParameter("nome") %>!</h1>

        <p><strong>Login:</strong> <%= request.getParameter("login") %></p>
        <p><strong>Senha:</strong> <%= request.getParameter("senha") %></p>

        <!-- Link para voltar ao formulário -->
        <p><a href="form_inserir_usuario.jsp">Voltar ao formulário</a></p>
    </body>
</html>
