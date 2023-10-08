<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Ativos Financeiro | AppFinance</title>
</head>
<body>
	<core:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container mt-3">
		<h2>Listagem de ativos financeiro</h2>

		<table class="table table-striped" title="Lista de Ações">
			<caption>
				Lista de Ações
				<core:if var="admin" test="${funcionario.cargo.equals('admin')}">
					<a href="/acoes/cadastro"> | CADASTRAR NOVA AÇÃO</a>
				</core:if>
			</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>Descrição</th>
					<th>Símbolo</th>
					<core:if var="admin" test="${funcionario.cargo.equals('admin')}">
						<th></th>
					</core:if>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="i" items="${listaAcoes}">
					<tr>
						<td>${i.id}</td>
						<td>${i.descricao}</td>
						<td>${i.simbolo}</td>
						<core:if var="admin" test="${funcionario.cargo.equals('admin')}">
							<td><a href="/ativo-financeiro/${i.id}/excluir">excluir</a></td>
						</core:if>
					</tr>
				</core:forEach>
			</tbody>
		</table>

		<table class="table table-striped"
			title="Lista de Fundos de Investimento">
			<caption>
				Lista de Fundos de Investimento
				<core:if var="admin" test="${funcionario.cargo.equals('admin')}">
					<a href="/fundo-de-investimento/cadastro"> | CADASTRAR NOVO FUNDO
						DE INVESTIMENTO</a>
				</core:if>
			</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>Descrição</th>
					<th>CNPJ</th>
					<core:if var="admin" test="${funcionario.cargo.equals('admin')}">
						<th></th>
					</core:if>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="i" items="${listaFundos}">
					<tr>
						<td>${i.id}</td>
						<td>${i.descricao}</td>
						<td>${i.cnpj}</td>
						<core:if var="admin" test="${funcionario.cargo.equals('admin')}">
							<td><a href="/ativo-financeiro/${i.id}/excluir">excluir</a></td>
						</core:if>
					</tr>
				</core:forEach>
			</tbody>
		</table>

		<table class="table table-striped" title="Lista de Tesouro">
			<caption>
				Lista de Tesouro
				<core:if var="admin" test="${funcionario.cargo.equals('admin')}">
					<a href="/tesouro/cadastro"> | CADASTRAR NOVO TESOURO</a>
				</core:if>
			</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>Descrição</th>
					<th>Taxa</th>
					<core:if var="admin" test="${funcionario.cargo.equals('admin')}">
						<th></th>
					</core:if>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="i" items="${listaTesouro}">
					<tr>
						<td>${i.id}</td>
						<td>${i.descricao}</td>
						<td>${i.taxa}%</td>
						<core:if var="admin" test="${funcionario.cargo.equals('admin')}">
							<td><a href="/ativo-financeiro/${i.id}/excluir">excluir</a></td>
						</core:if>
					</tr>
				</core:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>