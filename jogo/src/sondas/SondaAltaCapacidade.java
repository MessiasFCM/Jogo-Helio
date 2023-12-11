package sondas;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboFTT;

public class SondaAltaCapacidade extends Sonda {
    public SondaAltaCapacidade() {
        super("Alta Capacidade");
    }

    @Override
    public void aplicarEfeito(Robo robo) {
        if (robo instanceof RoboFTT) {
            RoboFTT roboFTT = (RoboFTT) robo;
            if (podeExtrair()) {
                // Implemente a lógica de aplicação do efeito para a SondaAltaCapacidade no RoboFTT
                // ...
                operacoesDeExtracao--;
            }
        }
    }
}