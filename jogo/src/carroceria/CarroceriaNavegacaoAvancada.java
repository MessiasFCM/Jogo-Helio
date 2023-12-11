package carroceria;

import robos.Robo;
import robos.RoboV;

public class CarroceriaNavegacaoAvancada extends Carroceria {
    public CarroceriaNavegacaoAvancada() {
        super("Navegação Avançada");
    }

    @Override
    public void aplicarEfeito(Robo robo) {
        if (robo instanceof RoboV) {
            RoboV roboV = (RoboV) robo;
            // Implemente a lógica de aplicação do efeito para a CarroceriaNavegacaoAvancada no RoboV
            // ...
        }
    }
}