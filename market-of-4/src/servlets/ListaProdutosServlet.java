package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ListaProdutosServlet")
public class ListaProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
    	HttpSession session = req.getSession(true);
    	Integer acesso = (Integer) session.getAttribute("acesso");
    	
    	if(acesso == null) {
    		acesso = 0;
    		out.println(
                    "<html>\n" +
                    "<head><title>Lista Produtos</title></head>\n"+
                    "<body>\n"+
                    "<h1>Lista Produtos</h1>"+
                    "<table>"+
                    "<tr>"+
                    	"<th>Nome</th>"+
                    	"<th>Descrição</th>"+
                    	"<th>Preço</th>"+
                    	"<th>Estoque</th>"+
                    	"<th>Carrinho</th>"+
                    "</tr>");
    		for(int i; i; i++) {
    			out.println("<tr>"+
    					
    					"</tr>");
    		}
    		
    		out.println("</table>"+
                    "</body></html>");
    		
    	}else {
    		acesso++;
    		out.println(
                    "<html>\n" +
                    "<head><title>HTTP Enviado</title></head>\n"+
                    "<body>\n"+
                    "</body></html>");
    		
    	}
    	
    	
    	
    	
    	super.doGet(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	super.doPost(req, resp);
    }


}
