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
    private double velocidadeExtracao = 1.0; // Velocidade de extração do robô, onde 1.0 representa 100% (padrão).
    private double agilidadeNaMovimentacao = 1.0; // Agilidade na movimentação do robô, onde 1.0 representa 100% (padrão).
    private double porcentagemCarga = 1.0; // Porcentagem de carga do robô, onde 1.0 representa 100% (padrão).
    private double mutiplicadorErro = 1.0; // Multiplicador de erro do robô, onde 1.0 representa 100% (padrão).


    public Robo(String nome, int posicaoInicialX, int posicaoInicialY) {
        this.nome = nome;
        this.volumeHelioProspectado = 0.0;
        this.posicaoAtualX = posicaoInicialX;
        this.posicaoAtualY = posicaoInicialY;
    }

    public void andarParaFrente(Terreno terreno) {
        int novaPosX = getPosicaoAtualX();
        int novaPosY = getPosicaoAtualY();

        if (getDirecaoRobo().equals("NORTE")) { novaPosY++; }
        else if (getDirecaoRobo().equals("SUL")) { novaPosY--; }
        else if (getDirecaoRobo().equals("LESTE")) { novaPosX++; }
        else if (getDirecaoRobo().equals("OESTE")) { novaPosX--; }

        terreno.getCelula(getPosicaoAtualX(), getPosicaoAtualY()).setRoboPresente(false);

        setPosicaoAtualX(novaPosX);
        setPosicaoAtualY(novaPosY);

        terreno.getCelula(getPosicaoAtualX(), getPosicaoAtualY()).setRoboPresente(true);
    }

    public void prospeccao(Terreno terreno){
        Celula celulaAtual = terreno.getCelula(getPosicaoAtualX(), getPosicaoAtualY());
        double concentracao = celulaAtual.getConcentracaoHelio();
        double volumeProspectado = celulaAtual.getConcentracaoHelio();

        volumeHelioProspectado += volumeProspectado;

        celulaAtual.setConcentracaoHelio(0);

        int segundos = (int) (10 * concentracao);
        CalcularTempo.sleep(segundos);
    }

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

        if (direcao.equals("NORTE")) { novaPosY++; }
        else if (direcao.equals("SUL")) { novaPosY--; }
        else if (direcao.equals("LESTE")) { novaPosX++; }
        else if (direcao.equals("OESTE")) { novaPosX--; }
        else { return false; }

        if (posicaoForaDosLimites(novaPosX, novaPosY, terreno) || terreno.getCelulas()[novaPosX][novaPosY].isRoboPresente()) {
            return false;
        }else{
            return true;
        }
    }

    private boolean posicaoForaDosLimites(int x, int y, Terreno terreno) {
        return x < 0 || x >= terreno.getLargura() || y < 0 || y >= terreno.getAltura();
    }

    public void descarregarHelio() {
        if (carroceria != null) {
            carroceria.aplicarEfeito(this);
        }
        System.out.println(nome + " realizou uma operação de descarga de Hélio-3.");
        System.out.println("Carga atual: " + volumeHelioProspectado);
    }

    // Métodos get e set + toString

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

    public double getVelocidadeExtracao() {
        return velocidadeExtracao;
    }

    public void setVelocidadeExtracao(double velocidadeExtracao) {
        this.velocidadeExtracao = velocidadeExtracao;
    }

    public double getAgilidadeNaMovimentacao() {
        return agilidadeNaMovimentacao;
    }

    public void setAgilidadeNaMovimentacao(double agilidadeNaMovimentacao) {
        this.agilidadeNaMovimentacao = agilidadeNaMovimentacao;
    }

    public double getPorcentagemCarga() {
        return porcentagemCarga;
    }

    public void setPorcentagemCarga(double porcentagemCarga) {
        this.porcentagemCarga = porcentagemCarga;
    }

    public double getMutiplicadorErro() {
        return mutiplicadorErro;
    }

    public void setMutiplicadorErro(double mutiplicadorErro) {
        this.mutiplicadorErro = mutiplicadorErro;
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
                ", velocidadeExtracao=" + velocidadeExtracao +
                ", agilidadeNaMovimentacao=" + agilidadeNaMovimentacao +
                ", porcentagemCarga=" + porcentagemCarga +
                ", mutiplicadorErro=" + mutiplicadorErro +
                '}';
    }
}