package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Produto;
import persistencia.ProdutoDAO;


@WebServlet("/VerCarrinhoServlet")
public class VerCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession sessao = req.getSession();
		Cookie cookies[] = req.getCookies();
		
		String dadosCarrinho = null;
		
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("Carrinho")) 
				dadosCarrinho = cookies[i].getValue();	
		}
		
		String[] p = dadosCarrinho.split(" ");
		Integer[] id = null;
		
    	for(int i = 0; i<p.length; i++) {
    		String[] p1 = p[i].split("Q");
    		id[i] = Integer.parseInt(p1[0]);
    	}
    	
    	List<Produto> listaProdutos;
    	ProdutoDAO produtoDAO = new ProdutoDAO();
    	listaProdutos = produtoDAO.readProduto();
    	List<Produto> listaCarrinho = null;
    	
    	for(int i=0; i<id.length; i++) {
    		for(int j=0; j<listaProdutos.size(); j++) {
    			if(id[i] == listaProdutos.get(j).getId()) {
    				listaCarrinho.add(listaProdutos.get(j));
    				break;
    			}
    		}
    	}
    	
    	out.println(
                "<html>\n" +
                "<head><title>Carrinho</title></head>\n"+
                "<body>\n"+
                "<h1>Carrinho</h1>"+
                "<table border = '1'><thead>"+
                "<tr>"+
                	"<th>Nome</th>"+
                	"<th>Descrição</th>"+
                	"<th>Preço</th>"+
                	"<th>Quantidade</th>"+
                	"<th></th>"+
                "</tr></thead>");
    	
    	for(int i=0; i<listaProdutos.size(); i++){
    		
    			out.println(
    			"<tbody>"+
                "<tr>"+
                	"<td>"+ listaCarrinho.get(i).getNome() +"</th>"+
                	"<td>"+ listaCarrinho.get(i).getDescricao() +"</th>"+
                	"<td>"+ listaCarrinho.get(i).getPreco() +"</th>"+
                	"<td>"+ " " +"</th>");
    		
	    		out.println("<td>"+ "<a href='CarrinhoServlet?id=<%=listaProdutos.get(i).getId()%>&metodo=remove'>Adicionar Carrinho</a>" +"</th>");
	
    	}
    		out.println("</tr></tbody></table>");
    	
    		out.println("<br><a href='/VerCarrinhoServlet'>Ver Carrinhoo</a>");
    		out.println("</body></html>");
    	
    	
    	super.doGet(req, resp);
	}


}
