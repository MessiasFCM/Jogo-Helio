package controladores;

import ambiente.Terreno;
import ambiente.Celula;
import robos.Robo;
import java.util.Random;

public class ControladorRoboFTT extends Controlador {

    @Override
    public String nomeControlador() {
        return "Controlador FTT";
    }

    public String buscaMaiorQuantidadeHelio(Robo robo, Terreno terreno) {

        Random geradorAleatorio = new Random();
        double maiorQuantidadeHelio = 0;
        String lado = null;

            if(terreno.estaDentroDosLimites(robo.getPosicaoAtualX() + 1, robo.getPosicaoAtualY())) {
                Celula celula = terreno.getCelula(robo.getPosicaoAtualX() + 1, robo.getPosicaoAtualY());

                double erro = celula.getCoeficienteErroLeitura()[0] +
                        geradorAleatorio.nextDouble() * (celula.getCoeficienteErroLeitura()[1] - celula.getCoeficienteErroLeitura()[0]);

                double concentracaoComErro = robo.getMutiplicadorErro() * celula.getConcentracaoHelio() + (celula.getConcentracaoHelio() * erro);
                maiorQuantidadeHelio = concentracaoComErro;
                lado = "OESTE";
                System.out.println("Lado: OESTE:" + concentracaoComErro);
            }
            if(terreno.estaDentroDosLimites(robo.getPosicaoAtualX() - 1, robo.getPosicaoAtualY())){
                Celula celula = terreno.getCelula(robo.getPosicaoAtualX() - 1, robo.getPosicaoAtualY());

                double erro = celula.getCoeficienteErroLeitura()[0] +
                        geradorAleatorio.nextDouble() * (celula.getCoeficienteErroLeitura()[1] - celula.getCoeficienteErroLeitura()[0]);

                double concentracaoComErro = robo.getMutiplicadorErro() * celula.getConcentracaoHelio() + (celula.getConcentracaoHelio() * erro);
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

                double concentracaoComErro = robo.getMutiplicadorErro() * celula.getConcentracaoHelio() + (celula.getConcentracaoHelio() * erro);
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

                double concentracaoComErro = robo.getMutiplicadorErro() * celula.getConcentracaoHelio() + (celula.getConcentracaoHelio() * erro);
                if(maiorQuantidadeHelio < concentracaoComErro){
                    maiorQuantidadeHelio = concentracaoComErro;
                    lado = "SUL";
                }
                System.out.println("Lado: SUL: " + concentracaoComErro);
            }

        return lado;
    }

    @Override
    public void andar(Robo robo, Terreno terreno) {

        String seletorLado = buscaMaiorQuantidadeHelio(robo, terreno);

        if (seletorLado.equals("OESTE")) {
            if(robo.getDirecaoRobo().equals("NORTE")) {
                direcaoParaDireita(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else if(robo.getDirecaoRobo().equals("OESTE")) {
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else if(robo.getDirecaoRobo().equals("SUL")) {
                direcaoParaEsquerda(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else {
                direcaoParaEsquerda(robo);
                direcaoParaEsquerda(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            }
        } else if (seletorLado.equals("LESTE")) {
            if(robo.getDirecaoRobo().equals("NORTE")) {
                direcaoParaEsquerda(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else if(robo.getDirecaoRobo().equals("OESTE")) {
                direcaoParaEsquerda(robo);
                direcaoParaEsquerda(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else if(robo.getDirecaoRobo().equals("SUL")) {
                direcaoParaDireita(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else {
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            }
        } else if (seletorLado.equals("NORTE")){
            if(robo.getDirecaoRobo().equals("NORTE")) {
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else if(robo.getDirecaoRobo().equals("OESTE")) {
                direcaoParaEsquerda(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else if(robo.getDirecaoRobo().equals("SUL")) {
                direcaoParaDireita(robo);
                direcaoParaDireita(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else {
                direcaoParaDireita(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            }
        } else {
            if(robo.getDirecaoRobo().equals("NORTE")) {
                direcaoParaDireita(robo);
                direcaoParaDireita(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else if(robo.getDirecaoRobo().equals("OESTE")) {
                direcaoParaDireita(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else if(robo.getDirecaoRobo().equals("SUL")) {
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            } else {
                direcaoParaEsquerda(robo);
                andarParaFrente(robo, terreno);
                iniciarProspeccao(robo, terreno);
            }
        }
    }
}