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
        Produto p = new Produto();
        ProdutoDao produtoDao = new ProdutoDao();
        Venda venda = new Venda();
        VendaDao vendaDao = new VendaDao();
        List<Produto> produtosVenda = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> usuarios = new ArrayList<>();
        String nome, login, senha;
        Cliente cliente = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> clientes = new ArrayList<>();
        String cpf;
        int i, id, resposta, opcao;
       
        while (true) {
            
           System.out.println(
                        "\nSelecionar a opção: \n"
                                + "1- Venda \n"
                                + "2- Usuários \n"
                                + "3- Produtos \n"
                                + "4- Clientes \n"
                                + "5- Sair");
                
            Scanner entrada = new Scanner(System.in);
            opcao = entrada.nextInt();
            entrada.nextLine(); 

                switch (opcao) {

                    case 1://Venda
                        
                        
                        while (true) {
                            
                            System.out.println("\nDigite login do usuário: ");
                            String log = entrada.nextLine();
                            
                            System.out.println("\nDigite a senha do usuário: ");
                            String sen = entrada.nextLine();
                            
                            try {
                                usuario = usuarioDao.autenticar(log, sen);
                                if (usuario != null) {
                                    venda.setUsuario(usuario);
                                    System.out.println("Usuario " + usuario.getNome() + " entrou no sistema");
                                    break;
                                    
                                } else {
                                    System.out.println("Usuario inexistente");
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } // fim while
                       
                        while (true) {
                            
                 
                            System.out.println("\nDigite o cpf do cliente: ");
                                clientes = clienteDao.listar();
                                
                                cpf = entrada.nextLine();
                                try {
                                    cliente = clienteDao.autenticar(cpf);
                                    
                                    if (cliente != null) {
                                        venda.setUsuario(usuario);
                                        System.out.println("\nCliente selecionado " + cliente.getNome());
                                        break;
                                    
                                } else {
                                    System.out.println("Cliente inexistente");
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } //fim while
                       
                                System.out.println("\nSelecione um produto pelo código: \n");
                                produtos = produtoDao.listar();
                                
                                System.out.println(produtos);
                                
                                id = entrada.nextInt();
                                
                                try {
                                    Produto prod = produtoDao.autenticar(id);
                                    
                                    if (prod != null) {
                                        
                                        System.out.println("\nProduto selecionado: " + prod.getNome());
                                        System.out.println("\nDigite a quantidade: \n");
                                        int qtde = entrada.nextInt();
                                       
                                        venda.setProduto(prod);
                                        venda.getProduto().setQuantidade(qtde);
                                        venda.setProdutosVenda(produtosVenda);
                                        
                                        System.out.println("\n========RESUMO DA VENDA=========\n");
                                        venda.setUsuario(usuario);
                                        venda.setCliente(cliente);
                                        venda.setData(dataHoje);
                                       
                                        venda.executar(prod, qtde);
                                        vendaDao.inserir(venda);
                                         
                                        break;
                                    
                                } else {
                                    System.out.println("Produto inexistente");
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                               
                                
                                System.out.println("Deseja vender mais algum produto? 1-SIM     2-NAO");
                                
                                resposta = entrada.nextInt();
                                
                                if (resposta==2){
                                    break;
                                }
                    
                        break;
                    case 2: //Usuários
                    
                        while(true){
                            System.out.println("\nSelecionar a opção: \n"
                                    + "1- Cadastrar usuário \n"
                                    + "2- Consultar usuários \n"
                                    + "3- Alterar usuário \n"
                                    + "4- Remover usuário \n"
                                    + "5- Voltar ao menu principal");
                            
                            int opcao_usuario = entrada.nextInt();
                            entrada.nextLine();
                            
                            switch (opcao_usuario) {
                                case 1:
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
                                    
                                case 2:
                                    usuarios = usuarioDao.listar();
                                    System.out.println("Usuarios cadastrados:\n");
                                    
                                    
                                for(Usuario us : usuarios){
                                    System.out.println("Código: " + us.getId() 
                                            + " Nome: " + us.getNome());
                                }
                                break;
                                   
                                    
                                case 3:
                                    System.out.println("Digite id do usuario: ");
                                    id = entrada.nextInt();
                                    entrada.nextLine();
                                    System.out.println("Digite o nome: ");
                                    nome = entrada.nextLine();
                                    System.out.println("Digite o novo login: ");
                                    login = entrada.nextLine();
                                    System.out.println("Digite a nova senha: ");
                                    senha = entrada.nextLine();
                                    
                                    usuario.setId(id);
                                    usuario.setNome(nome);
                                    usuario.setLogin(login);
                                    usuario.setSenha(senha);
                                    usuarioDao.atualizar(usuario);
                                    break;
                                    
                                case 4:
                                    System.out.println("Digite o id do usuario que quer remover");
                                    id = entrada.nextInt();
                                    usuarioDao.remover(id);
                                    break;
                                    
                                case 5:
                                    break;
                            }
                            break;
                        }
                        break;
                        
                    case 3: //Produtos
                        System.out.println("\nSelecionar a opção: \n"
                                + "1- Cadastrar produto \n"
                                + "2- Consultar produtos \n"
                                + "3- Alterar produto \n"
                                + "4- Remover produto \n");
                        
                        int opcao_produto = entrada.nextInt();
                        
                        switch (opcao_produto) {
                            
                            case 1:
                                System.out.println("============================");
                                entrada.nextLine();
                                System.out.println("\nDigite o nome do produto: ");
                                String nomeProduto = entrada.nextLine();
                                
                                System.out.println("Preco de compra: ");
                                Double pc = Double.parseDouble(entrada.nextLine());
                                
                                System.out.println("Preco de venda: ");
                                Double pv = Double.parseDouble(entrada.nextLine());
                                
                                System.out.println("Digite o estoque inicial: ");
                                int estoque = entrada.nextInt();
                                entrada.nextLine();
                                
                                System.out.println("\nDigite a categoria: ");
                                String categoria = entrada.nextLine();
                                
                                p = new Produto (nomeProduto, pc, pv, estoque, categoria);
                                produtoDao.inserir(p);
                                break;

                            case 2:
                                produtos = produtoDao.listar();
                                System.out.println("Produtos cadastrados:\n");
                                
                                for(Produto prod : produtos){
                                    System.out.println(prod);
                                }
                                break;
                                
                            case 3:
                                produtoDao.atualizar(p);
                                break;
                                
                            case 4:
                                System.out.println("Digite o id do produto que quer remover");
                                id = entrada.nextInt();
                                produtoDao.remover(id);
                                break;
                        }
                        
                        
                        break;
                        
                    case 4: //Clientes
                        System.out.println("\nSelecionar a opção: \n"
                                + "1- Cadastrar cliente \n"
                                + "2- Consultar clientes \n"
                                + "3- Alterar cliente \n"
                                + "4- Remover cliente \n");
                        
                        int opcao_cliente = entrada.nextInt();
                        entrada.nextLine();
                        
                        switch (opcao_cliente) {
                            
                            case 1:
                                System.out.println("============================");
                                
                                System.out.println("\nDigite o nome do cliente: ");
                                nome = entrada.nextLine();
                                
                                System.out.println("\nDigite o cpf: ");
                                cpf = entrada.nextLine();
                                cliente.setNome(nome);
                                cliente.setCpf(cpf);
                                
                                
                                try {
                                    clienteDao.inserir(cliente);
                                } catch (SQLException ex) {
                                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                break;
                                
                                
                            case 2:
                                clientes = clienteDao.listar();
                                System.out.println("Clientes cadastrados:\n");
                                
                                for(Cliente cli : clientes){
                                    System.out.println("Código: " + cli.getId() 
                                            + " Nome: " + cli.getNome());
                                   
                                           
                                }
                                break;
                                
                            case 3:
                                clienteDao.atualizar(cliente);
                                break;
                                
                            case 4:
                                System.out.println("Digite o id do cliente que quer remover");
                                id = entrada.nextInt();
                                clienteDao.remover(id);
                                break;
                        }
                        
                        
                        break;
                        
                    case 5:
                        System.out.println("saiu do sistema");
                        break;
                        
                    default:
                        
                        System.out.println("Opção inválida!");
                        break;
                }
        }
    }
}

       
    

        


    


