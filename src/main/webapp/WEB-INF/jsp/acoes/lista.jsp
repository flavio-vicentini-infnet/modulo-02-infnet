<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Ações | AppFinance</title>
</head>
<body>
	<core:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container mt-3">
		<h2>Listagem de ações</h2>
		<a href="/acoes/cadastro">NOVA AÇÃO</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Descrição</th>
					<th>Símbolo</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="a" items="${listaAcoes}">
					<tr>
						<td>${a.id}</td>
						<td>${a.descricao}</td>
						<td>${a.simbolo}</td>
						<td><a href="/acoes/${a.id}/excluir">excluir</a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>