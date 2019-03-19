package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Produto;
import persistencia.ProdutoDAO;

@WebServlet("/Logista")
public class Logista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
		
    	out.println(
                "<html>\n" +
                "<head><title>Lista Produtos</title></head>\n"+
                "<body>\n"+
                "<h1>Lista Produtos</h1>"+
                "<table border = '1'><thead>"+
                "<tr>"+
                	"<th>ID</th>"+
                	"<th>Nome</th>"+
                	"<th>Descrição</th>"+
                	"<th>Preço</th>"+
                	"<th>Estoque</th>"+
                "</tr></thead>");
   
    	List<Produto> listaProdutos;
    	
    	ProdutoDAO produtoDAO = new ProdutoDAO();
    	
    	
    	listaProdutos = produtoDAO.readProduto();
    	out.println("<tbody>");
    	for(int i=0; i<listaProdutos.size(); i++){
    	out.println(
                "<tr>"+
                	"<td>"+ listaProdutos.get(i).getId() +"</th>"+
                	"<td>"+ listaProdutos.get(i).getNome() +"</th>"+
                	"<td>"+ listaProdutos.get(i).getDescricao() +"</th>"+
                	"<td>"+ listaProdutos.get(i).getPreco() +"</th>"+
                	"<td>"+ listaProdutos.get(i).getEstoque() +"</th>"+
                "</tr>");
    	}
    	out.println("</tbody></table>");
    	out.println("<br><a href='/cadastrarProduto.html'>Cadastrar Produto</a>");
    	out.println("</body></html>");
    	
	}


}
