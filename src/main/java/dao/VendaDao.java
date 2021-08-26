package dao;

import entidade.Cliente;
import entidade.Produto;
import entidade.Usuario;
import entidade.Venda;
import entidade.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conexao;

public class VendaDao {

    private Connection conexao = Conexao.getConexao();

    public void inserir(Venda venda) throws SQLException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO venda (usuario,cliente,data,produto,precoVenda,quantidade,precoTotal) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, venda.getUsuario().getNome());
            stmt.setString(2, venda.getCliente().getNome());
            stmt.setString(3, venda.getData());
            stmt.setString(4, venda.getProduto().getNome());
            stmt.setDouble(5, venda.getProduto().getPrecoVenda());
            stmt.setDouble(6, venda.getProduto().getQuantidade());
            stmt.setDouble(7, venda.getPrecoTotal());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Venda cadastrada com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           conexao.close();
        }
    }

    public void atualizar(Venda venda) throws SQLException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE venda SET usuario=?,cliente=?,data=?,produto=?,precoVenda=?,quantidade=?,precoTotal=? WHERE id=?");
            stmt.setString(1, venda.getUsuario().getNome());
            stmt.setString(2, venda.getCliente().getNome());
            stmt.setString(3, venda.getData());
            stmt.setString(4, venda.getProduto().getNome());
            stmt.setDouble(5, venda.getProduto().getPrecoVenda());
            stmt.setInt(6, venda.getProduto().getQuantidade());
            stmt.setDouble(7, venda.getPrecoTotal());
            stmt.setInt(8, venda.getId());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Venda atualizada com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           conexao.close();
        }

    }

    public List<Venda> listar() throws SQLException {
        List<Venda> vendas = new ArrayList<>();
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM VENDA");
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Venda venda = new Venda();
                Usuario usuario = new Usuario();
                Cliente cliente = new Cliente();
                Produto produto = new Produto();
                venda.setUsuario(usuario);
                venda.setCliente(cliente);
                venda.setProduto(produto);

                venda.setId(resultado.getInt("id"));
                venda.getUsuario().setNome(resultado.getString("usuario"));
                venda.getCliente().setNome(resultado.getString("cliente"));
                venda.setData(resultado.getString("data"));
                venda.getProduto().setNome(resultado.getString("produto"));
                venda.getProduto().setPrecoVenda(resultado.getDouble("precoVenda"));
                venda.getProduto().setQuantidade(resultado.getInt("quantidade"));
                venda.setPrecoTotal(resultado.getDouble("precoTotal"));

                vendas.add(venda);
            }
            stmt.close();
            resultado.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           conexao.close();
        }
        return vendas;
    }

    public void remover(int id) throws SQLException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM venda WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Venda removida com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           conexao.close();
        }
    }

    public Venda buscar(int id) throws SQLException {
        Venda venda = new Venda();
        Usuario usuario = new Usuario();
        Cliente cliente = new Cliente();
        Produto produto = new Produto();
        venda.setUsuario(usuario);
        venda.setCliente(cliente);
        venda.setProduto(produto);

        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM venda WHERE id=?");
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            resultado.next();
            venda.setId(resultado.getInt("id"));
            venda.getUsuario().setNome(resultado.getString("usuario"));
            venda.getCliente().setNome(resultado.getString("cliente"));
            venda.setData(resultado.getString("data"));
            venda.getProduto().setNome(resultado.getString("produto"));
            venda.getProduto().setPrecoVenda(resultado.getDouble("precoVenda"));
            venda.getProduto().setQuantidade(resultado.getInt("quantidade"));
            venda.setPrecoTotal(resultado.getDouble("precoTotal"));
            stmt.close();
            resultado.close();
            conexao.close();
            return venda;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar a venda", ex);
        }
        finally{
           conexao.close();
        }

    }
}
