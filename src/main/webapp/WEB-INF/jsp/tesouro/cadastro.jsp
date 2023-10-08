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
<title>Cadastro Tesouro | AppFinance</title>
</head>
<div class="container mt-3">
	<div class="container">
		<h3>Cadastro novo tesouro</h3>
		<form action="/tesouro/incluir" method="post">
			<div class="form-group">
				<label for="descricao">Descricao:</label> <input type="text"
					class="form-control" id="descricao"
					placeholder="Insira a descrição do investimento" name="descricao">
			</div>
			<div class="form-group">
				<label for="taxa">Taxa:</label> <input type="text"
					class="form-control" id="taxa"
					placeholder="Insira a taxa" name="taxa">
			</div>
			<button type="submit" class="btn btn-default">Cadastrar</button>
		</form>
	</div>
</div>