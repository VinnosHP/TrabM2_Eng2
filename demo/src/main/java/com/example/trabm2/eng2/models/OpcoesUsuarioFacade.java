package com.example.trabm2.eng2.models;

public class OpcoesUsuarioFacade {
    public void fazLogin(Usuario usuario){
        Login login = new Login(usuario);
        boolean fezLogin = login.fazLogin();
    }
    public void fazCadastro(Usuario usuario){
        Cadastro cadastro = new Cadastro(usuario);
        boolean novoCadastro = cadastro.fazCadastro();
    }
    public void fazPergunta(Usuario usuario){
        Pergunta pergunta = new Pergunta();
        pergunta.usuario = usuario;
        String texto = "";
        boolean fezPergunta = pergunta.fazPergunta(texto, usuario);
    }
    public void respondePergunta(Usuario usuario){
        Resposta resposta = new Resposta();
        resposta.setUsuario(usuario);
        String texto = "";
        boolean respondeuPergunta = resposta.respondePergunta();
    }
    public void respondeResposta(Usuario usuario){
        Resposta resposta = new Resposta();
        resposta.setUsuario(usuario);
        String texto = "";
        boolean respondeuResposta = resposta.respondeResposta();
    }
}
