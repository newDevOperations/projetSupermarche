<%@ include file="/jsp/header.jsp"%>

	<%
	ServletContext context = this.getServletContext();
	HashMap<Long, Article> m = (HashMap<Long, Article>) context.getAttribute("magasin");
	long mCodeBarre = Long.parseLong(request.getParameter("art"));
	Article a = m.get(mCodeBarre);
	%>

	<h3> Modification Article </h3>

	<form method="POST">
	
	<fieldset>
	<legend> Saisir les informations de l'article </legend>
		
		<p>
			<label> Code Barre </label> <br>
			<input type="number" name="codeBarre" disabled
				value="<%=mCodeBarre%>">
		</p>
		<p>
			<label> Réf Article </label> <br>
			<input type="text" name="refArticle"
				value="<%=a.getReference()%>">
		</p>
		<p>
			<label>Nom de l'article</label> <br>
			<input type="text" name="libelle"
				value="<%=a.getLibelle()%>">
		</p>
		<p>
			<label>Prix HT (en centimes)</label> <br>
			<input type="number" name="prixht"
				value="<%=a.getPrixHT()%>">
		</p>

		<p>
			TVA :

			<%-- Récupère l'indice du taux de TVA --%>
			<%-- Récupère le tableau de TVA et construit la liste des options TVA  --%>

			<%
			Integer[] tTva = (Integer[]) context.getAttribute("tableauTVA");
			for (int i = 0; i < tTva.length; i++) {
				float tva = tTva[i];
			%>

			<input type="radio" id="TVA<%=i%>" name="tauxTVA" value="<%=i%>"
				<%if (a.getTauxTVA() == i) {%> checked <%}%>>
			<fmt:formatNumber value="<%=tva / 10000%>" pattern="0.00 %" />

			<%
			}
			%>
		</p>

		<input type="submit" value="Modifier">

	</fieldset>

	</form>

</body>
</html>