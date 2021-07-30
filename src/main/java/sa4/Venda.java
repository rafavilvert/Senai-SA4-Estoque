package sa4;

import java.util.ArrayList;
import java.util.Date;

public class Venda {

    private int idVenda;
    private Date dataVenda;
    ArrayList<Produto> produtosVenda = new ArrayList<>();

    public Venda() {
    }

    public Venda(int idVenda, Date dataVenda) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
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
}
