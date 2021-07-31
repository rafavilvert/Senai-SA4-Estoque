package sa4;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Grupo 1: Dario Distaso, Rafael Vilvert, Eduard Richard Sprung, José da Silva Mattos Junior
 */
public class Principal {
    public static void main(String[] args) {
        
        Produto p = new Produto();
        Venda venda = new Venda();
        Cliente cli = new Cliente();
        Gerente administrador = new Gerente();
        Usuario usuario = new Usuario();
        Date dataVenda = new Date();
        ArrayList<Produto> produtosVenda = new ArrayList<>();
        ArrayList<Produto> produtosEstoque = new ArrayList<>();
        ArrayList<Object> listaUsuarios = new ArrayList<>();
        ArrayList<Object> infoVenda = new ArrayList<>();
        String escolha;
        int opcao = 0;
        
        System.out.println("=================BEM-VINDO==================");
        System.out.println("CADASTRE O USUARIO ROOT -- Digite um login: ");
        Scanner entrada = new Scanner(System.in);
        String login = entrada.nextLine();
        administrador.setLogin(login);

        System.out.println("Digite o nome: ");
        String nome = entrada.nextLine();
        administrador.setNome(nome);

        System.out.println("Digite o email: ");
        String email = entrada.nextLine();
        administrador.setEmail(email);

        System.out.println("Digite a senha: ");
        String senha = entrada.nextLine();
        administrador.setSenha(senha);

        System.out.println("Digite o cargo: ");
        String cargo = entrada.nextLine();
        administrador.setCargo(cargo);

        System.out.println("Digite o cpf: ");
        String cpf = entrada.nextLine();
        administrador.setCpf(cpf);
        listaUsuarios.add(administrador);

        System.out.println("Administrador cadastrado com sucesso!");
            
        do {
            System.out.println(
                "\nSelecionar a opção: \n"
                + "1- Cadastrar produtos \n"
                + "2- Cadastrar usuários \n"
                + "3- Venda \n"
                + "4- Consultar usuários \n"
                + "5- Consultar produtos \n"
                + "6- Consultar vendas \n"
                + "7- Sair \n"
            );

            opcao = entrada.nextInt();
            entrada.nextLine(); // consome o comando do Enter

            switch(opcao) {
                
                case 1:
                    
                    System.out.println("=======================");
                    
                    System.out.println("Digite o codigo do produto: ");
                    int cod = entrada.nextInt();
                    entrada.nextLine();
                    
                    System.out.println("Digite a categoria: ");
                    String categoria = entrada.nextLine();
                    
                    System.out.println("Digite o nome do produto: ");
                    String nomeProduto = entrada.nextLine();
                    
                    System.out.println("Digite o preço de compra do produto: ");
                    double precoCompra = Double.parseDouble(entrada.nextLine());
                    
                    System.out.println("Digite o preço de venda do produto: ");
                    double precoVenda = Double.parseDouble(entrada.nextLine());
                    
                    System.out.println("Digite o estoque inicial do produto: ");
                    int estoque = entrada.nextInt();
                    entrada.nextLine();
                    
                    p = new Produto (cod,categoria,nomeProduto,precoCompra,precoVenda,estoque);
                    produtosEstoque.add(p);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                
                case 2: // cadastro usuário

                    System.out.println("============================");
                    System.out.println("Digite seu login: ");
                    login = entrada.nextLine();
                    System.out.println("Digite sua senha: ");
                    senha = entrada.nextLine();
                    
                    if (administrador.getLogin().equals(login) && administrador.getSenha().equals(senha)){
                        System.out.println("Usuário " + administrador.getNome() + " entrou no sistema\n");
                    }

                    else {
                        System.out.println("Usuário sem permissão!\n");
                    }
                    
                    entrada.nextLine();
                    administrador.cadastrarUsuario();
                    break;   
                
                case 3: // venda
                    System.out.println("Digite seu login: ");
                    login = entrada.nextLine();
                    System.out.println("Digite sua senha: ");
                    senha = entrada.nextLine();
                    
                    if (administrador.getLogin().equals(login) && administrador.getSenha().equals(senha)){
                        System.out.println("Usuário " + administrador.getNome() + " entrou no sistema\n");
                    }

                    else {
                        System.out.println("Usuário não cadastrado! Deseja cadastrar? Sim - Não: \n");
                        escolha = entrada.nextLine();

                        if (escolha == "Sim"){
                            Gerente gerente = new Gerente();
                            gerente.cadastrarUsuario();
                        }

                        else{
                            break;
                        }

                    }
                        
                    System.out.println("Digite o cpf do cliente: ");
                    cpf = entrada.nextLine();
                    cli.setCpf(cpf);
                    
                    System.out.println("\nDigite o código do produto: \n");
                    
                    
                        for (int i=0;i<produtosEstoque.size();i++) {

                            System.out.println("Código: " + produtosEstoque.get(i).getCodigo() + 
                                    " Produto: " + produtosEstoque.get(i).getNomeProduto() + 
                                    " Estoque: " + produtosEstoque.get(i).getEstoque());
                        }
                    
                    String codigo = entrada.nextLine();
                    
                    System.out.println("Digite a quantidade: ");
                    int quantidade = entrada.nextInt();
                    
                    produtosEstoque.add(p);
                    usuario.vender(p, quantidade);
                    produtosVenda.add(p);
                    infoVenda.add(usuario);
                    infoVenda.add(produtosVenda);
                    infoVenda.add(cli);
                    
                    break;


                case 4:
                    
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        System.out.println(listaUsuarios.get(i).toString() + "\n");
                    }
                    break;
                    
                case 5:
                    
                    for(int i=0;i<produtosEstoque.size();i++){
                        System.out.println(produtosEstoque.get(i).getDadosProduto());
                    }
                    break;
                    
                case 6:
                    for(Produto vendidos : produtosVenda){
                       System.out.println(vendidos.getNomeProduto() + "\n");
                    }
                    System.out.println(infoVenda.toString());
                case 7:
                    
                    break;
                    
                default:
                    
                    System.out.println("Opção inválida!");
                    break;
                }
            
            }  
        
        while(opcao!=7);
    
    
        
        
        
    }
    
}
