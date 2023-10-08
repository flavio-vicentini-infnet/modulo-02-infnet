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
	<title>Login | AppFinance</title>
</head>
<body>
	<div class="container mt-3">
		<div class="container">
			<h2>App Finance</h2>
			<form action="/valida" method="post">
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="email"
						placeholder="Entre com o seu email organizacional" name="email">
				</div>
				<div class="form-group">
					<label for="pwd">Senha:</label> <input type="password"
						class="form-control" id="pwd" placeholder="Insira sua senha"
						name="senha">
				</div>
				<button type="submit" class="btn btn-default">Acessar</button>
			</form>
		</div>
	</div>
</body>