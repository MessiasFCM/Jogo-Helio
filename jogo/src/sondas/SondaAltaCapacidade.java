package sondas;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboFTT;

public class SondaAltaCapacidade extends Sonda {

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