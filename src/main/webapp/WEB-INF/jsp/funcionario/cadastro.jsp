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

<title>Cadastro Funcionário | AppFinance</title>
</head>
<div class="container mt-3">
	<div class="container">
		<h3>Cadastro novo funcionario</h3>
		<form action="/funcionario/incluir" method="post">
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text"
					class="form-control" id="nome" placeholder="Insira seu nome"
					name="nome">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Informe um email para ser seu acesso ao sistema"
					name="email">
			</div>
			<div class="form-group">
				<label for="senha">Senha:</label> <input type="text"
					class="form-control" id="senha" placeholder="Crie uma senha para entrar no sistema"
					name="senha">
			</div>
			<button type="submit" class="btn btn-default">Cadastrar</button>
		</form>
	</div>
</div>
