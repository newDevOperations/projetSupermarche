package packsuper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;


// SERVLET class Init

public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Init() {
		super();
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// INITIALISATION DU SUPERMARCHE

		// Création d'un HashMap supermarche
		HashMap<Long, Article> supermarche = new HashMap<>();

		// Ajout des articles de base dans le supermarche
		Article art1 = new Article((long) 154299999, "SECS4522", "Pain de Mie 500g", 347, 1);
		supermarche.put(art1.getCodeBarre(), art1);
		Article art2 = new Article((long) 892999692, "SECS3222", "Confiture Fruits 250g", 252, 1);
		supermarche.put(art2.getCodeBarre(), art2);
		Article art3 = new Article((long) 912994321, "SECS4582", "Pâtes 1kg", 109, 0);
		supermarche.put(art3.getCodeBarre(), art3);
		Article art4 = new Article((long) 123456789, "FRECS4582", "Riz 500g", 178, 0);
		supermarche.put(art4.getCodeBarre(), art4);
		Article art5 = new Article((long) 123256789, "SQVCS4582", "Sucre 1kg", 59, 0);
		supermarche.put(art5.getCodeBarre(), art5);
		Article art6 = new Article((long) 123456789, "SECS4582", "Café Moulu 250g", 179, 1);
		supermarche.put(art6.getCodeBarre(), art6);
		Article art7 = new Article((long) 176456789, "SECS4582", "Farine 1 kg", 129, 0);
		supermarche.put(art6.getCodeBarre(), art7);

		// Stockage de la liste des articles + tableau TVA dans application
		ServletContext context = this.getServletContext();
		context.setAttribute("magasin", supermarche);
		context.setAttribute("tableauTVA", Article.tabTVA);

		// Création d'un Panier dans session
		HttpSession session = request.getSession(true);
		HashMap<Long, Integer> panier = new HashMap<>();
		session.setAttribute("panier", panier);

		response.sendRedirect(request.getContextPath()+"/Anonymous");

	}

}
