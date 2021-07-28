package sa4;

public class PessoaJuridica extends Pessoa{
    private String razaoSocial;
    private String inscricaoEstadual;
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String razaoSocial, String inscricaoEstadual, String cnpj, int codigo, String nome, String telefone, Endereco endereco) {
        super(codigo, nome, telefone, endereco);
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
