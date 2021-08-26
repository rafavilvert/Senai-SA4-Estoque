package dao;

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

/**
 *
 * @author USUARIO
 */
public class UsuarioDao {

    private Connection conexao = Conexao.getConexao();

    public void inserir(Usuario usuario) throws SQLException {

        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO usuario (nome,cpf,login,senha,cargo) VALUES(?,?,?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getCargo());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Usuario cadastrado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           conexao.close();
        }
    }

    public void atualizar(Usuario usuario) throws SQLException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE usuario SET nome=?,cpf=?,login=?,senha=?,cargo=? WHERE id=?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getCargo());
            stmt.setInt(6, usuario.getId());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("Usuario atualizado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           conexao.close();
        }
    }

    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet resultado;
            try ( PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM USUARIO")) {
                resultado = stmt.executeQuery();
                while (resultado.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultado.getInt("id"));
                    usuario.setNome(resultado.getString("nome"));
                    usuario.setCpf(resultado.getString("cpf"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setSenha(resultado.getString("senha"));
                    usuario.setCargo(resultado.getString("cargo"));

                    usuarios.add(usuario);
                }
            }
            resultado.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           conexao.close();
        }
        return usuarios;
    }

    public void remover(int id) throws SQLException {
        try {
            try ( PreparedStatement stmt = conexao.prepareStatement("DELETE FROM usuario WHERE id=?")) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
            conexao.close();
            System.out.println("Usuario removido com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           conexao.close();
        }
    }

    public Usuario buscar(int id) throws SQLException {

        try {
            Usuario usuario = new Usuario();
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE id=?");
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            resultado.next();
            usuario.setId(resultado.getInt("id"));
            usuario.setNome(resultado.getString("nome"));
            usuario.setCpf(resultado.getString("cpf"));
            usuario.setLogin(resultado.getString("login"));
            usuario.setSenha(resultado.getString("senha"));
            usuario.setCargo(resultado.getString("cargo"));
            stmt.close();
            resultado.close();
            conexao.close();
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar a usuario", ex);
        }
        finally{
           conexao.close();
        }

    }
}
