package sa4;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author @author Grupo 1: Dario Distaso, Rafael Vilvert, Eduard Richard
 * Sprung, José da Silva Mattos Junior
 */
public class Principal {

    public static void main(String[] args) {

        Date data = new Date();
        String hojeFormatado = DateFormat.getDateInstance().format(data);

        Pessoa usuario = new Usuario();
        usuario.setCodigo(355L);
        usuario.setNome("João");

        Cliente cliente = new Cliente();
        cliente.setCodigo(564L);
        cliente.setCpf("12345678900");
        cliente.setNome("Fernanda");

        Pessoa fornecedor = new Fornecedor();
        fornecedor.setCodigo(352L);
        fornecedor.setNome("Eletrônicos Atacadista LTDA");

        Lampada lampada = new Lampada();
        lampada.setCodigo(0001L);
        lampada.setNome("Lâmpada Led biVolt");
        lampada.setEstoque(30);
        lampada.setPrecoCompra(3.50);
        lampada.setPrecoVenda(12.90);
        lampada.setCor("Branca");
        lampada.setPotencia("15W");
        lampada.setVoltagem("220V");

        Lampada lampada2 = new Lampada();
        lampada2.setCodigo(0002L);
        lampada2.setNome("Lâmpada");
        lampada2.setEstoque(20);
        lampada2.setPrecoCompra(2.50);
        lampada2.setPrecoVenda(9.90);
        lampada2.setCor("Amarela");
        lampada2.setPotencia("9W");
        lampada2.setVoltagem("110V");

        Compra compra = new Compra();
        compra.setFornecedor(fornecedor);
        compra.setData(hojeFormatado);
        compra.setUsuario(usuario);
        List<Produto> produtosCompra = new ArrayList<>();
        produtosCompra.add(lampada);
        produtosCompra.add(lampada2);
        compra.setProdutosCompra(produtosCompra);
        System.out.println("\n========RESUMO DO PEDIDO=========\n");
        compra.executar(lampada, 23);
        compra.executar(lampada2, 50);
        System.out.println(compra);

        Venda venda = new Venda();
        venda.setCliente((Cliente) cliente);
        venda.setData(hojeFormatado);
        venda.setUsuario(usuario);
        List<Produto> produtosVenda = new ArrayList<>();
        produtosVenda.add(lampada);
        produtosVenda.add(lampada2);
        venda.setProdutosVenda(produtosVenda);
        System.out.println("\n========RESUMO DA VENDA=========\n");
        venda.executar(lampada, 3);
        venda.executar(lampada2, 5);
        System.out.println(venda);
    }
}
