package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import persistencia.UsuarioDAO;

@WebServlet("/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Usuario u = new Usuario(nome, email, senha, false);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println(" "+u.getNome());
        
       if(!usuarioDAO.verificarUsuario(email)) {
        	usuarioDAO.insertIntoUsuario(u);
        	response.sendRedirect("/ListarProdutosServlet");
        }else {
        	response.getWriter().append("\n USUARIO JÁ EXISTE");
        }
	}
	
	
	

}