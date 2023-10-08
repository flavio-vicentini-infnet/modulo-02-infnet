<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Tesouro | AppFinance</title>
</head>
<body>
	<core:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container mt-3">
		<h2>Listagem de tesouro</h2>
		<a href="/tesouro/cadastro">NOVO TESOURO</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Descrição</th>
					<th>Taxa</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="t" items="${listaTesouro}">
					<tr>
						<td>${t.id}</td>
						<td>${t.descricao}</td>
						<td>${t.taxa} %</td>
						<td><a href="/tesouro/${t.id}/excluir">excluir</a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>