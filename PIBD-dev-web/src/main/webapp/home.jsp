<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	    <head>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	        <title>
                taxi
	        </title>
	        <link href="styles.css" rel="stylesheet" type="text/css"/>
	    </head>
	    <body>
			<div >				
				<div class="hello">
				<c:if test="${sessionScope.usuarioLogado.papel == 'MOT' }">
					<p>Seja bem-vindo(a) ${sessionScope.usuarioLogado.nome}!</p>
                    <a href="">Corridas Feitas</a>
                    <a href="">Corridas Pendentes</a>
                    <a href="">Carros</a>
				</c:if>

                <c:if test="${sessionScope.usuarioLogado.papel == 'CONV' }">
					<p>Seja bem-vindo(a) ${sessionScope.usuarioLogado.nome}!</p>
                    <a href="">Faturas</a>
                    <a href="">Corridas Pendentes</a>
                    <a href="">Agendar Corridas</a>
                    <a href="">Passageiros</a>
				</c:if>

                <c:if test="${sessionScope.usuarioLogado.papel == 'ADMIN' }">
					<p>Seja bem-vindo(a) ${sessionScope.usuarioLogado.nome}!</p>
                    <a href="">Motoristas</a>
                    <a href="">Conveniadas</a>
                    <a href="">Agendamentos</a>
                    <a href="">Corridas</a>
				</c:if>
				</div>
				<br>
			</div>			
	    </body>
</html>