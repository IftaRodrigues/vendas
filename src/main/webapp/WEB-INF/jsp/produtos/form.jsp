<%-- 
    Document   : form
    Created on : 17/03/2020, 21:17:52
    Author     : iftar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Produto</title>
    </head>
    <body>
        <c:forEach var="error" items="${errors}">
            ${error.category}  ${error.message}<br />
        </c:forEach>
            
        <form action="${linkTo[ProdutosController].adiciona}"  method="POST">
            <input type="hidden" name="produto.id" value="${produto.id}"/><br/>
            Descrição:
            <input type="text" name="produto.descricao" value="${produto.descricao}"/><br/>
            Valor:
            <input type="text" name="produto.valor" value="${produto.valor}"/><br/>

            <input type="submit" value="Salvar" />
        </form>
    </body>
</html>
