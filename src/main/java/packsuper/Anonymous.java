package packsuper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

 // SERVLET class Anonymous

public class Anonymous extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Anonymous() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Information de connexion
		HttpSession session = request.getSession(true);
		session.setAttribute("connexion", "non connecté");
		this.getServletContext().getRequestDispatcher("/jsp/formAnonymous.jsp").forward(request, response);
	}

}
