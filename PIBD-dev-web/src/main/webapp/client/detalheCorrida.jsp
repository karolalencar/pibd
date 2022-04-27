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
                <a class="button" href="/<%= contextPath%>/clients/faturaMes">Voltar</a>
            </div>
        </header>
        <main>
            <div>
                <p>Corrida = ${requestScope.corrida.id}</p>
                <p>Nome motorista = ${requestScope.corrida.nome_motorista}</p>
                <p>Valor total: <label>${requestScope.corrida.valor}</label></p>
                <p>Inicia às:<label> ${requestScope.corrida.iniciaAs}</label></p>
                <p>Termina às:<label> ${requestScope.corrida.terminaAs}</label></p>
                <p>Inicia em:<label> ${requestScope.corrida.iniciaEm}</label></p>
                <p>Termina em:<label> ${requestScope.corrida.terminaEm}</label></p>
                      
            </div>
            
            
           <table border="1">
			<caption>Passageiros</caption>
			<tr>
                <th>Cpf</th>
				<th>Nome</th>
				<th>CEP</th>
                <th>num</th>
                
			</tr>
			<c:forEach var="passageiro" items="${requestScope.passageiros}">
				<tr>    
					<td>${passageiro.cpf}</td>
					<td>${passageiro.nome}</td>
					<td>${passageiro.cep}</td>
                    <td>${passageiro.num}</td>
                    
				</tr>
			</c:forEach>
		</table>
       
        </main>
    </div>
</body>
</html>