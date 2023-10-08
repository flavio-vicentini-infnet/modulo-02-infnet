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
<title>Cadastro Cliente | AppFinance</title>
</head>
<body>
	<div class="container mt-3">
		<div class="container">
			<h3>Cadastro novo cliente</h3>
			<form action="/cliente/incluir" method="post">
				<div class="form-group">
					<label for="nome">Nome:</label> <input type="text"
						class="form-control" id="nome" placeholder="Nome do cliente"
						name="nome">
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="email"
						placeholder="Email de contato do cliente" name="email">
				</div>
				<button type="submit" class="btn btn-default">Cadastrar</button>
			</form>
		</div>
	</div>
</body>