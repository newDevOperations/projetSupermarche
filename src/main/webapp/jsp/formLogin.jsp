<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" />

<meta charset="UTF-8">
<title>Page de Login</title>
</head>
<body>

<div id="container">
                      
            <form method="POST">
                <h1>Connexion</h1>
                
                <label><b>Nom d'utilisateur</b></label>
                <input type="text" placeholder="Entrer le nom d'utilisateur" name="username" required>

                <label><b>Mot de passe</b></label>
                <input type="password" placeholder="Entrer le mot de passe" name="password" required>

                <input type="submit">
                
                <% if(session.getAttribute("message") != null) { %>
			<p><%= session.getAttribute("message") %></p>
		<% } %>
               
            </form>
        </div>
<a href="<%= request.getContextPath() %>/Anonymous">Revenir au Magasin</a>

</body>
</html>

