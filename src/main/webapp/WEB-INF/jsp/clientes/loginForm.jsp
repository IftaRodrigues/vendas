<%-- 
    Document   : login
    Created on : 23 de ago de 2020, 20:34:27
    Author     : ifta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../template/header.jsp" %>

<form  action="${linkTo[ClientesController].login(null)}" method="POST">
    <legend>Efetue o Login</legend>
    
    <label for="login">Login:</label>
    <input type="text" name="login" id="login" class="form-control"/>

    <label for="senha">Senha:</label>
    <input type="password" name="senha" id="senha" class="form-control"/>
    
    <c:if test="${!empty errors}">
        <div class="error text-danger">
            <c:forEach items="${errors}" var="e">
                    <span class="validacaoErro">${e.message}</span>
            </c:forEach>
        </div>
    </c:if>

    <input type="submit" value="Entrar" class="btn"/>
</form>


<%@include file="../template/footer.jsp" %>