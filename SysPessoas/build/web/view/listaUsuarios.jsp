<%-- 
    Document   : listaUsuarios
    Created on : 08/04/2025, 15:35:18
    Author     : 363707
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Usuarios Cadastrados</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Acesso</th>
                <th colspan="2">Ações</th>
            </tr>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                    <td>
                        <c:if test="${usuario.acesso==1}">
                            Admin
                        </c:if>
                        <c:if test="${usuario.acesso!=1}">
                            Usuario
                        </c:if>
                    </td>
                    <td>
                    <a href="UsuarioController?acao=alterar&id=${usuario.id}">
                        <button>Alterar</button>                     
                    </a>                    
                    </td>   
                    <td>
                        
                        <button onclick="deletaRegistro(${usuario.id})">Excluir</button>   
                        
                    </td>>    
                </tr>
            </c:forEach>
    	</table>
        
        <script type="text/javascript">
            function deletarRegistro(id){
                let confirma = confirm(
                        "Deseja deletar o usuário de ID n°:" + id +"?"
                        );
                if(confirm){
                    window.location.href="UsuarioController? action = deletar $id="+id;
                }
                
            }
            
            function alterarUsuario(id){
                 window.location.href =
                         "UsuarioController?action=alterar&id="+id;
             }
             
        </script>    
        
    </body>
</html>