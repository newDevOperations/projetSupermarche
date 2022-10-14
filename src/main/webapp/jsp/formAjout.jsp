<%@ include file="/jsp/header.jsp"%>

	<h3> Nouvel Article </h3>

	<form method="POST"
		action="<%= request.getContextPath() %>/ArticleAjout">
	
	<fieldset>
	<legend> Saisir les informations de l'article </legend>
		<p>
			<label> Code Barre </label> <br>
			<input type="number" name="codeBarre">
		</p>
		<p>
			<label> Réf Article </label> <br>
			<input type="text" name="refArticle">
		</p>
		<p>
			<label>Nom de l'article</label> <br>
			<input type="text" name="libelle">
		</p>
		<p>
			<label>Prix HT (en centimes)</label> <br>
			<input type="number" name="prixht">
		</p>

		<p>
			TVA :

			<%-- Récupère le tableau de TVA et construit la liste des options TVA  --%>

			<%
			ServletContext context = this.getServletContext();
			Integer[] tTva = (Integer[]) context.getAttribute("tableauTVA");
 			for (int i=0;i<tTva.length;i++) {
 				float tva = tTva[i];%>

			<input type="radio" id="TVA<%=i%>" name="tauxTVA" value="<%=i%>"
				checked>
			<fmt:formatNumber value="<%= tva/10000 %>" pattern="0.00 %" />

			<%}%>

		</p>

		<input type="submit" value="Ajouter">
		
	</fieldset>

	</form>

</body>
</html>