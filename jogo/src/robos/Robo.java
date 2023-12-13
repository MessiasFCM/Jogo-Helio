package robos;

import carroceria.Carroceria;
import ambiente.Terreno;
import controladores.Controlador;
import funcionalidades.CalcularTempo;
import sondas.Sonda;

public abstract class Robo {
    private String nome;
    private int posicaoAtualX;
    private int posicaoAtualY;
    private double volumeHelioProspectado;
    private String direcaoRobo = "LESTE";
    private Controlador controladorUtilizado;
    private Carroceria carroceria;
    private Sonda sonda;

    public Robo(String nome, int posicaoInicialX, int posicaoInicialY) {
        this.nome = nome;
        this.volumeHelioProspectado = 0.0;
        this.posicaoAtualX = posicaoInicialX;
        this.posicaoAtualY = posicaoInicialY;
    }

    public void andarParaFrente(Terreno terreno) {
        int novaPosX = posicaoAtualX;
        int novaPosY = posicaoAtualY;

        if (direcaoRobo.equals("NORTE")) {
            novaPosY++;
        } else if (direcaoRobo.equals("SUL")) {
            novaPosY--;
        } else if (direcaoRobo.equals("LESTE")) {
            novaPosX++;
        } else if (direcaoRobo.equals("OESTE")) {
            novaPosX--;
        }

        terreno.getCelula(posicaoAtualX, posicaoAtualY).setRoboPresente(false);

        posicaoAtualX = novaPosX;
        posicaoAtualY = novaPosY;

        terreno.getCelula(posicaoAtualX, posicaoAtualY).setRoboPresente(true);
    }

    public abstract void prospeccao(Terreno terreno);

    public void direcaoParaDireita(Robo robo) {
        if (direcaoRobo.equals("NORTE")) {
            robo.setDirecaoRobo("LESTE");
        } else if (direcaoRobo.equals("LESTE")) {
            robo.setDirecaoRobo("SUL");
        } else if (direcaoRobo.equals("SUL")) {
            robo.setDirecaoRobo("OESTE");
        } else {
            robo.setDirecaoRobo("NORTE");
        }
    }

    public void direcaoParaEsquerda(Robo robo) {
        if (direcaoRobo.equals("NORTE")) {
            robo.setDirecaoRobo("OESTE");
        } else if (direcaoRobo.equals("OESTE")) {
            robo.setDirecaoRobo("SUL");
        } else if (direcaoRobo.equals("SUL")) {
            robo.setDirecaoRobo("LESTE");
        } else {
            robo.setDirecaoRobo("NORTE");
        }
    }

    public boolean movimentoValido(String direcao, Terreno terreno){
        int novaPosX = posicaoAtualX;
        int novaPosY = posicaoAtualY;

        if (direcao.equals("NORTE")) {
            novaPosY++;
        } else if (direcao.equals("SUL")) {
            novaPosY--;
        } else if (direcao.equals("LESTE")) {
            novaPosX++;
        } else if (direcao.equals("OESTE")) {
            novaPosX--;
        } else {
            return false;
        }

        if (novaPosX < 0 || novaPosX >= terreno.getLargura() || novaPosY < 0 || novaPosY >= terreno.getAltura() || terreno.getCelulas()[novaPosX][novaPosY].isRoboPresente()) {
            return false;
        }

        return true;
    };

    public void descarregarHelio() {
        if (carroceria != null) {
            carroceria.aplicarEfeito(this);
        }
        System.out.println(nome + " realizou uma operação de descarga de Hélio-3.");
        System.out.println("Carga atual: " + volumeHelioProspectado);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicaoAtualX() {
        return posicaoAtualX;
    }

    public void setPosicaoAtualX(int posicaoAtualX) {
        this.posicaoAtualX = posicaoAtualX;
    }

    public int getPosicaoAtualY() {
        return posicaoAtualY;
    }

    public void setPosicaoAtualY(int posicaoAtualY) {
        this.posicaoAtualY = posicaoAtualY;
    }

    public double getVolumeHelioProspectado() {
        return volumeHelioProspectado;
    }

    public void setVolumeHelioProspectado(double volumeHelioProspectado) {
        this.volumeHelioProspectado = volumeHelioProspectado;
    }

    public String getDirecaoRobo() {
        return direcaoRobo;
    }

    public void setDirecaoRobo(String direcaoRobo) {
        this.direcaoRobo = direcaoRobo;
    }

    public Controlador getControladorUtilizado() {
        return controladorUtilizado;
    }

    public void setControladorUtilizado(Controlador controladorUtilizado) {
        this.controladorUtilizado = controladorUtilizado;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(Carroceria carroceria) {
        this.carroceria = carroceria;
    }

    public Sonda getSonda() {
        return sonda;
    }

    public void setSonda(Sonda sonda) {
        this.sonda = sonda;
    }

    @Override
    public String toString() {
        return "Robo{" +
                "nome='" + nome + '\'' +
                ", posicaoAtualX=" + posicaoAtualX +
                ", posicaoAtualY=" + posicaoAtualY +
                ", volumeHelioProspectado=" + volumeHelioProspectado +
                ", direcaoRobo='" + direcaoRobo + '\'' +
                ", controladorUtilizado=" + controladorUtilizado +
                ", carroceria=" + carroceria +
                ", sonda=" + sonda +
                '}';
    }
}