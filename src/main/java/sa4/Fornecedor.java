package sa4;

public class Fornecedor extends PessoaJuridica{

    public Fornecedor() {
    }

    public Fornecedor(String razaoSocial, String inscricaoEstadual, String cnpj, int codigo, String nome, String telefone, Endereco endereco) {
        super(razaoSocial, inscricaoEstadual, cnpj, codigo, nome, telefone, endereco);
    }
    
}
