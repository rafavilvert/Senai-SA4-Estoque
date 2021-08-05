package sa4;

import java.util.ArrayList;
import java.util.List;

public class Compra implements Transacao {

    private List<Produto> produtosCompra = new ArrayList<>();
    private String data;
    private Pessoa usuario;
    private Pessoa fornecedor;

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

    @Override

    public void executar(Lampada l, int qtde) {
        int inicial = l.getEstoque();
        l.setEstoque(l.getEstoque() + qtde);
        System.out.println("Descrição item: " + l.getNome()
                + "\nEstoque inicial: " + inicial
                + "\nValor unitário: " + l.getPrecoCompra()
                + "\nComprou: " + qtde + " unidades"
                + "\nTotal: R$" + l.getPrecoCompra() * qtde
                + "\nEstoque atual: " + l.getEstoque() + "\n");

    }

    @Override
    public String toString() {
        return "DETALHES DA COMPRA:\n" + produtosCompra + "\n Data compra: " + data + "\n Usuario: " + usuario + "\n Fornecedor: " + fornecedor;
    }

}
