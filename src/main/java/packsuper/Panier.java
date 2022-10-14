package packsuper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// SERVLET class Panier

public class Panier extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public Panier() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/jsp/formPanier.jsp").forward(request, response);	
	}
	
}
