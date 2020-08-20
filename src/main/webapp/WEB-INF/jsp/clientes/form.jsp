<%-- 
    Document   : form
    Created on : 17 de ago de 2020, 00:38:00
    Author     : ifta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--inclusão da tag para mensagem de erro/validação de campos-->
<%@taglib tagdir="/WEB-INF/tags" prefix="validation" %>


<%@include file="/WEB-INF/jsp/template/header.jsp" %>
<form action="${linkTo[ClientesController].adiciona(null)}" method="POST">

    <validation:validationMessage name="cliente.nome"/>
    <label for="nome">Nome:</label> 
    <input type="text" name="cliente.nome" id="nome" class="form-control" value="${cliente.nome}"/>

    <validation:validationMessage name="cliente.cpf"/>
    <label for="cpf">CPF:</label>
    <input type="text" name="cliente.cpf" id="cpf" class="form-control" value="${cliente.cpf}"/>

    <validation:validationMessage name="cliente.login"/>
    <label for="login">Login:</label>
    <input type="text" name="cliente.login" id="login" class="form-control" value="${cliente.login}"/>

    <validation:validationMessage name="cliente.senha"/>
    <label for="senha">Senha:</label>
    <input type="password" name="cliente.senha" id="senha" class="form-control" />

    <input type="submit" value="Cadastrar" class="btn"/>
</form>

<%@include file="/WEB-INF/jsp/template/footer.jsp" %>