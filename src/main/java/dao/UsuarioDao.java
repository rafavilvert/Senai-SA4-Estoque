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

    public void inserir(Usuario usuario) {

        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO usuario (nome,login,senha) VALUES(?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
            stmt.close();

            System.out.println("Usuario cadastrado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizar(Usuario usuario) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("UPDATE usuario SET nome=?,login=?,senha=? WHERE id=?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());
            stmt.executeUpdate();
            stmt.close();

            System.out.println("Usuario atualizado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet resultado;
            try ( PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM USUARIO")) {
                resultado = stmt.executeQuery();
                while (resultado.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultado.getInt("id"));
                    usuario.setNome(resultado.getString("nome"));
                    usuario.setLogin(resultado.getString("login"));
                    usuario.setSenha(resultado.getString("senha"));
                    usuarios.add(usuario);
                }
            }
            resultado.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public void remover(int id) {
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
    }

    public Usuario autenticar(String login, String senha) throws SQLException {

        Usuario usuario = new Usuario();

        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE login=? and senha=?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                usuario.setNome(resultado.getString("nome"));
                stmt.close();
                resultado.close();

                return usuario;
            } else {
                stmt.close();
                resultado.close();

                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao buscar a usuario" + ex);
            return null;
        }

    }
}
