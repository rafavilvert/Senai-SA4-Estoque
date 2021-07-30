package sa4;

public class PessoaFisica extends Pessoa{
    private String cpf;

    public PessoaFisica() {
    }
    
    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica(String cpf, int codigo, String nome) {
        super(codigo, nome);
        this.cpf = cpf;
    }

    public PessoaFisica(String cpf, int codigo, String nome, String telefone, Endereco endereco) {
        super(codigo, nome, telefone, endereco);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
