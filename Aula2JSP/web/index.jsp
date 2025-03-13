<%-- 
    Document   : index
    Created on : 11/03/2025, 14:31:41
    Author     : 363707
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Página Inicial</title>
    </head>
    <body>
        <h1>Bem-vindo à Página Inicial!</h1>
        
        <!-- Link para a página de inserção de usuário -->
        <p><a href="form_inserir_usuario.jsp">Clique aqui para inserir um novo usuário</a></p>
        
        <h1>Contagem de 10 até 1</h1>
        
        <ul>
            <% 
                // Loop para realizar a contagem de 10 até 1
                for (int i = 10; i >= 1; i--) {
            %>
                <li><%=i%></li>
            <% 
                }
            %>
        </ul>
        
        <form action="inserir_usuario.jsp" method="get">
            <input type="text" value="Anonimo" name="nome" placeholder="Insira aqui o seu nome"/>
            <input type="submit" value="enviar"/>
        </form>
    </body>
</html>
