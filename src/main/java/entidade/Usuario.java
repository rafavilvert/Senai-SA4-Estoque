
package entidade;

public class Usuario extends PessoaFisica {

    private String login;
    private String senha;
    private Venda venda;
    private Compra compra;
    private String cargo;

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha) {
        this.setNome(nome);
        this.login = login;
        this.senha = senha;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
