/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entidade.Usuario;
import entidade.Pessoa;
import utils.Conexao;

/**
 *
 * @author USUARIO
 */
public class ClienteDao {

    private Connection conexao = Conexao.getConexao();
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        cliente.setCpf("445.344.645-33");
        cliente.setNome("Carlos");
        
        clienteDao.inserir(cliente);
    }

    public void inserir(Cliente cliente) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO cliente (cpf,nome) VALUES(?,?)");

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Cliente cadastrado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Cliente cliente) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE cliente SET cpf=?,nome=? WHERE id=?");
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Cliente atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> listar() {
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
        }
        return clientes;
    }

    public void remover(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM cliente WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Cliente removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente buscar(int id) {

        try {
            Cliente cliente = new Cliente();
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM cliente WHERE id=?");
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

        }

    }

}
