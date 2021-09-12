
package dao;

import entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Conexao;

public class ClienteDao {

    private Connection conexao;

    public void inserir(Cliente cliente) throws SQLException {
        PreparedStatement stmt = null;
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("INSERT INTO cliente (cpf,nome) VALUES(?,?)");
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso");
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }

    }

    public void atualizar(Cliente cliente) throws SQLException {
        PreparedStatement stmt = null;
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("UPDATE cliente SET cpf=?,nome=? WHERE id=?");
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
            
            System.out.println("Cliente atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Cliente> listar() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("SELECT * FROM CLIENTE");
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setNome(resultado.getString("nome"));
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
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
        return clientes;
    }

    public void remover(int id) throws SQLException {
        PreparedStatement stmt = null;
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("DELETE FROM cliente WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            System.out.println("Cliente removido com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class
                    .getName()).log(Level.SEVERE, null, ex);
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

    public Cliente buscar(int id) throws SQLException {

        Cliente cliente = new Cliente();
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("SELECT * FROM cliente WHERE id=?");
            stmt.setInt(1, id);
            resultado = stmt.executeQuery();

            if (resultado.next()) {
                cliente.setNome(resultado.getString("nome"));
                return cliente;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao buscar o cliente" + ex);
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
