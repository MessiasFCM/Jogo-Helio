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
    private double volumeHelioProspectadoTotal;
    private double volumeHelioProspectado;
    private String direcaoRobo = "LESTE";
    private Controlador controladorUtilizado;
    private Carroceria carroceria;
    private Sonda sonda;
    private double velocidadeExtracao = 1.0; // Velocidade de extração do robô, onde 1.0 representa 100% (padrão).
    private double agilidadeNaMovimentacao = 1.0; // Agilidade na movimentação do robô, onde 1.0 representa 100% (padrão).
    private double porcentagemCarga = 1.0; // Porcentagem de carga do robô, onde 1.0 representa 100% (padrão).
    private double tempoDescarga = 1.0; // Tempo de descarga do robô, onde 1.0 representa 100% (padrão).
    private double erroPrecisaoLeitura = 1.0; // Multiplicador de erro do robô, onde 1.0 representa 100% (padrão).


    public Robo(String nome, int posicaoInicialX, int posicaoInicialY) {
        this.nome = nome;
        this.volumeHelioProspectado = 0.0;
        this.posicaoAtualX = posicaoInicialX;
        this.posicaoAtualY = posicaoInicialY;
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

    public double getVolumeHelioProspectadoTotal() {
        return volumeHelioProspectadoTotal;
    }

    public void setVolumeHelioProspectadoTotal(double volumeHelioProspectadoTotal) {
        this.volumeHelioProspectadoTotal = volumeHelioProspectadoTotal;
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

    public double getTempoDescarga() {
        return tempoDescarga;
    }

    public void setTempoDescarga(double tempoDescarga) {
        this.tempoDescarga = tempoDescarga;
    }

    public double getErroPrecisaoLeitura() {
        return erroPrecisaoLeitura;
    }

    public void setErroPrecisaoLeitura(double erroPrecisaoLeitura) {
        this.erroPrecisaoLeitura = erroPrecisaoLeitura;
    }

    @Override
    public String toString() {
        return "Robo{" +
                "nome='" + nome + '\'' +
                ", posicaoAtualX=" + posicaoAtualX +
                ", posicaoAtualY=" + posicaoAtualY +
                ", volumeHelioProspectadoTotal=" + volumeHelioProspectadoTotal +
                ", volumeHelioProspectado=" + volumeHelioProspectado +
                ", direcaoRobo='" + direcaoRobo + '\'' +
                ", controladorUtilizado=" + controladorUtilizado +
                ", carroceria=" + carroceria +
                ", sonda=" + sonda +
                ", velocidadeExtracao=" + velocidadeExtracao +
                ", agilidadeNaMovimentacao=" + agilidadeNaMovimentacao +
                ", porcentagemCarga=" + porcentagemCarga +
                ", tempoDescarga=" + tempoDescarga +
                ", erroPrecisaoLeitura=" + erroPrecisaoLeitura +
                '}';
    }
}