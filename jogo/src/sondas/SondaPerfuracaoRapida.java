package sondas;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboXYZ;

// Sonda do robô XYZ

public class SondaPerfuracaoRapida extends Sonda {
    @Override
    public boolean aplicarEfeito(Robo robo) {
        if (podeSondar()) {
            operacoesDeSonda--;
            return true;
        }else{
            return false;
        }
    }
}