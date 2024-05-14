package com.example.trabm2.eng2.models;

public class Cadastro {
    private Usuario usuario;

    public Cadastro(){
        this.usuario = null;
    }

    public Cadastro(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean verificaDadosExistentes(){
        return false;
    }

    public boolean fazCadastro(){
        return !verificaDadosExistentes();
    }
}
