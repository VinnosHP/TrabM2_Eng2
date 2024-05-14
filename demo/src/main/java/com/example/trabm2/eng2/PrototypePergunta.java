package com.example.trabm2.eng2;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class PrototypePergunta {
    protected String id;
    protected String pergunta;
    protected ArrayList<Resposta> listaRespostas;
    protected Calendar data;
    protected Usuario usuario;

    protected PrototypePergunta() {
        this.pergunta = "";
        this.listaRespostas = null;
        this.data = null;
        this.usuario = null;
        this.id = null;
    }

    protected PrototypePergunta(PrototypePergunta prototypePergunta){
        if (prototypePergunta != null){
            this.pergunta = prototypePergunta.pergunta;
            this.listaRespostas = prototypePergunta.listaRespostas;
            this.data = prototypePergunta.data;
            this.usuario = prototypePergunta.usuario;
            this.id = prototypePergunta.id;
        }
    }

    protected String getPergunta() {
        return pergunta;
    }

    protected void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    protected ArrayList<Resposta> getListaRespostas() {
        return listaRespostas;
    }

    protected void setListaRespostas(ArrayList<Resposta> listaRespostas) {
        this.listaRespostas = listaRespostas;
    }

    protected Calendar getData() {
        return data;
    }

    protected void setData(Calendar data) {
        this.data = data;
    }

    protected Usuario getUsuario() {
        return usuario;
    }

    protected void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    protected String id(){
        return id;
    }

    protected void setId(String id){
        this.id = id;
    }

    protected abstract PrototypePergunta clone();
}
