package packsuper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

 // SERVLET class Login

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/jsp/formLogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		//Vérification si admin authentifié
		HttpSession session = request.getSession(true);
		session.setAttribute("message", "");
				
		if (username.equals("admin") && password.equals("secret")) {
			session.setAttribute("connexion", "admin");
			response.sendRedirect(request.getContextPath() + "/Admin");
		}
		else {
			session.setAttribute("connexion", "non connecté");
			session.setAttribute("message", "Mauvais utilisateur ou mauvais mot de passe !");
			response.sendRedirect(request.getContextPath() + "/Login");
		}
			
	}

}
