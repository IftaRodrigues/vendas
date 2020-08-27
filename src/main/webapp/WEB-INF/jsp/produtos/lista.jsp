<%-- 
    Document   : lista
    Created on : 26/03/2020, 20:49:38
    Author     : iftar
--%>
<%@ include file="/WEB-INF/jsp/template/header.jsp" %>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-bordered">
    <thead>
        <tr>
            <th>Descrição</th>
            <th>Valor</th>
            <th colspan="2">Opções</th>
        </tr> 
    </thead>
    <c:forEach items="${produtoList}" var="p">
        <tr>
            <td>${p.descricao}</td>
            <td>${p.valor}</td>
            <td><a href="${linkTo[ProdutosController].remove}?id=${p.id}">Excluir</a></td>
            <td><a href="${linkTo[ProdutosController].editar}?id=${p.id}">Editar</a></td>
        </tr>     
    </c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/template/footer.jsp" %>