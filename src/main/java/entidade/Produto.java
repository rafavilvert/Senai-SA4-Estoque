
package entidade;

public class Produto {

    private int id;
    private String nome;
    private Double precoCompra;
    private Double precoVenda;
    private int estoque;
    private String categoria;
    private int quantidade;

    public Produto() {
    }

    public Produto(int id, String nome, Double precoCompra, Double precoVenda, int estoque, String categoria) {
        this.id = id;
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public Produto(String nome, Double precoCompra, Double precoVenda, int estoque, String categoria) {
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    Produto(String nome, String pc, String pv, int estoque, String categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", precoCompra=" + precoCompra + ", precoVenda=" + precoVenda + ", estoque=" + estoque + ", categoria=" + categoria + "}\n";
    }

}
