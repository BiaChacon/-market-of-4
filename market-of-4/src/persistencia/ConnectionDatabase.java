package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

	private String user;
    private String password;
    private String url;
    private String driverjdbc;
    private Connection connection;

    public ConnectionDatabase() {
    	this.url = "jdbc:postgresql://ec2-54-221-236-144.compute-1.amazonaws.com:5432/dekd4m7lag3fa1?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    	this.user = "huyvtehgxkguvk";
        this.password = "e23ce409f920fa4ff96f7d79ccca20eb4435319de15abee1af0a83f1b6631c6e";
        this.driverjdbc = "org.postgresql.Driver";
    }
    /*
    public ConnectionDatabase() {
    	this.url =  "jdbc:postgresql://localhost:5432/market-of-4";
    	this.user = "postgres";
    	this.password = "1234";
    	this.driverjdbc = "org.postgresql.Driver";
    }*/

    public void dbConnection() {
        try {
            Class.forName(driverjdbc);
            connection = DriverManager.getConnection(url, user, password); 
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    public void dbConnectionClose() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
}