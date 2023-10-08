<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Investimento | AppFinance</title>
</head>
<body>
	<core:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container mt-3">
		<h2>Listagem de investimento</h2>
		<a href="/investimento/cadastro">NOVO INVESTIMENTO</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Cliente</th>
					<th>Ativo Financeiro</th>
					<th>Preço</th>
					<th>Quantidade</th>
					<th>Total</th>
					<th>Data</th>
					<th>Gerente</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="i" items="${listaInvestimento}">
					<tr>
						<td>${i.id}</td>
						<td>${i.cliente.nome.toUpperCase()}</td>
						<td>${i.ativo.descricao}</td>
						<td>${i.preco}</td>
						<td>${i.quantidade}</td>
						<td>${i.getTotal()}</td>
						<td>${i.dataFormatada()}</td>
						<td>${i.cliente.funcionario.nome}</td>
						<td><a href="/investimento/${t.id}/excluir">excluir</a></td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>