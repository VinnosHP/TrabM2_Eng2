package com.example.trabm2.eng2;

public class Login {
    private Usuario usuario;

    public Login(){
        this.usuario = null;
    }

    public Login(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public boolean verificaDados(){
        return false;
    }

    public boolean fazLogin(){
        return verificaDados();
    }
}
