package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import persistencia.UsuarioDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario u = new Usuario(email, senha);
		Usuario us = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		us = usuarioDAO.loginUsuario(u);
		
		if(us.isTipo()) {
		response.sendRedirect("/Logista");
		}else {
		response.sendRedirect("/ListaProdutoServlet");
		}
		
	}
}
