<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt_br"> 
<head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agendoc</title> 

    <%
        String contextPath = request.getContextPath().replace("/", "");
    %>

</head>
<body id= "page-start" >
    <div id= "container">
        <header class="page-header">
            <div class="top-bar-container">
                <a class="button" href="/<%= contextPath%>/clients/faturaMes">Voltar</a>
            </div>
        </header>
        <main>
            <div>
                <p>Corrida = ${requestScope.corrida.id}</p>
                
                <p>Valor total: <label>${requestScope.corrida.valor}</label></p>
                <p>Inicia às:<label> ${requestScope.corrida.iniciaAs}</label></p>
                <p>Termina às:<label> ${requestScope.corrida.terminaAs}</label></p>
                <p>Inicia em:<label> ${requestScope.corrida.iniciaEm}</label></p>
                <p>Termina em:<label> ${requestScope.corrida.terminaEm}</label></p>
                      
            </div>
            
            <!--
           <table border="1">
			<caption>Corridas</caption>
			<tr>
                <th>Id</th>
				<th>Nome</th>
				<th>Local</th>
			</tr>
			<c:forEach var="passageiro" items="${requestScope.passageiros}">
				<tr>    
					<td>${passageiro.id}</td>
					<td>${passageiro.nome}</td>
					<td>${passageiro.local}</td>
				</tr>
			</c:forEach>
		</table>
       --> 
        </main>
    </div>
</body>
</html>