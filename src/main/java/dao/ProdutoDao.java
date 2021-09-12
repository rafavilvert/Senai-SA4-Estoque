
package dao;

import entidade.Produto;
import entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conexao;

public class ProdutoDao {
    
    private Connection conexao;
    
    public void inserir(Produto produto) throws SQLException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("INSERT INTO produto (nome,precoCompra,precoVenda,estoque,categoria) VALUES(?,?,?,?,?)");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCompra());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getEstoque());
            stmt.setString(5, produto.getCategoria());
            stmt.executeUpdate();

            System.out.println("Produto cadastrado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }
    
    public void atualizar(Produto produto)  {
        PreparedStatement stmt = null;
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("UPDATE produto SET nome=?,precoCompra=?,precoVenda=?,estoque=?, categoria=? WHERE id=?");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCompra());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getEstoque());
            stmt.setString(5, produto.getCategoria());
            stmt.setInt(6, produto.getId());
            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
            
    public void atualizarEstoque(Produto produto) throws SQLException {
        PreparedStatement stmt = null;
        
        try {            
            conexao = Conexao.getConexao();
            
            stmt = conexao.prepareStatement("UPDATE produto SET estoque=? WHERE id=?");
            stmt.setInt(1, produto.getEstoque());
            stmt.setInt(2, produto.getId());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        
        try {

            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("SELECT * FROM PRODUTO");
            resultado = stmt.executeQuery();
            
            while (resultado.next()) {
                Produto produto = new Produto();
                produto.setId(resultado.getInt("id"));
                produto.setNome(resultado.getString("nome"));
                produto.setPrecoCompra(resultado.getDouble("precoCompra"));
                produto.setPrecoVenda(resultado.getDouble("precoVenda"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setCategoria(resultado.getString("categoria"));
                produtos.add(produto);
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (resultado != null) {
                resultado.close();
            }
            if (!conexao.isClosed() || conexao != null) {
                conexao.close();
            }
        }
        return produtos;
        
    }

    public void remover(int id) {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("DELETE FROM produto WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Produto removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Produto buscar(int id) throws SQLException {

        Produto produto = new Produto();
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("SELECT * FROM produto WHERE id=?");
            stmt.setInt(1, id);
           
            resultado = stmt.executeQuery();

            if (resultado.next()) {
                produto.setId(resultado.getInt("id"));
                produto.setNome(resultado.getString("nome"));
                produto.setPrecoVenda(resultado.getDouble("precoVenda"));
                produto.setPrecoCompra(resultado.getDouble("precoCompra"));
                produto.setEstoque(resultado.getInt("estoque"));
                produto.setCategoria(resultado.getString("categoria"));
                return produto;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao buscar o produto" + ex);
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
