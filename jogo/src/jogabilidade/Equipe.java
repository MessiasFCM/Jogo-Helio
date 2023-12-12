package jogabilidade;

import robos.Robo;

import java.util.ArrayList;

public class Equipe {
    private String nome;
    private ArrayList<Robo> robos;
    private ArrayList<String> tipoRobos;

    public Equipe(String nome, ArrayList<String> tipos) {
        this.nome = nome;
        this.tipoRobos = tipos;
        this.robos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Robo> getRobos() {
        return robos;
    }

    public void setRobos(ArrayList<Robo> robos) {
        this.robos = robos;
    }
    public ArrayList<String> getTipoRobos() {
        return tipoRobos;
    }

    public void setTipoRobos(ArrayList<String> tipoRobos) {
        this.tipoRobos = tipoRobos;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "nome='" + nome + '\'' +
                ", robos=" + robos +
                ", tipos=" + tipoRobos +
                '}';
    }
}
