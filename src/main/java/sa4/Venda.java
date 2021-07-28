package sa4;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
    private int idVenda;
    private Date dataVenda = new Date();
    ArrayList<Produto> produtosVenda = new ArrayList<>();
    
    
    
  public void vender(Produto p, int quantidade) {

        if (quantidade > p.getEstoque()) {
            System.out.println("Estoque insuficiente!");
        } else {
            p.setEstoque(p.getEstoque() - quantidade);
            System.out.println("Vendeu " + quantidade + " " + p.getNome() + " Total: " + p.getPrecoVenda()*quantidade + " Data venda: " + dataVenda);
        }    
    }
}
