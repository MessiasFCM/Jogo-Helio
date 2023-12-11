package carroceria;

import robos.Robo;
import robos.RoboXYZ;

public class CarroceriaTurbo extends Carroceria {
    public CarroceriaTurbo() {
        super("Turbo");
    }

    @Override
    public void aplicarEfeito(Robo robo) {
        if (robo instanceof RoboXYZ) {
            RoboXYZ roboXYZ = (RoboXYZ) robo;
            // Implemente a lógica de aplicação do efeito para a CarroceriaTurbo no RoboXYZ
            // ...
        }
    }
}
