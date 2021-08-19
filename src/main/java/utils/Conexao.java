package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	String URL = "jdbc:mysql://ckshdphy86qnz0bj.cbetxkdyhwsb.us-east-1.rds.amazonaws.com//3306//oeefmopo2ae8bf48";
	String USER = "loquh18ptw5ursa7";
	String PASS = "qdm4zqrp7uigcdfz";
	
	private static Connection Conexao;
	
	public boolean conecta() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Conexao = DriverManager.getConnection(URL, USER, PASS);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public Connection getConexao() {
		return this.Conexao;
	}

}
