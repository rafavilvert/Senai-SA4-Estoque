package entidade;

import java.util.ArrayList;
import java.util.List;

public class Venda implements Transacao {
    private int id;
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
    public void executar(Lampada l, int qtde) {

        if (l.getEstoque() < l.getQuantidade()) {
            System.out.println("Estoque insuficiente!");
        } else {
            int inicial = l.getEstoque();

            l.setEstoque(l.getEstoque() - qtde);
            System.out.println("Descrição item: " + l.getNome()
                    + "\nEstoque inicial: " + inicial
                    + "\nValor unitário: " + l.getPrecoVenda()
                    + "\nVendeu: " + qtde + " unidades"
                    + "\nTotal: R$" + l.getPrecoVenda() * qtde
                    + "\nEstoque atual: " + l.getEstoque() + "\n");
        }
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", produto=" + produto +  ", data=" + data + ", usuario=" + usuario + ", cliente=" + cliente + ", precoTotal=" + precoTotal + '}';
    }

    

}
