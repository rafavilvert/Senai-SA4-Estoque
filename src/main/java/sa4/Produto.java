package sa4;

import java.util.ArrayList;

public class Produto {
    private int codigo;
    private String categoria;
    private String nome;
    private double precoCompra;
    private double precoVenda;
    private int estoque;
    private int quantidade;
    ArrayList<Produto> produtosEstoque = new ArrayList<>();

    public Produto() {
    }
    
    public Produto(int codigo) {
        this.codigo = codigo;
        
    }

    public Produto(int codigo, String categoria, String nome, double precoCompra, double precoVenda, int estoque) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "Código: " + this.codigo + " Nome: " + this.nome + " Estoque: " + this.estoque;
    }
    
}
    

    