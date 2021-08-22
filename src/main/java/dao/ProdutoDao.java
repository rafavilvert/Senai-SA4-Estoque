/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public static void main(String[] args) {
        Produto produto = new Produto();
        ProdutoDao produtoDao = new ProdutoDao();
        produto.setNome("Lampada Led");
        produto.setPrecoCompra(3.50);
        produto.setPrecoVenda(12.50);
        produto.setEstoque(50);
        
        produtoDao.inserir(produto);
    }

    public void inserir(Produto produto) {
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
        }
    }

    public void atualizar(Produto produto) {
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
        }
    }

    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM USUARIO");
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
        }
        return produtos;
    }

    public void remover(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM produto WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Produto removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Produto buscar(int id) {

        try {
            Produto produto = new Produto();
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM produto WHERE id=?");
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

        }

    }
}
