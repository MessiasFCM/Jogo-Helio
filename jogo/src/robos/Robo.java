package robos;

import carroceria.Carroceria;
import ambiente.Terreno;
import ambiente.Celula;
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
        int novaPosX = getPosicaoAtualX();
        int novaPosY = getPosicaoAtualY();

        if (getDirecaoRobo().equals("NORTE")) {
            novaPosY++;
        } else if (getDirecaoRobo().equals("SUL")) {
            novaPosY--;
        } else if (getDirecaoRobo().equals("LESTE")) {
            novaPosX++;
        } else if (getDirecaoRobo().equals("OESTE")) {
            novaPosX--;
        }

        terreno.getCelula(getPosicaoAtualX(), getPosicaoAtualY()).setRoboPresente(false);

        setPosicaoAtualX(novaPosX);
        setPosicaoAtualY(novaPosY);

        terreno.getCelula(getPosicaoAtualX(), getPosicaoAtualY()).setRoboPresente(true);
    }

    public void prospeccao(Terreno terreno){
        Celula celulaAtual = terreno.getCelula(getPosicaoAtualX(), getPosicaoAtualY());
        //int atualX = posicaoAtualX;
        //int atualY = posicaoAtualY;

        double concentracao = celulaAtual.getConcentracaoHelio();
        double volumeProspectado = celulaAtual.getConcentracaoHelio();

        volumeHelioProspectado += volumeProspectado;

        celulaAtual.setConcentracaoHelio(0);

        int segundos = (int) (10 * concentracao);
        CalcularTempo.sleep(segundos);
    };

    public void direcaoParaDireita(Robo robo) {
        if (getDirecaoRobo().equals("NORTE")) {
            robo.setDirecaoRobo("LESTE");
        } else if (getDirecaoRobo().equals("LESTE")) {
            robo.setDirecaoRobo("SUL");
        } else if (getDirecaoRobo().equals("SUL")) {
            robo.setDirecaoRobo("OESTE");
        } else {
            robo.setDirecaoRobo("NORTE");
        }
    }

    public void direcaoParaEsquerda(Robo robo) {
        if (getDirecaoRobo().equals("NORTE")) {
            robo.setDirecaoRobo("OESTE");
        } else if (getDirecaoRobo().equals("OESTE")) {
            robo.setDirecaoRobo("SUL");
        } else if (getDirecaoRobo().equals("SUL")) {
            robo.setDirecaoRobo("LESTE");
        } else {
            robo.setDirecaoRobo("NORTE");
        }
    }

    public boolean movimentoValido(String direcao, Terreno terreno){
        int novaPosX = getPosicaoAtualX();
        int novaPosY = getPosicaoAtualY();
        System.out.printf("Chegou aqui : %s", direcao);

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