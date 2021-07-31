package sa4;

import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Usuario{
    
    ArrayList<Object> listaUsuarios;

    public void cadastrarUsuario(){
        Scanner entrada = new Scanner(System.in);
        Usuario usuario = new Usuario();
        
        System.out.println("Digite o login do usuário: ");
        String login = entrada.nextLine(); 
        usuario.setLogin(login);

        System.out.println("Digite o nome do usuário: ");
        String nome = entrada.nextLine();
        usuario.setNome(login);

        System.out.println("Digite o email do usuário: ");
        String email = entrada.nextLine();
        usuario.setEmail(email);

        System.out.println("Digite a senha do usuário: ");
        String senha = entrada.nextLine();
        usuario.setSenha(senha);
        
        System.out.println("Cargo do usuário: ");
        String cargo = entrada.nextLine();
        usuario.setCargo(cargo);

        System.out.println("Cpf do usuário: ");
        String cpf = entrada.nextLine();
        usuario.setCpf(cpf);

        listaUsuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }
   
    
}
