<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.HashMap, java.util.Map, packsuper.Article"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<p>

	<%-- Affiche infos connexion --%>
	
	<c:out value="${connexion}" default="non connecté" />
	
	<c:choose>
		<c:when test="${connexion == 'admin'}" >
			<a href="<%= request.getContextPath() %>/Anonymous">Se déconnecter</a>
		</c:when>
		<c:otherwise>
			<a href="<%= request.getContextPath() %>/Login">S'identifier</a>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${connexion == 'admin'}" >
			<div class="content">
				<h2> Mode Administrateur </h2>
			</div>
		</c:when>
		<c:otherwise>
			<div class="content">
				<h1> Supermarché JEE </h1>
			</div>
		</c:otherwise>
	</c:choose>
	
	
</p>