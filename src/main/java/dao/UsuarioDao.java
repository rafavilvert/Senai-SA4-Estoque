
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
import entidade.Usuario;
import utils.Conexao;

public class UsuarioDao {

    private Connection conexao;

    public void inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = null;
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("INSERT INTO usuario (nome,login,senha) VALUES(?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();

            System.out.println("Usuario cadastrado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = null;
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("UPDATE usuario SET nome=?,login=?,senha=? WHERE id=?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());
            stmt.executeUpdate();
            System.out.println("Usuario atualizado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public List<Usuario> listar() throws SQLException {

        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet resultado;

        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("SELECT * FROM USUARIO");
            resultado = stmt.executeQuery();

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return usuarios;
    }

    public void remover(int id) throws SQLException {
        PreparedStatement stmt = null;

        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("DELETE FROM usuario WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }

    }
    
    public Usuario buscar(int id) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        
        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE id=?");
            stmt.setInt(1, id);
            resultado = stmt.executeQuery();
            
            if(resultado.next()){
                usuario.setId(resultado.getInt("id"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setNome(resultado.getString("nome"));
                return usuario;
            }
            else{
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
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
    
    public Usuario autenticar(String login, String senha) throws SQLException {

        Usuario usuario = new Usuario();
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        try {
            conexao = Conexao.getConexao();
            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE login=? and senha=?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            resultado = stmt.executeQuery();

            if (resultado.next()) {
                usuario.setNome(resultado.getString("nome"));
                return usuario;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao buscar a usuario" + ex);
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
