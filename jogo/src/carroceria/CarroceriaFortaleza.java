package carroceria;

import robos.Robo;
import robos.RoboFTT;

public class CarroceriaFortaleza extends Carroceria {
    public CarroceriaFortaleza() {
        super("Fortaleza");
    }

    @Override
    public void aplicarEfeito(Robo robo) {
        if (robo instanceof RoboFTT) {
            RoboFTT roboFTT = (RoboFTT) robo;
            // Implemente a lógica de aplicação do efeito para a CarroceriaFortaleza no RoboFTT
            // ...
        }
    }
}