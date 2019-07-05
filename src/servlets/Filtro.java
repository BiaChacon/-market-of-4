package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

@WebFilter("/Filtro")
public class Filtro implements Filter {

    public Filtro() {}

	
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Usuario u = null;
		HttpSession sessao = ((HttpServletRequest) request).getSession(false);
		
		if(sessao != null) {
			u = (Usuario) sessao.getAttribute("user-logado");
		}
		
		if(u == null) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			 //((HttpServletResponse)response).ge
		}else {
			chain.doFilter(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}

}
