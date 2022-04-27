<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt_br"> 
<head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>taxi</title> 

    <%
        String contextPath = request.getContextPath().replace("/", "");
    %>

</head>
<body id= "page-start" >
    <div id= "container">
        <header class="page-header">
            <div class="top-bar-container">
                <a class="button" href="/<%= contextPath%>/clients/home">Voltar</a>
            </div>
            <div class="header-content">
                <strong>Escolha o mês</strong> 
                <form id="search-prof" method="post" action="${pageContext.request.contextPath}/clients/faturaMes" >
                    <div class="select-block">
                        <label for="mes">Mes</label>
                        <select name="mes" id="mes">
                            <option value="">Escolha uma opção:</option>
                            <option value="01">Janeiro</option>
                            <option value="02">Fevereiro</option>
                            <option value="03">Março</option>
                            <option value="04">Abril</option>
                            <option value="05">Maio</option>
                            <option value="06">Junho</option>
                            <option value="07">Julho</option>
                            <option value="08">Agosto</option>
                            <option value="09">Setembro</option>
                            <option value="10">Outubro</option>
                            <option value="10">Novembro</option>
                            <option value="11">Dezembro</option>
                        </select>
                    </div>
                    <button type="submit">Filtrar</button>
                </form>
            </div>
                </header>
        <main>
            <div>
                <p>Valor total: <label>${requestScope.valor_total}</label></p>
                <p>Corridas pagas: <label>${requestScope.num_corridas}</label></p>
                <p>Situação:<label> ${requestScope.fatura.situacao}</label></p>
            </div>
            
            
           <table border="1">
			<caption>Corridas</caption>
			<tr>
                <th>Id</th>
				<th>Valor</th>
				<th>Data Inicio</th>
				<th>Data Termino</th>
				<th>Detalhes</th>
			</tr>
			<c:forEach var="corrida" items="${requestScope.corridas}">
				<tr>
					<td>${corrida.id}</td>
					<td>${corrida.valor}</td>
					<td>${corrida.iniciaAs}</td>
					<td>${corrida.terminaAs}</td>
					<td align="center" ><a href="/<%=contextPath%>/clients/detalheCorrida?id=<c:out value='${corrida.id}'/>">Verificar Corrida</a></td>
				</tr>
			</c:forEach>
		</table>
        
        </main>
    </div>
</body>
</html>

