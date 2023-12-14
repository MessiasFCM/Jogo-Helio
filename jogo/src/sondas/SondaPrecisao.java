package sondas;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboV;

public class SondaPrecisao extends Sonda {
    private static int contadorExecucoes = 0;
    public SondaPrecisao(Robo robo) {
        super("Precisão");
        if (contadorExecucoes < 2 && robo instanceof RoboV) {
            RoboV roboV = (RoboV) robo;

            // Sem erros na leitura
            roboV.setErroPrecisaoLeitura(1);

            contadorExecucoes++;
        }
    }
}