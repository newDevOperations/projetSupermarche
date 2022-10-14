<%@ include file="/jsp/header.jsp"%>

	<table>
		<caption>Articles du magasin</caption>
		<tr>
			<th>Code Barre</th>
			<th>Nom Article</th>
			<th>Prix TTC</th>
		</tr>

		<% 
		ServletContext context = this.getServletContext();
		
		HashMap<Long, Article> mag = (HashMap<Long, Article>) context.getAttribute("magasin");
 		
		for (Map.Entry<Long, Article> e : mag.entrySet()) {%>
		<tr>
			<td><%= e.getKey() %></td>

			<td><%= e.getValue().getLibelle() %></td>
			
			<td>&euro; <fmt:formatNumber
					value="<%= e.getValue().getPrixTTC() %>" pattern="0.00" /></td>

			<td><a href="PanierAjout?art=<%= e.getKey() %>">Ajouter au
					panier</a></td>
		</tr>
		<% } %>

	</table>

	<br>

	<a href="<%= request.getContextPath() %>/Panier">Visualiser le
		panier</a>

</body>
</html>