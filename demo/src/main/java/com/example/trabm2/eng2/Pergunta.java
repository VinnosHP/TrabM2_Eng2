package com.example.trabm2.eng2;

public class Pergunta extends PrototypePergunta{
    public Pergunta(){}

    public Pergunta(Pergunta pergunta){
        super(pergunta);
    }

    public boolean fazPergunta(String pergunta, Usuario usuario){
        return false;
    }

    @Override
    public PrototypePergunta clone() {
        return new Pergunta(this);
    }
}
