<%@ include file="/jsp/header.jsp"%>

<table>
	<caption>Votre Panier</caption>
	<tr>
		<th>Code Barre</th>
		<th>Nom Article</th>
		<th>Prix U. TTC</th>
		<th>Quantité</th>
		<th>Montant TTC</th>
	</tr>

	<%
		ServletContext context = this.getServletContext();
		HashMap<Long, Article> mag = (HashMap<Long, Article>) context.getAttribute("magasin");
		HashMap<Long, Integer> pan = (HashMap<Long, Integer>) session.getAttribute("panier");
		Integer[] tTva = (Integer[]) context.getAttribute("tableauTVA");
		Float[] SumTva =  new Float[tTva.length];
		for (int i = 0; i < tTva.length; i++) SumTva[i]=0f;
		float sumTTC = 0;
		float sumHT=0;
		float tva=0;
		
		for (Map.Entry<Long, Integer> p : pan.entrySet()) {
			Article a = (Article) mag.get(p.getKey());
			sumTTC += a.getMontantTTC(p.getValue());
			sumHT += a.getMontantHT(p.getValue());
			SumTva[a.getTauxTVA()] +=(sumTTC-sumHT);
		%>
	<tr>
		<td><%=p.getKey()%></td>

		<td><%=a.getLibelle()%></td>

		<td>&euro; <fmt:formatNumber value="<%=a.getPrixTTC()%>"
				pattern="0.00" /></td>

		<td><%=p.getValue()%></td>

		<td>&euro; <fmt:formatNumber
				value="<%=a.getMontantTTC(p.getValue())%>" pattern="0.00" /></td>

		<td><a href="PanierSup?art=<%=p.getKey()%>">Supprimer du
				panier</a></td>
	</tr>


	<%
		}
		%>

	<tr>
		<th></th>
		<th></th>
		<th></th>
		<th>Total</th>
		<th>&euro; <fmt:formatNumber value="<%=sumTTC%>" pattern="0.00" /></th>
	</tr>


	<% for (int i = 0; i < tTva.length; i++) {%>


	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td>dont TVA <% tva = tTva[i]; %> <fmt:formatNumber
				value="<%=tva/10000%>" pattern="0.00 %" />
		</td>
		<td>&euro; <fmt:formatNumber value="<%=SumTva[i]%>"
				pattern="0.00" />
		</td>
	</tr>

	<%}%>



</table>

<a href="<%=request.getContextPath()%>/Anonymous">Revenir au magasin</a>


</body>
</html>