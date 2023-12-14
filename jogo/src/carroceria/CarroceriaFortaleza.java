package carroceria;

import robos.Robo;
import robos.RoboFTT;

public class CarroceriaFortaleza extends Carroceria {
    private double novaCapacidade;
    public CarroceriaFortaleza() {
        super("Fortaleza");
    }

    @Override
    public void aplicarEfeito(Robo robo) {
        if (robo instanceof RoboFTT) {
            RoboFTT roboFTT = (RoboFTT) robo;
            double novaCapacidade = roboFTT.getCapacidadeCarga() * 2;
            roboFTT.setCapacidadeCarga();
        }
    }
}