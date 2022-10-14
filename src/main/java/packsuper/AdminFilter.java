package packsuper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

 // SERVLET Filter  class AdminFilter

public class AdminFilter extends HttpFilter implements Filter {
   
	private static final long serialVersionUID = 1L;

    public AdminFilter() {
        super();
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
				
		// Teste si admin est authentifié
	    // Laisse passer /Admin/* si admin sinon redirige vers /Login
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
	    HttpServletResponse httpRes = (HttpServletResponse) response;
	    HttpSession session = httpReq.getSession();
	   
	    String etat = (String) session.getAttribute("connexion");
		
		if (etat.equals("admin")) 		
			 chain.doFilter(request, response);	
		else
			httpRes.sendRedirect(httpReq.getContextPath() + "/Login");
		
				 
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
