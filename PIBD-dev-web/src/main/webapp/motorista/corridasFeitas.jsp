<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
	<fmt:bundle basename="msgs">
	<head>
		<title>
			Corridas Feitas
		</title>
	</head>

	
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
            <p align="center" >Total recebido: ${requestScope.totalRecebido}</p>
            <p align="center" >Corridas Totais: ${requestScope.corridasTotais}</p>

            <form align="center" action="/<%=contextPath%>/motoristas/corridas">
				<label for="start"> <strong>Escolha o mês que deseja ver as suas Corridas!</strong></label>
				<input type="month" min="2018-03" value="2022-03" name="monthYear">
				<input type="submit" class="submit"/>
			</form>

			<div align="center">
				<table border="1">
					<caption>
						Lista de Corridas
					</caption>
					<tr>
						<th>ID</th>
						<th>Valor Recebido</th>
						<th>Valor Total</th>
						<th>Data de início</th>
						<th>Data de fim</th>
					</tr>
					<c:if test="${requestScope.corridas != 'NULL' }">
						<c:forEach var="corrida" items="${requestScope.corridas}">
								<tr>
									<td><a href="/<%=contextPath%>/motoristas/apresentaCorridaDetalhe?id=<c:out value='${corrida.id}'/>">${corrida.id}</a></td>
									<td>${corrida.valor * 0.6}</td>
									
									<td>${corrida.valor}</td>
									<td>${corrida.iniciaAs}</td>
									<td>${corrida.terminaAs}</td>
								</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
		</body>
	</fmt:bundle>
</html>