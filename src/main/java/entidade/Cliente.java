package entidade;

public class Cliente extends PessoaFisica {

    private Venda venda;

    public Cliente() {
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

}
