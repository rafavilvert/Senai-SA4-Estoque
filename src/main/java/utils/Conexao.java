package utils;

import java.sql.*;

public class Conexao {

    public static Connection getConexao() {
        
        try {
            String URL = "jdbc:mysql://ckshdphy86qnz0bj.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/oeefmopo2ae8bf48";
            String USUARIO = "loquh18ptw5ursa7";
            String SENHA = "qdm4zqrp7uigcdfz";
            
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectado ao banco de dados com sucesso!");
            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
}


