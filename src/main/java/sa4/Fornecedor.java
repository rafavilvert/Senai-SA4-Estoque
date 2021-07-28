package sa4;

public class Fornecedor extends PessoaJuridica{
    
    private int idFornecedor;

    public Fornecedor() {
    }
    
    

    public Fornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Fornecedor(int idFornecedor, String razaoSocial, String inscricaoEstadual, String cnpj, int codigo, String nome, String telefone, Endereco endereco) {
        super(razaoSocial, inscricaoEstadual, cnpj, codigo, nome, telefone, endereco);
        this.idFornecedor = idFornecedor;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    
    
    
    
}
