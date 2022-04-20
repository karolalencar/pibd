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
            <p align="center" >Total recebido: ${requestScope.totalRecebido}</p>
            <p align="center" >Corridas Totais: ${requestScope.corridasTotais}</p>
            
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
									<td><a href="/motoristas/apresentaDetalhamentoCorrida/">${corrida.id}</a></td>
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