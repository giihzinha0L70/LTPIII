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
        <title>JSP Page</title>
    </head>
    <body>
        <% String mensagem = "Bem Vindos"; %>
        <h1><%=mensagem%></h1>
        <%=request.getRemoteHost()%>
        
        <%for(int i =1; i<7; i++){%>
            <h<%=i%>>Olá mundo</h<%=i%>>            
        <%}%>
        
            <form action="inserir_usuario.jps" method="get">
                <input type="text" value="Anonimo" name="nome" placeholder="Insira aqui o seu nome"/>
                <input type="submit" value="enviar"/>       
            </form>
            
    </body>
</html>
