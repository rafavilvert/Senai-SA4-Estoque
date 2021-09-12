package dao;

import entidade.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conexao;

public class FornecedorDao {

    private Connection conexao;

    public void inserir(Fornecedor fornecedor) throws SQLException {
        PreparedStatement stmt = null;
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("INSERT INTO fornecedor (nome,cnpj) VALUES(?,?)");
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.executeUpdate();
            System.out.println("Fornecedor cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void atualizar(Fornecedor fornecedor) {
        PreparedStatement stmt = null;
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("UPDATE fornecedor SET nome=?,cnpj=? WHERE id=?");
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setInt(3, fornecedor.getId());
            stmt.executeUpdate();
            System.out.println("Fornecedor atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Fornecedor> listar() throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("SELECT * FROM FORNECEDOR");
            resultado = stmt.executeQuery();
            
            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setCnpj(resultado.getString("cnpj"));
                fornecedores.add(fornecedor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (resultado != null) {
                resultado.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }

        return fornecedores;
    }

    public void remover(int id) {

        PreparedStatement stmt = null;
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("DELETE FROM fornecedor WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Fornecedor removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Fornecedor buscar(int id) throws SQLException {
        Fornecedor fornecedor = new Fornecedor();
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("SELECT * FROM fornecedor WHERE id=?");
            stmt.setInt(1, id);
            resultado = stmt.executeQuery();
            
            if(resultado.next()){
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setCnpj(resultado.getString("cnpj"));
                return fornecedor; 
            }
            else{
                return null;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (resultado != null) {
                resultado.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }

        }

    }

}
