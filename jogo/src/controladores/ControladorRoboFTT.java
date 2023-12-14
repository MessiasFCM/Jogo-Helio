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