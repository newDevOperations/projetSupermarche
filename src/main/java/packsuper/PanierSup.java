package packsuper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

// SERVLET class PanierSup

public class PanierSup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PanierSup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération des données
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		HashMap<Long, Integer> pan = (HashMap<Long, Integer>) session.getAttribute("panier");
		long codeBarre = Long.parseLong(request.getParameter("art"));

		// Suppression de l'article dans le panier
		if (pan.containsKey(codeBarre)) {
			int qte = pan.get(codeBarre);
			qte--;
			if (qte == 0)
				pan.remove(codeBarre);
			else
				pan.replace(codeBarre, qte);
		}

		// MàJ dans session
		session.setAttribute("panier", pan);

		response.sendRedirect(request.getContextPath() + "/Panier");
	}

}
