
package sa4;


public class Usuario extends PessoaFisica {
    
    private String cargo;
    private String loginUsuario;
    private String senha;

    public Usuario() {
    }

    public Usuario(String cargo, String loginUsuario, String senha) {
        this.cargo = cargo;
        this.loginUsuario = loginUsuario;
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
    
}
