package controladores;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboFTT;

public class ControladorRoboFTT extends Controlador {
    @Override
    public String nomeControlador() {
        return "Controlador FTT";
    }

    @Override
    public void executarAcao(Robo robo, Terreno terreno) {
        if (robo instanceof RoboFTT) {
            RoboFTT roboFTT = (RoboFTT) robo;
            // Implemente a lógica de execução para o ControladorRoboFTT
            // ...
        }
    }
}