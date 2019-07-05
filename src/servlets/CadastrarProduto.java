package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Produto;
import persistencia.ProdutoDAO;

@WebServlet("/CadastrarProduto")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
        String precoS = request.getParameter("preco");
        String descricao = request.getParameter("descricao");
        String estoqueS = request.getParameter("estoque");
        int estoque  = Integer.parseInt(estoqueS);
        double preco = Double.parseDouble(precoS);
        
        Produto p = new Produto(nome, preco, descricao, estoque);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.insertIntoProduto(p);
        
        response.sendRedirect("/Logista");
		
	}

}
