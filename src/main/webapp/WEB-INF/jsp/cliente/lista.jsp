<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Cliente | AppFinance</title>
</head>
<body>
	<core:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container mt-3">
		<h2>Listagem de clientes</h2>
		<a href="/cliente/cadastro">NOVO CLIENTE</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Gerente</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="c" items="${listaClientes}">
					<tr>
						<td>${c.id}</td>
						<td>${c.nome}</td>
						<td>${c.email}</td>
						<td>${c.funcionario.nome}</td>
						<td><a href="/cliente/${c.id}/excluir">excluir</a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>