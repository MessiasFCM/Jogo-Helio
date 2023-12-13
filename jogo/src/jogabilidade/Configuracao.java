package jogabilidade;

import java.util.ArrayList;

public class Configuracao {
    private int tempoPartida;
    private ArrayList<Equipe> equipes;

    // Métodos get e set + toString

    public int getTempoPartida() {
        return tempoPartida;
    }

    public void setTempoPartida(int tempoPartida) {
        this.tempoPartida = tempoPartida;
    }

    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(ArrayList<Equipe> equipes) {
        this.equipes = equipes;
    }

    @Override
    public String toString() {
        return "Configuracao{" +
                "tempoPartida=" + tempoPartida +
                ", equipes=" + equipes +
                '}';
    }
}
