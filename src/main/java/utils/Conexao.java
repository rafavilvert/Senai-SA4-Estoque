
package utils;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {

    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://ckshdphy86qnz0bj.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/oeefmopo2ae8bf48";
    final static String USUARIO = "loquh18ptw5ursa7";
    final static String SENHA = "qdm4zqrp7uigcdfz";
    private static Connection conexao;

    public static Connection getConexao() {

        try {
            if (conexao == null || conexao.isClosed()) {
                Class.forName(DRIVER);
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            }
            return conexao;

        } catch (ClassNotFoundException e) {
            System.out.println("Não foi possível carregar o driver");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao banco de dados");
            e.printStackTrace();
            return null;
        }
    }
}
