package carroceria;

import robos.Robo;
import robos.RoboXYZ;

public class CarroceriaTurbo extends Carroceria {
    public CarroceriaTurbo(Robo robo) {
        super("Turbo");
        if (robo instanceof RoboXYZ) {
            RoboXYZ roboXYZ = (RoboXYZ) robo;

            // 20% mais rápido na velocidade de deslocamento
            double novaVelocidade = roboXYZ.getAgilidadeNaMovimentacao() * 0.8;
            roboXYZ.setAgilidadeNaMovimentacao(novaVelocidade);

            // Redução de 50% no tempo necessário para descargas
            double novoTempoDescarga = roboXYZ.getTempoDescarga() * 0.5;
            roboXYZ.setTempoDescarga(novoTempoDescarga);
        }
    }
}
