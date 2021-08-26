/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author USUARIO
 */
public class ClienteDao {

    private Connection conexao = Conexao.getConexao();

    public void inserir(Cliente cliente) throws SQLException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO cliente (cpf,nome) VALUES(?,?)");

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Cliente cadastrado com sucesso");
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
        }
    }

    public void atualizar(Cliente cliente) throws SQLException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE cliente SET cpf=?,nome=? WHERE id=?");
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Cliente atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
        }
    }

    public List<Cliente> listar() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM CLIENTE");
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setNome(resultado.getString("nome"));
                clientes.add(cliente);
            }
            stmt.close();
            resultado.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
        }
        return clientes;
    }

    public void remover(int id) throws SQLException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM cliente WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Cliente removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
        }
    }

    public Cliente buscar(int id) throws SQLException {
        Cliente cliente = new Cliente();
        
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM cliente WHERE id=?");
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            resultado.next();
            cliente.setId(resultado.getShort("id"));
            cliente.setCpf(resultado.getString("cpf"));
            cliente.setNome(resultado.getString("nome"));
            stmt.close();
            resultado.close();
            conexao.close();
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro no metodo buscar" + ex);
        } finally {
            conexao.close();
        }

    }

}
