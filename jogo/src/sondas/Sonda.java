package sondas;

import ambiente.Terreno;
import robos.Robo;

public abstract class Sonda {
    protected String nome;
    protected int operacoesDeExtracao;

    public Sonda(String nome) {
        this.nome = nome;
        this.operacoesDeExtracao = 2; // Valor padrão máximo de operações
    }

    public abstract void aplicarEfeito(Robo robo);

    public boolean podeExtrair() {
        return operacoesDeExtracao > 0;
    }
}
