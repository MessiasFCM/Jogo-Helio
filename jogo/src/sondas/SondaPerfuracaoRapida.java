package sondas;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboXYZ;

public class SondaPerfuracaoRapida extends Sonda {
    private static int contadorExecucoes = 0;
    public SondaPerfuracaoRapida(Robo robo) {
        super("Perfuração Rápida");
        if (contadorExecucoes < 2 && robo instanceof RoboXYZ) {
            RoboXYZ roboXYZ = (RoboXYZ) robo;

            // 50% mais rápido na velocidade de extração
            double novaVelocidade = roboXYZ.getVelocidadeExtracao() * 0.5;
            roboXYZ.setVelocidadeExtracao(novaVelocidade);

            contadorExecucoes++;
        }
    }
}