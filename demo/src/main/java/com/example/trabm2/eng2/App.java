package com.example.trabm2.eng2;

import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

public class App 
{
    public static void menuLogin(){
        System.out.print("----- MENU -----\n" +
                         " 1 - Login\n" +
                         " 2 - Cadastro\n" +
                         " 0 - Sair\n" +
                         "----------------\n" +
                         "Opcao:");
    }

    public static void menuPosLogin(){
        System.out.print("------- Principal -------\n" +
                         " 1 - Fazer Pergunta\n" +
                         " 2 - Responder Pergunta\n" +
                         " 0 - Sair\n" +
                         "-------------------------\n" +
                         "Opcao:");
    }

    public static void login(Usuario usuario){
        Login login = new Login();
        Scanner in = new Scanner(System.in);
        String senha;
        String email;
        do {
            System.out.print("Email: ");
            email = in.nextLine();
            if (Objects.equals(email, ""))
                System.out.println("Nome Invalido!");
        }while (Objects.equals(email, ""));
        do {
            System.out.print("Senha: ");
            senha = in.nextLine();
            if (Objects.equals(senha, ""))
                System.out.println("Senha Invalida!");
        }while (Objects.equals(senha, ""));

        login.setUsuario(usuario);

        if (login.fazLogin()) System.out.println("Login feito com sucesso!");
        else System.out.println("Login Fracassado!");

        in.close();
    }

    public static void cadastro(){
        Scanner in = new Scanner(System.in);
        Usuario usuario = new Usuario();
        Cadastro cadastro = new Cadastro();
        String nome, senha, email;

        do {
            System.out.print("Nome: ");
            nome = in.nextLine();
            if (Objects.equals(nome, ""))
                System.out.println("Nome Invalido!");
        }while (Objects.equals(nome, ""));
        do {
            System.out.print("Senha: ");
            senha = in.nextLine();
            if (Objects.equals(senha, ""))
                System.out.println("Senha Invalida!");
        }while (Objects.equals(senha, ""));
        do {
            System.out.print("Email: ");
            email = in.nextLine();
            if (Objects.equals(email, ""))
                System.out.println("Email Invalido!");
        }while (Objects.equals(email, ""));

        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setEmail(email);

        cadastro.setUsuario(usuario);

        if (cadastro.fazCadastro())
            System.out.println("Cadastro feito com sucesso!");
        else System.out.println("Cadastro fracassado!");

        in.close();
    }

    public static void fazerPergunta(Usuario usuario){
        System.out.println("\n----- Criar Pergunta -----");
        Pergunta pergunta = new Pergunta();
        Scanner in = new Scanner(System.in);
        String perg;
        do {
            System.out.println("Qual a sua pergunta?");
            perg = in.nextLine();
            if (Objects.equals(perg, "")) System.out.println("Pergunta Invalida!");
        }while (Objects.equals(perg, ""));

        pergunta.setUsuario(usuario);
        pergunta.setPergunta(perg);
        pergunta.setData(Calendar.getInstance());

        System.out.println("Pergunta Realizada!");
        in.close();
    }

    public static void responderPergunta(Usuario usuario, Pergunta pergunta){
        System.out.println("\n----- Responder Pergunta -----");
        Scanner in = new Scanner(System.in);
        Resposta resposta = new Resposta();
        String resp;
        do {
            System.out.print("Resposta: ");
            resp = in.nextLine();
            if (Objects.equals(resp, "")) System.out.println("Resposta Invalida!");
        }while (Objects.equals(resp, ""));

        resposta.setUsuario(usuario);
        resposta.setPergunta(pergunta);
        resposta.setData(Calendar.getInstance());
        resposta.setResposta(resp);

        System.out.println("Resposta Realizada!");
        in.close();
    }

    public static Usuario inicializaUsuario(Usuario usuario){
        usuario.setNome("Pedro");
        usuario.setEmail("pedropedrinho@gmail.com");
        usuario.setSenha("pedrinhometeoloko");
        return usuario;
    }

    public static void main(String[] args) {
        //Usuario usuario = new Usuario();
        Usuario usuario = inicializaUsuario(new Usuario());
        Scanner inputL = new Scanner(System.in), inputP = new Scanner(System.in);
        int opL, opP;
        do {
            menuLogin();
            opL = inputL.nextInt();
            switch (opL){
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    login(usuario);
                    do {
                        menuPosLogin();
                        opP = inputP.nextInt();
                        switch (opP) {
                            case 0:
                                System.out.println("Saindo...");
                            case 1:
                                fazerPergunta(usuario);
                                break;
                            case 2:
                                Pergunta pergunta = new Pergunta();
                                responderPergunta(usuario, pergunta);
                                break;
                            default:
                                System.out.println("Opcao Invalida");
                                break;
                        }
                    }while (opP != 0);
                    break;
                case 2:
                    cadastro();
                    break;
                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
        }while(opL != 0);
        inputL.close();
        inputP.close();
    }
}
