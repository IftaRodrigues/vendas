<%@ include file="../template/header.jsp" %>

<c:forEach items="${compras}" var="c">
    <legend>Data: ${c.date}</legend>
    <table class="table table-hover">
        <thead>
            <tr>

                <th>Descrição</th>
                <th>Qtd.</th>
                <th>Valor</th>
                <th>Total</th>

            </tr> 
        </thead>


        <tr>
            <c:forEach items="${c.itens}" var="i">
            <tr>
                <td>${i.produto.descricao}</td>
                <td>${i.qtd}</td>
                <td>${i.produto.valor}</td>
            </c:forEach>
            <td>${c.total()}</td>
        </tr>
    </tr>     

</table>
</c:forEach>
<%@ include file="../template/footer.jsp" %>