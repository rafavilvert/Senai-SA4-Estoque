/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Fornecedor;
import entidade.Produto;
import entidade.Usuario;
import entidade.Compra;
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

public class CompraDao {

    private Connection conexao = Conexao.getConexao();

    public void inserir(Compra compra) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO compra (usuario,fornecedor,data,produto,precoCompra,quantidade,precoTotal) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, compra.getUsuario().getNome());
            stmt.setString(2, compra.getFornecedor().getNome());
            stmt.setString(3, compra.getData());
            stmt.setString(4, compra.getProduto().getNome());
            stmt.setDouble(5, compra.getProduto().getPrecoCompra());
            stmt.setDouble(6, compra.getProduto().getQuantidade());
            stmt.setDouble(7, compra.getPrecoTotal());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Compra cadastrada com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizar(Compra compra) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE compra SET usuario=?,fornecedor=?,data=?,produto=?,precoCompra=?,quantidade=?,precoTotal=? WHERE id=?");
            stmt.setString(1, compra.getUsuario().getNome());
            stmt.setString(2, compra.getFornecedor().getNome());
            stmt.setString(3, compra.getData());
            stmt.setString(4, compra.getProduto().getNome());
            stmt.setDouble(5, compra.getProduto().getPrecoCompra());
            stmt.setInt(6, compra.getProduto().getQuantidade());
            stmt.setDouble(7, compra.getPrecoTotal());
            stmt.setInt(8, compra.getId());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Compra atualizada com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Compra> listar() {
        List<Compra> compras = new ArrayList<>();

        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM COMPRA");
            ResultSet resultado = stmt.executeQuery();
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
                compra.setUsuario(usuario);
                compra.setFornecedor(fornecedor);
                compra.setProduto(produto);
                compras.add(compra);
            }
            stmt.close();
            resultado.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compras;
    }

    public void remover(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM compra WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Compra removida com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Compra buscar(int id) {

        try {
            Compra compra = new Compra();
            Usuario usuario = new Usuario();
            Fornecedor fornecedor = new Fornecedor();
            Produto produto = new Produto();
            compra.setUsuario(usuario);
            compra.setFornecedor(fornecedor);
            compra.setProduto(produto);

            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM compra WHERE id=?");
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();

            resultado.next();
            compra.setId(resultado.getInt("id"));
            compra.getUsuario().setNome(resultado.getString("usuario"));
            compra.getFornecedor().setNome(resultado.getString("fornecedor"));
            compra.setData(resultado.getString("data"));
            compra.getProduto().setNome(resultado.getString("produto"));
            compra.getProduto().setPrecoCompra(resultado.getDouble("precoCompra"));
            compra.getProduto().setQuantidade(resultado.getInt("quantidade"));
            compra.setPrecoTotal(resultado.getDouble("precoTotal"));
            stmt.close();
            resultado.close();
            conexao.close();
            return compra;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar a compra", ex);
        }

    }
}
