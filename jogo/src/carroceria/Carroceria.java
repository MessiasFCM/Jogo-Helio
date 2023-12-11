package carroceria;

import robos.Robo;

public abstract class Carroceria {
    protected String nome;

    public Carroceria(String nome) {
        this.nome = nome;
    }

    public abstract void aplicarEfeito(Robo robo);
}