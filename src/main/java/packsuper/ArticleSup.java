package packsuper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

// SERVLET class ArticleSup

public class ArticleSup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArticleSup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération des données
		ServletContext context = this.getServletContext();
		context.getAttribute("magasin");

		@SuppressWarnings("unchecked")
		HashMap<Long, Article> mag = (HashMap<Long, Article>) context.getAttribute("magasin");

		long codeBarre = Long.parseLong(request.getParameter("art"));

		// Suppression de l'article
		mag.remove(codeBarre);

		// MàJ dans application
		context.setAttribute("magasin", mag);

		response.sendRedirect(request.getContextPath() + "/Admin");
	}
	
}
