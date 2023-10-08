<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Funcionários | AppFinance</title>
</head>
<body>
	<core:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container mt-3">
		<h2>Listagem de funcionários</h2>
		<a href="/funcionario/cadastro">NOVO FUNCIONÁRIO</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Cargo</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="f" items="${listaFuncionarios}">
					<tr>
						<td>${f.id}</td>
						<td>${f.nome}</td>
						<td>${f.email}</td>
						<td>${f.cargo}</td>
						<td><a href="/funcionario/${f.id}/excluir">excluir</a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>