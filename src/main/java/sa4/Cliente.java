package sa4;

public class Cliente extends PessoaFisica{

    public Cliente() {
    }

    public Cliente(String cpf) {
        super(cpf);
    }

    public Cliente(String cpf, int codigo, String nome, String telefone, Endereco endereco) {
        super(cpf, codigo, nome, telefone, endereco);
    }
    
}
