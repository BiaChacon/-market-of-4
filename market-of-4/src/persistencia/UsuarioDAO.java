package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Usuario;

public class UsuarioDAO {
	
	private ConnectionDatabase c = new ConnectionDatabase();

    private final String LOGIN = "SELECT * FROM USUARIO WHERE email = ? AND senha = ?;";

    private final String INSERT = "INSERT INTO USUARIO(nome, email, senha, tipo) VALUES (?, ?, ?, ?);";

    private final String DELETE = "DELETE FROM USUARIO WHERE id = ?;";

    private final String LISTUSUARIO = "SELECT * FROM USUARIO";

    private final String VERIFICAR = "SELECT * FROM USUARIO WHERE email = ?;";
    
    public Boolean verificarUsuario(String email) {
        try {
            c.dbConnection();

            PreparedStatement pst = c.getConnection().prepareStatement(VERIFICAR);

            pst.setString(1, email);

            ResultSet rst = pst.executeQuery();

            if (rst.next()) {
                c.dbConnectionClose();
                return true;
            }

            c.dbConnectionClose();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Usuario loginUsuario(Usuario u) {
        try {

            c.dbConnection();

            System.out.println(u.toString());

            PreparedStatement pst = c.getConnection().prepareStatement(LOGIN);

            pst.setString(1, u.getEmail());
            pst.setString(2, u.getSenha());

            ResultSet rst = pst.executeQuery();

            System.out.println(rst.toString());
            if (rst.next()) {
            	Usuario us = new Usuario(
                        rst.getInt("id"),
                        rst.getString("nome"),
                        rst.getString("email"),
                        rst.getString("senha"),
                        rst.getBoolean("tipo")
                );
                c.dbConnectionClose();
                return us;
            }

            c.dbConnectionClose();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }
    
    public void insertIntoUsuario(Usuario u) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(INSERT);
            pst.setString(1, u.getNome());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getSenha());
            pst.setBoolean(4, u.isTipo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro" + ex);
        }
        c.dbConnectionClose();

    }
    
    public List<Usuario> readUsuario() {
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        try {
            c.dbConnection();
            PreparedStatement ps;
            ps = c.getConnection().prepareStatement(LISTUSUARIO);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getBoolean("tipo")
                );
            	listaUsuario.add(u);
            }
            c.dbConnectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuario;
    }
    
}
