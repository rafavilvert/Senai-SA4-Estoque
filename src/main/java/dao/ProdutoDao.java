package dao;

import entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conexao;

/**
 *
 * @author USUARIO
 */
public class ProdutoDao {

    private Connection conexao = Conexao.getConexao();

    public void inserir(Produto produto) throws SQLException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO produto (nome,precoCompra,precoVenda,estoque) VALUES(?,?,?,?)");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCompra());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getEstoque());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Produto cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
        }
    }

    public void atualizar(Produto produto) throws SQLException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE produto SET nome=?,precoCompra=?,precoVenda=?,estoque=? WHERE id=?");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoCompra());
            stmt.setDouble(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getEstoque());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Produto atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM PRODUTO");
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Produto produto = new Produto();
                
                produto.setId(resultado.getInt("id"));
                produto.setNome(resultado.getString("nome"));
                produto.setPrecoCompra(resultado.getDouble("precoCompra"));
                produto.setPrecoVenda(resultado.getDouble("precoVenda"));
                produto.setEstoque(resultado.getInt("estoque"));

                produtos.add(produto);
            }
            stmt.close();
            resultado.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
        }
        return produtos;
    }

    public void remover(int id) throws SQLException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM produto WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Produto removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
        }
    }

    public Produto buscar(int id) throws SQLException {
        Produto produto = new Produto();
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM produto WHERE id=?");
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            resultado.next();
            produto.setId(resultado.getInt("id"));
            produto.setNome(resultado.getString("nome"));
            produto.setPrecoCompra(resultado.getDouble("precoCompra"));
            produto.setPrecoVenda(resultado.getDouble("precoVenda"));
            produto.setEstoque(resultado.getInt("estoque"));
            stmt.close();
            resultado.close();
            conexao.close();
            return produto;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro no metodo buscar" + ex);
        } finally {
            conexao.close();
        }

    }
}
