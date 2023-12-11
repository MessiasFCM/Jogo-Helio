package controladores;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboV;

public class ControladorRoboV extends Controlador {

    @Override
    public String nomeControlador() {
        return "Controlador V";
    }

    @Override
    public void executarAcao(Robo robo, Terreno terreno) {
        if (robo instanceof RoboV) {
            RoboV roboV = (RoboV) robo;
            // Implemente a lógica de execução para o ControladorRoboV
            // ...
        }
    }
}