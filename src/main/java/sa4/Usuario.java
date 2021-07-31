package sa4;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Usuario extends PessoaFisica {

    private String login;
    private String email;
    private String senha;
    private String cargo;
    ArrayList<Object> listaUsuarios;

    public Usuario() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ArrayList<Object> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Object> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    

    
    

    public void vender(Produto p, int quantidade) {

        if (quantidade > p.getEstoque()) {
            System.out.println("Estoque insuficiente!");
        } else {
            p.setEstoque(p.getEstoque() - quantidade);
            System.out.println("Vendeu " + quantidade + " " + p.getNomeProduto() + " Total: " + p.getPrecoVenda() * quantidade);
        }

    }

   
   
}

        