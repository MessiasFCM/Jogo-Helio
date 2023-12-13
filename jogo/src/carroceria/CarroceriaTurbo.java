package carroceria;

import robos.Robo;
import robos.RoboXYZ;

public class CarroceriaTurbo extends Carroceria {
    public CarroceriaTurbo() {
        super("Turbo");
    }
    private double aumentoVelocidade;
    private double reducaoTempoDescarga;

    public CarroceriaTurbo(String nome, double aumentoVelocidade, double reducaoTempoDescarga) {
        super(nome);
        this.aumentoVelocidade = aumentoVelocidade;
        this.reducaoTempoDescarga = reducaoTempoDescarga;
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
