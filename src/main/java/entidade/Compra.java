package entidade;

import dao.ProdutoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Compra implements Transacao {

    private int id;
    private Produto produto;
    private List<Produto> produtosCompra = new ArrayList<>();
    private String data;
    private Pessoa usuario;
    private Pessoa fornecedor;
    private Double precoTotal;
    private int quantidade;

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
        
        try {
            ProdutoDao produtoDao = new ProdutoDao();
            int inicial = p.getEstoque();
            p.setEstoque(p.getEstoque() + qtde);
            produtoDao.atualizarEstoque(p);
            
            System.out.println("\nDescrição item: " + p.getNome());
            System.out.println("\nEstoque inicial: " + inicial);
            System.out.println("\nValor unitário: " + String.format("%.2f", p.getPrecoCompra()));
            System.out.println("\nComprou: " + qtde + " unidades");
            System.out.println("\nTotal: R$" + String.format("%.2f", (p.getPrecoCompra() * qtde)));
            System.out.println("\nEstoque atual: " + p.getEstoque() + "\n");
            
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }

}

