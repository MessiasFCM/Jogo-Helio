package sondas;

import ambiente.Celula;
import ambiente.Terreno;
import robos.Robo;

import java.util.Random;

public class Sonda {
    protected String nome;
    public Sonda(String nome) {
        this.nome = nome;
    }

    public double calculoHelioDisponivel(Robo robo, Terreno terreno) {
        Celula celulaAtual = terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
        double[] coeficientesErro = celulaAtual.getCoeficienteErroLeitura();
        double erro = coeficientesErro[0] + new Random().nextDouble() * (coeficientesErro[1] - coeficientesErro[0]);
        double concentracao = celulaAtual.getConcentracaoHelio();
        return robo.getErroPrecisaoLeitura() * concentracao + (concentracao * erro);
    }
    public boolean movimentoValido(Robo robo, String direcao, Terreno terreno){
        int novaPosX = robo.getPosicaoAtualX();
        int novaPosY = robo.getPosicaoAtualY();

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

    private boolean posicaoForaDosLimites(int posicaoX, int posicaoY, Terreno terreno) {
        return posicaoX < 0 || posicaoX >= terreno.getLargura() || posicaoY < 0 || posicaoY >= terreno.getAltura();
    }

    public String buscaMaiorQuantidadeHelio(Robo robo, Terreno terreno) {

        Random geradorAleatorio = new Random();
        double maiorQuantidadeHelio = 0;
        String lado = null;

        if(terreno.estaDentroDosLimites(robo.getPosicaoAtualX() + 1, robo.getPosicaoAtualY())) {
            Celula celula = terreno.getCelula(robo.getPosicaoAtualX() + 1, robo.getPosicaoAtualY());

            double erro = celula.getCoeficienteErroLeitura()[0] +
                    geradorAleatorio.nextDouble() * (celula.getCoeficienteErroLeitura()[1] - celula.getCoeficienteErroLeitura()[0]);

            double concentracaoComErro = robo.getErroPrecisaoLeitura() * celula.getConcentracaoHelio() + (celula.getConcentracaoHelio() * erro);
            maiorQuantidadeHelio = concentracaoComErro;
            lado = "OESTE";
        }
        if(terreno.estaDentroDosLimites(robo.getPosicaoAtualX() - 1, robo.getPosicaoAtualY())){
            Celula celula = terreno.getCelula(robo.getPosicaoAtualX() - 1, robo.getPosicaoAtualY());

            double erro = celula.getCoeficienteErroLeitura()[0] +
                    geradorAleatorio.nextDouble() * (celula.getCoeficienteErroLeitura()[1] - celula.getCoeficienteErroLeitura()[0]);

            double concentracaoComErro = robo.getErroPrecisaoLeitura() * celula.getConcentracaoHelio() + (celula.getConcentracaoHelio() * erro);
            if(maiorQuantidadeHelio < concentracaoComErro){
                maiorQuantidadeHelio = concentracaoComErro;
                lado = "LESTE";
            }
        }
        if(terreno.estaDentroDosLimites(robo.getPosicaoAtualX(), robo.getPosicaoAtualY() + 1)){
            Celula celula = terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY() + 1);

            double erro = celula.getCoeficienteErroLeitura()[0] +
                    geradorAleatorio.nextDouble() * (celula.getCoeficienteErroLeitura()[1] - celula.getCoeficienteErroLeitura()[0]);

            double concentracaoComErro = robo.getErroPrecisaoLeitura() * celula.getConcentracaoHelio() + (celula.getConcentracaoHelio() * erro);
            if(maiorQuantidadeHelio < concentracaoComErro){
                maiorQuantidadeHelio = concentracaoComErro;
                lado = "NORTE";
            }
        }
        if(terreno.estaDentroDosLimites(robo.getPosicaoAtualX(), robo.getPosicaoAtualY() - 1)){
            Celula celula = terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY() - 1);

            double erro = celula.getCoeficienteErroLeitura()[0] +
                    geradorAleatorio.nextDouble() * (celula.getCoeficienteErroLeitura()[1] - celula.getCoeficienteErroLeitura()[0]);

            double concentracaoComErro = robo.getErroPrecisaoLeitura() * celula.getConcentracaoHelio() + (celula.getConcentracaoHelio() * erro);
            if(maiorQuantidadeHelio < concentracaoComErro){
                maiorQuantidadeHelio = concentracaoComErro;
                lado = "SUL";
            }
        }

        return lado;
    }

    public void verificarExecucoes(Robo robo){}

    // Métodos get e set + toString

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Sonda{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
