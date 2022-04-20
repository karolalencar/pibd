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
            <p>Total recebido: ${requestScope.totalRecebido}</p>
            <p>Corridas Totais: ${requestScope.corridasTotais}</p>
            
			<div align="center">
				<table border="1">
					<caption>
						<fmt:message key="professional_list"/>
					</caption>
					<tr>
						<th>ID</th>
						<th>Valor Recebido</th>
						<th>Valor Total</th>
						<th>Data de início</th>
						<th>Data de fim</th>
					</tr>
					<c:forEach var="corrida" items="${requestScope.corridas}">
						<a href="">
                            <tr>
                                <td>#${corrida.id}</td>
                                <td>${corrida.valor * 0.6}</td>
                                
                                <td>${corrida.valor}</td>
                                <td>${corrida.inicia_as}</td>
                                <td>${corrida.termina_as}</td>
                            </tr>
                        </a>
					</c:forEach>
				</table>
			</div>
		</body>
	</fmt:bundle>
</html>