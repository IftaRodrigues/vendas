<%-- 
    Document   : form
    Created on : 17/03/2020, 21:17:52
    Author     : iftar
--%>
<%@ include file="/WEB-INF/jsp/template/header.jsp" %>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="v" %>

        <form action="${linkTo[ProdutosController].adiciona}"  method="POST">
            <legend> Cadastro de Produto </legend>
            
            <input type="hidden" name="produto.id" value="${produto.id}"/>
           
            <label for="descricao">Descrição:</label>
            <input type="text" name="produto.descricao" id="descricao" class="form-control" value="${produto.descricao}"/>
            <v:validationMessage name="descricao"/>
            
            <label for="valor">Valor:</label>
            <input type="text" name="produto.valor" id="valor" class="form-control"  value="${produto.valor}"/>
            <v:validationMessage name="valor"/>
            
            <input type="submit" value="Salvar" class="btn"/>
        </form>
<%@ include file="/WEB-INF/jsp/template/footer.jsp" %>