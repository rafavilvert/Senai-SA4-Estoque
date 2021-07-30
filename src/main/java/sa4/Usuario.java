package sa4;

import java.util.ArrayList;
import java.util.Date;

public class Usuario extends PessoaFisica {

    private String loginUsuario;
    private String email;
    private String senha;
    private String cargo;
    private ArrayList<Usuario> listaUsuarios;

    public Usuario() {
    }
    
    

    public Usuario(String loginUsuario, String nome, String email, String senha, String cargo, String cpf) {
        this.loginUsuario = loginUsuario;
        this.setNome(nome);
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.setCpf(cpf);
    }

    

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
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

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public void vender(Produto p, int quantidade) {

        if (quantidade > p.getEstoque()) {
            System.out.println("Estoque insuficiente!");
        } else {
            p.setEstoque(p.getEstoque() - quantidade);
            System.out.println("Vendeu " + quantidade + " " + p.getNomeProduto() + " Total: " + p.getPrecoVenda() * quantidade + " Data venda: ");
        }

    }
    
    @Override //polimorfismo de sobreescrita do metodo toString
    //metodo somente acessível para o usuário ROOT pois mostra a senha dos usuários
    public String toString() {
        return "Dados do Usuário{" + " nome: " + this.getNome() + ", email: " + this.getEmail() 
                        + ", senha: " + this.getSenha() + ", login=" 
                        + this.getLoginUsuario() + " Cargo: " + this.getCargo() + " Cpf: " + this.getCpf() + "}";
    }
}

        