
package entidade;

import java.util.ArrayList;
import java.util.List;

public class Compra implements Transacao {
    private int id;
    private Produto produto;
    private List<Produto> produtosCompra = new ArrayList<>();
    private String data;
    private Pessoa usuario;
    private Pessoa fornecedor;
    private Double precoTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutosCompra() {
        return produtosCompra;
    }

    public void setProdutosCompra(List<Produto> produtosCompra) {
        this.produtosCompra = produtosCompra;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    public Pessoa getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Pessoa fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override

    public void executar(Produto p, int qtde) {
        int inicial = p.getEstoque();
        p.setEstoque(p.getEstoque() + qtde);
        System.out.println("Descrição item: " + p.getNome()
                + "\nEstoque inicial: " + inicial
                + "\nValor unitário: " + p.getPrecoCompra()
                + "\nComprou: " + qtde + " unidades"
                + "\nTotal: R$" + p.getPrecoCompra() * qtde
                + "\nEstoque atual: " + p.getEstoque() + "\n");

    }

    @Override
    public String toString() {
        return "DETALHES DA COMPRA:\n" + produtosCompra + "\n Data compra: " + data + "\n Usuario: " + usuario + "\n Fornecedor: " + fornecedor;
    }

}
