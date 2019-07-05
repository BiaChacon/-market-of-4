package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Produto;

public class ProdutoDAO {

    private ConnectionDatabase c = new ConnectionDatabase();

    private final String INSERT = "INSERT INTO PRODUTO(nome, preco, descricao, estoque) VALUES (?, ?, ?, ?);";

    private final String DELETE = "DELETE FROM PRODUTO WHERE id = ?;";

    private final String LISTPRODUTO = "SELECT * FROM PRODUTO";



    public void insertIntoProduto(Produto p) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(INSERT);
            pst.setString(1, p.getNome());
            pst.setDouble(2, p.getPreco());
            pst.setString(3, p.getDescricao());
            pst.setInt(4, p.getEstoque());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro" + ex);
        }
        c.dbConnectionClose();

    }


    public List<Produto> readProduto() {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        try {
            c.dbConnection();
            PreparedStatement ps;
            ps = c.getConnection().prepareStatement(LISTPRODUTO);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("descricao"),
                        rs.getInt("estoque")
                );
            	listaProduto.add(p);
            }
            c.dbConnectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProduto;
    }
    
}
