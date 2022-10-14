package packsuper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

// SERVET class PanierAjout

public class PanierAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PanierAjout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération des données
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		HashMap<Long, Integer> pan = (HashMap<Long, Integer>) session.getAttribute("panier");
		long codeBarre = Long.parseLong(request.getParameter("art"));

		// Ajout de l'article dans le panier
        
		if (pan!=null)
			if (pan.containsKey(codeBarre)) {
				int qte = pan.get(codeBarre);
				qte++;
				pan.replace(codeBarre, qte);
			} else
				pan.put(codeBarre, 1);
        
		// MàJ dans session
		session.setAttribute("panier", pan);

		response.sendRedirect(request.getContextPath() + "/Anonymous");
	}

}
