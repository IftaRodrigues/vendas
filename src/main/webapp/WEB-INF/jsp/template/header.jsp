<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>ShoopAle</title>
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="<c:url value="/site.css"/>"  rel="stylesheet" />    
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">HOME</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Produtos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${linkTo[ProdutosController].form}">Novo</a>
                            <a class="dropdown-item" href="${linkTo[ProdutosController].lista}">Consultar</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Vendas
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${linkTo[VendasController].carrinhoDeCompras}">Novo</a>
                            <a class="dropdown-item" href="${linkTo[VendasController].lista}">Consultar</a>
                        </div>
                    </li>


                </ul>
            </div>
                        
            <div style="padding-right: 70px">
                <c:choose>
                    <c:when test="${not empty clienteLogado.cliente}">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    ${clienteLogado.cliente.login}
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <form action="${linkTo[VendasController].compras(null)}" method="POST">                                        
                                        <input type="hidden" name="login" value="${clienteLogado.cliente.login}"/>
                                        <button class="dropdown-item" type="submit" >Minhas Compras</button>
                                    </form>
                                    <form action="${linkTo[ClientesController].remove(null)}" method="POST">                                        
                                        <input type="hidden" name="login" value="${clienteLogado.cliente.login}"/>
                                        <button class="dropdown-item" type="submit">Excluir Cadastro</button>
                                    </form>
                                    <a  class="dropdown-item" href="${linkTo[ClientesController].logout}">Sair</a>
                                </div>
                            </li>
                        </ul>

                    </c:when>
                    <c:otherwise>
                        <button class="btn"><a  href="${linkTo[ClientesController].loginForm}">Login</a></button>
                        <button class="btn"><a  href="${linkTo[ClientesController].form}">Cadastre-se</a></button>
                    </c:otherwise>
                </c:choose>
            </div> 
        </nav>


        <br/>
        <div id="conteudo" class="container-fluid">
            <fmt:setBundle basename="messages"/>
            <c:if test="${!empty msg}">
                <p class="message text-success">${msg}</p>
            </c:if>
