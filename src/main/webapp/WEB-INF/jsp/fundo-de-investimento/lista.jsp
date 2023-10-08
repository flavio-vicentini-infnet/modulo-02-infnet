<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Fundo de Investimento | AppFinance</title>
</head>
<body>
	<core:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container mt-3">
		<h2>Listagem de fundo de investimento</h2>
		<a href="/fundo-de-investimento/cadastro">NOVO FUNDO DE INVESTIMENTO</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Descrição</th>
					<th>CNPJ</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="f" items="${listaFundoDeInvestimento}">
					<tr>
						<td>${f.id}</td>
						<td>${f.descricao}</td>
						<td>${f.cnpj}</td>
						<td><a href="/fundo-de-investimento/${f.id}/excluir">excluir</a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>