package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Carrinho;

@WebServlet("/CarrinhoServlet")
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Carrinho carrinho = new Carrinho(); 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
	
		String id = request.getParameter("id");
		String command = request.getParameter("metodo");
		
		Cookie cookies[] = request.getCookies();
	
		
		String dadosCarrinho = new String();
	
		
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("Carrinho")) 
				dadosCarrinho = cookies[i].getValue();	
		}
		
		Integer qtd = null;
		String[] parts = dadosCarrinho.split(" ");
		
		if(command.equals("add")){
			for (int i = 0; i < parts.length; i++) {
				
				if (parts[i].contains(id+"Q")) {
					String[] parts2 = parts[i].split("Q");
					qtd = Integer.parseInt(parts[1]);
					qtd++;
					parts[1] = Integer.toString(qtd);
				}
				else {
					parts[parts.length +1] = (id+"Q1");
				}
				
			}
			
			for (int i = 0; i < parts.length; i++) {
				dadosCarrinho += parts[i]; 
			}
			
		}
		
		
		if(command.equals("remove")){
			
			for (int i = 0; i < parts.length; i++) {
				
				if (parts[i].contains(id+"Q")) {
					String[] parts2 = parts[i].split("Q");
					if (parts2[1]=="1") {
						parts[i] = ("");
						break;
					}
					else {
						qtd = Integer.parseInt(parts[1]);
						qtd--;
						parts[1] = Integer.toString(qtd);
					}
				}
			}
			
			
			for (int i = 0; i < parts.length; i++) {
				dadosCarrinho += parts[i];
			}
		}
		
		
		Cookie produtosCarrinho = new Cookie("carrinho",dadosCarrinho);
		
		response.addCookie(produtosCarrinho);
		
	}

}
