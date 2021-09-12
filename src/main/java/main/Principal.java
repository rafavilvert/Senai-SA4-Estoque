package main;

import entidade.*;
import dao.UsuarioDao;
import java.text.DateFormat;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import dao.ProdutoDao;
import dao.VendaDao;
import dao.ClienteDao;
import dao.CompraDao;
import dao.FornecedorDao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author @author Grupo 1: Dario Distaso, Rafael Vilvert, Eduard Richard
 * Sprung, José da Silva Mattos Junior
 */
public class Principal {

    public static void main(String[] args) throws SQLException {

        Date data = new Date();
        String dataHoje = DateFormat.getDateInstance().format(data);
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        Produto produto = new Produto();
        ProdutoDao produtoDao = new ProdutoDao();
        Venda venda = new Venda();
        VendaDao vendaDao = new VendaDao();
        Compra compra = new Compra();
        CompraDao compraDao = new CompraDao();
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDao fornecedorDao = new FornecedorDao();
        List<Produto> produtos = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Fornecedor> fornecedores = new ArrayList<>();
        List<Compra> compras = new ArrayList<>();
        int id, resposta, opcao, estoque, qtde;
        String nome, login, senha, cpf, cnpj, log, sen;
        Scanner entrada = new Scanner(System.in);
       
        while (true) {
            System.out.println("==============SISTEMA DE ESTOQUE -- SA4 ETAPA3================");
            System.out.println("\nDigite login do usuário: (usuario: admin, senha: 123456)");
            log = entrada.nextLine();
            System.out.println("\nDigite a senha do usuário: ");
            sen = entrada.nextLine();
            usuario = usuarioDao.autenticar(log, sen);
            
            if (usuario != null) {
                System.out.println("Usuario " + usuario.getNome() + " entrou no sistema");
                break;
                
            } else {
                System.out.println("Dados inválidos");
                continue;
            }
        }//fim while
        
        while (true) {
            System.out.println(
                  "1- VENDA "
                + " 2- USUARIOS "
                + " 3- PRODUTOS "
                + " 4- CLIENTES "
                + " 5- COMPRAS "
                + " 6- FORNECEDORES "
                + " 7- SAIR");
            opcao = entrada.nextInt();
            entrada.nextLine();
            
            switch (opcao) {

            case 1://Venda
                System.out.println("\nSelecionar a opção: \n"
                    + "1- Realizar venda \n"
                    + "2- Consultar todas as vendas \n"
                    + "3- Alterar venda \n"
                    + "4- Remover venda \n"
                    + "5- Voltar ao menu principal");
                int opcao_venda = entrada.nextInt();
                entrada.nextLine();

                switch(opcao_venda){

                    case 1: //realizar venda
                        
                        while(true){
                            System.out.println("\nDigite login do usuário: (usuario: admin, senha: 123456)");
                            log = entrada.nextLine();
                            System.out.println("\nDigite a senha do usuário: ");
                            sen = entrada.nextLine();
                            usuario = usuarioDao.autenticar(log, sen);

                        if (usuario != null) {
                            venda.setUsuario(usuario);
                            System.out.println("Usuario " + usuario.getNome() + " entrou no sistema\n");
                            break;
                        } else {
                            System.out.println("Dados inválidos!");
                        }
                    }
                        clientes = clienteDao.listar();
                        
                        for (Cliente cli : clientes){
                            System.out.println("Id: " + cli.getId()
                            + ", Nome: " + cli.getNome()
                            + ", Cpf: " + cli.getCpf());
                        }
                        
                    while(true){    
                        System.out.println("Digite o id do cliente: ");
                        id = entrada.nextInt();
                        cliente = clienteDao.buscar(id);
               
                        if (cliente != null) {
                            venda.setCliente(cliente);
                            System.out.println("Cliente selecionado: " + cliente.getNome());
                            break;
                        } else {
                            System.out.println("Cliente inexistente");  
                        }
                    }   
                    produtos = produtoDao.listar();
                    System.out.println(produtos);
                    
                    while(true){
                        System.out.println("Selecione o código do produto: ");
                        id = entrada.nextInt();
                        produto = produtoDao.buscar(id);

                        if(produto != null) {
                            System.out.println("Digite a quantidade: ");
                            qtde = entrada.nextInt();
                            venda.setProduto(produto);
                            venda.setData(dataHoje);
                            venda.getProduto().setQuantidade(qtde);
                            venda.getProduto().getPrecoVenda();
                            venda.setPrecoTotal(produto.getPrecoVenda() * qtde);
                            venda.executar(produto, qtde);
                            break;
                        }
                        else{
                            System.out.println("Produto inexistente");
                        }
                    }
                    
                    case 2: // consultar vendas
                        List<Venda> vendas = new ArrayList<>();
                        vendas = vendaDao.listar();
                        System.out.println("Vendas realizadas:\n");
                        
                        for(Venda vd : vendas){
                            System.out.println("Id venda: " + vd.getId()
                            + ", Usuario: " + vd.getUsuario().getNome()
                            + ", Cliente: " + vd.getCliente().getNome()
                            + ", Data: " + vd.getData()
                            + ", Produto: " + vd.getProduto().getNome()
                            + ", Preço: R$ " + vd.getProduto().getPrecoVenda()
                            + ", Quantidade: " + vd.getProduto().getQuantidade()
                            + ", Total: R$ " + vd.getPrecoTotal());
                        }
                    break;

                    case 3: // Alterar venda
                       
                        vendas = vendaDao.listar();
                        
                        for(Venda vd : vendas){
                            System.out.println("Id venda: " + vd.getId()
                            + ", Usuario: " + vd.getUsuario().getNome()
                            + ", Cliente: " + vd.getCliente().getNome()
                            + ", Data: " + vd.getData()
                            + ", Produto: " + vd.getProduto().getNome()
                            + ", Preço: R$ " + vd.getProduto().getPrecoVenda()
                            + ", Quantidade: " + vd.getProduto().getQuantidade()
                            + ", Total: R$ " + vd.getPrecoTotal());
                        }
                        
                        while(true) {
                            System.out.println("Digite o id da venda que deseja alterar:");
                            id = entrada.nextInt();
                            entrada.nextLine();
                            venda = vendaDao.buscar(id);
                        
                        if (venda != null){
                            break;
                        }
                        else{
                            System.out.println("Venda inexistente!");  
                        }
                        
                        } // fim while
                        
                        System.out.println("Id do usuario: ");
                            int id_usuario = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("id do cliente: ");
                            int id_cliente = entrada.nextInt();
                            System.out.println("Data da venda: ");
                            String data_venda = entrada.nextLine();
                            System.out.println("Id do produto: ");
                            int id_produto = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Preço de venda do produto: ");
                            Double pv = Double.parseDouble(entrada.nextLine());
                            System.out.println("Quantidade vendida: ");
                            qtde = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Valor total da venda: ");
                            Double tot = Double.parseDouble(entrada.nextLine());
                            System.out.println("...Aguarde...");
                            venda.setId(id);
                            venda.setUsuario(usuarioDao.buscar(id_usuario));
                            venda.setCliente(clienteDao.buscar(id_cliente));
                            venda.setData(data_venda);
                            venda.setProduto(produtoDao.buscar(id_produto));
                            venda.getProduto().setPrecoVenda(pv); 
                            venda.getProduto().setQuantidade(qtde);
                            venda.setPrecoTotal(tot);
                            vendaDao.atualizar(venda);
                            break;
                        
                    case 4://remover venda
                        vendas = vendaDao.listar();
                        
                        for(Venda vd : vendas) {
                            System.out.println("Id venda: " + vd.getId()
                            + ", Usuario: " + vd.getUsuario().getNome()
                            + ", Cliente: " + vd.getCliente().getNome()
                            + ", Data: " + vd.getData()
                            + ", Produto: " + vd.getProduto().getNome()
                            + ", Preço: R$ " + vd.getProduto().getPrecoVenda()
                            + ", Quantidade: " + vd.getProduto().getQuantidade()
                            + ", Total: R$ " + vd.getPrecoTotal());
                        }
                        
                        while(true) {
                                System.out.println("Digite o id da venda que quer remover:");
                                id = entrada.nextInt();
                                entrada.nextLine();
                                venda = vendaDao.buscar(id);
                                
                            if (venda != null){
                                vendaDao.remover(id);
                                break;
                            }
                            else{
                                System.out.println("Venda inexistente!");  
                            }
                        }   // fim while
                        
                    case 5: // sair do sistema
                        System.out.println("Saiu do sistema!");
                        break;
                    
                    default:
                        System.out.println("digite a opcao: ");       
                        opcao = entrada.nextInt();
                        
                        if (opcao == 1){
                            continue;
                        }
                        else{
                            break;
                        }
            } //fim switch opcao_venda
            continue; //repete o menu principal
            
            case 2: //Usuários
                
                System.out.println("\nSelecionar a opção: \n");
                System.out.println("1- Cadastrar usuário");
                System.out.println("2- Consultar usuários");
                System.out.println("3- Alterar usuário");
                System.out.println("4- Remover usuário");
                System.out.println("5- Voltar ao menu principal");
                int opcao_usuario = entrada.nextInt();
                entrada.nextLine();

                    switch (opcao_usuario) {
                        case 1: //cadastrar usuario
                            System.out.println("============================");
                            System.out.println("\nDigite o nome do usuário: ");
                            nome = entrada.nextLine();
                            System.out.println("\nDigite o login do usuário: ");
                            login = entrada.nextLine();
                            System.out.println("\nDigite a senha do usuário: ");
                            senha = entrada.nextLine();
                            usuario = new Usuario(nome, login, senha);
                            usuarioDao.inserir(usuario);
                            break;

                        case 2: // consultar usuarios
                            usuarios = usuarioDao.listar();
                            System.out.println("Usuarios cadastrados:\n");

                        for(Usuario us : usuarios){
                            System.out.println("Código: " + us.getId() 
                                    + ", Nome: " + us.getNome());
                        }
                        break;

                        case 3: //alterar usuario
                            usuarios = usuarioDao.listar();
                            
                            for(Usuario us : usuarios){
                            System.out.println("Código: " + us.getId() 
                                    + ", Nome: " + us.getNome());
                            }
                            
                            while(true) {
                                System.out.println("Digite id do usuário que deseja alterar: ");
                                id = entrada.nextInt();
                                entrada.nextLine();
                                usuario = usuarioDao.buscar(id);
                        
                            if (usuario != null){
                                break;
                            }
                            else{
                                System.out.println("Usuario inexistente!");
                            }
                        
                            }// fim while
                            
                            System.out.println("Nome usuário: ");
                            nome = entrada.nextLine();
                            System.out.println("Login: ");
                            login = entrada.nextLine();
                            System.out.println("Senha: ");
                            senha = entrada.nextLine();
                            System.out.println("...Aguarde...");
                            usuario.setId(id);
                            usuario.setNome(nome);
                            usuario.setLogin(login);
                            usuario.setSenha(senha);
                            usuarioDao.atualizar(usuario);
                            break;

                        case 4: // remover usuario
                            usuarios = usuarioDao.listar();
                            
                            for(Usuario us : usuarios){
                            System.out.println("Código: " + us.getId() 
                                    + ", Nome: " + us.getNome());
                            }
                            
                            while(true) {
                                System.out.println("Digite o id do usuário que quer remover:");
                                id = entrada.nextInt();
                                entrada.nextLine();
                                usuario = usuarioDao.buscar(id);

                            if (usuario != null){
                                usuarioDao.remover(id);
                                break;
                            }
                            else{
                                System.out.println("Usuario inexistente!");  
                            }

                        }   // fim while
                            
                        case 5: //volta ao menu principal
                            break;
                    }
                    continue; //repete o menu principal
                
            case 3: //Produtos
                
                System.out.println("\nSelecionar a opção: \n"
                    + "1- Cadastrar produto \n"
                    + "2- Consultar produtos \n"
                    + "3- Alterar produto \n"
                    + "4- Remover produto \n");
                int opcao_produto = entrada.nextInt();

                switch (opcao_produto) {
                    case 1: //cadastrar produto
                        System.out.println("============================");
                        entrada.nextLine();
                        System.out.println("\nNome do produto: ");
                        String nomeProduto = entrada.nextLine();
                        System.out.println("Preco de compra: ");
                        Double pc = Double.parseDouble(entrada.nextLine());
                        System.out.println("Preco de venda: ");
                        Double pv = Double.parseDouble(entrada.nextLine());
                        System.out.println("Estoque inicial: ");
                        estoque = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Categoria: ");
                        String categoria = entrada.nextLine();
                        produto = new Produto (nomeProduto, pc, pv, estoque, categoria);
                        produtoDao.inserir(produto);
                        break;

                    case 2: //consultar todos os produtos
                        produtos = produtoDao.listar();
                        System.out.println("Produtos cadastrados:\n");

                        for(Produto prod : produtos){
                            System.out.println(prod);
                        }
                        break;

                    case 3: //atualizar produto
                        produtos = produtoDao.listar();
                        
                        for(Produto prod : produtos){
                            System.out.println(prod);
                        }
                        
                    while(true) {
                        System.out.println("Digite id do produto que deseja alterar: ");
                        id = entrada.nextInt();
                        entrada.nextLine();
                        produto = produtoDao.buscar(id);
                        
                        if (produto != null){
                            break;
                        }
                        else{
                            System.out.println("Produto inexistente!");
                        }
                        
                    }    
                        System.out.println("Nome do produto: ");
                        String nome_produto = entrada.nextLine();
                        System.out.println("Preço de compra: ");
                        pc = Double.parseDouble(entrada.nextLine());
                        System.out.println("Preço de venda: ");
                        pv = Double.parseDouble(entrada.nextLine());
                        System.out.println("Estoque: ");
                        estoque = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Categoria: ");
                        categoria = entrada.nextLine();
                        System.out.println("...Aguarde...");
                        produto.setId(id);
                        produto.setNome(nome_produto);
                        produto.setPrecoCompra(pc);
                        produto.setPrecoVenda(pv);
                        produto.setEstoque(estoque);
                        produto.setCategoria(categoria);
                        produtoDao.atualizar(produto);
                        break;
                        
                    case 4: // remover produto
                        produtos = produtoDao.listar();
                        
                        for(Produto prod : produtos){
                            System.out.println(prod);
                        }
                        
                        while(true) {
                            System.out.println("Digite o id do produto que quer remover");
                            id = entrada.nextInt();
                            entrada.nextLine();
                            produto = produtoDao.buscar(id);

                            if (produto!=null){
                                produtoDao.remover(id);
                                break;
                            }
                            else{
                                System.out.println("Produto inexistente");  
                            }
                        
                        }// fim while
                        
                } // fim switch produto
                continue;//repete o menu principal
                
            case 4: //Clientes
                System.out.println("\nSelecionar a opção: \n"
                    + "1- Cadastrar cliente \n"
                    + "2- Consultar clientes \n"
                    + "3- Alterar cliente \n"
                    + "4- Remover cliente \n");
                int opcao_cliente = entrada.nextInt();
                entrada.nextLine();

                switch (opcao_cliente) {
                    case 1: // cadastrar cliente
                        System.out.println("============================");
                        System.out.println("\nNome do cliente: ");
                        nome = entrada.nextLine();
                        System.out.println("\nCpf: ");
                        cpf = entrada.nextLine();
                        cliente.setNome(nome);
                        cliente.setCpf(cpf);

                        try {
                            clienteDao.inserir(cliente);
                        } catch (SQLException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;

                    case 2: //listar todos os clientes
                        clientes = clienteDao.listar();
                        System.out.println("Clientes cadastrados:\n");

                        for(Cliente cli : clientes){
                            System.out.println("Código: " + cli.getId() 
                                    + ", Nome: " + cli.getNome()
                                    + ", Cpf: " + cli.getCpf());  
                        }
                        break;

                    case 3: //atualizar cliente
                        clientes = clienteDao.listar();
                        
                        for(Cliente cli : clientes){
                            System.out.println("Id: " + cli.getId() 
                                    + ", Nome: " + cli.getNome()
                                    + ", Cpf: " + cli.getCpf());  
                        }
                        
                        while(true) {
                            System.out.println("Digite id do cliente que deseja alterar: ");
                            id = entrada.nextInt();
                            entrada.nextLine();
                            cliente = clienteDao.buscar(id);

                            if (cliente != null){
                                break;
                            }
                            else{
                                System.out.println("Cliente inexistente");
                            }
                        } // fim while
                        
                            System.out.println("Nome do cliente: ");
                            String nome_cliente = entrada.nextLine();
                            System.out.println("Cpf: ");
                            cpf = entrada.nextLine();
                            System.out.println("...Aguarde...");
                            cliente.setId(id);
                            cliente.setNome(nome_cliente);
                            cliente.setCpf(cpf);
                            clienteDao.atualizar(cliente);
                    break;

                    case 4: //remover cliente
                        clientes = clienteDao.listar();
                        
                        for(Cliente cli : clientes){
                            System.out.println("Id: " + cli.getId() 
                                    + ", Nome: " + cli.getNome()
                                    + ", Cpf: " + cli.getCpf());  
                        }
                        
                        while(true) {
                            System.out.println("Digite o id do cliente que quer remover:");
                            id = entrada.nextInt();
                            entrada.nextLine();
                            cliente = clienteDao.buscar(id);
                        
                        if (cliente!=null){
                            clienteDao.remover(id);
                            break;
                        }
                        else{
                            System.out.println("Cliente inexistente!");  
                        }
                        
                    }   // fim while
                    
                }
                continue;//repete o menu principal

            case 5:// Compra
                System.out.println("\nSelecionar a opção: \n"
                        + "1- Realizar compra \n"
                        + "2- Consultar todas as compras \n"
                        + "3- Alterar compra \n"
                        + "4- Remover compra \n"
                        + "5- Voltar ao menu principal");
                int opcao_compra = entrada.nextInt();
                entrada.nextLine();

                switch(opcao_compra){
                    case 1: //realizar compra
                    System.out.println("\nDigite o id do fornecedor: ");
                    fornecedores = fornecedorDao.listar();
                    
                    for (Fornecedor frn : fornecedores){
                        System.out.println("Id: " + frn.getId()
                        + ", Nome: " + frn.getNome()
                        + ", Cnpj: " + frn.getCnpj()); 
                    }
                    
                    id = entrada.nextInt();

                    try {
                        fornecedor = fornecedorDao.buscar(id);

                        if (fornecedor != null) {
                            compra.setFornecedor(fornecedor);
                            System.out.println("\nFornecedor selecionado: " + fornecedor.getNome());

                    } else {
                        System.out.println("Fornecedor inexistente");
                    }
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    produtos = produtoDao.listar();
                    System.out.println(produtos);
                    
                    while(true){
                        System.out.println("\nSelecione um produto pelo código: \n");
                        id = entrada.nextInt();
                        Produto prod = produtoDao.buscar(id);

                        if (prod != null) {
                            System.out.println("\nProduto selecionado: " + prod.getNome());
                            System.out.println("\nDigite a quantidade: \n");
                            qtde = entrada.nextInt();
                            compra.setProduto(prod);
                            compra.getProduto().setQuantidade(qtde);
                            compra.setPrecoTotal(prod.getPrecoCompra() * qtde);
                            System.out.println("\n========RESUMO DA COMPRA=========\n");
                            compra.setUsuario(usuario);
                            compra.setFornecedor(fornecedor);
                            compra.setData(dataHoje);
                            compra.executar(prod, qtde);
                            compraDao.inserir(compra);
                            break;
                        } else {
                            System.out.println("Produto inexistente");
                        }
                    }
                    System.out.println("\nDeseja comprar mais algum produto? 1-SIM     2-NAO");
                    resposta = entrada.nextInt();

                    if (resposta==2){
                        break;
                    }
                break;

                case 2: // consultar todas as compras
                    System.out.println("Compras realizadas:\n");
                    compras = compraDao.listar();

                    for(Compra comp : compras){
                        System.out.println("Id compra: " + comp.getId()
                        + ", Usuário: " + comp.getUsuario().getNome()
                        + ", Fornecedor: " + comp.getFornecedor().getNome()
                        + ", Data: " + comp. getData()
                        + ", Produto: " + comp.getProduto().getNome()
                        + ", Preço: R$ " + comp.getProduto().getPrecoCompra()
                        + ", Quantidade: " + comp.getProduto().getQuantidade()
                        + ", Total: R$ " + comp.getPrecoTotal());
                    }
                    break;

                case 3: // Alterar compra
                    compras = compraDao.listar();
                    System.out.println("-----------------");
                    
                    for(Compra comp : compras){
                            System.out.println("Id compra: " + comp.getId()
                            + ", Usuário: " + comp.getUsuario().getNome()
                            + ", Fornecedor: " + comp.getFornecedor().getNome()
                            + ", Data: " + comp. getData()
                            + ", Produto: " + comp.getProduto().getNome()
                            + ", Preço: R$ " + comp.getProduto().getPrecoCompra()
                            + ", Quantidade: " + comp.getProduto().getQuantidade()
                            + ", Total: R$ " + comp.getPrecoTotal());
                        }
                    
                    while(true) {
                        System.out.println("Digite o id da compra que deseja alterar:");
                        id = entrada.nextInt();
                        entrada.nextLine();
                        compra = compraDao.buscar(id);
                        
                        if (compra != null){
                            break;
                        }
                        else{
                            System.out.println("Compra inexistente!");  
                        }
                        
                        } // fim while
                        
                    System.out.println("\nDigite o id da compra que deseja alterar: ");
                    int id_compra = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Id do usuario: ");
                    int id_usuario = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Id do fornecedor: ");
                    int id_fornecedor = entrada.nextInt();
                    System.out.println("Data da compra: ");
                    String data_venda = entrada.nextLine();
                    System.out.println("Id do produto: ");
                    int id_produto = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Preço de compra do produto: ");
                    Double pc = Double.parseDouble(entrada.nextLine());
                    System.out.println("Quantidade comprada: ");
                    qtde = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Valor total da compra: ");
                    Double tot = Double.parseDouble(entrada.nextLine());
                    System.out.println("...Aguarde...");
                    compra.setId(id_compra);
                    compra.setUsuario(usuarioDao.buscar(id_usuario));
                    compra.setFornecedor(fornecedorDao.buscar(id_fornecedor));
                    compra.setData(data_venda);
                    compra.setProduto(produtoDao.buscar(id_produto));
                    compra.getProduto().setPrecoCompra(pc); 
                    compra.getProduto().setQuantidade(qtde);
                    compra.setPrecoTotal(tot);
                    compraDao.atualizar(compra);
                    break;

                case 4://remover compra
                    
                    for(Compra comp : compras) {
                            System.out.println("Id compra: " + comp.getId()
                            + ", Usuário: " + comp.getUsuario().getNome()
                            + ", Fornecedor: " + comp.getFornecedor().getNome()
                            + ", Data: " + comp. getData()
                            + ", Produto: " + comp.getProduto().getNome()
                            + ", Preço: R$ " + comp.getProduto().getPrecoCompra()
                            + ", Quantidade: " + comp.getProduto().getQuantidade()
                            + ", Total: R$ " + comp.getPrecoTotal());
                        }
                    
                    while(true) {
                        System.out.println("Digite o id da compra que quer remover:");
                        id = entrada.nextInt();
                        entrada.nextLine();
                        compra = compraDao.buscar(id);
                        
                        if (compra != null){
                            compraDao.remover(id);
                            break;
                        }
                        else{
                            System.out.println("Compra inexistente!");  
                        }
                        
                    }   // fim while
                   
                case 5: 
                    System.out.println("Saiu do sistema!");
                    break;
                
                default:
                    break;

        } //fim switch opcao_compra
        continue; //repete o menu principal

            case 6: //Fornecedores
                System.out.println("\nSelecionar a opção: \n"
                        + "1- Cadastrar fornecedor \n"
                        + "2- Consultar todos os fornecedores \n"
                        + "3- Alterar fornecedor \n"
                        + "4- Remover fornecedor \n");
                int opcao_fornecedor = entrada.nextInt();
                entrada.nextLine();

                switch (opcao_fornecedor) {

                    case 1: // cadastrar fornecedor
                        fornecedor = new Fornecedor();
                        System.out.println("============================");
                        System.out.println("\nNome do fornecedor: ");
                        nome = entrada.nextLine();
                        System.out.println("\nCnpj: ");
                        cnpj = entrada.nextLine();
                        fornecedor.setNome(nome);
                        fornecedor.setCnpj(cnpj);
                        fornecedorDao.inserir(fornecedor);
                        break;

                    case 2: //consultar todos os fornecedores
                        fornecedores = fornecedorDao.listar();
                        System.out.println("Fornecedores cadastrados:\n");

                        for (Fornecedor frn : fornecedores) {
                            System.out.println("Código: " + frn.getId() 
                                    + ", Nome: " + frn.getNome()
                                    + ", Cnpj: " + frn.getCnpj());
                        }
                        break;

                    case 3: //atualizar fornecedor
                        System.out.println("Fornecedores cadastrados:\n");
                        fornecedores = fornecedorDao.listar();
                        
                        for (Fornecedor frn : fornecedores) {
                            System.out.println("Id: " + frn.getId() 
                                    + ", Nome: " + frn.getNome()
                                    + ", Cnpj: " + frn.getCnpj());
                        }
                        
                        while(true) {
                            System.out.println("Digite id do fornecedor que deseja alterar: ");
                            id = entrada.nextInt();
                            entrada.nextLine();
                            fornecedor = fornecedorDao.buscar(id);
                        
                        if (produto != null){
                            break;
                        }
                        else{
                            System.out.println("Fornecedor inexistente!");
                        }
                        
                        }    
                        
                        System.out.println("Nome do fornecedor: ");
                        String nome_fornecedor = entrada.nextLine();
                        System.out.println("Cnpj: ");
                        cnpj = entrada.nextLine();
                        System.out.println("...Aguarde...");
                        fornecedor.setId(id);
                        fornecedor.setNome(nome_fornecedor);
                        fornecedor.setCnpj(cnpj);
                        fornecedorDao.atualizar(fornecedor);
                        break;

                    case 4: //remover fornecedor
                        
                        for (Fornecedor frn : fornecedores) {
                            System.out.println("Código: " + frn.getId() 
                                    + ", Nome: " + frn.getNome()
                                    + ", Cnpj: " + frn.getCnpj());
                        }
                        
                        while(true) {
                            System.out.println("Digite o id do fornecedor que quer remover:");
                            id = entrada.nextInt();
                            entrada.nextLine();
                            fornecedor = fornecedorDao.buscar(id);
                        
                        if (fornecedor != null){
                            fornecedorDao.remover(id);
                            break;
                        }
                        else{
                            System.out.println("Fornecedor inexistente!");  
                        }
                        
                    }   // fim while
                        
                }
                continue; // repete o menu principal
                
            case 7:
                System.out.println("Saiu do sistema");
                break;

            default:
                System.out.println("Opção inválida!");
                
            }
            break;
        }
        
    }

}

       
    

        


    


