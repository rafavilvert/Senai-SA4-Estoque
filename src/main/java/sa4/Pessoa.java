package sa4;

public class Pessoa {

    private String nome;
    private Long codigo;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", codigo=" + codigo + '}';
    }

}
