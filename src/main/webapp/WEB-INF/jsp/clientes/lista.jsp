<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/WEB-INF/jsp/template/header.jsp" %>

<a href="${linkTo[ClientesController].form()}">Cadastrar novo usuario</a>

<table class="table table-hover">
    <thead>
        <tr>
            <th>Nome:</th>
            <th>CPF</th>
            <th>Login</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${clientes}" var="c">
            <tr>
                <td>${c.nome}</td>
                <td>${c.cpf}</td>
                <td>${c.login}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="/WEB-INF/jsp/template/footer.jsp" %>