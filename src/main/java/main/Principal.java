package main;

import dao.ClienteDao;
import dao.CompraDao;
import dao.FornecedorDao;
import dao.ProdutoDao;
import dao.UsuarioDao;
import dao.VendaDao;
import entidade.Cliente;
import entidade.Compra;
import entidade.Fornecedor;
import entidade.Produto;
import entidade.Usuario;
import entidade.Venda;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
        
        Date data = new Date();
        String dataHoje = DateFormat.getDateInstance().format(data);
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDao fornecedorDao = new FornecedorDao();
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        Produto produto = new Produto();
        ProdutoDao produtoDao = new ProdutoDao();
        Compra compra = new Compra();
        CompraDao compraDao = new CompraDao();
        Venda venda = new Venda();
        VendaDao vendaDao = new VendaDao();
        
        
        //DESMARQUE OS COMENTARIOS PARA SELECIONAR UMA AÇÃO
        
        //1) CADASTRAR UM USUARIO
        /*
        usuario.setNome("Gabriel");
        usuario.setLogin("gabriel123");
        usuario.setSenha("3jdj887a");
        
        usuarioDao.inserir(usuario);
        */
        
        
        //2) ATUALIZAR UM USUARIO
        /*
        usuario.setId(6);
        usuario.setNome("Helena");
        usuario.setLogin("paula123");
        usuario.setSenha("m883nagaf3");
        
        usuarioDao.atualizar(usuario);
        */
        
        
        //3) REMOVER UM USUARIO
        //usuarioDao.remover(5);
        
        //4) LISTAR TODOS OS USUARIOS
        /*
        List<Usuario> usuarios = usuarioDao.listar();
        System.out.println("=====================");
        System.out.println("USUARIOS CADASTRADOS");
        System.out.println("=====================");
        for(Usuario us:usuarios){
            System.out.println("Nome: "+us.getNome());
            System.out.println("Login: "+us.getLogin());
            System.out.println("Senha: "+us.getSenha());
            
            System.out.println("--------------------");
        }
        */
        
        //5) BUSCAR UM USUARIO
        /*
        usuario = usuarioDao.buscar(6);
        System.out.println("================");
        System.out.println("DADOS DO USUARIO");
        System.out.println("================");
        System.out.println("Id: " + usuario.getId());
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Login: " + usuario.getLogin());
        System.out.println("Senha: " + usuario.getSenha());
        
        System.out.println("--------------------");
        */
        
        //1) CADASTRAR UM FORNECEDOR
        /*
        
        
        fornecedor.setNome("Materiais eletronicos LTDA");
        fornecedor.setCnpj("84.233.734/0001-33");

        fornecedorDao.inserir(fornecedor);
        */
        
        
        //2) ATUALIZAR UM FORNECEDOR
        /*
        fornecedor.setId(1);
        fornecedor.setNome("Materiais eletronicos LTDA");
        fornecedor.setCnpj("84.233.734/0001-33");
        fornecedorDao.atualizar(fornecedor);
        */
        
        //3) REMOVER UM FORNECEDOR
        //fornecedorDao.remover(1);

        //4) LISTAR TODOS OS FORNECEDORES
        /*
        List<Fornecedor> fornecedores = fornecedorDao.listar();
        System.out.println("=====================");
        System.out.println("FORNECEDORES CADASTRADOS");
        System.out.println("=====================");
        for(Fornecedor forn:fornecedores){
            System.out.println("Nome: " + forn.getNome());
            System.out.println("Cnpj: " + forn.getCnpj());
            System.out.println("--------------------");
        }
        */
        //5) BUSCAR UM FORNECEDOR
        /*
        fornecedor = fornecedorDao.buscar(2);
        System.out.println("==================");
        System.out.println("DADOS DO FORNECEDOR");
        System.out.println("==================");
        System.out.println("Id: " + fornecedor.getId());
        System.out.println("Nome: " + fornecedor.getNome());
        System.out.println("Cnpj: " + fornecedor.getCnpj());
        System.out.println("--------------------");
        */
        
        
        //1) CADASTRAR UM CLIENTE
        /*
        cliente.setNome("André");
        cliente.setCpf("122.987.824-29");
        
        clienteDao.inserir(cliente);
        */

        //2) ATUALIZAR UM CLIENTE: INSERIR A ID QUE SE DESEJA ALTERAR
        //NO PARAMETRO DO METODO setId()
        /*
        cliente.setId(5);
        cliente.setNome("Samuel");
        cliente.setCpf("834.283.000-87");
        
        clienteDao.atualizar(cliente);
        */
        
        //3) LISTAR TODOS OS CLIENTES
        /*
        List<Cliente> clientes = clienteDao.listar();
        System.out.println("=====================");
        System.out.println("CLIENTES CADASTRADOS");
        System.out.println("=====================");
        for(Cliente us:clientes){
            System.out.println("Nome: "+us.getNome());
            System.out.println("Cpf: "+us.getCpf());
            System.out.println("--------------------");
        }
        */
        //4) REMOVER UM CLIENTE: INSERIR A ID COMO PARAMETRO
        //DO METODO buscar()
        //clienteDao.remover();
        
        //5) BUSCAR UM CLIENTE: INSERIR A ID COMO PARAMETRO
        //DO METODO buscar()
        /*
        cliente = clienteDao.buscar(5);
        System.out.println("================");
        System.out.println("DADOS DO CLIENTE");
        System.out.println("================");
        System.out.println("Id: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Cpf: " + cliente.getCpf());
        System.out.println("--------------------");
         */
        
        
        //1) CADASTRAR PRODUTO
       
        /*
        produto.setNome("chave inglesa");
        produto.setPrecoCompra(5.50);
        produto.setPrecoVenda(18.00);
        produto.setEstoque(18);
        produtoDao.inserir(produto);
        */
         
        //2) AUTALIZAR PRODUTO: INSERIR A ID QUE SE DESEJA ALTERAR
        //NO PARAMETRO DO METODO setId()
        /*
        produto.setId(2);
        produto.setNome("Chave inglesa");
        produto.setPrecoCompra(6.75);
        produto.setPrecoVenda(23.80);
        produto.setEstoque(15);
        produtoDao.atualizar(produto);
        */
        //3) LISTAR TODOS OS PRODUTOS
        /*
        List<Produto> produtos = produtoDao.listar();
        System.out.println("=====================");
        System.out.println("PRODUTOS CADASTRADOS");
        System.out.println("=====================");
        for(Produto prod: produtos){
            System.out.println("Nome: " + prod.getNome());
            System.out.println("Preço de compra: " + prod.getPrecoCompra());
            System.out.println("Preço de venda: " + prod.getPrecoVenda());
            System.out.println("Estoque: " + prod.getEstoque());
            System.out.println("--------------------");
        */  
        //4) REMOVER UM PRODUTO: INSERIR A ID COMO PARAMETRO
        //DO METODO remover()
        //produtoDao.remover(1);
        
        //5) BUSCAR UM PRODUTO: INSERIR A ID NO PARAMETRO
        //DO METODO buscar()
        /*
        produto = produtoDao.buscar(2);
        System.out.println("================");
        System.out.println("DADOS DO PRODUTO");
        System.out.println("================");
        System.out.println("Id: " + produto.getId());
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço de compra: " + produto.getPrecoCompra());
        System.out.println("Preço de venda: " + produto.getPrecoVenda());
        System.out.println("Estoque: " + produto.getEstoque());
        System.out.println("--------------------");
        */
        
        //1) CADASTRAR UMA COMPRA
        /*
        usuario.setNome("Luiz");
        compra.setUsuario(usuario);
        fornecedor.setNome("milium");
        compra.setFornecedor(fornecedor);
        compra.setData(dataHoje);
        produto.setNome("toalha mesa");
        produto.setPrecoCompra(6.50);
        produto.setQuantidade(20);
        compra.setProduto(produto);
        compra.setPrecoTotal(produto.getPrecoCompra() * produto.getQuantidade());
        compraDao.inserir(compra);
         */
        
        //2) ATUALIZAR OS DADOS DE UMA COMPRA: INSERIR A ID QUE SE DESEJA ALTERAR
        //NO PARAMETRO DO METODO setId()
        /*
        compra.setId(4);
        usuario.setNome("Roberta");
        compra.setUsuario(usuario);
        fornecedor.setNome("Ferragens & Cia");
        compra.setFornecedor(fornecedor);
        compra.setData(dataHoje);
        produto.setNome("parafuso");
        produto.setPrecoCompra(1.50);
        produto.setQuantidade(50);
        compra.setProduto(produto);
        compra.setPrecoTotal(produto.getPrecoCompra() * produto.getQuantidade());
        compraDao.atualizar(compra);
        */
     
        //3) LISTAR TODAS AS COMPRAS
        /*
        List<Compra> compras = compraDao.listar();
        System.out.println("===================");
        System.out.println("COMPRAS CADASTRADAS");
        System.out.println("===================");
        for (Compra cp : compras) {
            System.out.println("Id: " + cp.getId());
            System.out.println("Usuario: " + cp.getUsuario().getNome());
            System.out.println("Fornecedor: " + cp.getFornecedor().getNome());
            System.out.println("Data compra: " + cp.getData());
            System.out.println("Produto: " + cp.getProduto().getNome());
            System.out.println("Preco unitário:" + cp.getProduto().getPrecoCompra());
            System.out.println("Quantidade:" + cp.getProduto().getQuantidade());
            System.out.println("Total:" + cp.getPrecoTotal());
            System.out.println("--------------------");
        }
        */
        //4) REMOVER UMA COMPRA: INSERIR A ID COMO PARAMETRO
        //DO METODO remover()
        //compraDao.remover(7);
        
        //5) BUSCAR OS DADOS DE UMA COMPRA: INSERIR A ID NO PARAMETRO
        //DO METODO buscar()
        /*
        Compra comp = compraDao.buscar(1);
        System.out.println("================");
        System.out.println("DADOS DA COMPRA");
        System.out.println("================");
        System.out.println("Id: " + comp.getId());
        System.out.println("Usuario: " + comp.getUsuario().getNome());
        System.out.println("Fornecedor: " + comp.getFornecedor().getNome());
        System.out.println("Data compra: " + comp.getData());
        System.out.println("Produto: " + comp.getProduto().getNome());
        System.out.println("Preco unitário:" + comp.getProduto().getPrecoCompra());
        System.out.println("Quantidade:" + comp.getProduto().getQuantidade());
        System.out.println("Total:" + comp.getPrecoTotal());
        System.out.println("--------------------");
        */
        
        //1) CADASTRAR UMA VENDA
        /* 
        usuario.setNome("Roberto");
        venda.setUsuario(usuario);
        cliente.setNome("Marcos");
        venda.setCliente(cliente);
        venda.setData(dataHoje);
        produto.setNome("pilhas duracell");
        produto.setPrecoVenda(35.00);
        produto.setQuantidade(3);
        venda.setProduto(produto);
        venda.setPrecoTotal(produto.getPrecoVenda() * produto.getQuantidade());
        vendaDao.inserir(venda);
        */
        
        //2) ATUALIZAR OS DADOS DE UMA VENDA: INSERIR A ID QUE SE DESEJA ALTERAR
        //NO PARAMETRO DO METODO setId()
        /*
        venda.setId(2);
        usuario.setNome("Joice");
        venda.setUsuario(usuario);
        cliente.setNome("Carlos");
        venda.setCliente(cliente);
        venda.setData(dataHoje);
        produto.setNome("luvas");
        produto.setPrecoVenda(10.50);
        produto.setQuantidade(3);
        venda.setProduto(produto);
        venda.setPrecoTotal(produto.getPrecoVenda() * produto.getQuantidade());
        vendaDao.atualizar(venda);
        */
        
        //3) LISTAR TODAS AS VENDAS
        /*
        List<Venda> vendas = vendaDao.listar();
        System.out.println("==================");
        System.out.println("VENDAS CADASTRADAS");
        System.out.println("==================");
        for (Venda vd : vendas) {
            System.out.println("Id: " + vd.getId());
            System.out.println("Usuario: " + vd.getUsuario().getNome());
            System.out.println("Cliente: " + vd.getCliente().getNome());
            System.out.println("Data venda: " + vd.getData());
            System.out.println("Produto: " + vd.getProduto().getNome());
            System.out.println("Preco unitário: R$" + vd.getProduto().getPrecoVenda());
            System.out.println("Quantidade: " + vd.getProduto().getQuantidade());
            System.out.println("Total: R$" + vd.getPrecoTotal());
            System.out.println("--------------------");
        }
        */
        
        //4) REMOVER UMA VENDA: INSERIR A ID COMO PARAMETRO
        //DO METODO remover()
        //vendaDao.remover(3);
        
        //5) BUSCAR OS DADOS DE UMA VENDA: INSERIR A ID COMO PARAMETRO
        //DO METODO buscar()
        /*
        Venda vend = vendaDao.buscar(2);
        
        System.out.println("================");
        System.out.println("DADOS DA VENDA");
        System.out.println("================");
        System.out.println("Id: " + vend.getId());
        System.out.println("Usuario: " + vend.getUsuario().getNome());
        System.out.println("Cliente: " + vend.getCliente().getNome());
        System.out.println("Data venda: " + vend.getData());
        System.out.println("Produto: " + vend.getProduto().getNome());
        System.out.println("Preco unitário: R$" + vend.getProduto().getPrecoVenda());
        System.out.println("Quantidade:" + vend.getProduto().getQuantidade());
        System.out.println("Total: R$" + vend.getPrecoTotal());
        System.out.println("--------------------");
        */
        
    }
}
