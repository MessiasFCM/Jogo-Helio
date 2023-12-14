package carroceria;

import robos.Robo;
import robos.RoboXYZ;

public class CarroceriaTurbo extends Carroceria {
    private double novaVelocidade;
    private double novoTempoDescarga;
    public CarroceriaTurbo() {
        super("Turbo");
    }
    @Override
    public void aplicarEfeito(Robo robo) {
        if (robo instanceof RoboXYZ) {
            RoboXYZ roboXYZ = (RoboXYZ) robo;
            double novaVelocidade = roboXYZ.getVelocidadeExtracao() * 1.2;
            roboXYZ.setVelocidadeExtracao(novaVelocidade);
            // double novoTempoDescarga = roboXYZ
        }
    }
}
