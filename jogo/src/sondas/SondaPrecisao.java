package sondas;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboV;

public class SondaPrecisao extends Sonda {
    public SondaPrecisao() {
        super("Precisão");
    }

    @Override
    public void aplicarEfeito(Robo robo) {
        if (robo instanceof RoboV) {
            RoboV roboV = (RoboV) robo;
            if (podeExtrair()) {
                // Implemente a lógica de aplicação do efeito para a SondaPrecisao no RoboV
                // ...
                operacoesDeExtracao--;
            }
        }
    }
}