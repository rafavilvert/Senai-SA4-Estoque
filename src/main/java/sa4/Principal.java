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
        ArrayList<Produto> produtosVenda = new ArrayList<>();
        ArrayList<Produto> produtosEstoque = new ArrayList<>();
        
       int opcao = 0;
        do {

            System.out.println(
                    "Selecionar a opção: \n"
                    + "1- Venda \n"
                    + "2- Cadastrar usuário \n"
                    + "3- Consultar usuários \n"
                    + "4- Cadastrar produtos \n"
                    + "5- Consultar produtos \n"
                    + "6- Consultar vendas \n"
                    + "7- Sair"
            );

            Scanner entrada = new Scanner(System.in);
            opcao = entrada.nextInt();
            entrada.nextLine(); // consome o comando do Enter

            switch (opcao) {

                case 1:

                    System.out.println("Qual produto quer vender? Digite o código: ");
                    
                    for (int i=0;i<produtosEstoque.size();i++) {

                        System.out.println("Código: " + produtosEstoque.get(i).getCodigo() + 
                                " Produto: " + produtosEstoque.get(i).getNome() + 
                                " Estoque: " + produtosEstoque.get(i).getEstoque());
                    }
                    
                    String codigo = entrada.nextLine();
                    
                    System.out.println("Quantidade: ");
                    int quantidade = entrada.nextInt();
                    
                    produtosEstoque.add(p);
                    venda.vender(p, quantidade);
                    produtosVenda.add(p);
                    break;

                case 2:

                    System.out.println("============================");
                    System.out.println("Digite o nome do usuário: ");
                    String nomeUsuario = entrada.nextLine();

                    System.out.println("Digite o email do usuário: ");
                    String emailUsuario = entrada.nextLine();

                    System.out.println("Digite a senha do usuário: ");
                    String senhaUsuario = entrada.nextLine();

                    Usuario usuario = new Usuario(nomeUsuario, emailUsuario, senhaUsuario);
                    //listaUsuarios.add(usuario);
                    System.out.println("Usuário cadastrado com sucesso!");
                    
                    break;

                case 3:
                    
                    /*for (int i = 0; i < listaUsuarios.size(); i++) {
                        System.out.println(listaUsuarios.get(i).getDadosUsuario() + "\n");
                    }
                    break; ainda não criei a lista dos usuarios (vendedores, administrador, gerente)*/
                    
                case 4:
                    
                    System.out.println("=======================");
                    
                    System.out.println("Digite o codigo do produto: ");
                    int cod = entrada.nextInt();
                    entrada.nextLine();
                    
                    System.out.println("Digite a categoria: ");
                    String categoria = entrada.nextLine();
                    
                    System.out.println("Digite o nome do produto: ");
                    String nome = entrada.nextLine();
                    
                    System.out.println("Digite o preço de compra do produto: ");
                    double precoCompra = Double.parseDouble(entrada.nextLine());
                    
                    System.out.println("Digite o preço de venda do produto: ");
                    double precoVenda = Double.parseDouble(entrada.nextLine());
                    
                    System.out.println("Digite o estoque inicial do produto: ");
                    int estoque = entrada.nextInt();
                    entrada.nextLine();
                    
                    p = new Produto (cod,categoria,nome,precoCompra,precoVenda,estoque);
                    produtosEstoque.add(p);
                    break;
                    
                case 5:
                    
                    for(int i=0;i<produtosEstoque.size();i++){
                        System.out.println(produtosEstoque.get(i).getDadosProduto());
                    }
                    break;
                    
                case 6:
                    for(Produto vendidos : produtosVenda){
                       System.out.println(vendidos.getNome() + "\n");
                    }
                
                
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
