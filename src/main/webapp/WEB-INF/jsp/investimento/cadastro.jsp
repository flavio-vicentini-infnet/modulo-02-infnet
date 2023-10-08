<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<core:import url="/WEB-INF/jsp/menu.jsp" />
<title>Cadastro Investimento | AppFinance</title>
</head>
<div class="container mt-3">
	<div class="container">
		<h3>Cadastro novo investimento</h3>
		<form action="/investimento/incluir" method="post">

			<div class="form-group">
				<label>Cliente:</label> <select name="cliente" class="form-control">
					<core:forEach var="c" items="${clientes}">
						<option value="${c.id}">${c.nome}</option>
					</core:forEach>
				</select>
			</div>

			<div class="form-group">
				<label>Ativo Financeiro:</label> <select name="ativo"
					class="form-control">
					<core:forEach var="a" items="${ativos}">
						<option value="${a.id}">${a.descricao}</option>
					</core:forEach>
				</select>
			</div>

			<div class="form-group">
				<label for="quantidade">Quantidade:</label> <input type="text"
					class="form-control" id="quantidade"
					placeholder="Insira a quantidade" name="quantidade">
			</div>

			<div class="form-group">
				<label for="descricao">Preço:</label> <input type="text"
					class="form-control" id="preco"
					placeholder="Insira o preço unitário do investimento" name="preco">
			</div>

			<button type="submit" class="btn btn-default">Cadastrar</button>
		</form>
	</div>
</div>