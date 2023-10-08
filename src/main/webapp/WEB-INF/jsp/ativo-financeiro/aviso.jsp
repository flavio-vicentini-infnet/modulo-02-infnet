<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aviso | AppFinance</title>
</head>
<body>
	<core:import url="/WEB-INF/jsp/menu.jsp" />
	<div class="container mt-3">
		<a href="/ativo-financeiro/lista">VOLTAR</a>
		
		<h1>Aviso de restrição!</h1>
		<p>Ativo Financeiro não pode ser excluído pois há clientes com investimentos deste ativo financeiro.</p>
		
	</div>
</body>
</html>