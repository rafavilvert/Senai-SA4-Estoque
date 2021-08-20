/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.UsuarioDao;
import entidade.Usuario;
import java.sql.Connection;
import utils.Conexao;


/**
 *
 * @author USUARIO
 */
public class Principal {
    public static void main(String[] args) {
       
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();
        usuario.setNome("Maria da Silva");
        usuario.setCpf("873.334.567-12");
        usuario.setLogin("Maria123");
        usuario.setSenha("kk4u6nfw");
        usuario.setNivel("root");
        
        usuarioDao.inserir(usuario);
        
        
    }
}
