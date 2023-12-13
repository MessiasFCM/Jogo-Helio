package sondas;

import ambiente.Terreno;
import robos.Robo;

public abstract class Sonda {
    protected int operacoesDeSonda;

    public Sonda() {
        this.operacoesDeSonda = 2; // Valor padrão máximo de operações
    }

    public abstract boolean aplicarEfeito(Robo robo);

    public boolean podeSondar() {
        return operacoesDeSonda > 0;
    }
}
