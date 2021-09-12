package entidade;

import dao.ProdutoDao;
import dao.VendaDao;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Venda implements Transacao {

    Date data = new Date();
    private String dataHoje = DateFormat.getDateInstance().format(data);
    private int id;
    private int quantidade;
    int estoque;
    private Pessoa usuario;
    private Cliente cliente;
    private Double precoTotal;
    Produto produto = new Produto();
   
    public String getData() {
        return dataHoje;
    }

    public void setData(String data) {
        this.dataHoje = data;
    }

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

        if (p.getEstoque() >= q) {
            Venda venda = new Venda();
            ProdutoDao produtoDao = new ProdutoDao();
            VendaDao vendaDao = new VendaDao();
            
        try {
            
            p.setEstoque(p.getEstoque() - q);
            produtoDao.atualizarEstoque(p);
            System.out.println("\n========VENDA=========");
            System.out.println("Descrição item: " + p.getNome());
            System.out.println("Valor unitário: R$" + String.format("%.2f", p.getPrecoVenda()));
            System.out.println("Vendeu: " + q + " unidades");
            System.out.println("Total: R$" + String.format("%.2f", (p.getPrecoVenda() * q)));
            System.out.println("Estoque atual: " + p.getEstoque() + "\n");
            venda.setUsuario(usuario);
            venda.setCliente(cliente);
            venda.setData(dataHoje);
            venda.setProduto(p);
            venda.setData(dataHoje);
            venda.getProduto().getPrecoVenda();
            venda.getProduto().setQuantidade(q);
            venda.setPrecoTotal(p.getPrecoVenda() * q);
            vendaDao.inserir(venda);
            
        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        } //fim if
        else {
            System.out.println("Estoque insuficiente!");
        }

    }

    @Override
    public String toString() {
        return "Venda{" + "data=" + data + ", dataHoje=" + dataHoje + ", id=" + id + ", quantidade=" + quantidade + ", estoque=" + estoque + ", usuario=" + usuario + ", cliente=" + cliente + ", precoTotal=" + precoTotal + ", produto=" + produto + '}';
    }
    
    
}
