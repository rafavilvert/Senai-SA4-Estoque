
package dao;

import entidade.Fornecedor;
import entidade.Produto;
import entidade.Usuario;
import entidade.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conexao;

public class CompraDao {

    private Connection conexao;

    public void inserir(Compra compra) throws SQLException {
        PreparedStatement stmt = null;
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("INSERT INTO compra (usuario,fornecedor,data,produto,precoCompra,quantidade,precoTotal) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, compra.getUsuario().getNome());
            stmt.setString(2, compra.getFornecedor().getNome());
            stmt.setString(3, compra.getData());
            stmt.setString(4, compra.getProduto().getNome());
            stmt.setDouble(5, compra.getProduto().getPrecoCompra());
            stmt.setDouble(6, compra.getProduto().getQuantidade());
            stmt.setDouble(7, compra.getPrecoTotal());
            stmt.executeUpdate();
           
            System.out.println("\nCompra cadastrada com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void atualizar(Compra compra) throws SQLException {
        PreparedStatement stmt = null;
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("UPDATE compra SET usuario=?,fornecedor=?,data=?,produto=?,precoCompra=?,quantidade=?,precoTotal=? WHERE id=?");
            stmt.setString(1, compra.getUsuario().getNome());
            stmt.setString(2, compra.getFornecedor().getNome());
            stmt.setString(3, compra.getData());
            stmt.setString(4, compra.getProduto().getNome());
            stmt.setDouble(5, compra.getProduto().getPrecoCompra());
            stmt.setInt(6, compra.getProduto().getQuantidade());
            stmt.setDouble(7, compra.getPrecoTotal());
            stmt.setInt(8, compra.getId());
            stmt.executeUpdate();
            
            System.out.println("Compra atualizada com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }

    }

    public List<Compra> listar() throws SQLException {
        List<Compra> compras = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("SELECT * FROM COMPRA");
            resultado = stmt.executeQuery();
            
            while (resultado.next()) {
                
                Compra compra = new Compra();
                Usuario usuario = new Usuario();
                Fornecedor fornecedor = new Fornecedor();
                Produto produto = new Produto();
                compra.setUsuario(usuario);
                compra.setFornecedor(fornecedor);
                compra.setProduto(produto);
                compra.setId(resultado.getInt("id"));
                compra.getUsuario().setNome(resultado.getString("usuario"));
                compra.getFornecedor().setNome(resultado.getString("fornecedor"));
                compra.setData(resultado.getString("data"));
                compra.getProduto().setNome(resultado.getString("produto"));
                compra.getProduto().setPrecoCompra(resultado.getDouble("precoCompra"));
                compra.getProduto().setQuantidade(resultado.getInt("quantidade"));
                compra.setPrecoTotal(resultado.getDouble("precoTotal"));
                compras.add(compra);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
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
        return compras;
    }

    public void remover(int id) throws SQLException {
        PreparedStatement stmt = null;
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("DELETE FROM compra WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            System.out.println("Compra removida com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public Compra buscar(int id) throws SQLException {
        Compra compra = new Compra();
        Usuario usuario = new Usuario();
        Fornecedor fornecedor = new Fornecedor();
        Produto produto = new Produto();
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        try {
            conexao = Conexao.getConexao();
            
            compra.setUsuario(usuario);
            compra.setFornecedor(fornecedor);
            compra.setProduto(produto);

            stmt = conexao.prepareStatement("SELECT * FROM compra WHERE id=?");
            stmt.setInt(1, id);
            resultado = stmt.executeQuery();

            if(resultado.next()){
                compra.setId(resultado.getInt("id"));
                compra.getUsuario().setNome(resultado.getString("usuario"));
                compra.getFornecedor().setNome(resultado.getString("fornecedor"));
                compra.setData(resultado.getString("data"));
                compra.getProduto().setNome(resultado.getString("produto"));
                compra.getProduto().setPrecoCompra(resultado.getDouble("precoCompra"));
                compra.getProduto().setQuantidade(resultado.getInt("quantidade"));
                compra.setPrecoTotal(resultado.getDouble("precoTotal"));
                return compra;
            }
            else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally {
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
