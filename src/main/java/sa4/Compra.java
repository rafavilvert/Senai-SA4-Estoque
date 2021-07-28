package sa4;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private int idCompra;
    private Date dataCompra = new Date();
    ArrayList<Produto> produtosCompra = new ArrayList<>();

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    
 
    
}
