package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Produto;
import persistencia.ProdutoDAO;

@WebServlet("/ListaProdutosServlet")
public class ListaProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
    	
    	out.println(
                "<html>\n" +
                "<head><title>Lista Produtos</title></head>\n"+
                "<body>\n"+
                "<h1>Lista Produtos</h1>"+
                "<table border = '1'><thead>"+
                "<tr>"+
                	"<th>Nome</th>"+
                	"<th>Descrição</th>"+
                	"<th>Preço</th>"+
                	"<th>Estoque</th>"+
                	"<th></th>"+
                "</tr></thead>");
   
    	List<Produto> listaProdutos;
    	
    	ProdutoDAO produtoDAO = new ProdutoDAO();
    	
    	
    	listaProdutos = produtoDAO.readProduto();
    	
    	out.println("<tbody>");
    	
    	for(int i=0; i<listaProdutos.size(); i++){
    		out.println(
                "<tr>"+
                	"<td>"+ listaProdutos.get(i).getNome() +"</th>"+
                	"<td>"+ listaProdutos.get(i).getDescricao() +"</th>"+
                	"<td>"+ listaProdutos.get(i).getPreco() +"</th>"+
                	"<td>"+ listaProdutos.get(i).getEstoque() +"</th>");
    		
	    	if(listaProdutos.get(i).getEstoque() >= 1) {
	    		out.println("<td>"+ "<a href='CarrinhoServlet?id=listaProdutos.get(i).getId()&metodo=add'>Adicionar Carrinho</a>" +"</th>");
	    	}else {
	    		out.println("<td>"+ "Sem estoque" +"</th>");
	    	}
    	}
    	
    	out.println("</tr></tbody></table>");
    	out.println("<br><a href='/VerCarrinhoServlet'>Ver Carrinhoo</a>");
   		out.println("</body></html>");
    	
    }

}
