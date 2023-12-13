package controladores;

import ambiente.Terreno;
import robos.Robo;
import java.util.Random;

public class ControladorRoboXYZ extends Controlador {
    @Override
    public String nomeControlador() {
        return "Controlador XYZ";
    }

    @Override
    public void andar(Robo robo, Terreno terreno) {

        Random geradorAleatorio = new Random();
        int seletorLado = geradorAleatorio.nextInt(3);

        if (seletorLado == 0) {
            robo.direcaoParaDireita(robo);
            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
                robo.andarParaFrente(terreno);
                iniciarProspeccao(robo, terreno);
            } else {
                andar(robo, terreno);
            }
        } else if (seletorLado == 1) {
            robo.direcaoParaEsquerda(robo);
            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
                robo.andarParaFrente(terreno);
                iniciarProspeccao(robo, terreno);
            } else {
                andar(robo, terreno);
            }
        } else {
            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
                robo.andarParaFrente(terreno);
                iniciarProspeccao(robo, terreno);
            } else {
                andar(robo, terreno);
            }
        }
    }
}