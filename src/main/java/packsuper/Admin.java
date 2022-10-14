package packsuper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

 // SERVLET class Admin

public class Admin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     
	public Admin() {
        super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/jsp/formAdmin.jsp").forward(request, response);
	}

}
