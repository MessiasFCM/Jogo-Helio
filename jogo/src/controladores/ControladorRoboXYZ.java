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

        System.out.printf("Meio do caminho %d", seletorLado);
        if (seletorLado == 0) {
            robo.direcaoParaDireita(robo);
            System.out.printf("Meio do caminho -- 1 %s", robo.getDirecaoRobo());
            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
                robo.andarParaFrente(terreno);
                iniciarProspeccao(robo, terreno);
                System.out.println("Meio do caminho -- 11");
            } else {
                andar(robo, terreno);
            }
        } else if (seletorLado == 1) {
            robo.direcaoParaEsquerda(robo);
            System.out.printf("Meio do caminho -- 2 %s", robo.getDirecaoRobo());
            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
                robo.andarParaFrente(terreno);
                iniciarProspeccao(robo, terreno);
                System.out.println("Meio do caminho -- 22");
            } else {
                andar(robo, terreno);
            }
        } else {
            System.out.printf("Meio do caminho -- 3 %s", robo.getDirecaoRobo());
            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
                robo.andarParaFrente(terreno);
                iniciarProspeccao(robo, terreno);
                System.out.println("Meio do caminho -- 33");
            } else {
                andar(robo, terreno);
            }
        }
    }
}