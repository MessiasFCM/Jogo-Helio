package sondas;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboXYZ;

public class SondaPerfuracaoRapida extends Sonda {
    public SondaPerfuracaoRapida() {
        super("Perfuração Rápida");
    }

    @Override
    public void aplicarEfeito(Robo robo) {
        if (robo instanceof RoboXYZ) {
            RoboXYZ roboXYZ = (RoboXYZ) robo;
            if (podeExtrair()) {
                // Implemente a lógica de aplicação do efeito para a SondaPerfuracaoRapida no RoboXYZ
                // ...
                operacoesDeExtracao--;
            }
        }
    }
}