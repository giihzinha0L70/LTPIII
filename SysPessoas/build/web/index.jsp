<%-- 
    Document   : index
    Created on : 01/04/2025, 14:26:39
    Author     : 363707
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Cadastro de Pessoas</title>
        <style>
            body {
                font: normal 20px Arial;
            }
        </style>
    </head>
    <body>
        <h1>Cadastrar Pessoas</h1>
          	<form method="post" action="UsuarioController">
        	<input type="hidden" name="id" value="${usuario.id != null ? usuario.id : 0}"/>
        	<label>Nome</label>
        	<input type="text" name="nome" value="${usuario.nome != null ? usuario.nome : ''}"/>
        	<br/>
        	<label>Email</label>
        	<input type="email" name="email" value="${usuario.email != null ? usuario.email : ''}"/>
        	<br/>
        	<label>Senha</label>
        	<input type="password" name="senha" value="${usuario.senha != null ? usuario.senha : ''}"/>
        	<br/>
        	<label>Acesso</label>
        	<select name="nivel">
            	<option value="1">Admin</option>
            	<option value="2">Usuário</option>
        	</select>
        	<input type="submit" value="Enviar"/>
    	</form>

    	<a href="UsuarioController?action=listar">Listar Usuarios</a>

    </body>
</html>