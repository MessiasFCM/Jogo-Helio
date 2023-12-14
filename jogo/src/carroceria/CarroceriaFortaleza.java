package carroceria;

import robos.Robo;
import robos.RoboFTT;

public class CarroceriaFortaleza extends Carroceria {
    public CarroceriaFortaleza(Robo robo) {
        super("Fortaleza");
        if (robo instanceof RoboFTT) {
            RoboFTT roboFTT = (RoboFTT) robo;

            // Transporta o dobro do Hélio-3
            double novaCapacidade = roboFTT.getPorcentagemCarga() * 2;
            roboFTT.setPorcentagemCarga(novaCapacidade);
        }
    }
}