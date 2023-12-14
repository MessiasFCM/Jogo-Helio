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
            direcaoParaDireita(robo);
            validar(robo, terreno);
        } else if (seletorLado == 1) {
            direcaoParaEsquerda(robo);
            validar(robo, terreno);
        } else {
            validar(robo, terreno);
        }
    }
}