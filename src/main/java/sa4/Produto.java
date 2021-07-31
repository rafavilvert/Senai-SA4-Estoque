package sa4;

import java.util.ArrayList;

public class Produto {
    private int codigo;
    private String categoria;
    private String nomeProduto;
    private double precoCompra;
    private double precoVenda;
    private int estoque;
    private int quantidade;
    ArrayList<Produto> produtosEstoque;

    public Produto() {
    }

    public Produto(int codigo, String categoria, String nomeProduto, double precoCompra, double precoVenda, int estoque) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nomeProduto = nomeProduto;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.estoque = estoque;
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ArrayList<Produto> getProdutosEstoque() {
        return produtosEstoque;
    }

    public void setProdutosEstoque(ArrayList<Produto> produtosEstoque) {
        this.produtosEstoque = produtosEstoque;
    }
    
    public String getDadosProduto() {
        return "Código: " + this.codigo + " Nome: " + this.nomeProduto + " Estoque: " + this.estoque;
    }
    
}
    

    