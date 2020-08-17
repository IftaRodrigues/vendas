<%-- 
    Document   : form
    Created on : 17 de ago de 2020, 00:38:00
    Author     : ifta
--%>
<%@include file="/WEB-INF/jsp/template/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="${linkTo[UsuariosController].login}" method="POST">
    Login:
    <input type="text" name="usuario.login" value="${usuario.login}"/>
    
    Senha:
    <input type="text" name="usuario.senha" value="${usuario.senha}"/>
    
    <input type="submit" value="Entrar"/>
</form>

<%@include file="/WEB-INF/jsp/template/footer.jsp" %>