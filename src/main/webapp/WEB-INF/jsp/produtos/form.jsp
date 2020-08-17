<%-- 
    Document   : form
    Created on : 17/03/2020, 21:17:52
    Author     : iftar
--%>
<%@ include file="/WEB-INF/jsp/template/header.jsp" %>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
<%@ include file="/WEB-INF/jsp/template/footer.jsp" %>