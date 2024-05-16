package models;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Pergunta> listaPerguntas;
    private ArrayList<Resposta> listaRespostas;

    public Usuario(){
        this.nome = "";
        this.email = "";
        this.senha = "";
        this.listaPerguntas = null;
        this.listaRespostas = null;
    }

    public Usuario(String nome, String email, String senha, ArrayList<Pergunta> listaPerguntas, ArrayList<Resposta> listaRespostas) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.listaPerguntas = listaPerguntas;
        this.listaRespostas = listaRespostas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Pergunta> getListaPerguntas() {
        return listaPerguntas;
    }

    public void setListaPerguntas(ArrayList<Pergunta> listaPerguntas) {
        this.listaPerguntas = listaPerguntas;
    }

    public ArrayList<Resposta> getListaRespostas() {
        return listaRespostas;
    }

    public void setListaRespostas(ArrayList<Resposta> listaRespostas) {
        this.listaRespostas = listaRespostas;
    }
}
