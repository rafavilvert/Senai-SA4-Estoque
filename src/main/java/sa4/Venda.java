package sa4;

import java.util.ArrayList;
import java.util.Date;

public class Venda {

    private int idVenda;
    private Usuario usuario;
    private Cliente cliente;
    ArrayList<Produto> produtosVenda;
    ArrayList<Object> infoVenda;
    Date dataVenda;

    public Venda() {
    }
    
    public Venda(int idVenda, Usuario usuario, Cliente cliente) {
        this.idVenda = idVenda;
        this.usuario = usuario;
        this.cliente = cliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Object> getInfoVenda() {
        return infoVenda;
    }

    public void setInfoVenda(ArrayList<Object> infoVenda) {
        this.infoVenda = infoVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public ArrayList<Produto> getProdutosVenda() {
        return produtosVenda;
    }

    public void setProdutosVenda(ArrayList<Produto> produtosVenda) {
        this.produtosVenda = produtosVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "idVenda=" + this.idVenda + ", usuario=" + this.usuario + ", cliente=" + this.cliente + ", produtosVenda=" + this.produtosVenda + ", infoVenda=" + this.infoVenda + ", dataVenda=" + this.dataVenda + '}';
    }
    
    
}
