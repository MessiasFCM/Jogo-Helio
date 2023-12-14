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

        String seletorLado = robo.getSonda().buscaMaiorQuantidadeHelio(robo, terreno);

        if(seletorLado.equals("NULL")){
            return;
        }

        if (seletorLado.equals("OESTE")) {
            if(robo.getDirecaoRobo().equals("NORTE")) {
                direcaoParaDireita(robo);
                validar(robo,terreno);
            } else if(robo.getDirecaoRobo().equals("OESTE")) {
                validar(robo,terreno);
            } else if(robo.getDirecaoRobo().equals("SUL")) {
                direcaoParaEsquerda(robo);
                validar(robo,terreno);
            } else {
                direcaoParaEsquerda(robo);
                direcaoParaEsquerda(robo);
                validar(robo,terreno);
            }
        } else if (seletorLado.equals("LESTE")) {
            if(robo.getDirecaoRobo().equals("NORTE")) {
                direcaoParaEsquerda(robo);
                validar(robo,terreno);
            } else if(robo.getDirecaoRobo().equals("OESTE")) {
                direcaoParaEsquerda(robo);
                direcaoParaEsquerda(robo);
                validar(robo,terreno);
            } else if(robo.getDirecaoRobo().equals("SUL")) {
                direcaoParaDireita(robo);
                validar(robo,terreno);
            } else {
                validar(robo,terreno);
            }
        } else if (seletorLado.equals("NORTE")){
            if(robo.getDirecaoRobo().equals("NORTE")) {
                validar(robo,terreno);
            } else if(robo.getDirecaoRobo().equals("OESTE")) {
                direcaoParaEsquerda(robo);
                validar(robo,terreno);
            } else if(robo.getDirecaoRobo().equals("SUL")) {
                direcaoParaDireita(robo);
                direcaoParaDireita(robo);
                validar(robo,terreno);
            } else {
                direcaoParaDireita(robo);
                validar(robo,terreno);
            }
        } else {
            if(robo.getDirecaoRobo().equals("NORTE")) {
                direcaoParaDireita(robo);
                direcaoParaDireita(robo);
                validar(robo,terreno);
            } else if(robo.getDirecaoRobo().equals("OESTE")) {
                direcaoParaDireita(robo);
                validar(robo,terreno);
            } else if(robo.getDirecaoRobo().equals("SUL")) {
                validar(robo,terreno);
            } else {
                direcaoParaEsquerda(robo);
                validar(robo,terreno);
            }
        }
    }
}