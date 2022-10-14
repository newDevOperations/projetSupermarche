package packsuper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

// SERVLET class ArticleAjout

public class ArticleAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArticleAjout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/jsp/formAjout.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Récupération des données
			ServletContext context = this.getServletContext();
			context.getAttribute("magasin");

			@SuppressWarnings("unchecked")
			HashMap<Long, Article> mag = (HashMap<Long, Article>) context.getAttribute("magasin");

			// Ajout de l'article dans le magasin
			Article newArt = new Article(Long.parseLong(request.getParameter("codeBarre")),
					(String) request.getParameter("refArticle"), (String) request.getParameter("libelle"),
					Integer.parseInt(request.getParameter("prixht")),
					Integer.parseInt(request.getParameter("tauxTVA")));

			mag.put(newArt.getCodeBarre(), newArt);

			// MàJ dans application
			context.setAttribute("magasin", mag);

		} catch (NumberFormatException e) {
		}

		response.sendRedirect(request.getContextPath() + "/Admin");

	
	}

}
