<%@ include file="/jsp/header.jsp"%>

	<table>
		<caption>Articles du magasin</caption>
		<tr>
			<th>Code Barre</th>
			<th>Nom Article</th>
			<th>Ref. Article</th>
			<th>Prix HT</th>
			<th>TVA</th>
			<th>Prix TTC</th>
		</tr>

		<% ServletContext context = this.getServletContext();
 	HashMap<Long, Article> mag = (HashMap<Long, Article>) context.getAttribute("magasin");
 for (Map.Entry<Long, Article> e : mag.entrySet()) {%>
		<tr>
			<td><%= e.getKey() %></td>
			
			<td><%= e.getValue().getLibelle() %></td>

			<td><%= e.getValue().getReference() %></td>

			<td>&euro; <fmt:formatNumber
					value="<%= e.getValue().getPrixHTf() %>" pattern="0.00" /></td>

			<td><fmt:formatNumber 
					value="<%= e.getValue().getTVAf() %>" pattern="0.00 %"/></td>
			
			<td>&euro; <fmt:formatNumber
					value="<%= e.getValue().getPrixTTC() %>" pattern="0.00" /></td>

			<td><a href="ArticleModif?art=<%= e.getKey() %>">Modifier</a></td>

			<td><a href="ArticleSup?art=<%= e.getKey() %>">Supprimer</a></td>
		</tr>

		<% } %>

	</table>
	<br>
	<a href="<%= request.getContextPath() %>/ArticleAjout">Ajouter un
		article</a>

</body>
</html>