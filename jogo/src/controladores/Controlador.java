package controladores;

import ambiente.Terreno;
import funcionalidades.CalcularTempo;
import robos.Robo;
import java.util.Random;

public abstract class Controlador {
    public abstract String nomeControlador();
    public abstract void andar(Robo robo, Terreno terreno);

    public void iniciarProspeccao(Robo robo, Terreno terreno){
        robo.prospeccao((terreno));
    }

    public double sensorHelioDisponivel(Robo robo, Terreno terreno) {
        Random geradorAleatorio = new Random();
        double erro = terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getCoeficienteErroLeitura()[0] + geradorAleatorio.nextDouble() * (terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getCoeficienteErroLeitura()[1] - terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getCoeficienteErroLeitura()[0]);
        double concentracaoComErro = robo.getMutiplicadorErro() * terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getConcentracaoHelio() + (terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getConcentracaoHelio() * erro);
        return concentracaoComErro;
    }
    public void andarParaFrente(Robo robo, Terreno terreno) {
        int novaPosX = robo.getPosicaoAtualX();
        int novaPosY = robo.getPosicaoAtualY();

        if (robo.getDirecaoRobo().equals("NORTE")) { novaPosY++; }
        else if (robo.getDirecaoRobo().equals("SUL")) { novaPosY--; }
        else if (robo.getDirecaoRobo().equals("LESTE")) { novaPosX++; }
        else if (robo.getDirecaoRobo().equals("OESTE")) { novaPosX--; }

        terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).setRoboPresente(false);

        robo.setPosicaoAtualX(novaPosX);
        robo.setPosicaoAtualY(novaPosY);

        terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).setRoboPresente(true);

        double rugosidade = terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getRugosidade();

        int segundos = (int) ((10 * rugosidade) * robo.getAgilidadeNaMovimentacao());
        CalcularTempo.sleep(segundos);
    }
    public void direcaoParaDireita(Robo robo) {
        if (robo.getDirecaoRobo().equals("NORTE")) {
            robo.setDirecaoRobo("LESTE");
        } else if (robo.getDirecaoRobo().equals("LESTE")) {
            robo.setDirecaoRobo("SUL");
        } else if (robo.getDirecaoRobo().equals("SUL")) {
            robo.setDirecaoRobo("OESTE");
        } else {
            robo.setDirecaoRobo("NORTE");
        }
    }

    public void direcaoParaEsquerda(Robo robo) {
        if (robo.getDirecaoRobo().equals("NORTE")) {
            robo.setDirecaoRobo("OESTE");
        } else if (robo.getDirecaoRobo().equals("OESTE")) {
            robo.setDirecaoRobo("SUL");
        } else if (robo.getDirecaoRobo().equals("SUL")) {
            robo.setDirecaoRobo("LESTE");
        } else {
            robo.setDirecaoRobo("NORTE");
        }
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
}