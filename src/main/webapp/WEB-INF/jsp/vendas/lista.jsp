<%@ include file="../template/header.jsp" %>

<c:forEach items="${vendas}" var="c">

    <table class="table table-hover">
        <legend>Cliente:${c.cliente.nome}<br/> Data: ${c.date}</legend>
        <thead>
            <tr>
                <th>Descrição</th>
                <th>Qtd.</th>
                <th>Valor</th>
                

            </tr> 
        </thead>

        <tbody>
            <tr>
                <c:forEach items="${c.itens}" var="i">
                <tr>
                    <td>${i.produto.descricao}</td>
                    <td>${i.qtd}</td>
                    <td>${i.produto.valor}</td>
                </tr>
                </c:forEach>
                
            </tr>
            <tr><th>Total</th><td>${c.total()}</td></tr>
        </tbody>    

    </table>
</c:forEach>
<%@ include file="../template/footer.jsp" %>