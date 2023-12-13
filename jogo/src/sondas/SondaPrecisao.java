package sondas;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboV;

public class SondaPrecisao extends Sonda {
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