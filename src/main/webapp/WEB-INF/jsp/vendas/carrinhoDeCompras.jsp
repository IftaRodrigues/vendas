<%-- 
    Document   : carrinhoDeCompras
    Created on : 30/04/2020, 14:48:30
    Author     : iftar
--%>
<%@ include file="/WEB-INF/jsp/template/header.jsp" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table id="produtos" border="1">
    <thead>
    <caption>PRODUTOS</caption>
    <!--                <tr><th colspan="3"></th></tr>-->
    <tr>
        <th>Descrição</th>
        <th>Preço</th>
        <th>Quantidade</th>
    </tr>
    <tbody>
        <c:forEach items="${produtoList}" var="p">
            <tr>
                <td>${p.descricao}</td>
                <td>${p.valor}</td>
                <td>
                    <form action="${linkTo[VendasController].adicionaItem}" method="POST">
                        <input type="hidden" name="itemVenda.produto.id" value="${p.id}"/>
                        <input type="text" name="itemVenda.qtd"/>
                        <button type="submit">Add</button>
                    </form>
                </td>
            </tr>
        </c:forEach> 
    </tbody>
</table>

<table id="itens" border="1">
    <thead>
    <caption>Itens do Carrinho</caption>
    <tr>
        <th>Produto</th>
        <th>Quantidade</th>
        <th>Valor Parcial</th> 
    </tr>
</thead>
<tbody>
    <c:forEach items="${vendaSession.itens}" var="i">
        <tr>
            <td>${i.produto.descricao}</td>
            <td>${i.qtd}</td>
            <td>${i.total()}</td>
        </tr>
    </c:forEach>

</tbody>
<tfoot>
    <tr>

        <td colspan="2">Total</td>
        <td>${vendaSession.total()}</td>
        <td>
            <form action="${linkTo[VendasController].adicionaVenda}" method="POST">
                   <button type="submit">Comprar</button>
            </form>
                
        </td>
    </tr>
</tfoot>
</table> 
      

<%@ include file="/WEB-INF/jsp/template/footer.jsp" %>                   