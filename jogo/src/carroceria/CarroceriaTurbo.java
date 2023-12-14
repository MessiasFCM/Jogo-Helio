package carroceria;

import robos.Robo;
import robos.RoboXYZ;

public class CarroceriaTurbo extends Carroceria {
    public CarroceriaTurbo(Robo robo) {
        super("Turbo");
        if (robo instanceof RoboXYZ) {
            RoboXYZ roboXYZ = (RoboXYZ) robo;

            // Aumento de 20% na velocidade de deslocamento
            double novaVelocidade = roboXYZ.getAgilidadeNaMovimentacao() * 1.2;
            roboXYZ.setAgilidadeNaMovimentacao(novaVelocidade);

            // Redução de 50% no tempo necessário para descargas
            double novoTempoDescarga = roboXYZ.getTempoDescarga() * 0.5;
            roboXYZ.setTempoDescarga(novoTempoDescarga);
        }
    }
}
