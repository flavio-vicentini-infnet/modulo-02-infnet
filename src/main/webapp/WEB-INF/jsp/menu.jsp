<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<div class="container mt-3">
	<nav class="navbar navbar-inverse">
		<p style="color: white; margin-left: 18px">Bem vindo(a),
			${funcionario.nome}</p>
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">AppFinance</a>
			</div>

			<core:if test="${not empty funcionario}">
				<ul class="nav navbar-nav">
				
					<core:if var="admin" test="${funcionario.cargo.equals('admin')}">
						<li><a href="/funcionario/lista">Funcionarios</a></li>
					</core:if>
					
					<li><a href="/cliente/lista">Clientes</a></li>
					<li><a href="/ativo-financeiro/lista">Ativos Financeiros</a></li>
					<li><a href="/investimento/lista">Investimento</a></li>
				</ul>
			</core:if>

			<ul class="nav navbar-nav navbar-right">
				<core:if test="${empty funcionario}">
					<li><a href="/funcionario/cadastro"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</core:if>

				<core:if test="${not empty funcionario}">
					<li><a href="/logout"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>
				</core:if>
			</ul>

		</div>
	</nav>
</div>
