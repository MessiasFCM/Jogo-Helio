package jogabilidade;

import robos.Robo;

import java.util.ArrayList;

public class Equipe {
    private String nome;
    private ArrayList<Robo> robos;
    private int quantidadeRobos;
    private String tipoRobo;
    private String controladorRobo;

    public Equipe(String nome, int quantidadeRobos, String tipoRobo, String controladorRobo) {
        this.nome = nome;
        this.quantidadeRobos = quantidadeRobos;
        this.tipoRobo = tipoRobo;
        this.controladorRobo = controladorRobo;
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

    public int getQuantidadeRobos() {
        return quantidadeRobos;
    }

    public void setQuantidadeRobos(int quantidadeRobos) {
        this.quantidadeRobos = quantidadeRobos;
    }

    public String getTipoRobo() {
        return tipoRobo;
    }

    public void setTipoRobo(String tipoRobo) {
        this.tipoRobo = tipoRobo;
    }

    public String getControladorRobo() {
        return controladorRobo;
    }

    public void setControladorRobo(String controladorRobo) {
        this.controladorRobo = controladorRobo;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "nome='" + nome + '\'' +
                ", robos=" + robos +
                ", quantidadeRobos=" + quantidadeRobos +
                ", tipoRobo='" + tipoRobo + '\'' +
                ", controladorRobo='" + controladorRobo + '\'' +
                '}';
    }
}
