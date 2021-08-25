package entidade;

import dao.UsuarioDao;
import utils.Conexao;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

/**
 *
 * @author @author Grupo 1: Dario Distaso, Rafael Vilvert, Eduard Richard
 * Sprung, José da Silva Mattos Junior
 */
public class Principal {
    private final Connection conexao = Conexao.getConexao();

    public static void main(String[] args) {

        
        Date data = new Date();
        String dataHoje = DateFormat.getDateInstance().format(data);

        Usuario usuario = new Usuario();
        usuario.setLogin("João2021");
        usuario.setSenha("vmks32b");
        usuario.setNome("João da Silva");
        usuario.setCargo("Vendedor");

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.inserir((Usuario) usuario);

        Cliente cliente = new Cliente();
       
        cliente.setCpf("12345678900");
        cliente.setNome("Fernanda");

        Fornecedor fornecedor = new Fornecedor();
       
        fornecedor.setNome("Eletrônicos Atacadista LTDA");

        Lampada lampada = new Lampada();
        
        lampada.setNome("Lâmpada Led biVolt");
        lampada.setEstoque(30);
        lampada.setPrecoCompra(3.50);
        lampada.setPrecoVenda(12.90);
        lampada.setCor("Branca");
        lampada.setPotencia("15W");
        lampada.setVoltagem("220V");

        Lampada lampada2 = new Lampada();
        
        lampada2.setNome("Lâmpada");
        lampada2.setEstoque(20);
        lampada2.setPrecoCompra(2.50);
        lampada2.setPrecoVenda(9.90);
        lampada2.setCor("Amarela");
        lampada2.setPotencia("9W");
        lampada2.setVoltagem("110V");

        Compra compra = new Compra();
        compra.setFornecedor(fornecedor);
        compra.setData(dataHoje);
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
        venda.setData(dataHoje);
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


