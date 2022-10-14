package packsuper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

// SERVLET class ArticleModif

public class ArticleModif extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ArticleModif() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/jsp/formModif.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Récupération des données
			ServletContext context = this.getServletContext();
			context.getAttribute("magasin");

			@SuppressWarnings("unchecked")
			HashMap<Long, Article> mag = (HashMap<Long, Article>) context.getAttribute("magasin");

			long codeBarre = Long.parseLong(request.getParameter("art"));

			// Modification de l'article dans le magasin
			Article modifArt = new Article(codeBarre, (String) request.getParameter("refArticle"),
					(String) request.getParameter("libelle"), Integer.parseInt(request.getParameter("prixht")),
					Integer.parseInt(request.getParameter("tauxTVA")));

			mag.replace(codeBarre, modifArt);

			// MàJ dans application
			context.setAttribute("magasin", mag);

		} catch (NumberFormatException e) {
		}

		response.sendRedirect(request.getContextPath() + "/Admin");
	}

}
