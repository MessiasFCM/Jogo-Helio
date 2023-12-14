package controladores;

import ambiente.Celula;
import ambiente.Terreno;
import funcionalidades.CalcularTempo;
import robos.Robo;
import java.util.Random;

public abstract class Controlador {
    public abstract String nomeControlador();
    public abstract void andar(Robo robo, Terreno terreno);

    public void iniciarProspeccao(Robo robo, Terreno terreno){
        robo.getCarroceria().prospeccao(robo, terreno);
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
            System.out.println("Lado: OESTE:" + concentracaoComErro);
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
            System.out.println("Lado: LESTE: " + concentracaoComErro);
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
            System.out.println("Lado: NORTE: " + concentracaoComErro);
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
            System.out.println("Lado: SUL: " + concentracaoComErro);
        }

        return lado;
    }

    private boolean posicaoForaDosLimites(int posicaoX, int posicaoY, Terreno terreno) {
        return posicaoX < 0 || posicaoX >= terreno.getLargura() || posicaoY < 0 || posicaoY >= terreno.getAltura();
    }
}