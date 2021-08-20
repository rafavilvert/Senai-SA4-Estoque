/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class UsuarioDao {
    private Usuario usuario;
    private Connection conexao = Conexao.getConexao();

    public void inserir(Usuario usuario) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO usuario (nome,cpf,login,senha,nivel) VALUES(?,?,?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getNivel());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Usuario cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizar(Usuario usuario) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE usuario SET nome=?,cpf=?,login=?,senha=?,nivel=? WHERE id=?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getNivel());
            stmt.setInt(6, usuario.getId());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Usuario atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM USUARIO");
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                
                usuario.setNome(resultado.getString("nivel"));
                usuarios.add(usuario);
            }
            stmt.close();
            resultado.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public void remover(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM usuario WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Usuario removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario buscar(int id) {

        try {
            Usuario usuario = new Usuario();
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE id=?");
            ResultSet resultado = stmt.executeQuery();
            resultado.next();
            usuario.setId(resultado.getShort("id"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setNivel("nivel");
            stmt.close();
            resultado.close();
            conexao.close();
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro no metodo buscar" + ex);

        }

    }

}
