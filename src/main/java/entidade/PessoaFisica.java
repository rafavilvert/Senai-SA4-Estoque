package entidade;

public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf) {
       
        this.cpf = cpf;
    }

    public PessoaFisica(String cpf, String nome, int id) {
        super(nome, id);
        this.cpf = cpf;
    }
    
    public PessoaFisica(String nome, int id) {
        super(nome, id);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "cpf=" + cpf + '}';
    }


}
