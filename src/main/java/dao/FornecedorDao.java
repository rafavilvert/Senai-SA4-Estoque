/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author USUARIO
 */
public class FornecedorDao {

    private Connection conexao = Conexao.getConexao();

    public void inserir(Fornecedor fornecedor) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO fornecedor (nome,cnpj) VALUES(?,?)");
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Fornecedor cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizar(Fornecedor fornecedor) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE fornecedor SET nome=?,cnpj=? WHERE id=?");
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setInt(3, fornecedor.getId());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Fornecedor atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Fornecedor> listar() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM FORNECEDOR");
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(resultado.getInt(1));
                fornecedor.setNome(resultado.getString(2));
                fornecedor.setCnpj(resultado.getString(3));
                fornecedores.add(fornecedor);
            }
            stmt.close();
            resultado.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedores;
    }

    public void remover(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM fornecedor WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Fornecedor removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Fornecedor buscar(int id) {

        try {
            Fornecedor fornecedor = new Fornecedor();
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM fornecedor WHERE id=?");
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            resultado.next();
            fornecedor.setId(resultado.getInt("id"));
            fornecedor.setNome(resultado.getString("nome"));
            fornecedor.setCnpj(resultado.getString("cnpj"));
            stmt.close();
            resultado.close();
            conexao.close();
            return fornecedor;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro no metodo buscar" + ex);

        }

    }

}
