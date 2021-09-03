package entidade;

import java.util.ArrayList;
import java.util.List;

public class Venda implements Transacao {

    private int id;
    private int quantidade;
    private Produto produto;
    private List<Produto> produtosVenda;
    private String data;
    private Pessoa usuario;
    private Cliente cliente;
    private Double precoTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutosVenda() {
        return produtosVenda;
    }

    public void setProdutosVenda(List<Produto> produtosVenda) {
        this.produtosVenda = produtosVenda;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override
    public void executar(Produto p, int q) {

        double total = 0;

        if (p.getEstoque() < q) {
            System.out.println("Estoque insuficiente!");
        } else {
            int inicial = p.getEstoque();
            precoTotal = (p.getPrecoVenda() * q);
            p.setEstoque(p.getEstoque() - q);

            System.out.println("VENDEU:\n");
            System.out.println("Descrição item: " + p.getNome()
                    + "\nEstoque inicial: " + inicial
                    + "\nValor unitário: R$" + String.format("%.2f", p.getPrecoVenda())
                    + "\nVendeu: " + q + " unidades"
                    + "\nTotal: R$" + String.format("%.2f", precoTotal)
                    + "\nEstoque atual: " + p.getEstoque() + "\n");
            produtosVenda.add(p);
        }
    }

    @Override
    public String toString() {
        return "DETALHES DA VENDA:\n" + produtosVenda + ", data venda: " + data + ", usuario: " + usuario + ", cliente: " + cliente + ", precoTotal: " + precoTotal + "}\n";
    }

}
