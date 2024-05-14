package com.example.trabm2.eng2.models;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class PrototypePergunta {
    public String id;
    public String pergunta;
    public ArrayList<Resposta> listaRespostas;
    public Calendar data;
    public Usuario usuario;

    public PrototypePergunta(){}

    public PrototypePergunta(PrototypePergunta prototypePergunta){
        if (prototypePergunta != null){
            this.pergunta = prototypePergunta.pergunta;
            this.listaRespostas = prototypePergunta.listaRespostas;
            this.data = prototypePergunta.data;
            this.usuario = prototypePergunta.usuario;
            this.id = prototypePergunta.id;
        }
    }

    public abstract PrototypePergunta clone();

    /*public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public ArrayList<Resposta> getListaRespostas() {
        return listaRespostas;
    }

    public void setListaRespostas(ArrayList<Resposta> listaRespostas) {
        this.listaRespostas = listaRespostas;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String id(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }*/
}
