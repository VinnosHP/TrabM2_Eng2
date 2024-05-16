package com.example.trabm2.eng2.models;

import java.util.Calendar;

public class OpcoesUsuarioFacade {
    public void fazLogin(Usuario usuario){
        Login login = new Login(usuario);
        if (login.fazLogin(usuario)) {
            System.out.println("Login feito com sucesso!");
        }else System.out.println("Login Fracassado!");
    }
    public void fazCadastro(String nome, String email, String senha){
        Cadastro cadastro = new Cadastro();
        if (cadastro.fazCadastro(nome, email, senha)) {
            System.out.println("Cadastro feito com sucesso!");
        }else System.out.println("Cadastro fracassado!");
    }
    public void fazPergunta(Usuario usuario, String perg){
        Pergunta pergunta = new Pergunta();
        pergunta.usuario = usuario;
        if (pergunta.fazPergunta(perg, usuario)) {
            System.out.println("Pergunta realizada!");
        }else System.out.println("Erro ao fazer a pergunta!");
    }
    public void respondePergunta(Usuario usuario, String resp, Pergunta pergunta){
        Resposta resposta = new Resposta();
        if (resposta.respondePergunta(usuario, pergunta, Calendar.getInstance(), resp)) {
            System.out.println("Pergunta respondida com sucesso!");
        }else System.out.println("Erro ao responder a pergunta!");
    }
    public void respondeResposta(Usuario usuario){
        System.out.println("Precisa ser conversado sobre essa funcao");
    }
}
